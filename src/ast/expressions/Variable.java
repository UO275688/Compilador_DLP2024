package ast.expressions;

import semantic.Visitor;

public class Variable extends AbstractExpression implements Expression{

    private String name;

    public Variable(int line, int column, String name) {
        super(line, column);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Variable{" +
                "name='" + getName() + '\'' +
                '}';
    }
}
