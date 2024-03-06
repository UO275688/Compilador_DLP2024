package ast;

import ast.types.Type;

public class RecordField extends AbstractASTNode implements ASTNode {

    private Type type;

    private String name;

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

    @Override
    public String toString() {
        return "RecordField{" +
                "type=" + getType() +
                ", name='" + getName() + '\'' +
                '}';
    }
}
