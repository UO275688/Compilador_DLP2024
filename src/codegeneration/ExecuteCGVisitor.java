package codegeneration;

import ast.Program;
import ast.definitions.Definition;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.statements.Assignment;
import ast.statements.Read;
import ast.statements.Statement;
import ast.statements.Write;
import ast.types.FunctionType;

/*
execute[[Read: statement -> expression]] =
	value[[expression]]
	<in> expression.type.suffix()


execute[[Write: statement -> expression]] =
	value[[expression]]
	<out> expression.type.suffix()


execute[[Assignment: statement -> expression1 expression2]] =
	address[[expression1]]
	value[[expression2]]
	storei


execute[[VarDefinition: definition -> type ID]] =



execute[[FuncDefinition: definition -> type ID vardefinitions* statements* ]] =
    execute[[type]]
    for(Definition var : vardefinitions*)
        execute[[var]]
    for(Statement stmt : statements*)
        execute[[stmt]]
    <ret> type.returnFunctionBytes



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
 */
public class ExecuteCGVisitor extends AbstractCGVisitor<Void, Void>{

    private CodeGenerator cg;

    private AddressCGVisitor addressVisitor;
    private ValueCGVisitor valueVisitor;

    public ExecuteCGVisitor(CodeGenerator cg){
        this.cg = cg;
        this.addressVisitor = new AddressCGVisitor(cg);
        this.valueVisitor = new ValueCGVisitor(cg, addressVisitor);
    }

    /*
    execute[[Read: statement -> expression]] =
        address[[expression]]
        <in> expression.type.suffix()
    */
    @Override
    public Void visit(Read v, Void param) {
        cg.addLine(v.getLine());
        cg.addComment("\n\t' * Read");

        v.getExpression().accept(this.addressVisitor, param);
        cg.read(v.getExpression().getType());
        cg.store(v.getExpression().getType());

        return null;
    }

    /*
    execute[[Write: statement -> expression]] =
        value[[expression]]
        <out> expression.type.suffix()
    */
    @Override
    public Void visit(Write v, Void param) {
        cg.addLine(v.getLine());
        cg.addComment("\n\t' * Write");

        v.getExpression().accept(this.valueVisitor, param);
        cg.write(v.getExpression().getType());

        return null;
    }

    /*
    execute[[Assignment: statement -> expression1 expression2]] =
        address[[expression1]]
        value[[expression2]]
        storei
    */
    @Override
    public Void visit(Assignment v, Void param) {
        cg.addLine(v.getLine());

        v.getLeftExpression().accept(this.addressVisitor , param);
        v.getRightExpression().accept(this.valueVisitor , param);
        cg.store(v.getLeftExpression().getType());

        return null;
    }

    /*
    execute[[VarDefinition: definition -> type ID]] =

    */
    @Override
    public Void visit(VarDefinition v, Void param) {


        return null;
    }

    /*
    execute[[FuncDefinition: definition -> type ID vardefinitions* statements* ]] =
        execute[[type]]
        for(Definition var : vardefinitions*)
            execute[[var]]
        for(Statement stmt : statements*)
            execute[[stmt]]
        <ret> type.returnFunctionBytes
    */
    @Override
    public Void visit(FuncDefinition v, Void param) {
        v.getType().accept(this, param);

        for(VarDefinition vardef : v.getVarDefinitions())
            vardef.accept(this, param);

        for(Statement stmt : v.getStatements())
            stmt.accept(this, param);

        cg.returnFunctionBytes((FunctionType) v.getType(), v);

        return null;
    }



    /*
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
     */
    @Override
    public Void visit(Program v, Void param) {
        for(Definition vardef : v.getDefinitions())
            if(vardef instanceof VarDefinition)
                vardef.accept(this, param);

        cg.callMain(v.getLine());

        for(Definition fundef : v.getDefinitions())
            if(fundef instanceof FuncDefinition)
                fundef.accept(this, param);

        return null;
    }
}
