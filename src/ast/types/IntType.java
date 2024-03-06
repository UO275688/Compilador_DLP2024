package ast.types;

import ast.ASTNode;
import ast.AbstractASTNode;

public class IntType extends AbstractASTNode implements Type, ASTNode {

    public IntType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "IntType{}";
    }
}
