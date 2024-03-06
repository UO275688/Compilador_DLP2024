package ast.expressions.operators;

import ast.expressions.Expression;

public class Logical extends AbstractOperator implements Expression {

    public Logical(int line, int column, Expression left, Expression right, String operator) {
        super(line, column, left, right, operator);
    }

    @Override
    public String toString() {
        return "Logical{" +
                "leftExpression=" + getLeft() +
                ", rightExpression=" + getRight() +
                ", operator='" + getOperator() +
                '}';
    }
}
