package ast.expressions;

import ast.AbstractASTNode;

public abstract class AbstractExpression extends AbstractASTNode implements Expression{

    private boolean lvalue;

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
}
