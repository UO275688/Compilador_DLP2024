package ast.expressions.operators;

import ast.expressions.AbstractExpression;
import ast.expressions.Expression;

public abstract class AbstractBinaryExpression extends AbstractExpression implements Expression {

    protected String operator;

    protected Expression left, right;

    public AbstractBinaryExpression(int line, int column, Expression left, Expression right, String operator) {
        super(line, column);
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }
}
