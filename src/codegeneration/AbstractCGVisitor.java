package codegeneration;

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
import semantic.Visitor;

import java.io.IOException;

public class AbstractCGVisitor<TP, TR> implements Visitor<TP, TR> {

    @Override
    public TR visit(Program v, TP param) {
        throwAssertion();
        return null;
    }

    @Override
    public TR visit(FuncDefinition v, TP param) {
        throwAssertion();
        return null;
    }

    @Override
    public TR visit(VarDefinition v, TP param) {
        throwAssertion();
        return null;
    }

    @Override
    public TR visit(CharLiteral v, TP param) {
        throwAssertion();
        return null;
    }

    @Override
    public TR visit(DoubleLiteral v, TP param) {
        throwAssertion();
        return null;
    }

    @Override
    public TR visit(IntLiteral v, TP param) {
        throwAssertion();
        return null;
    }

    @Override
    public TR visit(Arithmetic v, TP param) {
        throwAssertion();
        return null;
    }

    @Override
    public TR visit(Comparator v, TP param) {
        throwAssertion();
        return null;
    }

    @Override
    public TR visit(Logical v, TP param) {
        throwAssertion();
        return null;
    }

    @Override
    public TR visit(Modulus v, TP param) {
        throwAssertion();
        return null;
    }

    @Override
    public TR visit(UnaryMinus v, TP param) {
        throwAssertion();
        return null;
    }

    @Override
    public TR visit(UnaryNot v, TP param) {
        throwAssertion();
        return null;
    }

    @Override
    public TR visit(Cast v, TP param) {
        throwAssertion();
        return null;
    }

    @Override
    public TR visit(FieldAccess v, TP param) {
        throwAssertion();
        return null;
    }

    @Override
    public TR visit(FuncInvocation v, TP param) {
        throwAssertion();
        return null;
    }

    @Override
    public TR visit(Indexing v, TP param) {
        throwAssertion();
        return null;
    }

    @Override
    public TR visit(Variable v, TP param) {
        throwAssertion();
        return null;
    }

    @Override
    public TR visit(Assignment v, TP param) {
        throwAssertion();
        return null;
    }

    @Override
    public TR visit(IfElseStatement a, TP param) {
        throwAssertion();
        return null;
    }

    @Override
    public TR visit(Read a, TP param) {
        throwAssertion();
        return null;
    }

    @Override
    public TR visit(Return v, TP param) {
        throwAssertion();
        return null;
    }

    @Override
    public TR visit(While v, TP param) {
        throwAssertion();
        return null;
    }

    @Override
    public TR visit(Write a, TP param) {
        throwAssertion();
        return null;
    }

    @Override
    public TR visit(ArrayType v, TP param) {
        throwAssertion();
        return null;
    }

    @Override
    public TR visit(CharType v, TP param) {
        throwAssertion();
        return null;
    }

    @Override
    public TR visit(DoubleType v, TP param) {
        throwAssertion();
        return null;
    }

    @Override
    public TR visit(FunctionType v, TP param) {
        throwAssertion();
        return null;
    }

    @Override
    public TR visit(IntType v, TP param) {
        throwAssertion();
        return null;
    }

    @Override
    public TR visit(RecordType v, TP param) {
        throwAssertion();
        return null;
    }

    @Override
    public TR visit(VoidType v, TP param) {
        throwAssertion();
        return null;
    }

    @Override
    public TR visit(RecordField v, TP param) {
        throwAssertion();
        return null;
    }

    @Override
    public TR visit(ErrorType v, TP param) {
        throwAssertion();
        return null;
    }

    private void throwAssertion() {
        String msg = "Undefined template visitX for the code function " + this.getClass().getName();
        assert false: msg;
        throw new UnsupportedOperationException(msg);
    }
}
