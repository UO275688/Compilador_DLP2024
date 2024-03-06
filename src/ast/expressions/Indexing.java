package ast.expressions;

import ast.AbstractASTNode;

public class Indexing extends AbstractASTNode implements Expression {

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
    public String toString() {
        return "Indexing{" +
                "expressionLeft=" + getExpressionLeft() +
                ", expressionRight=" + getExpressionRight() +
                '}';
    }
}
