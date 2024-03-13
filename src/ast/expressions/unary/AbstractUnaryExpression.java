package ast.expressions.unary;

import ast.expressions.AbstractExpression;
import ast.expressions.Expression;

public abstract class AbstractUnaryExpression extends AbstractExpression implements Expression {

    protected Expression expression;

    public AbstractUnaryExpression(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }
}
