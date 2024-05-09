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

        return new ErrorType(t.getLine(), t.getColumn(), String.format("Semantic ERROR: an arithmetic operation CANNOT be performed against types %s and %s", this.getNameType(), t.getNameType()));
    }

    @Override
    public Type comparison(Type t) {
        if(t instanceof ErrorType)
            return t;

        return new ErrorType(t.getLine(), t.getColumn(), String.format("Semantic ERROR: a comparison operation CANNOT be performed between type %s and %s", this.getNameType(), t.getNameType()));
    }

    @Override
    public Type logical(Type t, ASTNode node) {
        if(t instanceof ErrorType)
            return t;

        return new ErrorType(node.getLine(), node.getColumn(), String.format("Semantic ERROR: a logical operation CANNOT be performed against types %s and %s, ONLY IntTypes", this.getNameType(), t.getNameType()));
    }

    @Override
    public Type logical(ASTNode node) {
        return new ErrorType(node.getLine(), node.getColumn(), String.format("Semantic ERROR: the type %s MUST be boolean.", node));
    }

    @Override
    public Type modulus(Type t) {
        if(t instanceof ErrorType)
            return t;

        return new ErrorType(t.getLine(), t.getColumn(), String.format("Semantic ERROR: a modulus operation CANNOT be performed against types %s and %s", this.getNameType(), t.getNameType()));
    }

    @Override
    public Type squareBrackets(Type t) {
        if(t instanceof ErrorType)
            return t;

        return new ErrorType(t.getLine(), t.getColumn(), String.format("Semantic ERROR: an indexing operation CANNOT be performed against type %s, ONLY array types.", this.getNameType()));
    }

    @Override
    public Type parenthesis(List<Type> types, ASTNode node) {
        return new ErrorType(node.getLine(), node.getColumn(), String.format("Semantic ERROR: function Invocation NOT valid."));
    }

    @Override
    public Type dot(String s, ASTNode node) {
        return new ErrorType(node.getLine(), node.getColumn(), String.format("Semantic ERROR: field access is NOT valid."));
    }

    @Override
    public boolean promotableTo(Type t) {
        return false;
    }

    @Override
    public Type readable(ASTNode node) {
        return new ErrorType(node.getLine(), node.getColumn(), String.format("Semantic ERROR: %s MUST be a built-in type to be read.", this.getNameType()));
    }

    @Override
    public Type writable(ASTNode node) {
        return new ErrorType(node.getLine(), node.getColumn(), String.format("Semantic ERROR: %s MUST be a built-in type to be written.", this.getNameType()));
    }

    @Override
    public Type negative(ASTNode node) {
        return new ErrorType(node.getLine(), node.getColumn(), String.format("Semantic ERROR: %s MUST be a built-in type to apply UnaryMinus.", this.getNameType()));
    }

    @Override
    public Type negation(ASTNode node) {
        return new ErrorType(node.getLine(), node.getColumn(), String.format("Semantic ERROR: the type %s MUST be boolean to apply UnaryNot.", node));
    }

    @Override
    public Type canBeCastTo(Type type) {
        return new ErrorType(type.getLine(), type.getColumn(), String.format("Semantic ERROR: the type %s CANNOT be casted, ONLY built-in types.", this.getNameType()));
    }

    @Override
    public Type returnAs(Type t, ASTNode node) {
        return new ErrorType(node.getLine(), node.getColumn(), String.format("Semantic ERROR: the return type of the function %s CANNOT be returned as the type %s.", t.getNameType(), this.getNameType()));
    }

    @Override
    public char getSuffix() {
        ErrorType errorType = new ErrorType(getLine(), getColumn(), String.format("Code generation ERROR: CANNOT get the suffix of the type " + this.getNameType()));
        throw new IllegalStateException(errorType.toString());
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
