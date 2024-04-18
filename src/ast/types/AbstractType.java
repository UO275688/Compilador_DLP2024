package ast.types;

import ast.ASTNode;
import ast.AbstractASTNode;

import java.util.List;

public abstract class AbstractType extends AbstractASTNode implements Type{

    private int offset;

    public AbstractType(int line, int column) {
        super(line, column);
    }

    @Override
    public String typeExpression() {
        return toString();
    }

    @Override
    public Type arithmetic(Type t) {
        if(t instanceof ErrorType) 	// instanceof is allowed
            return t;

        return new ErrorType(t.getLine(), t.getColumn(), String.format("An arithmetic operation CANNOT be performed against types %s and %s", this, t));
    }

    @Override
    public Type comparison(Type t) {
        if(t instanceof ErrorType)
            return t;

        return new ErrorType(t.getLine(), t.getColumn(), String.format("Semantic ERROR: a comparison operation CANNOT be performed between type %s and %s", this, t));
    }

    @Override
    public Type logical(Type t, ASTNode node) {
        if(t instanceof ErrorType)
            return t;

        return new ErrorType(node.getLine(), node.getColumn(), String.format("A logical operation CANNOT be performed against types %s and %s", this, t));
    }

    @Override
    public Type logical(ASTNode node) {
        return new ErrorType(node.getLine(), node.getColumn(), String.format("Semantic ERROR: the type %s MUST be boolean.", node));
    }

    @Override
    public Type modulus(Type t) {
        if(t instanceof ErrorType)
            return t;

        return new ErrorType(t.getLine(), t.getColumn(), String.format("A modulus operation CANNOT be performed against types %s and %s", this, t));
    }

    @Override
    public Type squareBrackets(Type t) {
        if(t instanceof ErrorType)
            return t;

        return new ErrorType(t.getLine(), t.getColumn(), String.format("An indexing operation CANNOT be performed with the type %s.", this, t));
    }

    @Override
    public Type parenthesis(List<Type> types, ASTNode node) {
        return new ErrorType(node.getLine(), node.getColumn(), String.format("Function Invocation NOT valid."));
    }

    @Override
    public Type dot(String s, ASTNode node) {
        return new ErrorType(node.getLine(), node.getColumn(), String.format("Field Access is NOT valid."));
    }

    @Override
    public boolean promotableTo(Type t) {
        return false;
    }

    @Override
    public Type readable(ASTNode node) {
        return new ErrorType(node.getLine(), node.getColumn(), String.format("Semantic ERROR: %s MUST be a built-in type to be read.", this));
    }

    @Override
    public Type writable(ASTNode node) {
        return new ErrorType(node.getLine(), node.getColumn(), String.format("Semantic ERROR: %s MUST be a built-in type to be written.", this));
    }

    @Override
    public Type negative(ASTNode node) {
        return new ErrorType(node.getLine(), node.getColumn(), String.format("Semantic ERROR: %s MUST be a built-in type to apply UnaryMinus.", this));
    }

    @Override
    public Type negation(ASTNode node) {
        return new ErrorType(node.getLine(), node.getColumn(), String.format("Semantic ERROR: the type %s MUST be boolean to apply UnaryNot.", node));
    }

    @Override
    public Type canBeCastTo(Type type) {
        return new ErrorType(type.getLine(), type.getColumn(), String.format("Semantic ERROR: the type %s CANNOT be promoted.", type));
    }

    @Override
    public Type returnAs(Type t, ASTNode node) {
        return new ErrorType(node.getLine(), node.getColumn(), String.format("Semantic ERROR: the return type of the function %s CANNOT be returned as the expression type %s.", t, this));
    }

    @Override
    public char getSuffix() {
        throw new IllegalStateException("Code generation ERROR: CANNOT get the suffix of the type %s " + this);
    }

    @Override
    public int numberOfBytes() {
        return 0;
    }

    public void setOffset(int offset){
        this.offset = offset;
    }

    public int getOffset(){
        return offset;
    }

    @Override
    public String getNameType() {
        return "";
    }
}
