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

public class IdentificationVisitor implements Visitor<Void, Void> {

    @Override
    public Void visit(FuncDefinition a, Void param) {
        return null;
    }

    @Override
    public Void visit(VarDefinition a, Void param) {
        return null;
    }

    @Override
    public Void visit(CharLiteral v, Void param) {
        return null;
    }

    @Override
    public Void visit(DoubleLiteral v, Void param) {
        return null;
    }

    @Override
    public Void visit(IntLiteral v, Void param) {
        return null;
    }

    @Override
    public Void visit(Arithmetic v, Void param) {
        return null;
    }

    @Override
    public Void visit(Comparator v, Void param) {
        return null;
    }

    @Override
    public Void visit(Logical v, Void param) {
        return null;
    }

    @Override
    public Void visit(Modulus v, Void param) {
        return null;
    }

    @Override
    public Void visit(UnaryMinus v, Void param) {
        return null;
    }

    @Override
    public Void visit(UnaryNot v, Void param) {
        return null;
    }

    @Override
    public Void visit(Cast v, Void param) {
        return null;
    }

    @Override
    public Void visit(FieldAccess v, Void param) {
        return null;
    }

    @Override
    public Void visit(FuncInvocation v, Void param) {
        return null;
    }

    @Override
    public Void visit(Indexing v, Void param) {
        return null;
    }

    @Override
    public Void visit(Variable v, Void param) {
        return null;
    }

    @Override
    public Void visit(Assignment a, Void param) {
        return null;
    }

    @Override
    public Void visit(IfElseStatement a, Void param) {
        return null;
    }

    @Override
    public Void visit(Read a, Void param) {
        return null;
    }

    @Override
    public Void visit(Return a, Void param) {
        return null;
    }

    @Override
    public Void visit(While a, Void param) {
        return null;
    }

    @Override
    public Void visit(Write a, Void param) {
        return null;
    }

    @Override
    public Void visit(ArrayType a, Void param) {
        return null;
    }

    @Override
    public Void visit(CharType a, Void param) {
        return null;
    }

    @Override
    public Void visit(DoubleType a, Void param) {
        return null;
    }

    @Override
    public Void visit(ErrorType a, Void param) {
        return null;
    }

    @Override
    public Void visit(FunctionType a, Void param) {
        return null;
    }

    @Override
    public Void visit(IntType a, Void param) {
        return null;
    }

    @Override
    public Void visit(RecordType a, Void param) {
        return null;
    }

    @Override
    public Void visit(VoidType a, Void param) {
        return null;
    }

    @Override
    public Void visit(Program a, Void param) {
        return null;
    }

    @Override
    public Void visit(RecordField a, Void param) {
        return null;
    }
}
