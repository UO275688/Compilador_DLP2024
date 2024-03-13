package ast.expressions;

import ast.statements.Statement;
import semantic.Visitor;

import java.util.List;

public class FuncInvocation extends AbstractExpression implements Expression, Statement {

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
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "FuncInvocation{" +
                "variable=" + getVariable() +
                ", expressions=" + getParams() +
                '}';
    }
}
