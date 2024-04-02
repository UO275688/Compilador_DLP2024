package ast.expressions;

import ast.AbstractASTNode;
import ast.types.Type;

public abstract class AbstractExpression extends AbstractASTNode implements Expression{

    private boolean lvalue;

    private Type type;

    public AbstractExpression(int line, int column) {
        super(line, column);
    }

    @Override
    public void setLvalue(boolean lvalue) {
        this.lvalue = lvalue;
    }

    @Override
    public boolean getLvalue() {
        return this.lvalue;
    }

    @Override
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public Type getType() {
        return this.type;
    }
}
