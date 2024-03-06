package ast.expressions.operators;

import ast.expressions.Expression;

public class Arithmetic extends AbstractOperator implements Expression {

    public Arithmetic(int line, int column, Expression left, Expression right, String operator) {
        super(line, column, left, right, operator);
    }

    @Override
    public String toString() {
        return "Arithmetic{" +
                "leftExpression=" + getLeft() +
                ", rightExpression=" + getRight() +
                ", operator='" + getOperator() +
                '}';
    }
}
