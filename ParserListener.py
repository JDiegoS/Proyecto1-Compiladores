# Generated from Parser.g4 by ANTLR 4.10.1
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .ParserParser import ParserParser
else:
    from ParserParser import ParserParser

# This class defines a complete listener for a parse tree produced by ParserParser.
class ParserListener(ParseTreeListener):

    # Enter a parse tree produced by ParserParser#program.
    def enterProgram(self, ctx:ParserParser.ProgramContext):
        pass

    # Exit a parse tree produced by ParserParser#program.
    def exitProgram(self, ctx:ParserParser.ProgramContext):
        pass


    # Enter a parse tree produced by ParserParser#ClassDec.
    def enterClassDec(self, ctx:ParserParser.ClassDecContext):
        pass

    # Exit a parse tree produced by ParserParser#ClassDec.
    def exitClassDec(self, ctx:ParserParser.ClassDecContext):
        pass


    # Enter a parse tree produced by ParserParser#MethodFeature.
    def enterMethodFeature(self, ctx:ParserParser.MethodFeatureContext):
        pass

    # Exit a parse tree produced by ParserParser#MethodFeature.
    def exitMethodFeature(self, ctx:ParserParser.MethodFeatureContext):
        pass


    # Enter a parse tree produced by ParserParser#AssignFeature.
    def enterAssignFeature(self, ctx:ParserParser.AssignFeatureContext):
        pass

    # Exit a parse tree produced by ParserParser#AssignFeature.
    def exitAssignFeature(self, ctx:ParserParser.AssignFeatureContext):
        pass


    # Enter a parse tree produced by ParserParser#param.
    def enterParam(self, ctx:ParserParser.ParamContext):
        pass

    # Exit a parse tree produced by ParserParser#param.
    def exitParam(self, ctx:ParserParser.ParamContext):
        pass


    # Enter a parse tree produced by ParserParser#WhileExpr.
    def enterWhileExpr(self, ctx:ParserParser.WhileExprContext):
        pass

    # Exit a parse tree produced by ParserParser#WhileExpr.
    def exitWhileExpr(self, ctx:ParserParser.WhileExprContext):
        pass


    # Enter a parse tree produced by ParserParser#MulExpr.
    def enterMulExpr(self, ctx:ParserParser.MulExprContext):
        pass

    # Exit a parse tree produced by ParserParser#MulExpr.
    def exitMulExpr(self, ctx:ParserParser.MulExprContext):
        pass


    # Enter a parse tree produced by ParserParser#StringExpr.
    def enterStringExpr(self, ctx:ParserParser.StringExprContext):
        pass

    # Exit a parse tree produced by ParserParser#StringExpr.
    def exitStringExpr(self, ctx:ParserParser.StringExprContext):
        pass


    # Enter a parse tree produced by ParserParser#TrueExpr.
    def enterTrueExpr(self, ctx:ParserParser.TrueExprContext):
        pass

    # Exit a parse tree produced by ParserParser#TrueExpr.
    def exitTrueExpr(self, ctx:ParserParser.TrueExprContext):
        pass


    # Enter a parse tree produced by ParserParser#IdExpr.
    def enterIdExpr(self, ctx:ParserParser.IdExprContext):
        pass

    # Exit a parse tree produced by ParserParser#IdExpr.
    def exitIdExpr(self, ctx:ParserParser.IdExprContext):
        pass


    # Enter a parse tree produced by ParserParser#IfThenExpr.
    def enterIfThenExpr(self, ctx:ParserParser.IfThenExprContext):
        pass

    # Exit a parse tree produced by ParserParser#IfThenExpr.
    def exitIfThenExpr(self, ctx:ParserParser.IfThenExprContext):
        pass


    # Enter a parse tree produced by ParserParser#LetExpr.
    def enterLetExpr(self, ctx:ParserParser.LetExprContext):
        pass

    # Exit a parse tree produced by ParserParser#LetExpr.
    def exitLetExpr(self, ctx:ParserParser.LetExprContext):
        pass


    # Enter a parse tree produced by ParserParser#NegExpr.
    def enterNegExpr(self, ctx:ParserParser.NegExprContext):
        pass

    # Exit a parse tree produced by ParserParser#NegExpr.
    def exitNegExpr(self, ctx:ParserParser.NegExprContext):
        pass


    # Enter a parse tree produced by ParserParser#LtExpr.
    def enterLtExpr(self, ctx:ParserParser.LtExprContext):
        pass

    # Exit a parse tree produced by ParserParser#LtExpr.
    def exitLtExpr(self, ctx:ParserParser.LtExprContext):
        pass


    # Enter a parse tree produced by ParserParser#AddExpr.
    def enterAddExpr(self, ctx:ParserParser.AddExprContext):
        pass

    # Exit a parse tree produced by ParserParser#AddExpr.
    def exitAddExpr(self, ctx:ParserParser.AddExprContext):
        pass


    # Enter a parse tree produced by ParserParser#AssignExpr.
    def enterAssignExpr(self, ctx:ParserParser.AssignExprContext):
        pass

    # Exit a parse tree produced by ParserParser#AssignExpr.
    def exitAssignExpr(self, ctx:ParserParser.AssignExprContext):
        pass


    # Enter a parse tree produced by ParserParser#BraceExpr.
    def enterBraceExpr(self, ctx:ParserParser.BraceExprContext):
        pass

    # Exit a parse tree produced by ParserParser#BraceExpr.
    def exitBraceExpr(self, ctx:ParserParser.BraceExprContext):
        pass


    # Enter a parse tree produced by ParserParser#IsvoidExpr.
    def enterIsvoidExpr(self, ctx:ParserParser.IsvoidExprContext):
        pass

    # Exit a parse tree produced by ParserParser#IsvoidExpr.
    def exitIsvoidExpr(self, ctx:ParserParser.IsvoidExprContext):
        pass


    # Enter a parse tree produced by ParserParser#FalseExpr.
    def enterFalseExpr(self, ctx:ParserParser.FalseExprContext):
        pass

    # Exit a parse tree produced by ParserParser#FalseExpr.
    def exitFalseExpr(self, ctx:ParserParser.FalseExprContext):
        pass


    # Enter a parse tree produced by ParserParser#MethodDotExpr.
    def enterMethodDotExpr(self, ctx:ParserParser.MethodDotExprContext):
        pass

    # Exit a parse tree produced by ParserParser#MethodDotExpr.
    def exitMethodDotExpr(self, ctx:ParserParser.MethodDotExprContext):
        pass


    # Enter a parse tree produced by ParserParser#DivExpr.
    def enterDivExpr(self, ctx:ParserParser.DivExprContext):
        pass

    # Exit a parse tree produced by ParserParser#DivExpr.
    def exitDivExpr(self, ctx:ParserParser.DivExprContext):
        pass


    # Enter a parse tree produced by ParserParser#EqualsExpr.
    def enterEqualsExpr(self, ctx:ParserParser.EqualsExprContext):
        pass

    # Exit a parse tree produced by ParserParser#EqualsExpr.
    def exitEqualsExpr(self, ctx:ParserParser.EqualsExprContext):
        pass


    # Enter a parse tree produced by ParserParser#NewExpr.
    def enterNewExpr(self, ctx:ParserParser.NewExprContext):
        pass

    # Exit a parse tree produced by ParserParser#NewExpr.
    def exitNewExpr(self, ctx:ParserParser.NewExprContext):
        pass


    # Enter a parse tree produced by ParserParser#MethodParenExpr.
    def enterMethodParenExpr(self, ctx:ParserParser.MethodParenExprContext):
        pass

    # Exit a parse tree produced by ParserParser#MethodParenExpr.
    def exitMethodParenExpr(self, ctx:ParserParser.MethodParenExprContext):
        pass


    # Enter a parse tree produced by ParserParser#LequalExpr.
    def enterLequalExpr(self, ctx:ParserParser.LequalExprContext):
        pass

    # Exit a parse tree produced by ParserParser#LequalExpr.
    def exitLequalExpr(self, ctx:ParserParser.LequalExprContext):
        pass


    # Enter a parse tree produced by ParserParser#NotExpr.
    def enterNotExpr(self, ctx:ParserParser.NotExprContext):
        pass

    # Exit a parse tree produced by ParserParser#NotExpr.
    def exitNotExpr(self, ctx:ParserParser.NotExprContext):
        pass


    # Enter a parse tree produced by ParserParser#IntExpr.
    def enterIntExpr(self, ctx:ParserParser.IntExprContext):
        pass

    # Exit a parse tree produced by ParserParser#IntExpr.
    def exitIntExpr(self, ctx:ParserParser.IntExprContext):
        pass


    # Enter a parse tree produced by ParserParser#ParenExpr.
    def enterParenExpr(self, ctx:ParserParser.ParenExprContext):
        pass

    # Exit a parse tree produced by ParserParser#ParenExpr.
    def exitParenExpr(self, ctx:ParserParser.ParenExprContext):
        pass


    # Enter a parse tree produced by ParserParser#MinusExpr.
    def enterMinusExpr(self, ctx:ParserParser.MinusExprContext):
        pass

    # Exit a parse tree produced by ParserParser#MinusExpr.
    def exitMinusExpr(self, ctx:ParserParser.MinusExprContext):
        pass



del ParserParser