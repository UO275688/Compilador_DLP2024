package ast.expressions.unary;

import ast.expressions.Expression;

public class UnaryMinus extends AbstractUnary implements Expression {

    public UnaryMinus(int line, int column, Expression expression) {
        super(line, column, expression);
    }

    @Override
    public String toString() {
        return "UnaryMinus{" +
                "expression=" + getExpression() +
                "}";
    }
}