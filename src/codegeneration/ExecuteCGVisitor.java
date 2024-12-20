package codegeneration;

import ast.Program;
import ast.ReturnBytes;
import ast.definitions.Definition;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.FuncInvocation;
import ast.statements.*;
import ast.types.FunctionType;
import ast.types.VoidType;

/*
execute[[Read: statement -> expression]] =
	value[[expression]]
	<in > expression.type.suffix()
    <store > expression.type.suffix()


execute[[Write: statement -> expression]] =
	value[[expression]]
	<out > expression.type.suffix()


execute[[Assignment: statement -> expression1 expression2]] =
	address[[expression1]]
	value[[expression2]]
	<store > expression1.type.suffix()


execute[[VarDefinition: definition -> type ID]] =
        ´ * type.toString() ID ( offset vardefinition.offset )


execute[[FuncDefinition: definition -> type ID vardefinitions* statements* ]] =
    int localVarsBytes = 0;
    int parametersBytes = 0;
    int bytesToReturn = ( (FunctionType) definition.getType()).getReturnType().numberOfBytes();

    for(VarDefinition vardef : vardefinitions*)
        localVarsBytes += vardef.getType().numberOfBytes();

    for(VarDefinition param : ( (FunctionType) funcDefinition.getType()).getParams())
        parametersBytes += param.getType().numberOfBytes();

    ID :

    ' * Parameters:
    execute[[type]]

    ' * Local variables:
    vardefinitions*.foreach(var -> execute[[var]])

    if (vardefinition*.size() > 0)
        <enter > localVarsBytes
    else
        <enter > 0

    statements*.foreach(var -> execute[[stmt]])

    if(type.returnType instanceof VoidType)
	    <ret > bytesReturn <, > bytesLocals <, >  bytesArgs


execute[[Program: program -> definition*]] =
    for(Definition vardef : definition*)
        if(vardef instanceof VarDefinition)
            execute[[vardef]]

    <call main>
	<halt>

    <main:>
	for(Definition fundef : definition*)
        if(fundef instanceof FuncDefinition)
            execute[[fundef]]


execute[[FunctionType: type1 -> type2 vardefinitions*]] =
        vardefinitions*.foreach(var -> execute[[var]])


execute[[WhileStatement: statement -> exp statement*]] =
	String conditionLabel = cg.nextLabel(), exitLabel = cg.nextLabel();
	conditionLabel<:>
		value[[exp]]
		<jz > exitLabel
		statement*.forEach(stmt -> execute[[stmt]])
		<jmp > conditionLabel
	exitLabel<:>


execute[[IfElseStmt: statement1 -> expression statement2* statement3*]] =
	String elseLabel = cg.nextLabel(), exitLabel = cg.nextLabel();
		value[[expression]]
		<jz > elseLabel
		statement2*.forEach(s -> execute[[s]])
		<jmp > exitLabel
	elseLabel<:>
		statement3*.forEach(s -> execute[[s]])
	exitLabel<:>


execute[[FuncInvocation: statement → expression1 expression2*]] =
	expression2*.forEach(exp -> value[[exp]])
	<call > expression1.name
	if(!(expression1.type.returnType instanceof VoidType))
		<pop > expression1.type.returnType.suffix()


execute[[Return: statement -> expression]] =
	value[[expression]]
	<ret > ?, ?, ?
 */
public class ExecuteCGVisitor extends AbstractCGVisitor<ReturnBytes, Void>{

    private CodeGenerator cg;

    private AddressCGVisitor addressVisitor;
    private ValueCGVisitor valueVisitor;

    public ExecuteCGVisitor(CodeGenerator cg){
        this.cg = cg;
        this.addressVisitor = new AddressCGVisitor(cg);
        this.valueVisitor = new ValueCGVisitor(cg, addressVisitor);
        this.addressVisitor.setValueCGVisitor(valueVisitor);
    }

    /*
    execute[[Read: statement -> expression]] =
        address[[expression]]
        <in > expression.type.suffix()
        <store > expression.type.suffix()
    */
    @Override
    public Void visit(Read v, ReturnBytes param) {
        cg.addLine(v.getLine());
        cg.addComment("\n\t' * Read");

        v.getExpression().accept(this.addressVisitor, null);

        cg.read(v.getExpression().getType());
        cg.store(v.getExpression().getType());

        return null;
    }

    /*
    execute[[Write: statement -> expression]] =
        value[[expression]]
        <out > expression.type.suffix()
    */
    @Override
    public Void visit(Write v, ReturnBytes param) {
        cg.addLine(v.getLine());
        cg.addComment("\n\t' * Write");

        v.getExpression().accept(this.valueVisitor, null);
        cg.write(v.getExpression().getType());

        return null;
    }

    /*
    execute[[Assignment: statement -> expression1 expression2]] =
        address[[expression1]]
        value[[expression2]]
        <store > expression1.type.suffix()
    */
    @Override
    public Void visit(Assignment v, ReturnBytes param) {
        cg.addLine(v.getLine());

        v.getLeftExpression().accept(this.addressVisitor , null);
        v.getRightExpression().accept(this.valueVisitor , null);

        cg.store(v.getLeftExpression().getType());

        return null;
    }

    /*
    execute[[VarDefinition: definition -> type ID]] =
        <´ * > type.toString() ID <(> offset definition.offset <)>
    */
    @Override
    public Void visit(VarDefinition v, ReturnBytes param) {
        cg.addComment("\n\t' * " + v.getType().getNameType() + " " + v.getName() + " (offset " + v.getOffset() + ")");

        return null;
    }

    /*
    execute[[FuncDefinition: definition -> type ID vardefinitions* statements* ]] =
        int localVarsBytes = 0;
        int parametersBytes = 0;
        int bytesToReturn = type.returnType.numberOfBytes();

        for(VarDefinition vardef : vardefinitions*)
            localVarsBytes += vardef.getType().numberOfBytes();

        for(VarDefinition param : type.getParams())
            parametersBytes += param.getType().numberOfBytes();

        ID :

        ' * Parameters:
        execute[[type]]

        ' * Local variables:
        vardefinitions*.foreach(var -> execute[[var]])

        if (vardefinition*.size() > 0)
            <enter > localVarsBytes
        else
            <enter > 0

        statements*.foreach(var -> execute[[stmt]])

        if(type.returnType instanceof VoidType)
		    <ret > bytesReturn <, > bytesLocals <, >  bytesArgs
    */
    @Override
    public Void visit(FuncDefinition v, ReturnBytes param) {
        // Inherited attributes for the bytes that need to be returned
        ReturnBytes finalParam = calculateBytes(v);

        cg.addLine(v.getLine());
        cg.addComment("\n\n " + v.getName() + ":");

        cg.addComment("\n\t' * Parameters");
        v.getType().accept(this, finalParam);

        cg.addComment("\n\t' * Local variables");
        v.getVarDefinitions().forEach(vardef -> vardef.accept(this, finalParam));

        // Allocate bytes for the local variables
        if (v.getVarDefinitions().size() > 0)
            cg.enter(finalParam.getBytesLocals());
            //cg.enter( - v.getVarDefinitions().get(v.getVarDefinitions().size()-1).getOffset() );
        else
            cg.enter(0);

        v.getStatements().forEach(stmt -> stmt.accept(this, finalParam));

        if( ((FunctionType)v.getType()).getReturnType() instanceof VoidType )
            cg.returnBytes(finalParam);

        return null;
    }

    public ReturnBytes calculateBytes(FuncDefinition funcDefinition){
        int localVarsBytes = 0;
        int parametersBytes = 0;
        int bytesToReturn = ( (FunctionType) funcDefinition.getType()).getReturnType().numberOfBytes();

        for(VarDefinition vardef : funcDefinition.getVarDefinitions())
            localVarsBytes += vardef.getType().numberOfBytes();

        for(VarDefinition param : ( (FunctionType) funcDefinition.getType()).getParams())
            parametersBytes += param.getType().numberOfBytes();

        return new ReturnBytes(bytesToReturn, localVarsBytes, parametersBytes);
    }

    /*
    execute[[Program: program -> definition*]] =
        <´ * > Global variables:
        for(Definition vardef : definition*)
            if(vardef instanceof VarDefinition)
                execute[[vardef]]

        <call main>
        <halt>

        for(Definition fundef : definition*)
            if(fundef instanceof FuncDefinition)
                execute[[fundef]]
     */
    @Override
    public Void visit(Program v, ReturnBytes param) {
        cg.addSource();
        cg.addComment("\n\n\t' * Global variables:");

        for(Definition vardef : v.getDefinitions())
            if (vardef instanceof VarDefinition varDefinition)
                varDefinition.accept(this, param);

        cg.callMain();

        for(Definition fundef : v.getDefinitions())
            if(fundef instanceof FuncDefinition funcDefinition)
                funcDefinition.accept(this, param);

        return null;
    }

    /*
    execute[[FunctionType: type1 -> type2 vardefinitions*]] =
        vardefinitions*.foreach(var -> execute[[var]])
     */
    @Override
    public Void visit(FunctionType v, ReturnBytes param) {
        v.getParams().forEach(var -> var.accept(this, param));

        return null;
    }

    /*
    execute[[WhileStatement: statement -> exp statement*]] =
        String conditionLabel = cg.nextLabel(), exitLabel = cg.nextLabel();
        conditionLabel<:>
            value[[exp]]
            <jz > exitLabel
            statement*.forEach(stmt -> execute[[stmt]])
            <jmp > conditionLabel
        exitLabel<:>
     */
    @Override
    public Void visit(While v, ReturnBytes param) {
        cg.addComment("\n\t' * While");
        cg.addLine(v.getLine());

        String conditionLabel = cg.nextLabel(), exitLabel = cg.nextLabel();

        cg.addLabel(conditionLabel);
        v.getCondition().accept(valueVisitor, null);
        cg.jz(exitLabel);

        cg.addComment("\n\t' * Body of the while statement");
        v.getStatements().forEach(stmt -> stmt.accept(this, param));
        cg.jmp(conditionLabel);
        cg.addLabel(exitLabel);

        return null;
    }

    /*
    execute[[IfElseStmt: statement1 -> expression statement2* statement3*]] =
        String elseLabel = cg.nextLabel(), exitLabel = cg.nextLabel();
            value[[expression]]
            <jz > elseLabel
            statement2*.forEach(s -> execute[[s]])
            <jmp > exitLabel
        elseLabel<:>
            statement3*.forEach(s -> execute[[s]])
        exitLabel<:>
     */
    @Override
    public Void visit(IfElseStatement v, ReturnBytes param) {
        cg.addComment("\n\t' * If statement");
        cg.addLine(v.getLine());

        String elseLabel = cg.nextLabel(), exitLabel = cg.nextLabel();
        v.getCondition().accept(valueVisitor, null);
        cg.jz(elseLabel);

        cg.addComment("\n\t' * Body of the if branch");
        v.getIfStmt().forEach(stmt -> stmt.accept(this, param));
        cg.jmp(exitLabel);
        cg.addLabel(elseLabel);

        cg.addComment("\n\t' * Body of the else branch");
        v.getElseStmt().forEach(stmt -> stmt.accept(this, param));
        cg.addLabel(exitLabel);

        return null;
    }


    /*
    We can call one or another the type of the parent:
    V write f();
    V a + f();
    E f();  could be a list of statements

    execute[[FuncInvocation: statement → expression1 expression2*]] =
        expression2*.forEach(exp -> value[[exp]])
        <call > expression1.name
        if(!(expression1.type.returnType instanceof VoidType))
            <pop > expression1.type.returnType.suffix()
     */
    @Override
    public Void visit(FuncInvocation v, ReturnBytes param) {
        cg.addLine(v.getLine());

        v.getParams().forEach(exp -> exp.accept(valueVisitor, null));
        cg.callFunction(v.getVariable().getName());

        // Clear the top of the stack (pop), when it is returning something,
        // meaning the function is NOT Void
        if(! (v.getType() instanceof VoidType) )
            cg.popi();

        return null;
    }

    /*
    execute[[Return: statement -> expression]] =
        value[[expression]]
        <ret > ?, ?, ?
     */
    @Override
    public Void visit(Return v, ReturnBytes param) {
        cg.addLine(v.getLine());
        cg.addComment("\n\t' * Return");

        v.getExpression().accept(valueVisitor, null);
        cg.returnBytes(param); // inherited from FuncDefinition

        return null;
    }
}
