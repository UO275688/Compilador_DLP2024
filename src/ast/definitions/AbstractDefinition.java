package ast.definitions;

import ast.ASTNode;
import ast.AbstractASTNode;
import ast.types.Type;

public abstract class AbstractDefinition extends AbstractASTNode implements ASTNode, Definition{

    protected Type type;

    protected String name;

    protected int scope;

    public AbstractDefinition(int line, int column, Type type, String name){
        super(line, column);
        this.type = type;
        this.name = name;
    }

    @Override
    public Type getType() {
        return this.type;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setScope(int scope) {
        this.scope = scope;
    }

    @Override
    public int getScope() {
        return this.scope;
    }
}
