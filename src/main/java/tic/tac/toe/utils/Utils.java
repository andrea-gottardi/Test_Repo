package tic.tac.toe.utils;

import java.io.IOException;
import java.util.Random;

import tic.tac.toe.model.TicTacToe;

/**
 *This class contains some utils.
 */
public class Utils {
	/**
	 * Read a character from the input stream
	 * @return int
	 * */
	public static int readCharacter() throws IOException {
		byte[] buf = new byte[16];
		System.in.read(buf);
		return buf[0];
	}
	
	/**
	 * Generate a random int in the rage
	 * 0<x<BOARD_DIM
	 * @return int
	 * */
	public static int getCoordinate() {
		Random rand = new Random();
		return rand.nextInt(TicTacToe.BOARD_DIM);
	}
}
