package ast.expressions.unary;

import ast.AbstractASTNode;
import ast.expressions.Expression;

public class AbstractUnary extends AbstractASTNode implements Expression {

    protected Expression expression;

    public AbstractUnary(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }}
