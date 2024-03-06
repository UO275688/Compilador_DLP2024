package ast.expressions.operators;

import ast.AbstractASTNode;
import ast.expressions.Expression;

public class Modulus extends AbstractASTNode implements Expression {

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
    public String toString() {
        return "Modulus{" +
                "left=" + getLeft() +
                ", right=" + getRight() +
                '}';
    }
}
