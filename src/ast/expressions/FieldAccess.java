package ast.expressions;

import ast.AbstractASTNode;

public class FieldAccess extends AbstractASTNode implements Expression {

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
    public String toString() {
        return "FieldAccess{" +
                "expression=" + getExpression() +
                ", fieldName='" + getFieldName() +
                '}';
    }
}
