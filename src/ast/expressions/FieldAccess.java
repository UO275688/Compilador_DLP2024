package ast.expressions;

import semantic.Visitor;

public class FieldAccess extends AbstractExpression implements Expression {

    private Expression expression;

    private String fieldName;

    public FieldAccess(int line, int column, Expression expression, String fieldName) {
        super(line, column);
        this.expression = expression;
        this.fieldName = fieldName;
    }

    public Expression getExpression() {
        return expression;
    }

    public String getFieldName() {
        return fieldName;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "FieldAccess{" +
                "expression=" + getExpression() +
                ", fieldName='" + getFieldName() +
                '}';
    }
}
