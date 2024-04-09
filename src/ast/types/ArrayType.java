package ast.types;

import ast.ASTNode;
import ast.AbstractASTNode;
import semantic.Visitor;

public class ArrayType extends AbstractType implements Type, ASTNode {

    private Type type;

    private int size;

    public ArrayType(int line, int column, Type type, int size) {
        super(line, column);
        this.type = type;
        this.size = size;
    }

    @Override
    // Recursive, works with multidimensional arrays
    public int numberOfBytes(){
        return this.type.numberOfBytes() * this.size;
    }

    public void setNewDimensionType(Type newType) {
        try {
            ((ArrayType) this.type).setNewDimensionType(newType);
        } catch (RuntimeException e){
            setType(newType);
        }
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getSize(){
        return this.size;
    }

    public Type getType(){
        return this.type;
    }

    @Override
    public Type squareBrackets(Type t) {
        if(t instanceof IntType)
            return this.type;
        if(t instanceof ErrorType)
            return t;

        return new ErrorType(t.getLine(), t.getColumn(), String.format("The type %s CANNOT be an indexing operation (must be int)", t));
    }


    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "ArrayType{" +
                "size=" + getSize() +
                ", type=" + getType() +
                '}';
    }
}
