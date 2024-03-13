package ast.expressions;

import ast.ASTNode;

public interface Expression extends ASTNode {

    void setLvalue(boolean lvalue);

    boolean getLvalue();
}
