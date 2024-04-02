package ast.types;

import ast.ASTNode;
import ast.AbstractASTNode;
import semantic.Visitor;

public class VoidType extends AbstractType implements Type, ASTNode {

    public VoidType(int line, int column) {
        super(line, column);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String typeExpression() {
        return toString();
    }

    @Override
    public String toString() {
        return "VoidType{}";
    }
}
