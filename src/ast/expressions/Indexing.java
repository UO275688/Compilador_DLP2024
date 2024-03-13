package ast.expressions;

import semantic.Visitor;

public class Indexing extends AbstractExpression implements Expression {

    private Expression expressionLeft, expressionRight;

    public Indexing(int line, int column, Expression expressionLeft, Expression expressionRight) {
        super(line, column);
        this.expressionLeft = expressionLeft;
        this.expressionRight = expressionRight;
    }

    public Expression getExpressionLeft() {
        return expressionLeft;
    }

    public Expression getExpressionRight() {
        return expressionRight;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Indexing{" +
                "expressionLeft=" + getExpressionLeft() +
                ", expressionRight=" + getExpressionRight() +
                '}';
    }
}
