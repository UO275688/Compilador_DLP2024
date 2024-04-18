package ast.types;

import ast.ASTNode;
import ast.AbstractASTNode;
import ast.RecordField;
import semantic.Visitor;

import java.util.ArrayList;
import java.util.List;

public class RecordType extends AbstractType implements Type, ASTNode {

    private List<RecordField> fields;

    public RecordType(int line, int column, List<RecordField> fields) {
        super(line, column);
        this.fields = new ArrayList<RecordField>(fields);
    }

    public List<RecordField> getFields() {
        return fields;
    }

    @Override
    public int numberOfBytes() {
        int fieldsBytesSum = 0;

        for (RecordField rf : this.fields)
            fieldsBytesSum += rf.getType().numberOfBytes();

        return fieldsBytesSum;

        // Aggregation / reduction
        // return this.fields.stream().mapToInt(rf -> rf.type.numberOfBytes()).sum();
    }

    @Override
    public Type dot(String recordField, ASTNode node) {
        for(RecordField field : fields)
            if(field.getName().equals(recordField))
                return field.getType();

        return new ErrorType(node.getLine(), node.getColumn(), String.format("Semantic ERROR: record field %s does NOT exist.", recordField));
    }

    @Override
    public boolean promotableTo(Type t) {
        if(t instanceof RecordType)
            return true;
        return false;
    }

    @Override
    public String getNameType() {
        return "struct";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "RecordType{" +
                "fields=" + fields +
                '}';
    }
}
