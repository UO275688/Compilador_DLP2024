package ast.expressions;

import ast.types.Type;
import semantic.Visitor;

public class Cast extends AbstractExpression implements Expression{

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
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Cast{" +
                "type=" + getType() +
                ", expression=" + getExpression() +
                '}';
    }
}
