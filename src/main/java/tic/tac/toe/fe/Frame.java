package tic.tac.toe.fe;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tic.tac.toe.exception.EndException;
import tic.tac.toe.model.Symbols;
import tic.tac.toe.model.TicTacToe;
import tic.tac.toe.thread.GameThread;
import tic.tac.toe.utils.Utils;

/**
 * This Jframe is the main Window. Contains the main application buttons
 * and the BoardFrame containing the board. When Play is pressed the game 
 * start and when Exit is pressed the user close the application.
 * */
public class Frame extends JFrame implements ActionListener {

	private BoardFrame bf;

	public Frame() {
		this.setSize(400, 410);
		this.setLayout(new BorderLayout());

		bf = new BoardFrame();
		this.add(bf, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 2));
		JButton gioca = new JButton("Play");
		gioca.addActionListener(this);
		buttonPanel.add(gioca);
		JButton esci = new JButton("Exit");
		esci.addActionListener(this);
		buttonPanel.add(esci);
		buttonPanel.setVisible(true);
		this.add(buttonPanel, BorderLayout.SOUTH);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		int screenw = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenh = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation((screenw - this.getSize().width) / 2,
				(screenh - this.getSize().height) / 2);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals("Play")) {
			new GameThread(bf).start();
		} else if (ae.getActionCommand().equals("Exit")) {
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}

	}
}