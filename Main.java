import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.gui.TestRig;
import java.io.FileInputStream;

public class Main {

    public static void main(String[] args) throws Exception {


        FileInputStream inputStream = new FileInputStream("test.cl");        
        ANTLRInputStream input = new ANTLRInputStream(inputStream);
        ParserLexer lexer = new ParserLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ParserParser parser = new ParserParser(tokens);
        ParseTree tree = parser.program();
        // Mostrar Arbol
        TestRig.main(new String[]{"Parser" ,"program", "-gui", "-tokens", "test.cl"});
    }
}