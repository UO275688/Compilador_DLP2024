package ast.definitions;

import ast.statements.Statement;

import java.util.ArrayList;
import java.util.List;

public class FuncBody {

    private List<VarDefinition> varDefinitions;

    private List<Statement> statements;

    public FuncBody(){
        this.varDefinitions = new ArrayList<VarDefinition>();
        this.statements = new ArrayList<Statement>();
    }

    public void addVarDefinitions(List<VarDefinition> v){
        varDefinitions.addAll(v);
    }

    public void addStatements(List<Statement> s){
        statements.addAll(s);
    }

    public List<VarDefinition> getVarDefinitions() {
        return varDefinitions;
    }

    public List<Statement> getStatements() {
        return statements;
    }
}
