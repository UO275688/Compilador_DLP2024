package ast.statements;

import ast.ASTNode;
import ast.AbstractASTNode;
import ast.expressions.Expression;
import semantic.Visitor;

public class Write extends AbstractASTNode implements Statement, ASTNode {

    private Expression expression;

    public Write(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Write{" +
                "expression=" + getExpression() +
                '}';
    }
}
