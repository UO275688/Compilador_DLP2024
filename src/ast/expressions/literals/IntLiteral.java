package ast.expressions.literals;

import ast.AbstractASTNode;
import ast.expressions.Expression;

public class IntLiteral extends AbstractASTNode implements Expression {

    private int value;

    public IntLiteral(int line, int column, int value) {
        super(line, column);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "IntLiteral{" +
                "value=" + getValue() +
                '}';
    }
}
