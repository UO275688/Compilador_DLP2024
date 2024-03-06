package ast.types;

import ast.ASTNode;
import ast.AbstractASTNode;
import ast.RecordField;

import java.util.ArrayList;
import java.util.List;

public class RecordType extends AbstractASTNode implements Type, ASTNode {

    private List<RecordField> fields;

    public RecordType(int line, int column, List<RecordField> fields) {
        super(line, column);
        this.fields = new ArrayList<RecordField>(fields);
    }

    public List<RecordField> getFields() {
        return fields;
    }

    @Override
    public String toString() {
        return "RecordType{" +
                "fields=" + fields +
                '}';
    }
}
