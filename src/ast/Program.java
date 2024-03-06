package ast;

import ast.definitions.Definition;

import java.util.ArrayList;
import java.util.List;

public class Program extends AbstractASTNode implements  ASTNode{

    private List<Definition> definitions;

    public Program(int line, int column, List<Definition> definitions) {
        super(line, column);
        this.definitions = new ArrayList<Definition>(definitions);
    }

    public List<Definition> getDefinitions() {
        return definitions;
    }

    @Override
    public String toString() {
        return "Program{" +
                "definitions=" + definitions +
                '}';
    }
}
