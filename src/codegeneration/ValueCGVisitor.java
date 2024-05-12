package codegeneration;

import ast.expressions.*;
import ast.expressions.literals.CharLiteral;
import ast.expressions.literals.DoubleLiteral;
import ast.expressions.literals.IntLiteral;
import ast.expressions.operators.Arithmetic;
import ast.expressions.operators.Comparator;
import ast.expressions.operators.Logical;
import ast.expressions.operators.Modulus;
import ast.expressions.unary.UnaryNot;
import ast.types.ArrayType;
import ast.types.ErrorType;

/*
value[[IntLiteral: expression -> INT_CONSTANT]] =
	<pushi> expression.value


value[[RealLiteral: expression -> DOUBLE_CONSTANT]] =
	<pushf> expression.value


value[[CharLiteral: expression -> CHAR_CONSTANT]] =
	<pushb> (int) expression.value


value[[Variable: expression -> ID]] =
	address[[expression]]
	<load> expression.type.suffix()


value[[Arithmetic: expression1 -> expression2 (+ | - | * | /) expression3]] =
	value[[expression2]]
	expression2.type.arithmeticConvertTo(expression1.type)
	value[[expression3]]
	expression3.type.arithmeticConvertTo(expression1.type)
	switch (expression1.operator) {
		case "+" : <add> expression1.type.suffix() break;
		case "-" : <sub> expression1.type.suffix() break;
		case "*" : <mul> expression1.type.suffix() break;
		case "/" : <div> expression1.type.suffix() break;
		default: assert false;
	}


value[[Modulus: expression1 -> expression2 % expression3]] =
	value[[expression2]]
	expression2.type.arithmeticConvertTo(expression1.type)
	value[[expression3]]
	expression3.type.arithmeticConvertTo(expression1.type)
	<modi>


value[[Comparison: expression1 -> expression2 (> | < | >= | <= | == | !=) expression3]] =
	value[[expression2]]
	expression2.type.superType(expression1.type)
	value[[expression3]]
	expression3.type.superType(expression1.type)
	switch (expression1.operator) {
		case ">" : <gt> expression1.type.suffix()  break;
		case "<" : <lt> expression1.type.suffix() break;
		case ">=" : <ge> expression1.type.suffix() break;
		case "<=" : <le> expression1.type.suffix() break;
		case "==" : <eq> expression1.type.suffix() break;
		case "!=" : <ne> expression1.type.suffix() break;
		default: assert false;
	}

	 C C = I	I
	 I I = I	I
	 F F = I	F compares float but returns an integer


value[[Logical: expression1 -> expression2 (&& | ||) expression3]] =
	value[[expression2]]
	value[[expression3]]
	switch (expression1.operator) {
		case “&&”: <and>
				break;
		case “||”: <or>
				break;
		default: assert false;
	}


value[[Cast: expression1 -> type expression2]] =
	value[[expression2]]
	expression2.type.castTo(type)


value[[UnaryNot: expression1 -> expression2]] =
    value[[expression2]]
    <not>

value[[Indexing: expression1 -> expression2 expression3]] =
	address[[expression1]]
	<load > expression1.type.suffix()


value[[FieldAccess: expression1 -> expression2 ID]] =
	address[[expression1]]
	<load > expression1.type.suffix()

value[[FuncInvocation: expression1 → expression2 expression3*]] =
	expression3*.forEach(exp -> value[[exp]])
	<call > expression2.name
 */
public class ValueCGVisitor extends AbstractCGVisitor<Void, Void> {

    private final CodeGenerator cg;

    private final AddressCGVisitor addressVisitor;

    public ValueCGVisitor(CodeGenerator codeGenerator, AddressCGVisitor addressVisitor){
        this.cg = codeGenerator;
        this.addressVisitor = addressVisitor;
    }

    /*
    value[[IntLiteral: expression -> INT_CONSTANT]] =
	    <pushi > expression.value
     */
    @Override
    public Void visit(IntLiteral v, Void param) {
        cg.pushi(v.getValue());
        return null;
    }

    /*
    value[[CharLiteral: expression -> CHAR_CONSTANT]] =
	    <pushb > (int) expression.value
     */
    @Override
    public Void visit(CharLiteral v, Void param) {
        cg.pushb(v.getValue());
        return null;
    }

    /*
    value[[RealLiteral: expression -> DOUBLE_CONSTANT]] =
	    <pushf > expression.value
     */
    @Override
    public Void visit(DoubleLiteral v, Void param) {
        cg.pushf(v.getValue());
        return null;
    }

    /*
    value[[Variable: expression -> ID]] =
	    address[[expression]]
	    <load > expression.type.suffix()
    */
    @Override
    public Void visit(Variable v, Void param) {
        v.accept(addressVisitor, param);
        cg.load(v.getType());
        return null;
    }

    /*
    value[[Arithmetic: expression1 -> expression2 (+ | - | * | /) expression3]] =
        value[[expression2]]
        expression2.type.arithmeticConvertTo(expression1.type)
        value[[expression3]]
        expression3.type.arithmeticConvertTo(expression1.type)
        switch (expression1.operator) {
            case "+" : <add > expression1.type.suffix() break;
            case "-" : <sub > expression1.type.suffix() break;
            case "*" : <mul > expression1.type.suffix() break;
            case "/" : <div > expression1.type.suffix() break;
            default: assert false;
	    }
	*/
    @Override
    public Void visit(Arithmetic v, Void param) {
        v.getLeft().accept(this, param);
        cg.arithmeticConvertTo(v.getLeft().getType(), v.getType());

        v.getRight().accept(this, param);
        cg.arithmeticConvertTo(v.getRight().getType(), v.getType());

        cg.arithmetic(v.getOperator(), v.getType());

        return null;
    }

    /*
    value[[Modulus: expression1 -> expression2 % expression3]] =
        value[[expression2]]
        expression2.type.arithmeticConvertTo(expression1.type)
        value[[expression3]]
        expression3.type.arithmeticConvertTo(expression1.type)
        <modi>
    */
    @Override
    public Void visit(Modulus v, Void param) {
        v.getLeft().accept(this, param);
        cg.arithmeticConvertTo(v.getLeft().getType(), v.getType());

        v.getRight().accept(this, param);
        cg.arithmeticConvertTo(v.getRight().getType(), v.getType());

        cg.modulus(v.getType());

        return null;
    }

    /*
    value[[Comparison: expression1 -> expression2 (> | < | >= | <= | == | !=) expression3]] =
        value[[expression2]]
        expression2.type.superType(expression1.type)
        value[[expression3]]
        expression3.type.superType(expression1.type)
        switch (expression1.operator) {
            case ">" : <gt > expression1.type.suffix()  break;
            case "<" : <lt > expression1.type.suffix() break;
            case ">=" : <ge > expression1.type.suffix() break;
            case "<=" : <le > expression1.type.suffix() break;
            case "==" : <eq > expression1.type.suffix() break;
            case "!=" : <ne > expression1.type.suffix() break;
            default: assert false;
        }
    */
    @Override
    public Void visit(Comparator v, Void param) {
        v.getLeft().accept(this, param);
        cg.superType(v.getLeft().getType(), v.getType());

        v.getRight().accept(this, param);
        cg.superType(v.getRight().getType(), v.getType());

        cg.comparator(v.getOperator(), v.getType());

        return null;
    }

    /*
    value[[Logical: expression1 -> expression2 (&& | ||) expression3]] =
        value[[expression2]]
        value[[expression3]]
        switch (expression1.operator) {
            case “&&”: <and>
                    break;
            case “||”: <or>
                    break;
            default: assert false;
        }
     */
    @Override
    public Void visit(Logical v, Void param) {
        v.getLeft().accept(this, param);
        v.getRight().accept(this, param);

        cg.logical(v.getOperator());

        return null;
    }

    /*
    value[[Cast: expression1 -> type expression2]] =
        value[[expression2]]
        expression2.type.castTo(type)
     */
    @Override
    public Void visit(Cast v, Void param) {
        v.getExpression().accept(this, param);

        cg.castTo(v.getExpression().getType(), v.getCastType());

        return null;
    }

    /*
    value[[UnaryNot: expression1 -> expression2]] =
        value[[expression2]]
        <not>
     */
    @Override
    public Void visit(UnaryNot v, Void param) {
        v.getExpression().accept(this, param);

        cg.unaryNot();

        return null;
    }

    /*
    value[[Indexing: expression1 -> expression2 expression3]] =
        address[[expression1]]
        <load > expression1.type.suffix()
     */
    @Override
    public Void visit(Indexing v, Void param) {
        v.accept(addressVisitor, param);

        cg.load(v.getType());

        // Check the index bounds of the array size
        int size = ((ArrayType) v.getExpressionLeft().getType()).getSize();

        try {
            if (((IntLiteral) v.getExpressionRight()).getValue() >=  size || ((IntLiteral) v.getExpressionRight()).getValue() < 0)
                new ErrorType(v.getLine(), v.getColumn(), String.format("Code generation ERROR: index out of bounds, the size is %s", size));
        } catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }

        return null;
    }

    /*
    value[[FieldAccess: expression1 -> expression2 ID]] =
        address[[expression1]]
        <load > expression1.type.suffix()
     */
    @Override
    public Void visit(FieldAccess v, Void param) {
        v.accept(addressVisitor, param);

        cg.load(v.getType());

        return null;
    }

    /*
    value[[FuncInvocation: expression1 → expression2 expression3*]] =
        expression3*.forEach(exp -> value[[exp]])
        <call > expression2.name
     */
    @Override
    public Void visit(FuncInvocation v, Void param) {
        v.getParams().forEach(exp -> exp.accept(this, param));

        cg.callFunction(v.getVariable().getName());

        return null;
    }
}
