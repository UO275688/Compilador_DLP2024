package ast.definitions;

import ast.ASTNode;
import ast.statements.Statement;
import ast.types.Type;

public class VarDefinition extends AbstractDefinition implements Definition, ASTNode {

    private int offset;

    public VarDefinition(int line, int column, Type type, String name) {
        super(line, column, type, name);
    }

    public VarDefinition(int line, int column, Type type, String name, int offset) {
        super(line, column, type, name);
        this.offset = offset;
    }

    public int getOffset() {
        return offset;
    }

    @Override
    public String toString() {
        return "VarDefinition{" +
                "type=" + getType() +
                ", name=" + getName() +
                ", offset=" + getOffset() +
                '}';
    }
}
