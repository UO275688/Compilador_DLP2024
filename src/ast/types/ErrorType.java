package ast.types;

import ast.ASTNode;
import errorhandler.ErrorHandler;
import semantic.Visitor;

import java.util.List;

public class ErrorType extends AbstractType implements Type, ASTNode {

    private String message;

    public ErrorType(int line, int column, String message) {
        super(line, column);
        this.message = message;
        ErrorHandler.getInstance().addError(this);
    }

    public String getMessage() {
        return message;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String getNameType() {
        return toString();
    }

    @Override
    public String toString() {
        return "ErrorType{" +
                "line='" + getLine() +
                ", column='" + getColumn() +
                ", message='" + getMessage() + '\'' +
                '}';
    }
}
