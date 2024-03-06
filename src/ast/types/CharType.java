package ast.types;

import ast.ASTNode;
import ast.AbstractASTNode;

public class CharType extends AbstractASTNode implements Type, ASTNode {

    public CharType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "CharType{}";
    }
}
