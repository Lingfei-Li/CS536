package edu.wisc.cs.lingfei.cs536;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SymTable {

	private List<Map<String, Sym>> symTable;

	SymTable() {
		this.symTable = new LinkedList<Map<String, Sym>>();
	}

	void addDecl(String name, Sym sym) throws DuplicateSymException, EmptySymTableException {
		if (this.symTable.size() == 0)
			throw new EmptySymTableException();
		if (name == null || sym == null)
			throw new NullPointerException();
		if (this.symTable.get(0).containsKey(name))
			throw new DuplicateSymException();

		this.symTable.get(0).put(name, sym);
	}

	void addScope() {
		this.symTable.add(0, new HashMap<String, Sym>());
	}

	Sym lookupLocal(String name) throws EmptySymTableException {
		if (this.symTable.size() == 0)
			throw new EmptySymTableException();
		if (this.symTable.get(0).containsKey(name))
			return this.symTable.get(0).get(name);
		return null;
	}

	Sym lookupGlobal(String name) throws EmptySymTableException {
		if (this.symTable.size() == 0)
			throw new EmptySymTableException();
		for (Map<String, Sym> e : this.symTable) {
			if (e.containsKey(name))
				return e.get(name);
		}
		return null;
	}

	void removeScope() throws EmptySymTableException {
		if (this.symTable.size() == 0)
			throw new EmptySymTableException();
		this.symTable.remove(0);
	}

	void print() {
		System.out.print("\nSym Table\n");
		for (Map<String, Sym> e : this.symTable) {
			System.out.println(e);
		}
		System.out.println("");
	}

}
