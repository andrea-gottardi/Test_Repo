package tic.tac.toe.fe;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import tic.tac.toe.model.Symbols;
import tic.tac.toe.model.TicTacToe;

/**
 * This frame contains the board that displays the 
 * game status. It paint a 3x3 grid and on it paints 
 * X and O.
 * */
public class BoardFrame extends JPanel {

	private TicTacToe ticTacToe;

	public BoardFrame() {
	}
	
	public void setTicTacToe(TicTacToe ticTacToe){
		this.ticTacToe = ticTacToe;
		this.repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int width = this.getWidth() / 3;
		int height = this.getHeight() / 3;
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				g.setColor(Color.black);
				g.drawRect(x * width, y * height, width, height);
				if (ticTacToe != null) {
					Symbols symbol = ticTacToe.getBoard()[x][y];
					if (symbol.equals(Symbols.O)) {
						g.setColor(Color.red);
						g.drawOval(x * width + 30, y * height + 30, width - 60,
								height - 60);
					} else if (symbol.equals(Symbols.X)) {
						g.setColor(Color.red);
						g.drawLine(x * width + 30, y * height + 30, (x+1) * width - 30,
								(y+1) * height - 30);
						g.drawLine(x * width + 30, (y+1) * height - 30, (x+1) * width - 30,
								y * height + 30);
					}
				}

			}
		}

	}

}
