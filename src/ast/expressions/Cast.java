package ast.expressions;

import ast.types.Type;
import semantic.Visitor;

public class Cast extends AbstractExpression implements Expression{

    private Type castType;

    private Expression expression;

    public Cast(int line, int column, Type castType, Expression expression) {
        super(line, column);
        this.expression = expression;
        this.castType = castType;
    }

    public Expression getExpression() {
        return expression;
    }

    public Type getCastType() {
        return castType;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Cast{" +
                "type=" + getCastType() +
                ", expression=" + getExpression() +
                '}';
    }
}
