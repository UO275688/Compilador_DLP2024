package ast.types;

import ast.ASTNode;
import ast.AbstractASTNode;
import errorhandler.ErrorHandler;

public class ErrorType extends AbstractASTNode implements Type, ASTNode {

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
    public String toString() {
        return "ErrorType{" +
                "line='" + getLine() +
                ", column='" + getColumn() +
                ", message='" + getMessage() + '\'' +
                '}';
    }
}
