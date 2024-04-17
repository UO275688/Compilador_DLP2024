import ast.Program;
import codegeneration.CodeGenerator;
import codegeneration.ExecuteCGVisitor;
import codegeneration.OffsetVisitor;
import errorhandler.ErrorHandler;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorView;
import parser.*;

import org.antlr.v4.runtime.*;
import semantic.IdentificationVisitor;
import semantic.TypeCheckingVisitor;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String... args) throws Exception {
		if (args.length < 1) {
			System.err.println("Please, pass me the input file.");
			return;
		}

		// create a lexer that feeds off of input CharStream
		CharStream input = CharStreams.fromFileName(args[0]);
		String inputFile = args[0].toString();
		String output = args[1].toString();
		CmmLexer lexer = new CmmLexer(input);

		// create a parser that feeds off the tokens buffer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CmmParser parser = new CmmParser(tokens);

		Program ast = parser.program().ast;

		// Identification phase is done prior to type checking
		ast.accept(new IdentificationVisitor(),null);
		if (ErrorHandler.getInstance().anyErrors())
			ErrorHandler.getInstance().showErrors(System.err);
		else
		ast.accept(new TypeCheckingVisitor(),null);

		ast.accept(new OffsetVisitor(),null);

		if (ErrorHandler.getInstance().anyErrors())
			ErrorHandler.getInstance().showErrors(System.err);
		else {
			// * The AST is shown if no errors exist
			ast.accept(new ExecuteCGVisitor(new CodeGenerator(inputFile, output)), null);
			IntrospectorModel model=new IntrospectorModel(
					"Program", ast);
			new IntrospectorView("Introspector", model);
		}
	}
}
