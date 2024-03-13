package ast.expressions.operators;

import ast.expressions.Expression;
import semantic.Visitor;

public class Comparator extends AbstractBinaryExpression implements Expression {

    public Comparator(int line, int column, Expression left, Expression right, String operator) {
        super(line, column, left, right, operator);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
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
