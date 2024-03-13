package ast.expressions.unary;

import ast.expressions.Expression;
import semantic.Visitor;

public class UnaryNot extends AbstractUnaryExpression implements Expression {

    public UnaryNot(int line, int column, Expression expression) {
        super(line, column, expression);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "UnaryNot{" +
                "expression=" + getExpression() +
                "}";
    }
}
