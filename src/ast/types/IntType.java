package ast.types;

import ast.ASTNode;
import ast.AbstractASTNode;
import semantic.Visitor;

public class IntType extends AbstractType implements Type, ASTNode {

    public IntType(int line, int column) {
        super(line, column);
    }

    @Override
    public int numberOfBytes() {
        return 2;
    }

    @Override
    public Type arithmetic(Type t) {
        if(t instanceof IntType)
            return this;
        if(t instanceof ErrorType)
            return t;

        return new ErrorType(t.getLine(), t.getColumn(), String.format("Semantic ERROR: an arithmetic operation CANNOT be performed against types %s and %s", this.getNameType(), t.getNameType()));
    }

    @Override
    public Type comparison(Type t) {
        if(t instanceof IntType)
            return this;

        return new ErrorType(t.getLine(), t.getColumn(), String.format("Semantic ERROR: a comparison operation CANNOT be performed between type %s and %s", this.getNameType(), t.getNameType()));
    }

    @Override
    public Type logical(Type t, ASTNode node) {
        if(t instanceof IntType)
            return this;
        if(t instanceof ErrorType)
            return t;

        return new ErrorType(node.getLine(), node.getColumn(), String.format("Semantic ERROR: a logical operation CANNOT be applied to type %s, ONLY int.", t.getNameType()));
    }

    @Override
    public Type logical(ASTNode node) {
        return this;
    }

    // Int promociona a Double
    @Override
    public boolean promotableTo(Type t) {
        if(t instanceof IntType)
            return true;
        return false;
    }

    @Override
    public Type readable(ASTNode node) {
        return this;
    }

    @Override
    public Type writable(ASTNode node) {
        return this;
    }

    @Override
    public Type negative(ASTNode node) {
        return this;
    }

    @Override
    public Type negation(ASTNode node) {
        return this;
    }

    @Override
    public Type modulus(Type t) {
        if(t instanceof IntType)
            return this;
        if(t instanceof CharType)
            return this;
        if(t instanceof ErrorType)
            return t;

        return new ErrorType(t.getLine(), t.getColumn(), String.format("Semantic ERROR: the type %s CANNOT be applied to a modulus operation", t.getNameType()));
    }

    @Override
    public Type canBeCastTo(Type t) {
        if(t instanceof IntType)
            return this;
        if(t instanceof DoubleType)
            return t;
        if(t instanceof CharType)
            return t;
        if(t instanceof ErrorType)
            return t;

        return new ErrorType(t.getLine(), t.getColumn(), String.format("The type %s CANNOT be casted to %s.", this.getNameType(), t.getNameType()));
    }

    @Override
    public Type returnAs(Type t, ASTNode node) {
        if(t instanceof IntType)
            return t;
        if(t instanceof ErrorType)
            return t;

        return new ErrorType(node.getLine(), node.getColumn(), String.format("Semantic ERROR: the return type of the function %s CANNOT be returned as the type %s.", t.getNameType(), this.getNameType()));
    }

    @Override
    public char getSuffix() {
        return 'i';
    }

    @Override
    public String getNameType() {
        return "int";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "IntType{}";
    }
}
