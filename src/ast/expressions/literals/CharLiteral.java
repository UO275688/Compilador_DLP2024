package ast.expressions.literals;

import ast.AbstractASTNode;
import ast.expressions.Expression;

public class CharLiteral extends AbstractASTNode implements Expression {

    private char value;

    public CharLiteral(int line, int column, char value) {
        super(line, column);
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "CharLiteral{" +
                "value=" + getValue() +
                '}';
    }
}
