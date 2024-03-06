package ast.statements;

import ast.ASTNode;
import ast.AbstractASTNode;
import ast.expressions.Expression;

import java.util.ArrayList;
import java.util.List;

public class IfElseStatement extends AbstractASTNode implements Statement, ASTNode {

    private Expression condition;

    private List<Statement> ifStmt, elseStmt;

    public IfElseStatement(int line, int column, Expression condition, List<Statement> ifStmt) {
        super(line, column);
        this.condition = condition;
        this.ifStmt = new ArrayList<Statement>(ifStmt);
        this.elseStmt = new ArrayList<Statement>();
    }

    public IfElseStatement(int line, int column, Expression condition, List<Statement> ifStmt, List<Statement> elseStmt) {
        super(line, column);
        this.condition = condition;
        this.ifStmt = new ArrayList<Statement>(ifStmt);
        this.elseStmt = new ArrayList<Statement>(elseStmt);
    }

    public Expression getCondition() {
        return condition;
    }

    public List<Statement> getIfStmt() {
        return ifStmt;
    }

    public List<Statement> getElseStmt() {
        return elseStmt;
    }

    @Override
    public String toString() {
        return "IfElseStatement{" +
                "condition=" + getCondition() +
                ", ifStmt=" + getIfStmt() +
                ", elseStmt=" + getElseStmt() +
                '}';
    }
}
