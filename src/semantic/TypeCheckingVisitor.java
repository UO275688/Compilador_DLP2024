package semantic;

import ast.definitions.FuncDefinition;
import ast.expressions.*;
import ast.expressions.literals.CharLiteral;
import ast.expressions.literals.DoubleLiteral;
import ast.expressions.literals.IntLiteral;
import ast.expressions.operators.Arithmetic;
import ast.expressions.operators.Comparator;
import ast.expressions.operators.Logical;
import ast.expressions.operators.Modulus;
import ast.expressions.unary.UnaryMinus;
import ast.expressions.unary.UnaryNot;
import ast.statements.*;
import ast.types.*;

/*
--------------------------- EXPRESSIONS

(P) Cast: expression1 -> type expression2
(R) expression1.type = expression2.type.canBeCastTo(type)

(P) FieldAccess: expression1 -> expression2 ID
(R) expression1.type = expression2.type.dot(ID)

(P) FuncInvocation: expression1 -> expression2 expression3*
(R) expression1.type = expression2.type.parenthesis(
        expression3*.stream().map( exp -> exp.type ).toList()
    )

(P) FuncInvocation: statement -> expression1 expression2*
(R) expression1.type.parenthesis(
        expression2*.stream().map( exp -> exp.type ).toList()
    )

(P) Indexing: expression1 -> expression2 expression3
(R) expression1.type = expression2.type.squareBrackets(expression3.type)

(P) Variable : expression -> ID
(R) expression.type = expression.definition.type // Variables are linked with their VarDefinition;

--------------------------- LITERALS

(P) CharLiteral: expression -> CHAR_CONSTANT
(R) expression1.type = new CharType()

(P) IntLiteral: expression -> INT_CONSTANT
(R) expression1.type = new IntType()

(P) DoubleLiteral: expression -> DOUBLE_CONSTANT
(R) expression1.type = new DoubleType()

--------------------------- OPERATORS

(P) Arithmetic: expression1 -> expression2 expression3
(R) expression1.type = expression2.type.arithemetic(expression3.type);

(P) Comparator: expression1 -> expression2 expression3
(R) expression1.type = expression2.type.comparison(expression3.type);

(P) Logical: expression1 -> expression2 expression3
(R) expression1.type = expression2.type.logical(expression3.type);

(P) Modulus: expression1 -> expression2 expression3
(R) expression1.type = expression2.type.modulus(expression3.type);

--------------------------- UNARY

(P) UnaryMinus: expression1 -> expression2
(R) expression1.type = expression2.type.negative()

(P) UnaryNot: expression1 -> expression2
(R) expression1.type = expression2.type.negation()

--------------------------- STATEMENTS

(P) Assignment: statement -> expression1 expression2
(R) expression1.type.promotableTo(expression2.type)

(P) IfElseStatement: statement1 -> expression statement2* statement3*
(R) expression.type.mustBeBoolean()
    statement2*.forEach( stmt.returnType = definition.type.returnType )
    statement3*.forEach( stmt.returnType = definition.type.returnType )

(P) Read: statement -> expression
(R) expression.type.readable()

(P) Return: statement -> expression
(R) expression.type.returnAs(statement.returnType)

(P) WhileStmt: statement1 -> expression statement2*
(R) expression.type.mustBeBoolean()
    statement2*.forEach( stmt.returnType = definition.type.returnType )

(P) Write: statement -> expression
(R) expression.type.writable()

--------------------------- DEFINITIONS

(P) FuncDefinition: definition -> type ID definition* statement*
(R) statement*.forEach( stmt.returnType = type.returnType )

 */
// No longer generic because we instantiate them
public class TypeCheckingVisitor extends AbstractVisitor<Type, Void> {

    /*(P) FuncDefinition: definition -> type ID definition* statement*
    (R) statement*.forEach( stmt.returnType = type.returnType )*/
    @Override
    public Void visit(FuncDefinition v, Type param) {
        v.getType().accept(this, param);
        v.getVarDefinitions().forEach(var -> var.accept(this, param));

        // Pass the return type as a parameter, inherited attribute
        v.getStatements().forEach(stmt -> stmt.accept(this, ((FunctionType) v.getType()).getReturnType()));

        return null;
    }

    /*(P) CharLiteral: expression -> CHAR_CONSTANT
    (R) expression1.type = new CharType()*/
    @Override
    public Void visit(CharLiteral v, Type param) {
        v.setLvalue(false);
        v.setType(new CharType(v.getLine(), v.getColumn()));

        return null;
    }

    /*(P) DoubleLiteral: expression -> DOUBLE_CONSTANT
    (R) expression1.type = new DoubleType()*/
    @Override
    public Void visit(DoubleLiteral v, Type param) {
        v.setLvalue(false);
        v.setType(new DoubleType(v.getLine(), v.getColumn()));

        return null;
    }

    /*(P) IntLiteral: expression -> INT_CONSTANT
    (R) expression1.type = new IntType()*/
    @Override
    public Void visit(IntLiteral v, Type param) {
        v.setLvalue(false);
        v.setType(new IntType(v.getLine(), v.getColumn()));

        return null;
    }

    /*(P) Arithmetic: expression1 -> expression2 expression3
    (R) expression1.type = expression2.type.arithemetic(expression3.type);*/
    @Override
    public Void visit(Arithmetic v, Type param) {
        // Post-order, first evaluate the child
        v.getLeft().accept(this, null);
        v.getRight().accept(this, null);
        v.setLvalue(false);
        v.setType(v.getLeft().getType().arithmetic(v.getRight().getType()));

        return null;
    }

    /*(P) Comparator: expression1 -> expression2 expression3
    (R) expression1.type = expression2.type.comparison(expression3.type);*/
    @Override
    public Void visit(Comparator v, Type param) {
        // Post-order, first evaluate the child
        v.getLeft().accept(this, null);
        v.getRight().accept(this, null);
        v.setLvalue(false);
        v.setType(v.getLeft().getType().comparison(v.getRight().getType()));

        return null;
    }

    /*(P) Logical: expression1 -> expression2 expression3
    (R) expression1.type = expression2.type.logical(expression3.type);*/
    @Override
    public Void visit(Logical v, Type param) {
        // Post-order, first evaluate the child
        v.getLeft().accept(this, null);
        v.getRight().accept(this, null);
        v.setLvalue(false);
        v.setType(v.getLeft().getType().logical(v.getRight().getType(), v));

        return null;
    }

    /*(P) Modulus: expression1 -> expression2 expression3
    (R) expression1.type = expression2.type.modulus(expression3.type);*/
    @Override
    public Void visit(Modulus v, Type param) {
        // Post-order, first evaluate the child
        v.getLeft().accept(this, null);
        v.getRight().accept(this, null);
        v.setLvalue(false);
        v.setType(v.getLeft().getType().modulus(v.getRight().getType()));

        return null;
    }

    /*(P) UnaryMinus: expression1 -> expression2
    (R) expression1.type = expression2.type.negative()*/
    @Override
    public Void visit(UnaryMinus v, Type param) {
        v.getExpression().accept(this, param);
        v.setLvalue(false);
        v.setType(v.getExpression().getType().negative(v.getExpression()));

        return null;
    }

    /*(P) UnaryNot: expression1 -> expression2
    (R) expression1.type = expression2.type.negation()*/
    @Override
    public Void visit(UnaryNot v, Type param) {
        v.getExpression().accept(this, param);
        v.setLvalue(false);
        v.setType(v.getExpression().getType().negation(v.getExpression()));

        return null;
    }

    /*(P) Cast: expression1 -> type expression2
    (R) expression1.type = expression2.type.canBeCastTo(type)*/
    @Override
    public Void visit(Cast v, Type param) {
        v.getExpression().accept(this, param);
        v.setLvalue(false);
        v.setType(v.getExpression().getType().canBeCastTo(v.getCastType()));

        return null;
    }

    /*(P) FieldAccess: expression1 -> expression2 ID
    (R) expression1.type = expression2.type.dot(ID)*/
    @Override
    public Void visit(FieldAccess v, Type param) {
        // Post-order, first evaluate the child
        v.getExpression().accept(this, param);
        v.setLvalue(true);
        v.setType(v.getExpression().getType().dot(v.getFieldName(), v.getExpression()));

        if(!v.getExpression().getLvalue())
            new ErrorType(v.getLine(), v.getColumn(), String.format("Semantic ERROR: field access expression %s MUST be an lvalue", v.getExpression()));

        return null;
    }

    /*
    (P) FuncInvocation: expression1 -> expression2 expression3*
    (R) expression1.type = expression2.type.parenthesis(
            expression3*.stream().map( exp -> exp.type ).toList())

    (P) FuncInvocation: statement -> expression1 expression2*
    (R) expression1.type.parenthesis(
            expression2*.stream().map( exp -> exp.type ).toList())
    */
    @Override
    public Void visit(FuncInvocation v, Type param) {
        v.getVariable().accept(this, param);
        v.getParams().forEach(e -> e.accept(this, param));
        v.setLvalue(false);

        // Expression
        v.setType(v.getVariable().getType().parenthesis(v.getParams().stream().map(exp -> exp.getType()).toList(), v));

        return null;
    }

    /*(P) Indexing: expression1 -> expression2 expression3
    (R) expression1.type = expression2.type.squareBrackets(expression3.type)*/
    @Override
    public Void visit(Indexing v, Type param) {
        // Post-order, first evaluate the child
        v.getExpressionLeft().accept(this, param);
        v.getExpressionRight().accept(this, param);
        v.setLvalue(true);
        v.setType(v.getExpressionLeft().getType().squareBrackets(v.getExpressionRight().getType()));

        return null;
    }

    /*(P) Variable : expression -> ID
    (R) expression.type = expression.definition.type*/
    @Override
    public Void visit(Variable v, Type param) {
        // Leaf node, no need to traverse
        v.setLvalue(true);

        // Variables are linked with their VarDefinition (IdentificationVisitor)
        v.setType(v.getDefinition().getType());

        return null;
    }

    /*(P) Assignment: statement -> expression1 expression2
    (R) expression1.type.promotableTo(expression2.type)*/
    @Override
    public Void visit(Assignment v, Type param) {
        // Post-order traversal
        v.getLeftExpression().accept(this, param);
        v.getRightExpression().accept(this, param);

        // expression1.lvalue = expression2.lvalue
        v.setLvalue(v.getLeftExpression().getLvalue());

        // MUST have the same built-in type and the left-hand side expression is an l-value.
        if (!v.getLeftExpression().getLvalue())
            new ErrorType(v.getLine(), v.getColumn(), String.format("Semantic ERROR: expression %s is NOT an lvalue.", v.getLeftExpression()));

        // Check the value is promotable
        if( !v.getLeftExpression().getType().promotableTo(v.getRightExpression().getType()))
            new ErrorType(v.getLine(), v.getColumn(), String.format("Semantic ERROR: assigning to expression %s, type must be promotable to %s.", v.getLeftExpression(), v.getLeftExpression().getType().getNameType()));

        return null;
    }

    /*(P) Read: statement -> expression
    (R) expression.type.readable()*/
    @Override
    public Void visit(Read v, Type param) {
        v.getExpression().accept(this, param);

        if (!v.getExpression().getLvalue())
            new ErrorType(v.getLine(), v.getColumn(), String.format("Semantic ERROR: expression %s MUST be an lvalue to be read.", v.getExpression()));

        v.getExpression().getType().readable(v.getExpression());

        return null;
    }

    /*(P) IfElseStatement: statement1 -> expression statement2* statement3*
    (R) expression.type.logical()
    statement2*.forEach( stmt.returnType = definition.type.returnType )
    statement3*.forEach( stmt.returnType = definition.type.returnType )*/
    @Override
    public Void visit(IfElseStatement v, Type param) {
        v.getCondition().accept(this, param);
        v.getCondition().setType(v.getCondition().getType().logical(v.getCondition()));

        v.getIfStmt().forEach(stmt -> stmt.accept(this, param));
        v.getElseStmt().forEach(stmt -> stmt.accept(this, param));

        return null;
    }

    /*(P) Return: statement -> expression
    (R) expression.type.returnAs(statement.returnType)*/
    @Override
    public Void visit(Return v, Type param) {
        v.getExpression().accept(this, param);

        // Inherited attribute from FuncDefinion returnType
        v.getExpression().setType(v.getExpression().getType().returnAs( param, v) );

        return null;
    }

    /*(P) WhileStmt: statement1 -> expression statement2*
    (R) expression.type.logical()
        statement2*.forEach( stmt.returnType = definition.type.returnType )*/
    @Override
    public Void visit(While v, Type param) {
        v.getCondition().accept(this, param);
        v.getCondition().setType(v.getCondition().getType().logical(v.getCondition()));

        v.getStatements().forEach(stmt -> stmt.accept(this, param));

        return null;
    }

    /*(P) Write: statement -> expression
    (R) expression.type.writable()*/
    @Override
    public Void visit(Write v, Type param) {
        v.getExpression().accept(this, param);
        v.getExpression().getType().writable(v.getExpression());

        return null;
    }
}
