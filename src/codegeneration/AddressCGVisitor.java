package codegeneration;

import ast.definitions.VarDefinition;
import ast.expressions.Variable;

/*
    address[[Variable: expression -> ID]] =
	if (expression.definition.scope==0)
		<pusha> expression.definition.offset
	else {
		<push bp>
		<pushi> expression.definition.offset
		<addi>
	}
 */
public class AddressCGVisitor extends AbstractCGVisitor<Void, Void>{

    private CodeGenerator cg;

    public AddressCGVisitor(CodeGenerator codeGenerator){
        this.cg = codeGenerator;
    }

    /*
    address[[Variable: expression -> ID]] =
	if (expression.definition.scope==0)
		<pusha> expression.definition.offset
	else {
		<push bp>
		<pushi> expression.definition.offset
		<addi>
	}
     */
    @Override
    public Void visit(Variable v, Void param) {
        if (v.getDefinition().getScope() == 0)
            cg.pusha( ((VarDefinition) v.getDefinition()).getOffset() );
        else{
           cg.pushBP();
           cg.pushi(((VarDefinition) v.getDefinition()).getOffset());
           cg.add(v.getType());
        }

        return null;
    }
}
