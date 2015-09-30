package tic.tac.toe.model;

import java.util.Arrays;

import tic.tac.toe.exception.EndException;

/**
 * The model TicTacToe contains the definition of the game
 * board and perform the moves and the checks on it. Also contain
 * an extra method to print it in a user friendly way.
 * 
 * */
public class TicTacToe {
	public static final String DRAW = "Game ends with a draw!";
	public static final String WIN = "Player {0} wins!";
	public static final int BOARD_DIM = 3;
	private Symbols board[][];

	public TicTacToe() {
		board = new Symbols[BOARD_DIM][BOARD_DIM];
		for (int x = 0; x < 3; x++) {
			Arrays.fill(board[x], Symbols.EMPTY);
		}

	}

	/**
	 * Make a move and check the game status. If the cell already contains 
	 * a value return false, otherwise return true.
	 * @param x the row
	 * @param y the col
	 * @param symbol the symbol
	 * @return Boolean
	 * @throws EndException
	 * */
	public Boolean move(int x, int y, Symbols symbol) throws EndException {
		switch (board[x][y]) {
		case O:
		case X:
			return false;
		case EMPTY: {
			board[x][y] = symbol;
			checkStatus();
			return true;
		}
		default:
			return false;
		}
	}

	/**
	 * Check the status of the game. Control rows, columns and diagonals.
	 * @throws EndException
	 * */
	private void checkStatus() throws EndException {
		checkColWinner();
		checkRowWinner();
		checkDiagWinner();
		checkEndGame();
	}

	/**
	 * Check if a column contains the same values. If true returns a
	 * EndException containing the winner Symbol.
	 * @throws EndException
	 * */
	private void checkColWinner() throws EndException {
		for (int y = 0; y < BOARD_DIM; y++) {
			for (int x=0; x<BOARD_DIM;x++){
				if (x==BOARD_DIM-1)
					throw new EndException(WIN.replace("{0}", board[x][y].toString()));
				 else if (!board[x][y].equals(board[x+1][y]) || board[x][y].equals(Symbols.EMPTY))
					break;					
			}
		}
	}
	
	/**
	 * Check if a row contains the same values. If true returns a
	 * EndException containing the winner Symbol.
	 * @throws EndException
	 * */
	private void checkRowWinner() throws EndException {
		for (int x = 0; x < BOARD_DIM; x++) {
			for (int y=0; y<BOARD_DIM;y++){
				if (y==BOARD_DIM-1)
					throw new EndException(WIN.replace("{0}", board[x][y].toString()));
				 else if (!board[x][y].equals(board[x][y+1]) || board[x][y].equals(Symbols.EMPTY))
					break;					
			}
		}
	}

	/**
	 * Check if a diagonal contains the same values. If true returns a
	 * EndException containing the winner Symbol.
	 * @throws EndException
	 * */
	private void checkDiagWinner() throws EndException {
		for (int x=0; x<BOARD_DIM;x++){
			if (x==BOARD_DIM-1)
				throw new EndException(WIN.replace("{0}", board[x][x].toString()));
			 else if (!board[x][x].equals(board[x+1][x+1]) || board[x][x].equals(Symbols.EMPTY))
				break;					
		}
		for (int x=0; x<BOARD_DIM;x++){
			if (x==BOARD_DIM-1)
				throw new EndException(WIN.replace("{0}", board[x][2-x].toString()));
			 else if (!board[x][2-x].equals(board[x+1][2-(x+1)]) || board[x][2-x].equals(Symbols.EMPTY))
				break;					
		}
	}

	/**
	 * Check if the board contains empty cells. If false the 
	 * game can continue, otherwise an EndException is throw 
	 * containing the draw message.
	 * @throws EndException
	 * */
	private void checkEndGame() throws EndException {
		Boolean endGame = true;
		for (int x = 0; x < BOARD_DIM; x++) {
			if (Arrays.asList(board[x]).contains(Symbols.EMPTY)) {
				endGame = false;
			}
		}
		if (endGame)
			throw new EndException(DRAW);
	}

	/**
	 * This is and extra method to print the board
	 * in a user friendly way.
	 * */
	public void print() {
		for (int x = 0; x < BOARD_DIM; x++) {
			String boardString = "";
			for (int y = 0; y < BOARD_DIM; y++) {
				if (y == 1)
					boardString = boardString.concat("|")
							.concat(this.board[x][y].toString()).concat("|");
				else
					boardString = boardString.concat(this.board[x][y]
							.toString());
			}
			System.out.println(boardString);
			if (x != BOARD_DIM - 1) {
				System.out.println("-+-+-");
			} else {
				System.out.println("");
			}
		}
	}

	/**
	 * Returns the board.
	 * @return Symbols[][]
	 * */
	public Symbols[][] getBoard() {
		return board;
	}

}
