package ast.expressions.literals;

import ast.AbstractASTNode;
import ast.expressions.Expression;

public class DoubleLiteral extends AbstractASTNode implements Expression {

    private double value;

    public DoubleLiteral(int line, int column, double value) {
        super(line, column);
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "DoubleLiteral{" +
                "value=" + getValue() +
                '}';
    }
}
