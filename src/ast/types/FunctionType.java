package ast.types;

import ast.ASTNode;
import ast.AbstractASTNode;
import ast.definitions.VarDefinition;

import java.util.ArrayList;
import java.util.List;

public class FunctionType extends AbstractASTNode implements Type, ASTNode {

    private Type returnType;

    private List<VarDefinition> params;

    public FunctionType(int line, int column, Type type, List<VarDefinition> params) {
        super(line, column);
        this.returnType = type;
        this.params = new ArrayList<VarDefinition>(params);
    }

    public Type getReturnType(){
        return this.returnType;
    }

    public List<VarDefinition> getParams(){
        return this.params;
    }

    @Override
    public String toString() {
        return "FunctionType{" +
                "returnType=" + getReturnType() +
                ", params=" + getParams() +
                '}';
    }
}
