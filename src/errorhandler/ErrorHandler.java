package errorhandler;

import ast.types.ErrorType;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ErrorHandler {

    public static ErrorHandler errorHandler = new ErrorHandler();

    private List<ErrorType> errors;

    private ErrorHandler(){
        this.errors = new ArrayList<>();
    }

    public static ErrorHandler getInstance(){
        return errorHandler;
    }

    public boolean anyErrors(){
        return !errors.isEmpty();
    }

    public void showErrors(PrintStream out){
        for(ErrorType e : errors)
            out.println(e.toString());
    }

    public void addError(ErrorType e){
        errors.add(e);
    }

    public List<ErrorType> getErrors() {
        return errors;
    }

    @Override
    public String toString() {
        return "ErrorHandler{" +
                "errors=" + errors +
                '}';
    }
}
