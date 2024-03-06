package ast.expressions;

import ast.AbstractASTNode;
import ast.definitions.Definition;
import ast.statements.Statement;

import java.util.List;

public class FuncInvocation extends AbstractASTNode implements Expression, Statement {

    private Variable variable;

    private List<Expression> params;

    public FuncInvocation(int line, int column, Variable variable, List<Expression> params) {
        super(line, column);
        this.variable = variable;
        this.params = params;
    }

    public List<Expression> getParams() {
        return params;
    }

    public Variable getVariable() {
        return variable;
    }

    @Override
    public String toString() {
        return "FuncInvocation{" +
                "variable=" + getVariable() +
                ", expressions=" + getParams() +
                '}';
    }
}
