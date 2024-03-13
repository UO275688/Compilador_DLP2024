package ast.expressions.operators;

import ast.expressions.Expression;
import semantic.Visitor;

public class Arithmetic extends AbstractBinaryExpression implements Expression {

    public Arithmetic(int line, int column, Expression left, Expression right, String operator) {
        super(line, column, left, right, operator);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
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
