// Generated from Parser.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ParserParser}.
 */
public interface ParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ParserParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ParserParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ParserParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#newClass}.
	 * @param ctx the parse tree
	 */
	void enterNewClass(ParserParser.NewClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#newClass}.
	 * @param ctx the parse tree
	 */
	void exitNewClass(ParserParser.NewClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#feature}.
	 * @param ctx the parse tree
	 */
	void enterFeature(ParserParser.FeatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#feature}.
	 * @param ctx the parse tree
	 */
	void exitFeature(ParserParser.FeatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(ParserParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(ParserParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterWhileExpr(ParserParser.WhileExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitWhileExpr(ParserParser.WhileExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulExpr(ParserParser.MulExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulExpr(ParserParser.MulExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterStringExpr(ParserParser.StringExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitStringExpr(ParserParser.StringExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TrueExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTrueExpr(ParserParser.TrueExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TrueExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTrueExpr(ParserParser.TrueExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(ParserParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(ParserParser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfThenExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIfThenExpr(ParserParser.IfThenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfThenExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIfThenExpr(ParserParser.IfThenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LetExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLetExpr(ParserParser.LetExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LetExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLetExpr(ParserParser.LetExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NegExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNegExpr(ParserParser.NegExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NegExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNegExpr(ParserParser.NegExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LtExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLtExpr(ParserParser.LtExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LtExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLtExpr(ParserParser.LtExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(ParserParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(ParserParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DotExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDotExpr(ParserParser.DotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DotExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDotExpr(ParserParser.DotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdParenExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdParenExpr(ParserParser.IdParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdParenExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdParenExpr(ParserParser.IdParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpr(ParserParser.AssignExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpr(ParserParser.AssignExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BraceExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBraceExpr(ParserParser.BraceExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BraceExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBraceExpr(ParserParser.BraceExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IsvoidExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIsvoidExpr(ParserParser.IsvoidExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IsvoidExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIsvoidExpr(ParserParser.IsvoidExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FalseExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFalseExpr(ParserParser.FalseExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FalseExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFalseExpr(ParserParser.FalseExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DivExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDivExpr(ParserParser.DivExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DivExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDivExpr(ParserParser.DivExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqualsExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqualsExpr(ParserParser.EqualsExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqualsExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqualsExpr(ParserParser.EqualsExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NewExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNewExpr(ParserParser.NewExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NewExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNewExpr(ParserParser.NewExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LequalExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLequalExpr(ParserParser.LequalExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LequalExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLequalExpr(ParserParser.LequalExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(ParserParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(ParserParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIntExpr(ParserParser.IntExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIntExpr(ParserParser.IntExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(ParserParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(ParserParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MinusExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMinusExpr(ParserParser.MinusExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MinusExpr}
	 * labeled alternative in {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMinusExpr(ParserParser.MinusExprContext ctx);
}