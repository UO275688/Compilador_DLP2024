package ast.types;

import ast.ASTNode;

import java.util.List;

public interface Type extends ASTNode {

    int numberOfBytes();

    String typeExpression();

    Type arithmetic(Type t);

    Type comparison(Type t);

    Type logical(Type t, ASTNode node);

    Type logical(ASTNode node);

    Type modulus(Type t);

    Type squareBrackets(Type t);

    Type parenthesis(List<Type> types, ASTNode node);

    Type dot(String s, ASTNode node);

    boolean promotableTo(Type t);

    Type readable(ASTNode node);

    Type writable(ASTNode node);

    Type negative(ASTNode node);

    Type negation(ASTNode node);

    Type canBeCastTo(Type type);

    Type returnAs(Type param, ASTNode node);

    char getSuffix();

    String getNameType();
}
