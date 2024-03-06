package ast.types;

import ast.ASTNode;
import ast.AbstractASTNode;

public class VoidType extends AbstractASTNode implements Type, ASTNode {

    public VoidType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "VoidType{}";
    }
}
