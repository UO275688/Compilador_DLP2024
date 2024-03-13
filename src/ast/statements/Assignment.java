package ast.statements;

import ast.ASTNode;
import ast.AbstractASTNode;
import ast.expressions.Expression;
import semantic.Visitor;

public class Assignment extends AbstractASTNode implements Statement, ASTNode {

    private Expression leftExpression, rightExpression;

    private boolean lvalue;

    public Assignment(int line, int column, Expression leftExpression, Expression rightExpression) {
        super(line, column);
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    public void setLvalue(boolean lvalue) {
        this.lvalue = lvalue;
    }

    public boolean getLvalue() {
        return this.lvalue;
    }

    public Expression getLeftExpression() {
        return leftExpression;
    }

    public Expression getRightExpression() {
        return rightExpression;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Assigment{" +
                "leftExpression=" + getLeftExpression() +
                ", rightExpression=" + getRightExpression() +
                '}';
    }

}
