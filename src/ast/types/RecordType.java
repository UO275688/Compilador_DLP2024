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
    public Type dot(String recordField, ASTNode node) {
        for(RecordField field : fields)
            if(field.getName().equals(recordField))
                return field.getType();

        return new ErrorType(node.getLine(), node.getColumn(), String.format("Semantic ERROR: record field %s does NOT exist.", recordField));
    }

    @Override
    public boolean equivalent(Type t) {
        if(t instanceof RecordType)
            return true;
        return false;
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
