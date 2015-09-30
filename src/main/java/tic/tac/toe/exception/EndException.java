package tic.tac.toe.exception;

/**
 * Exception used to notify a winner or a draw
 * status of the game including a message.
 * 
 * */
public class EndException extends Exception {
	
	private static final long serialVersionUID = 2257044127821910973L;

	public EndException(String message){
		super(message);
	}

}
