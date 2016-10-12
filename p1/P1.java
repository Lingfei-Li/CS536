package edu.wisc.cs.lingfei.cs536;

/**
 * A test class for Sym and SymTable
 * */
public class P1 {

	/**
	 * The entry point for testing
	 * */
	public static void main(String[] args) {

		// SymTable instance to be tested
		SymTable symTable = new SymTable();

		// 1-1: addDecl Empty SymTable => EmptySymTableException
		try {
			symTable.addDecl("1", new Sym("1_sym"));
			System.out.println("Test 1-1 failed");
		} catch (EmptySymTableException e) {

		} catch (Exception e) {
			System.out.println("Test 1-1 failed");
		}

		// 1-2: lookupLocal Empty SymTable => EmptySymTableException
		try {
			symTable.lookupLocal("1");
			System.out.println("Test 1-2 failed");
		} catch (EmptySymTableException e) {

		} catch (Exception e) {
			System.out.println("Test 1-2 failed");
		}

		// 1-3: lookupGlobal Empty SymTable => EmptySymTableException
		try {
			symTable.lookupGlobal("1");
			System.out.println("Test 1-3 failed");
		} catch (EmptySymTableException e) {

		} catch (Exception e) {
			System.out.println("Test 1-3 failed");
		}

		// 2: Adding declaration to symTable => success
		symTable.addScope();
		try {
			symTable.addDecl("1", new Sym("1_sym"));
			symTable.addDecl("2", new Sym("2_sym"));
			symTable.addDecl("3", new Sym("3_sym"));
			symTable.addDecl("4", new Sym("4_sym"));
		} catch (Exception e) {
			System.out.println("Test 2 failed");
		}

		// 3-1: Adding declaration to symTable with null name =>
		// NullPointerException
		try {
			symTable.addDecl(null, new Sym("1_sym"));
			System.out.println("Test 3-1 failed");
		} catch (NullPointerException e) {

		} catch (Exception e) {
			System.out.println("Test 3-1 failed");
		}

		// 3-2: Adding declaration to symTable with null sym =>
		// NullPointerException
		try {
			symTable.addDecl("1", null);
			System.out.println("Test 3-2 failed");
		} catch (NullPointerException e) {

		} catch (Exception e) {
			System.out.println("Test 3-2 failed");
		}

		// 4: Adding duplicated declaration to symTable => 
		// DuplicateSymException
		try {
			symTable.addDecl("1", new Sym("1_sym"));
			System.out.println("Test 4 failed");
		} catch (DuplicateSymException e) {

		} catch (Exception e) {
			System.out.println("Test 4 failed");
		}

		// 5-0: lookup testing setup
		symTable.addScope();
		try {
			symTable.addDecl("1", new Sym("1_sym"));
			symTable.addDecl("2", new Sym("2_sym"));
			symTable.addDecl("5", new Sym("5_sym"));
			symTable.addDecl("6", new Sym("6_sym"));
		} catch (Exception e) {
			System.out.println("Test 5-0 failed");
		}

		// 5-1: lookup success
		try {
			symTable.lookupLocal("1");
			symTable.lookupLocal("2");
			symTable.lookupLocal("5");
			symTable.lookupLocal("6");
			symTable.lookupGlobal("1");
			symTable.lookupGlobal("2");
			symTable.lookupGlobal("3");
			symTable.lookupGlobal("4");
			symTable.lookupGlobal("5");
			symTable.lookupGlobal("6");

		} catch (Exception e) {
			System.out.println("Test 5-1 failed");
		}

		// 5-2: lookup returning null
		try {
			if (symTable.lookupLocal("3") != null)
				throw new Exception();
			if (symTable.lookupLocal("4") != null)
				throw new Exception();
			if (symTable.lookupGlobal("7") != null)
				throw new Exception();
			if (symTable.lookupGlobal("8") != null)
				throw new Exception();
		} catch (Exception e) {
			System.out.println("Test 5-2 failed");
		}

		// Test symTable.print()
		symTable.print();

		// 6-1: remove scope success
		try {
			symTable.removeScope();
			symTable.removeScope();
		} catch (Exception e) {
			System.out.println("Test 6-1 failed");
		}

		// 6-2: remove scope EmptySymException
		try {
			symTable.removeScope();
			System.out.println("Test 6-2 failed");
		} catch (Exception e) {

		}

		// 7: instantiate and test class Sym
		Sym symbol = new Sym("Foo");
		if (symbol.getType().equals("Foo") == false 
			|| symbol.toString().equals("Foo") == false) {
			System.out.println("Test 7 failed");
		}
	}
}
