import java.util.*;
import java.io.*;
import java_cup.runtime.*;  // defines Symbol

/**
 * This program is to be used to test the Scanner.
 * This version is set up to test all tokens, but more code is needed to test 
 * other aspects of the scanner (e.g., input that causes errors, character 
 * numbers, values associated with tokens)
 */
public class P2 {
    public static void main(String[] args) throws IOException {
                                           // exception may be thrown by yylex
        
        for(String filename : args) {
            System.out.println(filename);
            CharNum.num = 1;
            testAllTokens(filename);
        }
    }

    /**
     * testAllTokens
     *
     * Open and read from file allTokens.txt
     * For each token read, write the corresponding string to allTokens.out
     * If the input file contains all tokens, one per line, we can verify
     * correctness of the scanner by comparing the input and output files
     * (e.g., using a 'diff' command).
     */
    private static void testAllTokens(String inputFilename) throws IOException {
        // open input and output files
        FileReader inFile = null;
        PrintWriter outFile = null;
        PrintWriter errFile = null;
        try {
            inFile = new FileReader(inputFilename);
            outFile = new PrintWriter(new FileWriter(inputFilename+".out"));
            PrintStream errStream = new PrintStream( inputFilename+".err");
            System.setErr(errStream);           //Redirecting stderr to a file 
        } catch (FileNotFoundException ex) {
            System.err.println("File "+inputFilename+"not found.");
            System.exit(-1);
        } catch (IOException ex) {
            System.err.println(inputFilename+".out cannot be opened.");
            System.exit(-1);
        }

        // create and call the scanner
        Yylex scanner = new Yylex(inFile);
        Symbol token = scanner.next_token();
        while (token == null || token.sym != sym.EOF) {
            if(token != null) { //else: comments or bad cases
                switch (token.sym) {
                case sym.BOOL:
                    outFile.println("bool"); 
                    break;
                case sym.INT:
                    outFile.println("int");
                    break;
                case sym.VOID:
                    outFile.println("void");
                    break;
                case sym.TRUE:
                    outFile.println("true"); 
                    break;
                case sym.FALSE:
                    outFile.println("false"); 
                    break;
                case sym.STRUCT:
                    outFile.println("struct"); 
                    break;
                case sym.CIN:
                    outFile.println("cin"); 
                    break;
                case sym.COUT:
                    outFile.println("cout");
                    break;				
                case sym.IF:
                    outFile.println("if");
                    break;
                case sym.ELSE:
                    outFile.println("else");
                    break;
                case sym.WHILE:
                    outFile.println("while");
                    break;
                case sym.RETURN:
                    outFile.println("return");
                    break;
                case sym.ID:
                    outFile.print("ID: ");
                    outFile.println(((IdTokenVal)token.value).idVal);
                    break;
                case sym.INTLITERAL:  
                    outFile.print("INT: ");
                    outFile.println(((IntLitTokenVal)token.value).intVal);
                    break;
                case sym.STRINGLITERAL: 
                    outFile.print("STR: ");
                    outFile.println(((StrLitTokenVal)token.value).strVal);
                    break;    
                case sym.LCURLY:
                    outFile.println("{");
                    break;
                case sym.RCURLY:
                    outFile.println("}");
                    break;
                case sym.LPAREN:
                    outFile.println("(");
                    break;
                case sym.RPAREN:
                    outFile.println(")");
                    break;
                case sym.SEMICOLON:
                    outFile.println(";");
                    break;
                case sym.COMMA:
                    outFile.println(",");
                    break;
                case sym.DOT:
                    outFile.println(".");
                    break;
                case sym.WRITE:
                    outFile.println("<<");
                    break;
                case sym.READ:
                    outFile.println(">>");
                    break;				
                case sym.PLUSPLUS:
                    outFile.println("++");
                    break;
                case sym.MINUSMINUS:
                    outFile.println("--");
                    break;	
                case sym.PLUS:
                    outFile.println("+");
                    break;
                case sym.MINUS:
                    outFile.println("-");
                    break;
                case sym.TIMES:
                    outFile.println("*");
                    break;
                case sym.DIVIDE:
                    outFile.println("/");
                    break;
                case sym.NOT:
                    outFile.println("!");
                    break;
                case sym.AND:
                    outFile.println("&&");
                    break;
                case sym.OR:
                    outFile.println("||");
                    break;
                case sym.EQUALS:
                    outFile.println("==");
                    break;
                case sym.NOTEQUALS:
                    outFile.println("!=");
                    break;
                case sym.LESS:
                    outFile.println("<");
                    break;
                case sym.GREATER:
                    outFile.println(">");
                    break;
                case sym.LESSEQ:
                    outFile.println("<=");
                    break;
                case sym.GREATEREQ:
                    outFile.println(">=");
                    break;
                case sym.ASSIGN:
                    outFile.println("=");
                    break;
                default:
                    outFile.println("UNKNOWN TOKEN");
                } // end switch
                // Print line number and char number to output
                int linenum = ((TokenVal)(token.value)).linenum;
                int charnum = ((TokenVal)(token.value)).charnum;
                outFile.println(linenum + "," + charnum);
            }
            token = scanner.next_token();
        } // end while
        outFile.close();
    }
}
