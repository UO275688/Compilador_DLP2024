package ast.statements;

import ast.ASTNode;
import ast.AbstractASTNode;
import ast.expressions.Expression;

import java.util.ArrayList;
import java.util.List;

public class While extends AbstractASTNode implements Statement, ASTNode {

    private Expression condition;

    private List<Statement> statements;

    public While(int line, int column, Expression condition, List<Statement> statements) {
        super(line, column);
        this.condition = condition;
        this.statements = new ArrayList<Statement>(statements);
    }

    public Expression getCondition() {
        return condition;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    @Override
    public String toString() {
        return "While{" +
                "condition=" + getCondition() +
                ", statements=" + getStatements() +
                '}';
    }
}
