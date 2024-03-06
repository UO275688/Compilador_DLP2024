package ast.types;

import ast.ASTNode;
import ast.AbstractASTNode;

public class DoubleType extends AbstractASTNode implements Type, ASTNode {

    public DoubleType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "DoubleType{}";
    }
}
