package ast.definitions;

import ast.ASTNode;
import ast.statements.Statement;
import ast.types.FunctionType;

import java.util.ArrayList;
import java.util.List;

public class FuncDefinition extends AbstractDefinition implements Definition, ASTNode {

    private List<VarDefinition> varDefinitions;

    private List<Statement> statements;

    public FuncDefinition(int line, int column, FunctionType funcType, String name, List<VarDefinition> varDefinitions,
                          List<Statement> statements) {
        super(line, column, funcType, name);
        this.varDefinitions = new ArrayList<VarDefinition>(varDefinitions);
        this.statements = new ArrayList<Statement>(statements);
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public List<VarDefinition> getVarDefinitions() {
        return varDefinitions;
    }

    @Override
    public String toString() {
        return "FuncDefinition{" +
                "type=" + getType() +
                ", name=" + getName() +
                ", varDefinitions=" + getVarDefinitions() +
                ", statements=" + getStatements() +
                '}';
    }
}
