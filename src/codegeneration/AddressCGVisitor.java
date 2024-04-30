package codegeneration;

import ast.definitions.VarDefinition;
import ast.expressions.FieldAccess;
import ast.expressions.Indexing;
import ast.expressions.Variable;
import ast.types.IntType;
import ast.types.RecordType;

/*
    address[[Variable: expression -> ID]] =
	if (expression.definition.scope==0)
		<pusha> expression.definition.offset
	else {
		<push bp>
		<pushi> expression.definition.offset
		<addi>
	}

	// Example to access the address of v[i]:
    // &v + i * type.numberOfBytes()

    address[[Indexing: expression1 -> expression2 expression3]] =
        address[[expression2]]
        value[[expression3]]
        <pushi > expression1.type.numberOfBytes()
        <muli>
        <addi>


    address[[FieldAccess: expression1 -> expression2 ID]] =
        address[[expression2]]
        <pushi > exp2.type.getField(ID).offset
        <addi>
 */
public class AddressCGVisitor extends AbstractCGVisitor<Void, Void>{

    private CodeGenerator cg;

    private ValueCGVisitor valueCGVisitor;

    public AddressCGVisitor(CodeGenerator codeGenerator){
        this.cg = codeGenerator;
    }

    public void setValueCGVisitor(ValueCGVisitor valueCGVisitor) {
        this.valueCGVisitor = valueCGVisitor;
    }

    /*
    address[[Variable: expression -> ID]] =
        if (expression.definition.scope==0)
            <pusha > expression.definition.offset
        else {
            <push bp>
            <pushi > expression.definition.offset
            <addi >
        }
    */
    @Override
    public Void visit(Variable v, Void param) {
        if (v.getDefinition().getScope() == 0)
            cg.pusha( ((VarDefinition) v.getDefinition()).getOffset() );
        else{
           cg.pushBP();
           cg.pushi(((VarDefinition) v.getDefinition()).getOffset());
           cg.addi();
        }

        return null;
    }

    /*
	// Example to access the address of v[i]:
    // &v + i * type.numberOfBytes()

    address[[Indexing: expression1 -> expression2 expression3]] =
        address[[expression2]]
        value[[expression3]]
        <pushi > expression1.type.numberOfBytes()
        <muli>
        <addi>
     */
    @Override
    public Void visit(Indexing v, Void param) {
        v.getExpressionLeft().accept(this, param);
        v.getExpressionRight().accept(valueCGVisitor, param);

        cg.pushi(v.getType().numberOfBytes());
        cg.muli();
        cg.addi();

        return null;
    }

    /*
    address[[FieldAccess: expression1 -> expression2 ID]] =
        address[[expression2]]
        <pushi > exp2.type.getField(ID).offset
        <addi>
    */
    @Override
    public Void visit(FieldAccess v, Void param) {
        v.getExpression().accept(this, param);
        cg.pushi( ((RecordType)v.getExpression().getType()).getField(v.getFieldName()).getOffset() );
        cg.addi();

        return null;
    }
}
