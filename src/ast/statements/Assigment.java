package ast.statements;

import ast.ASTNode;
import ast.AbstractASTNode;
import ast.expressions.Expression;

public class Assigment extends AbstractASTNode implements Statement, ASTNode {

    private Expression leftExpression, rightExpression;

    public Assigment(int line, int column, Expression leftExpression, Expression rightExpression) {
        super(line, column);
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    public Expression getLeftExpression() {
        return leftExpression;
    }

    public Expression getRightExpression() {
        return rightExpression;
    }

    @Override
    public String toString() {
        return "Assigment{" +
                "leftExpression=" + getLeftExpression() +
                ", rightExpression=" + getRightExpression() +
                '}';
    }
}
