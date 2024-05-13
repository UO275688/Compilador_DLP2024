package ast;

import ast.types.AbstractType;
import ast.types.Type;
import semantic.Visitor;

public class RecordField extends AbstractType implements ASTNode {

    private Type type;

    private String name;

    private int offset;

    public RecordField(int line, int column, Type type, String name) {
        super(line, column);
        this.type = type;
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setOffset(int offset){
        this.offset = offset;
    }

    public int getOffset(){
        return offset;
    }

    @Override
    public String getNameType() {
        return "(" + name + " x " + type.getNameType() + ")";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "RecordField{" +
                "type=" + getType() +
                ", name='" + getName() + '\'' +
                ", offset='" + getOffset() + '\'' +
                '}';
    }
}
