package ast.expressions.literals;

import ast.expressions.AbstractExpression;
import ast.expressions.Expression;
import semantic.Visitor;

public class CharLiteral extends AbstractExpression implements Expression {

    private char value;

    public CharLiteral(int line, int column, char value) {
        super(line, column);
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "CharLiteral{" +
                "value=" + getValue() +
                '}';
    }
}
