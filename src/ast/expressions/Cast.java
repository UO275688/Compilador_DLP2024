package ast.expressions;

import ast.AbstractASTNode;
import ast.types.Type;

public class Cast extends AbstractASTNode implements Expression{

    private Type type;

    private Expression expression;

    public Cast(int line, int column, Type type, Expression expression) {
        super(line, column);
        this.expression = expression;
        this.type = type;
    }

    public Expression getExpression() {
        return expression;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Cast{" +
                "type=" + getType() +
                ", expression=" + getExpression() +
                '}';
    }
}
