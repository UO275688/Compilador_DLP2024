package ast.types;

import ast.ASTNode;
import ast.definitions.VarDefinition;
import semantic.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FunctionType extends AbstractType implements Type, ASTNode {

    private Type returnType;

    private List<VarDefinition> params;

    public FunctionType(int line, int column, Type returnType, List<VarDefinition> params) {
        super(line, column);
        this.returnType = returnType;
        this.params = new ArrayList<VarDefinition>(params);
    }

    public Type getReturnType(){
        return this.returnType;
    }

    public List<VarDefinition> getParams(){
        return this.params;
    }

    @Override
    public Type parenthesis(List<Type> types, ASTNode node) {
        // Check the number of parameters
        if (types.size() != params.size())
            return new ErrorType(node.getLine(), node.getColumn(), String.format("Semantic ERROR: the Function Type MUST have the same number of params, expected %s.", params.size()));

        for(int i = 0; i < types.size(); i++)
            if( ! types.get(i).promotableTo(params.get(i).getType()) )
                return new ErrorType(node.getLine(), node.getColumn(), String.format("Semantic ERROR: the expected param type is %s, NOT %s", params.get(i).getType().getNameType(), types.get(i).getNameType()));

        return returnType;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "FunctionType{" +
                "returnType=" + getReturnType() +
                ", params=" + getParams() +
                '}';
    }
}
