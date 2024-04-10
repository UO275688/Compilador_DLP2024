package semantic;

import ast.Program;
import ast.RecordField;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
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

// Generic class
public abstract class AbstractVisitor<TP, TR> implements Visitor<TP, TR>{

    @Override
    public TR visit(FuncDefinition v, TP param) {
        v.getType().accept(this, param);
        v.getVarDefinitions().forEach(var -> var.accept(this, param));
        v.getStatements().forEach(stmt -> stmt.accept(this, param));
        return null;
    }

    @Override
    public TR visit(VarDefinition v, TP param) {
        v.getType().accept(this, param);
        return null;
    }

    @Override
    public TR visit(CharLiteral v, TP param) {
        return null;
    }

    @Override
    public TR visit(DoubleLiteral v, TP param) {
        return null;
    }

    @Override
    public TR visit(IntLiteral v, TP param) {
        return null;
    }

    @Override
    public TR visit(Variable v, TP param) {
        return null;
    }

    @Override
    public TR visit(Arithmetic v, TP param) {
        // Post-order, first evaluate the child
        v.getLeft().accept(this, null);
        v.getRight().accept(this, null);

        return null;
    }

    @Override
    public TR visit(Comparator v, TP param) {
        // Post-order, first evaluate the child
        v.getLeft().accept(this, null);
        v.getRight().accept(this, null);

        return null;
    }

    @Override
    public TR visit(Logical v, TP param) {
        // Post-order, first evaluate the child
        v.getLeft().accept(this, null);
        v.getRight().accept(this, null);

        return null;
    }

    @Override
    public TR visit(Modulus v, TP param) {
        // Post-order, first evaluate the child
        v.getLeft().accept(this, null);
        v.getRight().accept(this, null);

        return null;
    }

    @Override
    public TR visit(UnaryMinus v, TP param) {
        v.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(UnaryNot v, TP param) {
        v.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Cast v, TP param) {
        v.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(FieldAccess v, TP param) {
        // Post-order, first evaluate the child
        v.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(FuncInvocation v, TP param) {
        v.getVariable().accept(this, param);
        v.getParams().forEach(e -> e.accept(this, param));
        return null;
    }

    @Override
    public TR visit(Indexing v, TP param) {
        // Post-order, first evaluate the child
        v.getExpressionLeft().accept(this, param);
        v.getExpressionRight().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Assignment a, TP param) {
        // Post-order traversal
        a.getLeftExpression().accept(this, null);
        a.getRightExpression().accept(this, null);
        return null;
    }

    @Override
    public TR visit(IfElseStatement a, TP param) {
        a.getCondition().accept(this, param);
        a.getIfStmt().forEach(stmt -> stmt.accept(this, param));
        a.getElseStmt().forEach(stmt -> stmt.accept(this, param));
        return null;
    }

    @Override
    public TR visit(Read a, TP param) {
        a.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Return a, TP param) {
        a.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(While a, TP param) {
        a.getCondition().accept(this, param);
        a.getStatements().forEach(stmt -> stmt.accept(this, param));
        return null;
    }

    @Override
    public TR visit(Write a, TP param) {
        a.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(VoidType a, TP param) {
        return null;
    }

    @Override
    public TR visit(CharType a, TP param) {
        return null; // leaf node
    }

    @Override
    public TR visit(IntType a, TP param) {
        return null; // leaf node
    }

    @Override
    public TR visit(DoubleType a, TP param) {
        return null; // leaf node
    }

    @Override
    public TR visit(ErrorType a, TP param) {
        return null; // leaf node
    }

    @Override
    public TR visit(FunctionType a, TP param) {
        a.getReturnType().accept(this, param);
        a.getParams().forEach(def -> def.accept(this, param));
        return null;
    }

    @Override
    public TR visit(ArrayType a, TP param) {
        a.getType().accept(this, param);
        return null;
    }

    @Override
    public TR visit(RecordType a, TP param) {
        a.getFields().forEach(f -> f.accept(this, param));
        return null;
    }

    @Override
    public TR visit(RecordField a, TP param) {
        a.getType().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Program a, TP param) {
        a.getDefinitions().forEach(def -> def.accept(this, param));
        return null;
    }
}
