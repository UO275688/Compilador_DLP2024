package ast.types;

import ast.ASTNode;
import ast.AbstractASTNode;

public class ArrayType extends AbstractASTNode implements Type, ASTNode {

    private Type type;

    private int size;

    public ArrayType(int line, int column, Type type, int size) {
        super(line, column);
        this.type = type;
        this.size = size;
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
    public String toString() {
        return "ArrayType{" +
                "size=" + getSize() +
                ", type=" + getType() +
                '}';
    }
}
