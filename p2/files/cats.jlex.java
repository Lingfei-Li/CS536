import java_cup.runtime.*; // defines the Symbol class
import java.lang.reflect.Field;
// The generated scanner will return a Symbol for each token that it finds.
// A Symbol contains an Object field named value; that field will be of type
// TokenVal, defined below.
//
// A TokenVal object contains the line number on which the token occurs as
// well as the number of the character on that line that starts the token.
// Some tokens (literals and IDs) also include the value of the token.
class TokenVal {
  // fields
    int linenum;
    int charnum;
  // constructor
    TokenVal(int line, int ch) {
        linenum = line;
        charnum = ch;
    }
}
class IntLitTokenVal extends TokenVal {
  // new field: the value of the integer literal
    int intVal;
  // constructor
    IntLitTokenVal(int line, int ch, int val) {
        super(line, ch);
        intVal = val;
    }
}
class IdTokenVal extends TokenVal {
  // new field: the value of the identifier
    String idVal;
  // constructor
    IdTokenVal(int line, int ch, String val) {
        super(line, ch);
    idVal = val;
    }
}
class StrLitTokenVal extends TokenVal {
  // new field: the value of the string literal
    String strVal;
  // constructor
    StrLitTokenVal(int line, int ch, String val) {
        super(line, ch);
        strVal = val;
    }
}
// The following class is used to keep track of the character number at which
// the current token starts on its line.
class CharNum {
    static int num=1;
}
// The following class helps reduce duplicated codes for operators 
// (e.g. plus, minus)
class OperatorTokenVal {
    static Symbol makeSymbol(String yytext, int yyline, int symVal) {
        Symbol S = new Symbol(symVal, new TokenVal(yyline+1, CharNum.num));
        CharNum.num += yytext.length();
        return S;
    }
}


class Yylex implements java_cup.runtime.Scanner {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 128;
	private final int YY_EOF = 129;
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private int yyline;
	private boolean yy_at_bol;
	private int yy_lexical_state;

	Yylex (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	Yylex (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private Yylex () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yyline = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;
	}

	private boolean yy_eof_done = false;
	private final int YYINITIAL = 0;
	private final int yy_state_dtrans[] = {
		0
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private int yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_end () {
		if (yy_buffer_end > yy_buffer_start &&
		    '\n' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start &&
		    '\r' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
	}
	private boolean yy_last_was_cr=false;
	private void yy_mark_start () {
		int i;
		for (i = yy_buffer_start; i < yy_buffer_index; ++i) {
			if ('\n' == yy_buffer[i] && !yy_last_was_cr) {
				++yyline;
			}
			if ('\r' == yy_buffer[i]) {
				++yyline;
				yy_last_was_cr=true;
			} else yy_last_was_cr=false;
		}
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start) &&
		            ('\r' == yy_buffer[yy_buffer_end-1] ||
		             '\n' == yy_buffer[yy_buffer_end-1] ||
		             2028/*LS*/ == yy_buffer[yy_buffer_end-1] ||
		             2029/*PS*/ == yy_buffer[yy_buffer_end-1]);
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i= 0; i < size1; i++) {
			for (int j= 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex==-1) ? st :
					st.substring(0, commaIndex);
				st = st.substring(commaIndex+1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j]=Integer.parseInt(workString);
					continue;
				}
				lengthString =
					workString.substring(colonIndex+1);
				sequenceLength=Integer.parseInt(lengthString);
				workString=workString.substring(0,colonIndex);
				sequenceInteger=Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}
	private int yy_acpt[] = {
		/* 0 */ YY_NOT_ACCEPT,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NO_ANCHOR,
		/* 9 */ YY_NO_ANCHOR,
		/* 10 */ YY_NO_ANCHOR,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NO_ANCHOR,
		/* 14 */ YY_NO_ANCHOR,
		/* 15 */ YY_NO_ANCHOR,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NO_ANCHOR,
		/* 18 */ YY_NO_ANCHOR,
		/* 19 */ YY_NO_ANCHOR,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NO_ANCHOR,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_END,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NO_ANCHOR,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NO_ANCHOR,
		/* 33 */ YY_NO_ANCHOR,
		/* 34 */ YY_NO_ANCHOR,
		/* 35 */ YY_NO_ANCHOR,
		/* 36 */ YY_END,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NOT_ACCEPT,
		/* 39 */ YY_NO_ANCHOR,
		/* 40 */ YY_NO_ANCHOR,
		/* 41 */ YY_END,
		/* 42 */ YY_END,
		/* 43 */ YY_NOT_ACCEPT,
		/* 44 */ YY_NO_ANCHOR,
		/* 45 */ YY_NO_ANCHOR,
		/* 46 */ YY_NOT_ACCEPT,
		/* 47 */ YY_NO_ANCHOR,
		/* 48 */ YY_NO_ANCHOR,
		/* 49 */ YY_NOT_ACCEPT,
		/* 50 */ YY_NO_ANCHOR,
		/* 51 */ YY_NO_ANCHOR,
		/* 52 */ YY_NOT_ACCEPT,
		/* 53 */ YY_NO_ANCHOR,
		/* 54 */ YY_NO_ANCHOR,
		/* 55 */ YY_NO_ANCHOR,
		/* 56 */ YY_NO_ANCHOR,
		/* 57 */ YY_NO_ANCHOR,
		/* 58 */ YY_NO_ANCHOR,
		/* 59 */ YY_NO_ANCHOR,
		/* 60 */ YY_NO_ANCHOR,
		/* 61 */ YY_NO_ANCHOR,
		/* 62 */ YY_NO_ANCHOR,
		/* 63 */ YY_NO_ANCHOR,
		/* 64 */ YY_NO_ANCHOR,
		/* 65 */ YY_NO_ANCHOR,
		/* 66 */ YY_NO_ANCHOR,
		/* 67 */ YY_NO_ANCHOR,
		/* 68 */ YY_NO_ANCHOR,
		/* 69 */ YY_NO_ANCHOR,
		/* 70 */ YY_NO_ANCHOR,
		/* 71 */ YY_NO_ANCHOR,
		/* 72 */ YY_NO_ANCHOR,
		/* 73 */ YY_NO_ANCHOR,
		/* 74 */ YY_NO_ANCHOR,
		/* 75 */ YY_NO_ANCHOR,
		/* 76 */ YY_NO_ANCHOR,
		/* 77 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,130,
"3:9,45,4,3:2,27,3:18,45,41,24,2,3:2,42,26,31,32,40,38,34,39,35,1,23:10,3,33" +
",36,44,37,26,3,22:26,3,25,3:2,22,3,17,5,19,12,15,16,22,21,8,22:2,7,22,9,6,2" +
"2:2,13,18,10,14,11,20,22:3,29,43,30,3:2,0,28")[0];

	private int yy_rmap[] = unpackFromString(1,78,
"0,1,2,3,1,4,5,1:7,6,7,8,9,1,10,11,12,1,13,1:14,3,1,14,15,16,15:2,17,18,19,2" +
"0,16,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,13,40,41,42,4" +
"3,32,44,45,46")[0];

	private int yy_nxt[][] = unpackFromString(47,46,
"1,2,3,39,4,5,69:2,40,69,71,72,69,73,69,74,75,69,76,55,77,69:2,6,44,39:2,-1," +
"1,7,8,9,10,11,12,13,14,15,16,17,18,19,47,50,20,21,-1:47,38,-1:45,38:3,22,38" +
":23,-1,38:17,-1:5,69,56,69:17,-1:45,6,-1:58,26,-1:7,27,-1:38,28,-1:6,29,-1:" +
"39,30,-1:46,31,-1:50,32,-1:45,35,-1:46,21,-1:5,69:19,-1:27,69:4,45,69:6,23," +
"69:7,-1:23,43:3,24,43:19,25,46,43,41,24,43:17,-1,49:3,36,49:19,37,52,49,42," +
"36,49:17,-1:5,69:5,23,69:13,-1:23,49:8,43:2,49:13,43:3,49,-1,49:17,-1:42,33" +
",-1:8,69:4,23,69:14,-1:65,34,-1:7,69:2,23,69:16,-1:23,49:27,-1,49:17,-1:5,6" +
"9:10,23,69:8,-1:27,69:7,23,69:11,-1:27,69,63,69,48,69:15,-1:27,69,51,69:17," +
"-1:27,69:9,53,69:9,-1:27,69:3,54,69:15,-1:27,69:5,65,69:13,-1:27,69:13,53,6" +
"9:5,-1:27,69:2,60,69:16,-1:27,69:8,70,69:10,-1:27,69:9,45,69:9,-1:27,69:3,6" +
"6,69:15,-1:27,69:9,67,69:9,-1:27,69:2,53,69:16,-1:27,69:8,48,69:10,-1:27,69" +
":14,45,69:4,-1:27,69:9,68,69:9,-1:27,69:8,57,69:10,-1:27,69,58,69:17,-1:27," +
"69:10,59,69:8,-1:27,69:12,61,69:6,-1:27,69:5,62,69:13,-1:27,69:16,64,69:2,-" +
"1:22");

	public java_cup.runtime.Symbol next_token ()
		throws java.io.IOException {
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol) yy_lookahead = YY_BOL;
			else yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {

return new Symbol(sym.EOF);
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					switch (yy_last_accept_state) {
					case 1:
						
					case -2:
						break;
					case 2:
						{ 
            int symVal = sym.DIVIDE;
            return OperatorTokenVal.makeSymbol(yytext(), yyline, symVal);
          }
					case -3:
						break;
					case 3:
						{ ErrMsg.fatal(yyline+1, CharNum.num,
                         "illegal character ignored: " + yytext());
            CharNum.num += yytext().length();
          }
					case -4:
						break;
					case 4:
						{ CharNum.num = 1; }
					case -5:
						break;
					case 5:
						{
            // identifiers
            Symbol S = new Symbol(sym.ID, new IdTokenVal(yyline+1, CharNum.num, yytext()) );
            CharNum.num += yytext().length();
            return S;
}
					case -6:
						break;
					case 6:
						{ 
            // integer literals
            int val = 0;
            Symbol S;
            try {
                val = Integer.parseInt(yytext());
                S = new Symbol(sym.INTLITERAL,
                                 new IntLitTokenVal(yyline+1, CharNum.num, val));
            }           
            catch(NumberFormatException e) {
                ErrMsg.warn(yyline+1, CharNum.num, "integer literal too large; using max value");
                S = new Symbol(sym.INTLITERAL,
                                 new IntLitTokenVal(yyline+1, CharNum.num, Integer.MAX_VALUE));
            }
            CharNum.num += yytext().length();
            return S;
}
					case -7:
						break;
					case 7:
						{ 
            int symVal = sym.LCURLY;
            return OperatorTokenVal.makeSymbol(yytext(), yyline, symVal);
          }
					case -8:
						break;
					case 8:
						{ 
            int symVal = sym.RCURLY;
            return OperatorTokenVal.makeSymbol(yytext(), yyline, symVal);
          }
					case -9:
						break;
					case 9:
						{ 
            int symVal = sym.LPAREN;
            return OperatorTokenVal.makeSymbol(yytext(), yyline, symVal);
          }
					case -10:
						break;
					case 10:
						{ 
            int symVal = sym.RPAREN;
            return OperatorTokenVal.makeSymbol(yytext(), yyline, symVal);
          }
					case -11:
						break;
					case 11:
						{ 
            int symVal = sym.SEMICOLON;
            return OperatorTokenVal.makeSymbol(yytext(), yyline, symVal);
          }
					case -12:
						break;
					case 12:
						{ 
            int symVal = sym.COMMA;
            return OperatorTokenVal.makeSymbol(yytext(), yyline, symVal);
          }
					case -13:
						break;
					case 13:
						{ 
            int symVal = sym.DOT;
            return OperatorTokenVal.makeSymbol(yytext(), yyline, symVal);
          }
					case -14:
						break;
					case 14:
						{ 
            int symVal = sym.LESS;
            return OperatorTokenVal.makeSymbol(yytext(), yyline, symVal);
          }
					case -15:
						break;
					case 15:
						{ 
            int symVal = sym.GREATER;
            return OperatorTokenVal.makeSymbol(yytext(), yyline, symVal);
          }
					case -16:
						break;
					case 16:
						{ 
            int symVal = sym.PLUS;
            return OperatorTokenVal.makeSymbol(yytext(), yyline, symVal);
          }
					case -17:
						break;
					case 17:
						{ 
            int symVal = sym.MINUS;
            return OperatorTokenVal.makeSymbol(yytext(), yyline, symVal);
          }
					case -18:
						break;
					case 18:
						{ 
            int symVal = sym.TIMES;
            return OperatorTokenVal.makeSymbol(yytext(), yyline, symVal);
          }
					case -19:
						break;
					case 19:
						{ 
            int symVal = sym.NOT;
            return OperatorTokenVal.makeSymbol(yytext(), yyline, symVal);
          }
					case -20:
						break;
					case 20:
						{ 
            int symVal = sym.ASSIGN;
            return OperatorTokenVal.makeSymbol(yytext(), yyline, symVal);
          }
					case -21:
						break;
					case 21:
						{ CharNum.num += yytext().length(); }
					case -22:
						break;
					case 22:
						{
            // comments
            return null;
}
					case -23:
						break;
					case 23:
						{ 
            // reserved keywords
            int symToken = 0;      //default: EOF
            try {
                // Convert the word to uppercase to match symbol token type
                Field field = sym.class.getField(yytext().toUpperCase());
                symToken = field.getInt(null);
            }catch(NoSuchFieldException|IllegalAccessException e) {
                ErrMsg.fatal(yyline+1, CharNum.num, e.getMessage());
            }
            Symbol S = new Symbol(symToken, new IdTokenVal(yyline + 1, CharNum.num, yytext()));
            CharNum.num += yytext().length();
            return S;
}
					case -24:
						break;
					case 24:
						{
            // unterminated string
            ErrMsg.fatal(yyline+1, CharNum.num, "unterminated string literal ignored");
            CharNum.num = 1;
            return null;
}
					case -25:
						break;
					case 25:
						{
            // string
            Symbol S = new Symbol(sym.STRINGLITERAL,
                             new StrLitTokenVal(yyline+1, CharNum.num, yytext()));
            CharNum.num += yytext().length();
            return S;
}
					case -26:
						break;
					case 26:
						{ 
            int symVal = sym.WRITE;
            return OperatorTokenVal.makeSymbol(yytext(), yyline, symVal);
          }
					case -27:
						break;
					case 27:
						{ 
            int symVal = sym.LESSEQ;
            return OperatorTokenVal.makeSymbol(yytext(), yyline, symVal);
          }
					case -28:
						break;
					case 28:
						{ 
            int symVal = sym.READ;
            return OperatorTokenVal.makeSymbol(yytext(), yyline, symVal);
          }
					case -29:
						break;
					case 29:
						{ 
            int symVal = sym.GREATEREQ;
            return OperatorTokenVal.makeSymbol(yytext(), yyline, symVal);
          }
					case -30:
						break;
					case 30:
						{ 
            int symVal = sym.PLUSPLUS;
            return OperatorTokenVal.makeSymbol(yytext(), yyline, symVal);
          }
					case -31:
						break;
					case 31:
						{ 
            int symVal = sym.MINUSMINUS;
            return OperatorTokenVal.makeSymbol(yytext(), yyline, symVal);
          }
					case -32:
						break;
					case 32:
						{ 
            int symVal = sym.NOTEQUALS;
            return OperatorTokenVal.makeSymbol(yytext(), yyline, symVal);
          }
					case -33:
						break;
					case 33:
						{ 
            int symVal = sym.AND;
            return OperatorTokenVal.makeSymbol(yytext(), yyline, symVal);
          }
					case -34:
						break;
					case 34:
						{ 
            int symVal = sym.OR;
            return OperatorTokenVal.makeSymbol(yytext(), yyline, symVal);
          }
					case -35:
						break;
					case 35:
						{ 
            int symVal = sym.EQUALS;
            return OperatorTokenVal.makeSymbol(yytext(), yyline, symVal);
          }
					case -36:
						break;
					case 36:
						{
            // bad unterminated string. need to be placed after good string or the regex will fail 
            ErrMsg.fatal(yyline+1, CharNum.num, "unterminated string literal with bad escaped character ignored");
            CharNum.num = 1;
            return null;
}
					case -37:
						break;
					case 37:
						{
            // bad string. need to be placed after good string or the regex will fail 
            ErrMsg.fatal(yyline+1, CharNum.num, "string literal with bad escaped character ignored");
            CharNum.num += yytext().length();
            return null;
}
					case -38:
						break;
					case 39:
						{ ErrMsg.fatal(yyline+1, CharNum.num,
                         "illegal character ignored: " + yytext());
            CharNum.num += yytext().length();
          }
					case -39:
						break;
					case 40:
						{
            // identifiers
            Symbol S = new Symbol(sym.ID, new IdTokenVal(yyline+1, CharNum.num, yytext()) );
            CharNum.num += yytext().length();
            return S;
}
					case -40:
						break;
					case 41:
						{
            // unterminated string
            ErrMsg.fatal(yyline+1, CharNum.num, "unterminated string literal ignored");
            CharNum.num = 1;
            return null;
}
					case -41:
						break;
					case 42:
						{
            // bad unterminated string. need to be placed after good string or the regex will fail 
            ErrMsg.fatal(yyline+1, CharNum.num, "unterminated string literal with bad escaped character ignored");
            CharNum.num = 1;
            return null;
}
					case -42:
						break;
					case 44:
						{ ErrMsg.fatal(yyline+1, CharNum.num,
                         "illegal character ignored: " + yytext());
            CharNum.num += yytext().length();
          }
					case -43:
						break;
					case 45:
						{
            // identifiers
            Symbol S = new Symbol(sym.ID, new IdTokenVal(yyline+1, CharNum.num, yytext()) );
            CharNum.num += yytext().length();
            return S;
}
					case -44:
						break;
					case 47:
						{ ErrMsg.fatal(yyline+1, CharNum.num,
                         "illegal character ignored: " + yytext());
            CharNum.num += yytext().length();
          }
					case -45:
						break;
					case 48:
						{
            // identifiers
            Symbol S = new Symbol(sym.ID, new IdTokenVal(yyline+1, CharNum.num, yytext()) );
            CharNum.num += yytext().length();
            return S;
}
					case -46:
						break;
					case 50:
						{ ErrMsg.fatal(yyline+1, CharNum.num,
                         "illegal character ignored: " + yytext());
            CharNum.num += yytext().length();
          }
					case -47:
						break;
					case 51:
						{
            // identifiers
            Symbol S = new Symbol(sym.ID, new IdTokenVal(yyline+1, CharNum.num, yytext()) );
            CharNum.num += yytext().length();
            return S;
}
					case -48:
						break;
					case 53:
						{
            // identifiers
            Symbol S = new Symbol(sym.ID, new IdTokenVal(yyline+1, CharNum.num, yytext()) );
            CharNum.num += yytext().length();
            return S;
}
					case -49:
						break;
					case 54:
						{
            // identifiers
            Symbol S = new Symbol(sym.ID, new IdTokenVal(yyline+1, CharNum.num, yytext()) );
            CharNum.num += yytext().length();
            return S;
}
					case -50:
						break;
					case 55:
						{
            // identifiers
            Symbol S = new Symbol(sym.ID, new IdTokenVal(yyline+1, CharNum.num, yytext()) );
            CharNum.num += yytext().length();
            return S;
}
					case -51:
						break;
					case 56:
						{
            // identifiers
            Symbol S = new Symbol(sym.ID, new IdTokenVal(yyline+1, CharNum.num, yytext()) );
            CharNum.num += yytext().length();
            return S;
}
					case -52:
						break;
					case 57:
						{
            // identifiers
            Symbol S = new Symbol(sym.ID, new IdTokenVal(yyline+1, CharNum.num, yytext()) );
            CharNum.num += yytext().length();
            return S;
}
					case -53:
						break;
					case 58:
						{
            // identifiers
            Symbol S = new Symbol(sym.ID, new IdTokenVal(yyline+1, CharNum.num, yytext()) );
            CharNum.num += yytext().length();
            return S;
}
					case -54:
						break;
					case 59:
						{
            // identifiers
            Symbol S = new Symbol(sym.ID, new IdTokenVal(yyline+1, CharNum.num, yytext()) );
            CharNum.num += yytext().length();
            return S;
}
					case -55:
						break;
					case 60:
						{
            // identifiers
            Symbol S = new Symbol(sym.ID, new IdTokenVal(yyline+1, CharNum.num, yytext()) );
            CharNum.num += yytext().length();
            return S;
}
					case -56:
						break;
					case 61:
						{
            // identifiers
            Symbol S = new Symbol(sym.ID, new IdTokenVal(yyline+1, CharNum.num, yytext()) );
            CharNum.num += yytext().length();
            return S;
}
					case -57:
						break;
					case 62:
						{
            // identifiers
            Symbol S = new Symbol(sym.ID, new IdTokenVal(yyline+1, CharNum.num, yytext()) );
            CharNum.num += yytext().length();
            return S;
}
					case -58:
						break;
					case 63:
						{
            // identifiers
            Symbol S = new Symbol(sym.ID, new IdTokenVal(yyline+1, CharNum.num, yytext()) );
            CharNum.num += yytext().length();
            return S;
}
					case -59:
						break;
					case 64:
						{
            // identifiers
            Symbol S = new Symbol(sym.ID, new IdTokenVal(yyline+1, CharNum.num, yytext()) );
            CharNum.num += yytext().length();
            return S;
}
					case -60:
						break;
					case 65:
						{
            // identifiers
            Symbol S = new Symbol(sym.ID, new IdTokenVal(yyline+1, CharNum.num, yytext()) );
            CharNum.num += yytext().length();
            return S;
}
					case -61:
						break;
					case 66:
						{
            // identifiers
            Symbol S = new Symbol(sym.ID, new IdTokenVal(yyline+1, CharNum.num, yytext()) );
            CharNum.num += yytext().length();
            return S;
}
					case -62:
						break;
					case 67:
						{
            // identifiers
            Symbol S = new Symbol(sym.ID, new IdTokenVal(yyline+1, CharNum.num, yytext()) );
            CharNum.num += yytext().length();
            return S;
}
					case -63:
						break;
					case 68:
						{
            // identifiers
            Symbol S = new Symbol(sym.ID, new IdTokenVal(yyline+1, CharNum.num, yytext()) );
            CharNum.num += yytext().length();
            return S;
}
					case -64:
						break;
					case 69:
						{
            // identifiers
            Symbol S = new Symbol(sym.ID, new IdTokenVal(yyline+1, CharNum.num, yytext()) );
            CharNum.num += yytext().length();
            return S;
}
					case -65:
						break;
					case 70:
						{
            // identifiers
            Symbol S = new Symbol(sym.ID, new IdTokenVal(yyline+1, CharNum.num, yytext()) );
            CharNum.num += yytext().length();
            return S;
}
					case -66:
						break;
					case 71:
						{
            // identifiers
            Symbol S = new Symbol(sym.ID, new IdTokenVal(yyline+1, CharNum.num, yytext()) );
            CharNum.num += yytext().length();
            return S;
}
					case -67:
						break;
					case 72:
						{
            // identifiers
            Symbol S = new Symbol(sym.ID, new IdTokenVal(yyline+1, CharNum.num, yytext()) );
            CharNum.num += yytext().length();
            return S;
}
					case -68:
						break;
					case 73:
						{
            // identifiers
            Symbol S = new Symbol(sym.ID, new IdTokenVal(yyline+1, CharNum.num, yytext()) );
            CharNum.num += yytext().length();
            return S;
}
					case -69:
						break;
					case 74:
						{
            // identifiers
            Symbol S = new Symbol(sym.ID, new IdTokenVal(yyline+1, CharNum.num, yytext()) );
            CharNum.num += yytext().length();
            return S;
}
					case -70:
						break;
					case 75:
						{
            // identifiers
            Symbol S = new Symbol(sym.ID, new IdTokenVal(yyline+1, CharNum.num, yytext()) );
            CharNum.num += yytext().length();
            return S;
}
					case -71:
						break;
					case 76:
						{
            // identifiers
            Symbol S = new Symbol(sym.ID, new IdTokenVal(yyline+1, CharNum.num, yytext()) );
            CharNum.num += yytext().length();
            return S;
}
					case -72:
						break;
					case 77:
						{
            // identifiers
            Symbol S = new Symbol(sym.ID, new IdTokenVal(yyline+1, CharNum.num, yytext()) );
            CharNum.num += yytext().length();
            return S;
}
					case -73:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}
