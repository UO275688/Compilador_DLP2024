package ast.types;

import ast.ASTNode;
import ast.AbstractASTNode;
import semantic.Visitor;

public class IntType extends AbstractASTNode implements Type, ASTNode {

    public IntType(int line, int column) {
        super(line, column);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "IntType{}";
    }
}
