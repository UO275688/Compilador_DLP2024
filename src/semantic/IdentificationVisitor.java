package semantic;

import ast.definitions.Definition;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.*;
import ast.types.*;
import semantic.symboltable.SymbolTable;

// No longer generic because we instantiate them
public class IdentificationVisitor extends AbstractVisitor<Void, Void> {

    private SymbolTable st = new SymbolTable();

    @Override
    public Void visit(FuncDefinition v, Void param) {
        // FuncDefinition already exists
        if(!st.insert(v))
            new ErrorType(v.getLine(), v.getColumn(), String.format("Semantic ERROR: the function definition %s is already defined in the current scope.", v));

        // New scope
        st.set();

        // Insert the parameters (VarDefinition) from the function type
        FunctionType functionType = (FunctionType) v.getType();
        functionType.accept(this, param);

        // Insert the variable definitions and statements
        v.getVarDefinitions().forEach(var -> var.accept(this, param));
        v.getStatements().forEach(stmt -> stmt.accept(this, param));

        // Scope is deleted and goes back to the parent scope
        st.reset();

        return null;
    }

    @Override
    public Void visit(VarDefinition v, Void param) {
        // Variable already defined
        if(!st.insert(v))
            new ErrorType(v.getLine(), v.getColumn(), String.format("Semantic ERROR: the variable definition %s is already defined in the current scope.", v));

        v.getType().accept(this, param);

        return null;
    }

    @Override
    public Void visit(Variable v, Void param) {
        // Variable is NOT defined
        if(st.find(v.getName()) == null)
            new ErrorType(v.getLine(), v.getColumn(), String.format("Semantic ERROR: the variable %s is NOT defined in any parent scope.", v));

        // Link Variable to the Definition
        Definition definition = st.find(v.getName());
        v.setDefinition(definition);

        return null;
    }
}
