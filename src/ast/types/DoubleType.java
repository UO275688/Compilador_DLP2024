package ast.types;

import ast.ASTNode;
import semantic.Visitor;

public class DoubleType extends AbstractType implements Type, ASTNode {

    public DoubleType(int line, int column) {
        super(line, column);
    }

    @Override
    public Type arithmetic(Type t) {
        if(t instanceof DoubleType)
            return this;
        if(t instanceof IntType)
            return this;
        if(t instanceof ErrorType)
            return t;

        return new ErrorType(t.getLine(), t.getColumn(), String.format("The type %s CANNOT be applied to an arithmetic operation", t));
    }

    @Override
    public Type comparison(Type t) {
        if(t instanceof DoubleType)
            return new IntType(t.getLine(), t.getColumn());

        return new ErrorType(t.getLine(), t.getColumn(), String.format("The type %s CANNOT be applied to an comparison operation", t));
    }

    @Override
    public boolean equivalent(Type t) {
        if(t instanceof DoubleType)
            return true;
        return false;
    }

    @Override
    public Type mustBeBuiltIn(ASTNode node) {
        return this;
    }

    @Override
    public Type promotableTo(Type t) {
        if(t instanceof IntType)
            return t;
        if(t instanceof DoubleType)
            return t;
        if(t instanceof CharType)
            return t;
        if(t instanceof ErrorType)
            return t;

        return new ErrorType(t.getLine(), t.getColumn(), String.format("The type %s CANNOT be casted.", t));
    }

    @Override
    public Type returnAs(Type t, ASTNode node) {
        if(t instanceof DoubleType)
            return t;
        if(t instanceof ErrorType)
            return t;

        return new ErrorType(node.getLine(), node.getColumn(), String.format("Semantic ERROR: the return type of the function %s CANNOT be returned as the expression type.", t));
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "DoubleType{}";
    }
}
