package ast.expressions;

import ast.ASTNode;
import ast.types.Type;

public interface Expression extends ASTNode {

    void setLvalue(boolean lvalue);

    boolean getLvalue();

    void setType(Type type);

    Type getType();
}
