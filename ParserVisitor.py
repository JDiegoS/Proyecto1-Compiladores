# Generated from Parser.g4 by ANTLR 4.10.1
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .ParserParser import ParserParser
else:
    from ParserParser import ParserParser

# This class defines a complete generic visitor for a parse tree produced by ParserParser.

class ParserVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by ParserParser#program.
    def visitProgram(self, ctx:ParserParser.ProgramContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ParserParser#ClassDec.
    def visitClassDec(self, ctx:ParserParser.ClassDecContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ParserParser#MethodFeature.
    def visitMethodFeature(self, ctx:ParserParser.MethodFeatureContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ParserParser#AssignFeature.
    def visitAssignFeature(self, ctx:ParserParser.AssignFeatureContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ParserParser#param.
    def visitParam(self, ctx:ParserParser.ParamContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ParserParser#WhileExpr.
    def visitWhileExpr(self, ctx:ParserParser.WhileExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ParserParser#MulExpr.
    def visitMulExpr(self, ctx:ParserParser.MulExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ParserParser#StringExpr.
    def visitStringExpr(self, ctx:ParserParser.StringExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ParserParser#TrueExpr.
    def visitTrueExpr(self, ctx:ParserParser.TrueExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ParserParser#IdExpr.
    def visitIdExpr(self, ctx:ParserParser.IdExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ParserParser#IfThenExpr.
    def visitIfThenExpr(self, ctx:ParserParser.IfThenExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ParserParser#LetExpr.
    def visitLetExpr(self, ctx:ParserParser.LetExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ParserParser#NegExpr.
    def visitNegExpr(self, ctx:ParserParser.NegExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ParserParser#LtExpr.
    def visitLtExpr(self, ctx:ParserParser.LtExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ParserParser#AddExpr.
    def visitAddExpr(self, ctx:ParserParser.AddExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ParserParser#AssignExpr.
    def visitAssignExpr(self, ctx:ParserParser.AssignExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ParserParser#BraceExpr.
    def visitBraceExpr(self, ctx:ParserParser.BraceExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ParserParser#IsvoidExpr.
    def visitIsvoidExpr(self, ctx:ParserParser.IsvoidExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ParserParser#FalseExpr.
    def visitFalseExpr(self, ctx:ParserParser.FalseExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ParserParser#MethodDotExpr.
    def visitMethodDotExpr(self, ctx:ParserParser.MethodDotExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ParserParser#DivExpr.
    def visitDivExpr(self, ctx:ParserParser.DivExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ParserParser#EqualsExpr.
    def visitEqualsExpr(self, ctx:ParserParser.EqualsExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ParserParser#NewExpr.
    def visitNewExpr(self, ctx:ParserParser.NewExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ParserParser#MethodParenExpr.
    def visitMethodParenExpr(self, ctx:ParserParser.MethodParenExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ParserParser#LequalExpr.
    def visitLequalExpr(self, ctx:ParserParser.LequalExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ParserParser#NotExpr.
    def visitNotExpr(self, ctx:ParserParser.NotExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ParserParser#IntExpr.
    def visitIntExpr(self, ctx:ParserParser.IntExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ParserParser#ParenExpr.
    def visitParenExpr(self, ctx:ParserParser.ParenExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ParserParser#MinusExpr.
    def visitMinusExpr(self, ctx:ParserParser.MinusExprContext):
        return self.visitChildren(ctx)



del ParserParser