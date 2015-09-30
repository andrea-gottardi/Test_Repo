package tic.tac.toe.thread;

import tic.tac.toe.exception.EndException;
import tic.tac.toe.fe.BoardFrame;
import tic.tac.toe.model.Symbols;
import tic.tac.toe.model.TicTacToe;
import tic.tac.toe.utils.Utils;

/**
 * This class is used from the UI Frame to start
 * each new game. It works like the Game class
 * but at the end the thread will dead.
 * */
public class GameThread extends Thread {

	private BoardFrame bf;
	private Boolean run;

	public GameThread(BoardFrame bf) {
		super();
		this.bf = bf;
		this.run=true;
	}

	public void run() {
		TicTacToe ticTacToe = new TicTacToe();
		this.bf.setTicTacToe(ticTacToe);
		Symbols symbol = Symbols.X;
		while (run) {
			try {
				Boolean move = false;
				while (!move) {
					move = ticTacToe.move(Utils.getCoordinate(),
							Utils.getCoordinate(), symbol);
				}
				this.bf.repaint();
				if (symbol.equals(Symbols.X))
					symbol = Symbols.O;
				else
					symbol = Symbols.X;
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
				run=false;
			} catch (EndException e) {
				this.bf.repaint();
				// TODO System.out.println(e.getMessage());
				run=false;
			}
		}
		run=false;
	}
}
