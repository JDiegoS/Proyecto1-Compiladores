import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.FileInputStream;

public class Main {

    public static void main(String[] args) throws Exception {


        FileInputStream inputStream = new FileInputStream("test.cl");        
        ANTLRInputStream input = new ANTLRInputStream(inputStream);
        ParserLexer lexer = new ParserLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ParserParser parser = new ParserParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new Error());
        ParseTree tree = parser.program();
        ParserBaseVisitor visitor = new ParserBaseVisitor();
        visitor.visit(tree);
    }
}