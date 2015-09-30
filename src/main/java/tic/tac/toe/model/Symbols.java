package tic.tac.toe.model;

/**
 * Symbols used to fill the board. The two players
 * are represented by X and Y. EMPTY is used to 
 * indicate an unused cell.
 * 
 * */
public enum Symbols {
	X("X"),
	O("O"),
	EMPTY(" ");
	
	private String label;
	
	private Symbols(String label) {	
		this.label = label;
	}
	
	@Override
	public String toString() {
		return label;
	}
}
