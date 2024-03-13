package ast.types;

import ast.ASTNode;
import ast.AbstractASTNode;
import semantic.Visitor;

public class CharType extends AbstractASTNode implements Type, ASTNode {

    public CharType(int line, int column) {
        super(line, column);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "CharType{}";
    }
}
