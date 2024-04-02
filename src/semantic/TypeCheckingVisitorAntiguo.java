package semantic;

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
import ast.statements.Assignment;
import ast.statements.Read;
import ast.types.ErrorType;

/*
--------------------------- EXPRESSIONS

(P) Cast: expression1 -> type expression2
(R) expression1.type = expression2.type.promotableTo(type)

(P) FieldAccess: expression1 -> expression2 expression3
(R) expression1.type = expression2.type.dot(expression3.type)

(P) FuncInvocation: expression1 -> expression2 expression3*
(R) expression1.type = expression2.type.parenthesis(
expression3*.stream().map( exp -> exp.type ).toArray()
)

(P) FuncInvocation: statement -> expression1 expression2*
(R) expression1.type.parenthesis(
Expression2*.stream().map( exp -> exp.type ).toArray()
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
(R) expression1.type = expression2.type.mustBeBuiltIn()

(P) UnaryNot: expression1 -> expression2
(R) expression1.type = expression2.type.mustBeBoolean()

--------------------------- STATEMENTS

(P) Assignment: statement -> expression1 expression2
(R) expression1.type.equivalent(expression2.type)

(P) IfElseStatement: statement1 -> expression statement2* statement3*
(R) expression.type.mustBeBoolean()
    statement2*.forEach( stmt.returnType = type.returnType )
    statement3*.forEach( stmt.returnType = type.returnType )

(P) Read: statement -> expression*
(R) for( Expression exp : expression*) {
    exp.type.mustBeBuiltIn()
}

(P) Return: statement -> expression
(R) expression.type.returnAs(statement.returnType)

(P) WhileStmt: statement1 -> expression statement2*
(R) expression.type.mustBeBoolean()
    statement2*.forEach( stmt.returnType = type.returnType )

(P) Write: statement -> expression*
(R) for( Expression exp : expression*) {
    exp.type.mustBeBuiltIn()

--------------------------- DEFINITIONS

(P) FuncDefinition: definition -> type expression definition* statement*
(R) statement.forEach( stmt.returnType = type.returnType )

 */
// No longer generic because we instantiate them
public class TypeCheckingVisitorAntiguo extends AbstractVisitor<Void, Void> {

    @Override
    public Void visit(CharLiteral v, Void param) {
        v.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(DoubleLiteral v, Void param) {
        v.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(IntLiteral v, Void param) {
        v.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Arithmetic v, Void param) {
        // Post-order, first evaluate the child
        v.getLeft().accept(this, null);
        v.getRight().accept(this, null);
        v.setLvalue(false);

        return null;
    }

    @Override
    public Void visit(Comparator v, Void param) {
        // Post-order, first evaluate the child
        v.getLeft().accept(this, null);
        v.getRight().accept(this, null);
        v.setLvalue(false);

        return null;
    }

    @Override
    public Void visit(Logical v, Void param) {
        // Post-order, first evaluate the child
        v.getLeft().accept(this, null);
        v.getRight().accept(this, null);
        v.setLvalue(false);

        return null;
    }

    @Override
    public Void visit(Modulus v, Void param) {
        // Post-order, first evaluate the child
        v.getLeft().accept(this, null);
        v.getRight().accept(this, null);
        v.setLvalue(false);

        return null;
    }

    @Override
    public Void visit(UnaryMinus v, Void param) {
        v.getExpression().accept(this, param);
        v.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(UnaryNot v, Void param) {
        v.getExpression().accept(this, param);
        v.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Cast v, Void param) {
        v.getExpression().accept(this, param);
        v.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(FieldAccess v, Void param) {
        // Post-order, first evaluate the child
        v.getExpression().accept(this, param);
        v.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(FuncInvocation v, Void param) {
        v.getVariable().accept(this, param);
        v.getParams().forEach(e -> e.accept(this, param));
        v.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Indexing v, Void param) {
        // Post-order, first evaluate the child
        v.getExpressionLeft().accept(this, param);
        v.getExpressionRight().accept(this, param);
        v.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(Variable v, Void param) {
        // Leaf node, no need to traverse
        v.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(Assignment a, Void param) {
        // Post-order traversal
        a.getLeftExpression().accept(this, null);
        a.getRightExpression().accept(this, null);
        // expression1.lvalue = expression2.lvalue
        a.setLvalue(a.getLeftExpression().getLvalue());

        if (!a.getLeftExpression().getLvalue())
            new ErrorType(a.getLine(), a.getColumn(), String.format("Semantic error: expression %s CANNOT be an lvalue", a.getLeftExpression()));

        return null;
    }

    @Override
    public Void visit(Read a, Void param) {
        a.getExpression().accept(this, param);

        if (!a.getExpression().getLvalue())
            new ErrorType(a.getLine(), a.getColumn(), String.format("Semantic ERROR: expression %s CANNOT be read, must be a variable.", a.getExpression()));

        return null;
    }
}
