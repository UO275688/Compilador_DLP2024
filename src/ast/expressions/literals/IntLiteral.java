package ast.expressions.literals;

import ast.expressions.AbstractExpression;
import ast.expressions.Expression;
import semantic.Visitor;

public class IntLiteral extends AbstractExpression implements Expression {

    private int value;

    public IntLiteral(int line, int column, int value) {
        super(line, column);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "IntLiteral{" +
                "value=" + getValue() +
                '}';
    }
}
