package ast.expressions.operators;

import ast.expressions.Expression;

public class Comparator extends AbstractOperator implements Expression {

    public Comparator(int line, int column, Expression left, Expression right, String operator) {
        super(line, column, left, right, operator);
    }

    @Override
    public String toString() {
        return "Comparator{" +
                "leftExpression=" + getLeft() +
                ", rightExpression=" + getRight() +
                ", operator='" + getOperator() +
                '}';
    }
}
