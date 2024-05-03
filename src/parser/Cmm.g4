grammar Cmm;	

@header{
    import ast.*;
    import ast.definitions.*;
    import ast.expressions.*;
    import ast.expressions.literals.*;
    import ast.expressions.operators.*;
    import ast.expressions.unary.*;
    import ast.statements.*;
    import ast.types.*;
    import parser.*;
}

program returns [Program ast] locals [List<Definition> def = new ArrayList<Definition>()]:
        (d=definitions {$def.addAll($d.ast);} )*  md=mainDefinition {$def.add($md.ast);} EOF {$ast = new Program($md.ast.getLine(), $md.ast.getColumn(), $def);}
       ;

expression returns [Expression ast]:
        RC=REAL_CONSTANT   {$ast = new DoubleLiteral($RC.getLine(), $RC.getCharPositionInLine()+1, LexerHelper.lexemeToReal($RC.text));}
        | IC=INT_CONSTANT   { $ast = new IntLiteral($IC.getLine(), $IC.getCharPositionInLine()+1, LexerHelper.lexemeToInt($IC.text)); }
        | CC=CHAR_CONSTANT { $ast = new CharLiteral($CC.getLine(), $CC.getCharPositionInLine()+1, LexerHelper.lexemeToChar($CC.text)); }
        | ID    {$ast = new Variable($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text);}
        | '(' expression ')' {$ast = $expression.ast;}
        | f=functionInvocation    {$ast = $f.ast;}
        | e1=expression '[' e2=expression ']' {$ast = new Indexing($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $e2.ast);}
        | e=expression '.' ID {$ast = new FieldAccess($e.ast.getLine(), $e.ast.getColumn(), $e.ast, $ID.text);}
        | '(' t=builtInType ')' e=expression   {$ast = new Cast($e.ast.getLine(), $e.ast.getColumn(), $t.ast, $e.ast);}
        | '-' e=expression     {$ast = new UnaryMinus($e.ast.getLine(), $e.ast.getColumn(), $e.ast);}
        | '!' e=expression    {$ast = new UnaryNot($e.ast.getLine(), $e.ast.getColumn(), $e.ast);}
        | e1=expression OP=('*'| '/' | '%') e2=expression
            { if($OP.text.equals("%"))
                $ast = new Modulus($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $e2.ast);
            else
                $ast = new Arithmetic($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $e2.ast, $OP.text);
            }
        | e1=expression OP=('+'| '-') e2=expression
                    {$ast = new Arithmetic($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $e2.ast, $OP.text);}
        | e1=expression OP=('>'| '>=' | '<' | '<=' | '!=' | '==') e2=expression
                    {$ast = new Comparator($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $e2.ast, $OP.text);}
        | e1=expression OP=('&&' | '||') e2=expression
                    {$ast = new Logical($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $e2.ast, $OP.text);}
       ;

statements returns [List<Statement> ast = new ArrayList<Statement>()]:
        'while' '(' e=expression ')' b=block {$ast.add(new While($e.ast.getLine(), $e.ast.getColumn(), $e.ast, $b.ast));}
        | e1=expression '=' e2=expression ';' {$ast.add(new Assignment($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $e2.ast));}
        | c=consoleInOuts {$c.ast.forEach(s -> $ast.add(s));}
        | fi=functionInvocation ';'     {$ast.add($fi.ast);}
        | 'return' e=expression ';'   {$ast.add(new Return($e.ast.getLine(), $e.ast.getColumn(), $e.ast));}
        | 'if' '(' e=expression ')' b1=block
                            {$ast.add(new IfElseStatement($e.ast.getLine(), $e.ast.getColumn(), $e.ast, $b1.ast));}
        | 'if' '(' e=expression ')' b1=block  'else' b2=block
                    {$ast.add(new IfElseStatement($e.ast.getLine(), $e.ast.getColumn(), $e.ast, $b1.ast, $b2.ast));}
       ;

consoleInOuts returns[List<Statement> ast = new ArrayList<Statement>()]:
        R='read' le=listExpressions ';'
                {$le.ast.forEach(e -> $ast.add(new Read($R.getLine(), $R.getCharPositionInLine()+1, e)));}
        | W='write'  le=listExpressions ';'
                {$le.ast.forEach(e -> $ast.add(new Write($W.getLine(), $W.getCharPositionInLine()+1, e)));}
        ;

listExpressions returns [List<Expression> ast = new ArrayList<Expression>()]:
        e1=expression {$ast.add($e1.ast);}
            (',' e2=expression {$ast.add($e2.ast);} )*
        ;

functionInvocation returns [FuncInvocation ast] locals [List<Expression> expressions = new ArrayList<Expression>()]:
        ID '(' (le=listExpressions {$expressions.addAll($le.ast);} )? ')'
            {$ast = new FuncInvocation($ID.getLine(), $ID.getCharPositionInLine()+1, new Variable($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text), $expressions);}
        ;

block returns [List<Statement> ast = new ArrayList<Statement>()]:
        s1=statements {$s1.ast.forEach(s -> $ast.add(s));}
        | '{' (s2=statements  {$s2.ast.forEach(s -> $ast.add(s));} )* '}'
        ;

type returns [Type ast] locals [ArrayType secondArray]:
        bt=builtInType  {$ast = $bt.ast;}
        |t=type('['IC=INT_CONSTANT']')  {$ast=new ArrayType($IC.getLine(), $IC.getCharPositionInLine()+1, $t.ast, LexerHelper.lexemeToInt($IC.text));}
            ('['IC2=INT_CONSTANT']'
                {
                $secondArray = new ArrayType($IC2.getLine(), $IC2.getCharPositionInLine()+1, $t.ast, LexerHelper.lexemeToInt($IC2.text));
                ((ArrayType) $ast).setNewDimensionType( $secondArray);
                })*
       | s=struct {$ast = $s.ast;}
       ;

builtInType returns [Type ast]:
        t='int'  {$ast = new IntType($t.getLine(), $t.getCharPositionInLine()+1);}
        |  t='double' {$ast = new DoubleType($t.getLine(), $t.getCharPositionInLine()+1);}
        |  t='char' {$ast = new CharType($t.getLine(), $t.getCharPositionInLine()+1);}
        ;

void returns [VoidType ast]:
        V='void' {$ast = new VoidType($V.getLine(), $V.getCharPositionInLine()+1);}
        ;

struct returns [RecordType ast] locals [List<RecordField> fields = new ArrayList<RecordField>(), List<String> names = new ArrayList<String>()]:
         ST='struct' '{' (rf=recordFields
            {
                for(RecordField field : $rf.ast) {
                    if($names.contains(field.getName()))
                       new ErrorType(field.getLine(), field.getColumn(), String.format("Semantic ERROR: variable %s already defined in the scope.", field.getName(), field.getLine(), field.getColumn()));
                    else {
                        $names.add(field.getName());
                         $fields.add(field);
                    }
                }
            })+ '}'
            {$ast = new RecordType($ST.getLine(), $ST.getCharPositionInLine()+1, $fields);}
        ;

recordFields returns [List<RecordField> ast = new ArrayList<RecordField>()]:
        t=type id1=ID { $ast.add( new RecordField($id1.getLine(), $id1.getCharPositionInLine()+1, $t.ast, $id1.text)); }
            (',' id2=ID { $ast.add( new RecordField($id2.getLine(), $id2.getCharPositionInLine()+1, $t.ast, $id2.text));} )* ';'
        ;

functionReturnType returns [Type ast]:
        v=void {$ast = $v.ast;}
        | bt=builtInType {$ast = $bt.ast;}
        ;

params returns [List<VarDefinition> ast = new ArrayList<VarDefinition>()]:
        (bt1=builtInType id1=ID {$ast.add(new VarDefinition($id1.getLine(), $id1.getCharPositionInLine()+1, $bt1.ast, $id1.text));}
            (',' bt2=builtInType id2=ID {$ast.add(new VarDefinition($id2.getLine(), $id2.getCharPositionInLine()+1, $bt2.ast, $id2.text));})* )*
        ;

mainDefinition returns [FuncDefinition ast] locals [FunctionType mainType]:
        v=void 'main' '(' ')' '{' fs=funcBody '}'
                {$mainType = new FunctionType($v.ast.getLine(), $v.ast.getColumn(), $v.ast, new ArrayList<VarDefinition>());}
                {$ast = new FuncDefinition($v.ast.getLine(), $v.ast.getColumn(), $mainType, "main", $fs.ast.getVarDefinitions(), $fs.ast.getStatements());}
        ;

definitions returns [List<Definition> ast = new ArrayList<Definition>()]:
        fd=funcDefinition {$ast.add($fd.ast);}
        | v=varDefinitions   {$ast.addAll($v.ast);}
       ;

funcDefinition returns [FuncDefinition ast] locals [FunctionType ft]:
        frt=functionReturnType  ID '(' p=params ')' '{' fs=funcBody '}'
                {$ft = new FunctionType($frt.ast.getLine(), $frt.ast.getColumn(), $frt.ast, $p.ast);}
                {$ast = new FuncDefinition($ft.getLine(), $ft.getColumn(), $ft, $ID.text, $fs.ast.getVarDefinitions(), $fs.ast.getStatements());}
        ;

funcBody returns [FuncBody ast = new FuncBody()] locals [List<VarDefinition> defs = new ArrayList<VarDefinition>(), List<String> names = new ArrayList<String>()]:
    (vd=varDefinitions
        {
            for(VarDefinition vardef : $vd.ast) {
                if($names.contains(vardef.getName()))
                    new ErrorType(vardef.getLine(), vardef.getColumn(), String.format("Semantic ERROR: variable %s already defined in the scope.", vardef.getName(), vardef.getLine(), vardef.getColumn()));
                else {
                    $names.add(vardef.getName());
                    $defs.add(vardef);
               }
           }
        })* {$ast.addVarDefinitions($defs);} (s=statements {$ast.addStatements($s.ast);} )*
    ;

varDefinitions returns [List<VarDefinition> ast = new ArrayList<VarDefinition>()]:
        t=type id1=ID { $ast.add( new VarDefinition($id1.getLine(), $id1.getCharPositionInLine()+1, $t.ast, $id1.text) ); }
            (',' id2=ID { $ast.add( new VarDefinition($id2.getLine(), $id2.getCharPositionInLine()+1, $t.ast, $id2.text) ); } )* ';'
        ;

fragment
LETTER: [a-zA-Z]
        ;

fragment
DIGIT: [0-9]
        ;

fragment
EXPONENT: ('e' | 'E') ('+' | '-')? INT_CONSTANT+
        ;

IGNORE:[ \n\r\t]+ -> skip
            ;

ONE_LINE_COMMENT: '//' .*? ('\n' | EOF) -> skip
            ;

MULTIPLE_LINE_COMMENT: '/*' .*? '*/' -> skip
            ;

REAL_CONSTANT: ( (INT_CONSTANT '.' INT_CONSTANT?) | (INT_CONSTANT? '.' INT_CONSTANT) ) EXPONENT?
                | INT_CONSTANT EXPONENT
               ;

INT_CONSTANT: [1-9] [0-9]*
            | '0'
            ;

CHAR_CONSTANT: '\'' .*? '\''
            | '\'\\n\''
            | '\'\\t\''
            | '\'' '\\' DIGIT+ '\''
            ;

ID: (LETTER | '_')+ (LETTER | DIGIT | '_')*
	       ;