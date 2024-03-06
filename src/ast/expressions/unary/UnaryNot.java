package ast.expressions.unary;

import ast.expressions.Expression;

public class UnaryNot extends AbstractUnary implements Expression {

    public UnaryNot(int line, int column, Expression expression) {
        super(line, column, expression);
    }

    @Override
    public String toString() {
        return "UnaryNot{" +
                "expression=" + getExpression() +
                "}";
    }
}
