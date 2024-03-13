package ast.expressions.operators;

import ast.expressions.AbstractExpression;
import ast.expressions.Expression;
import semantic.Visitor;

public class Modulus extends AbstractExpression implements Expression {

    private Expression left, right;

    public Modulus(int line, int column, Expression left, Expression right) {
        super(line, column);
        this.left = left;
        this.right = right;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Modulus{" +
                "left=" + getLeft() +
                ", right=" + getRight() +
                '}';
    }
}
