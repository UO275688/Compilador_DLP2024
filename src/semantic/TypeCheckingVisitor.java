package semantic;

import ast.Program;
import ast.RecordField;
import ast.definitions.Definition;
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

// No longer generic because we instantiate them
public class TypeCheckingVisitor extends AbstractVisitor<Void, Void> {

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
