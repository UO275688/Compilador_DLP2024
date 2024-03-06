package ast.statements;

import ast.ASTNode;
import ast.AbstractASTNode;
import ast.expressions.Expression;

public class Read extends AbstractASTNode implements Statement, ASTNode {

    private Expression expression;

    public Read(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return "Read{" +
                "expression=" + getExpression() +
                '}';
    }
}
