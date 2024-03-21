package ast.expressions;

import ast.definitions.Definition;
import semantic.Visitor;

public class Variable extends AbstractExpression implements Expression{

    private String name;

    private Definition definition;

    public Variable(int line, int column, String name) {
        super(line, column);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDefinition(Definition definition) {
        this.definition = definition;
    }

    public Definition getDefinition() {
        return definition;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Variable{" +
                "name='" + name + '\'' +
                ", definition=" + definition +
                '}';
    }
}
