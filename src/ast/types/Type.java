package ast.types;

import ast.ASTNode;

import java.util.List;

public interface Type extends ASTNode {

    String typeExpression();

    Type arithmetic(Type t);

    Type comparison(Type t);

    Type logical(Type t, ASTNode node);

    Type modulus(Type t);

    Type squareBrackets(Type t);

    Type parenthesis(List<Type> types, ASTNode node);

    Type dot(String s, ASTNode node);

    boolean equivalent(Type t);

    Type mustBeBuiltIn(ASTNode node);

    Type mustBeBoolean(ASTNode node);

    Type promotableTo(Type type);

    Type returnAs(Type param, ASTNode node);
}
