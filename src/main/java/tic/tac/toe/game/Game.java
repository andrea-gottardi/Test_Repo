package tic.tac.toe.game;

import java.io.IOException;
import java.util.Random;

import tic.tac.toe.exception.EndException;
import tic.tac.toe.fe.Frame;
import tic.tac.toe.model.Symbols;
import tic.tac.toe.model.TicTacToe;
import tic.tac.toe.utils.Utils;

/**
 * This is the main class. Here we start/control 
 * the process and ask the user the actions to perform.
 * 
 * */
public class Game {

	public static final String CREATION = "Game Board Creation...\n";
	public static final String START_PLAYER = "Board Created.\nThe game will start with player {0}\n";
	public static final String CURRENT_PLAYER = "Player {0}";
	public static final String OPTIONS = "\ns. Start\nu. Start with ui\nq. Quit";
	public static final char START = 's';
	public static final char START_UI = 'u';
	public static final char QUIT = 'q';
	public static final String READ_ERROR = "Read Error";
	public static final String BYE = "Bye";
	public static final String INVALID_OPTION = "Invalid option";

	public static void main(String[] args) {
		startGame();
	} 
 
	/**
	 * Start the game asking the user the actions to perform,
	 * by insert the appropriate char.
	 * 
	 * The char 's' starts the game, make a move every
	 * two seconds and display the current status.
	 * 
	 * The char 'u' starts the game in the UI mode.
	 * 
	 * The char 'q' quit the game.
	 * 
	 * */
	protected static void startGame() {
		{
			int response = 0;
			while (response != QUIT) {
				System.out.println(OPTIONS);

				try {
					response = Utils.readCharacter();
				} catch (IOException e1) {
					System.out.println(READ_ERROR);
				}

				switch (response) {
				case START: {
					TicTacToe ticTacToe = new TicTacToe();
					Symbols symbol = Symbols.X;
					System.out.println(CREATION);
					ticTacToe.print();
					System.out.println(START_PLAYER.replace("{0}",
							symbol.toString()));
					while (true) {
						try {
							Boolean move = false;

							while (!move) {
								move = ticTacToe.move(Utils.getCoordinate(),
										Utils.getCoordinate(), symbol);
							}

							System.out.println(CURRENT_PLAYER.replace("{0}",
									symbol.toString()));
							ticTacToe.print();
							if (symbol.equals(Symbols.X))
								symbol = Symbols.O;
							else
								symbol = Symbols.X;
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							System.out.println(e.getMessage());
							break;
						} catch (EndException e) {
							System.out.println(CURRENT_PLAYER.replace("{0}",
									symbol.toString()));
							ticTacToe.print();
							System.out.println(e.getMessage());
							break;
						}
					}
					break;
				}
				case START_UI: {
					TicTacToe ticTacToe = new TicTacToe();
					Frame frame=new Frame();
					while (frame.isVisible()){}
					break;
				}
				case QUIT: {
					System.out.println(BYE);
					System.exit(0);
				}
				default:
					System.out.println(INVALID_OPTION);
					break;
				}
			}
		}
	}

}
