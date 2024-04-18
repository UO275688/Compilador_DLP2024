package codegeneration;

import ast.Program;
import ast.RecordField;
import ast.definitions.Definition;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.statements.Assignment;
import ast.statements.Read;
import ast.statements.Statement;
import ast.statements.Write;
import ast.types.FunctionType;
import ast.types.RecordType;

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
        ´ * type.toString() ID ( offset vardefinition.offset )
        }
    */
    @Override
    public Void visit(VarDefinition v, Void param) {
        // Global scope
        if(v.getScope() == 0)
            cg.addComment("\n' * " + v.getType().getNameType() + " " + v.getName() + " (offset " + v.getOffset() + ")");

        // Local scope
        else if (v.getScope() > 0)
            cg.addComment("\n\t' * " + v.getType().getNameType() + " " + v.getName() + " (offset " + v.getOffset() + ")");

        return null;
    }

    /*
    execute[[FuncDefinition: definition -> type ID vardefinitions* statements* ]] =
        ID :
        ' * Parameters:
        execute[[type]]

        ' * Local variables:
        for(Definition var : vardefinitions*)
            execute[[var]]

        if (vardefinition*.size() > 0)
            enter -vardefinition*.get(vardefinition*.size()-1).offset

        for(Statement stmt : statements*)
            execute[[stmt]]
        <ret> type.returnFunctionBytes
    */
    @Override
    public Void visit(FuncDefinition v, Void param) {
        cg.addLine(v.getLine());
        cg.addComment("\n\n " + v.getName() + ":");

        cg.addComment("\n\t' * Parameters:");
        v.getType().accept(this, param);

        cg.addComment("\n\t' * Local variables:");
        for(VarDefinition vardef : v.getVarDefinitions())
            vardef.accept(this, param);

        //if (v.getVarDefinitions().size() > 0)
          //  cg.enter(-v.getVarDefinitions().get(v.getVarDefinitions().size()-1).getOffset());

        for(Statement stmt : v.getStatements())
            stmt.accept(this, param);

        cg.returnFunctionBytes((FunctionType) v.getType(), v);

        return null;
    }

    /*
    execute[[Program: program -> definition*]] =
    ´ * Global variables:
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
        cg.callMain();
        cg.addComment("\n' * Global variables:");

        for(Definition vardef : v.getDefinitions()) {
            if (vardef instanceof VarDefinition)
                vardef.accept(this, param);
        }

        //cg.invokeMain(v.getLine());

        for(Definition fundef : v.getDefinitions())
            if(fundef instanceof FuncDefinition)
                fundef.accept(this, param);

        return null;
    }

    @Override
    public Void visit(FunctionType v, Void param) {
        for(VarDefinition var : v.getParams())
            var.accept(this, param);

        return null;
    }

    /*
    @Override
    public Void visit(RecordType v, Void param) {
        for(RecordField f : v.getFields())
            f.accept(this, param);

        return null;
    }

    @Override
    public Void visit(RecordField v, Void param) {
        cg.addComment("\n\t' * " + v.getType().getNameType() + " " + v.getName() + " (offset " + v.getOffset() + ")");

        return null;
    }
    */
}
