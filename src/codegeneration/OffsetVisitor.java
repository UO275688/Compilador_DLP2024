package codegeneration;

import ast.RecordField;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.types.FunctionType;
import ast.types.RecordType;
import semantic.AbstractVisitor;

import java.util.List;

/*

------------------------- GLOBAL VARIABLES

&global = Σ numberOfBytes( types( previous global, itself excluded ) )

P: VarDefinition: definition -> type ID
R:
if (definition.scope == 0) {
    definition.offset = globalsBytesSum;        // global field initialized to 0
    globalsBytesSum += type.numberOfBytes();
}

------------------------- LOCAL VARIABLES

&localVariable = BP – Σ numberOfBytes( types( previous local variables, itself included ) )

(P) FuncDefinition: definition -> type varDefinitions* statements*
(R)
int localBytesSum = 0;
for (VarDefinition v : varDefinitions*) {
    localBytesSum += v.type.numberOfBytes();
    v.offset = - localBytesSum;
}

------------------------- PARAMETERS

&parameter = BP + 4 + Σ numberOfBytes( types( right-most parameters, itself excluded ) )

(P) FunctionType: type1 -> type2 definition*
(R)
int paramBytesSum = 0;
for (int i = definition*.size(); i >= 0; i--) {
    definition*.get(i).offset = paramBytesSum + 4;
    paramBytesSum += v.type.numberOfBytes();
}

------------------------- RECORD FIELDS

&recordField = Σ numberOfBytes( types( previous fields, itself excluded ) )

(P) RecordType: type -> fields
(R)
int fieldsBytesSum = 0;
for (RecordField rf : fields*) {
	rf.offset = fieldsBytesSum;
	fieldsBytesSum += rf.type.numberOfBytes();
}

 */
public class OffsetVisitor extends AbstractVisitor<Void, Void> {

    private int globalsBytesSum = 0;

    /*
    GLOBAL VARIABLES

    &global = Σ numberOfBytes( types( previous global, itself excluded ) )

    P: VarDefinition: definition -> type ID
    R:
    if (definition.scope == 0) {
        definition.offset = globalsBytesSum;        // global field initialized to 0
        globalsBytesSum += type.numberOfBytes();
    }
     */
    @Override
    public Void visit(VarDefinition v, Void param) {
        v.getType().accept(this, param);

        // Global scope
        if (v.getScope() == 0) {
            v.setOffset(globalsBytesSum);
            globalsBytesSum += v.getType().numberOfBytes();
        }

        return null;
    }

    /*
    LOCAL VARIABLES

    &localVariable = BP – Σ numberOfBytes( types( previous local variables, itself included ) )

    (P) FuncDefinition: definition -> type definition* statements*
    (R)
    int localBytesSum = 0;
    for (VarDefinition v : varDefinitions*) {
        localBytesSum += v.type.numberOfBytes();
        v.offset = - localBytesSum;
    }
     */
    @Override
    public Void visit(FuncDefinition f, Void param) {
        int localBytesSum = 0;

        f.getType().accept(this, param);

        List<VarDefinition> vardefs = f.getVarDefinitions();

        for (VarDefinition v : vardefs) {
            v.accept(this, param);
            localBytesSum += v.getType().numberOfBytes();
            v.setOffset(- localBytesSum);
        }

        return null;
    }

    /*
    PARAMETERS

    &parameter = BP + 4 + Σ numberOfBytes( types( right-most parameters, itself excluded ) )

    (P) FunctionType: type1 -> type2 definition*
    (R)
    int paramBytesSum = 0;
    for (int i = definition*.size(); i >= 0; i--) {
        definition*.get(i).offset = paramBytesSum + 4;
        paramBytesSum += v.type.numberOfBytes();
    }
     */
    @Override
    public Void visit(FunctionType v, Void param) {
        v.getReturnType().accept(this, param);

        int paramBytesSum = 0;

        List<VarDefinition> params = v.getParams();
        for (int i = params.size() - 1; i >= 0; i--) {
            params.get(i).setOffset(paramBytesSum + 4);
            paramBytesSum += params.get(i).getType().numberOfBytes();
        }

        return null;
    }

    /*
    RECORD FIELDS

    &recordField = Σ numberOfBytes( types( previous fields, itself excluded ) )

    (P) RecordType: type -> fields
    (R)
    int fieldsBytesSum = 0;
    for (RecordField rf : fields*) {
        rf.offset = fieldsBytesSum;
        fieldsBytesSum += rf.type.numberOfBytes();
    }
     */
    @Override
    public Void visit(RecordType v, Void param) {
        int fieldsBytesSum = 0;

        // Post-order traversal for the children, in case we have another struct inside
        for (RecordField rf : v.getFields()) {
            rf.accept(this, param);
            rf.setOffset(fieldsBytesSum);
            fieldsBytesSum += rf.getType().numberOfBytes();
        }

        return null;
    }
}
