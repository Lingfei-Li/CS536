###
# This Makefile can be used to make a scanner for the cats language
# (Yylex.class) and to make a program that tests the scanner (P2.class).
#
# The default makes both the scanner and the test program.
#
# make clean removes all generated files.
#
# Note: P2.java will not compile unless Yylex.class exists.
#
###

# define the java compiler to be used and the flags
JC = javac
FLAGS = -g -cp $(CP)
CP = ~cs536-1/public/tools/deps:.

P2.class: P2.java Yylex.class sym.class
	$(JC) $(FLAGS) P2.java

Yylex.class: cats.jlex.java ErrMsg.class sym.class
	$(JC) $(FLAGS) cats.jlex.java

cats.jlex.java: cats.jlex sym.class
	java -cp $(CP) JLex.Main cats.jlex

sym.class: sym.java
	$(JC) $(FLAGS) sym.java

ErrMsg.class: ErrMsg.java
	$(JC) $(FLAGS) ErrMsg.java


	
###
# testing - add more here to run your tester and compare its results
# to expected results
###
INPUT = testFile/intLit.in testFile/strLit.in testFile/id.in testFile/reservedAndOperators.in testFile/commentsAndIllegal.in
test:
	java -cp $(CP) P2 $(INPUT)
	diff testFile/intLit.in.ans testFile/intLit.in.out
	diff testFile/intLit.in.err.ans testFile/intLit.in.err
	diff testFile/strLit.in.ans testFile/strLit.in.out
	diff testFile/strLit.in.err.ans testFile/strLit.in.err
	diff testFile/id.in.ans testFile/id.in.out
	diff testFile/id.in.err.ans testFile/id.in.err
	diff testFile/reservedAndOperators.in.ans testFile/reservedAndOperators.in.out
	diff testFile/reservedAndOperators.in.err.ans testFile/reservedAndOperators.in.err
	diff testFile/commentsAndIllegal.in.ans testFile/commentsAndIllegal.in.out
	diff testFile/commentsAndIllegal.in.err.ans testFile/commentsAndIllegal.in.err

###
# clean up
###

clean:
	rm -f *~ *.class cats.jlex.java foo.jlex.java

cleantest:
	rm -f testFile/*.out 
	rm -f testFile/*.err
