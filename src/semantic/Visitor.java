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

// Generic
public interface Visitor<TP, TR> {

    // Definitions
    public TR visit(FuncDefinition v, TP param);
    public TR visit(VarDefinition v, TP param);

    // Expressions
    // Literals
    public TR visit(CharLiteral v, TP param);
    public TR visit(DoubleLiteral v, TP param);
    public TR visit(IntLiteral v, TP param);

    // Operators
    public TR visit(Arithmetic v, TP param);
    public TR visit(Comparator v, TP param);
    public TR visit(Logical v, TP param);
    public TR visit(Modulus v, TP param);

    // Unary
    public TR visit(UnaryMinus v, TP param);
    public TR visit(UnaryNot v, TP param);

    public TR visit(Cast v, TP param);
    public TR visit(FieldAccess v, TP param);
    public TR visit(FuncInvocation v, TP param);
    public TR visit(Indexing v, TP param);
    public TR visit(Variable v, TP param);

    // Statements
    public TR visit(Assignment a, TP param);
    public TR visit(IfElseStatement a, TP param);
    public TR visit(Read a, TP param);
    public TR visit(Return a, TP param);
    public TR visit(While a, TP param);
    public TR visit(Write a, TP param);


    // Types
    public TR visit(ArrayType a, TP param);
    public TR visit(CharType a, TP param);
    public TR visit(DoubleType a, TP param);
    public TR visit(ErrorType a, TP param);
    public TR visit(FunctionType a, TP param);
    public TR visit(IntType a, TP param);
    public TR visit(RecordType a, TP param);
    public TR visit(VoidType a, TP param);


    public TR visit(Program a, TP param);
    public TR visit(RecordField a, TP param);
}
