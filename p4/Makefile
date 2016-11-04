###
# This Makefile can be used to make a parser for the cats language
# (parser.class) and to make a program (P4.class) that tests the parser and
# the unparse methods in ast.java.
#
# make clean removes all generated files.
#
###

JC = javac -Xdiags:verbose 
CP2 = ~cs536-1/public/tools/deps_src/java-cup-11b.jar:~cs536-1/public/tools/deps_src/java-cup-11b-runtime.jar:~cs536-1/public/tools/deps:.
CP = ~cs536-1/public/tools/deps:.

P4.class: P4.java parser.class Yylex.class ASTnode.class
	$(JC)    P4.java

parser.class: parser.java ASTnode.class Yylex.class ErrMsg.class
	$(JC)      parser.java

parser.java: cats.cup
	java   java_cup.Main < cats.cup

Yylex.class: cats.jlex.java sym.class ErrMsg.class
	$(JC)   cats.jlex.java

ASTnode.class: ast.java
	$(JC)  ast.java

cats.jlex.java: cats.jlex sym.class
	java    JLex.Main cats.jlex

sym.class: sym.java
	$(JC)    sym.java

sym.java: cats.cup
	java    java_cup.Main < cats.cup

ErrMsg.class: ErrMsg.java
	$(JC) ErrMsg.java

##test
t:
	java P4 nameErrors.cf nameErrors.txt
	java P4 test.cf out_ok.txt
	cat out_ok.txt

###
# clean
###
clean:
	rm -f *~ *.class parser.java cats.jlex.java sym.java
