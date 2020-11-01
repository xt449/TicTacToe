package com.github.xt449.tictactoe;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeActionListener implements ActionListener {

	private final TicTacToeBoard board;

	public TicTacToeActionListener(TicTacToeBoard ticTacToeBoard) {
		board = ticTacToeBoard;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		final String command = event.getActionCommand();

		if(command.equals("buttonClick")) {
			final JButton button = ((JButton) event.getSource());

			final String name = button.getName();
			final int n = Integer.parseInt(name.substring(name.length() - 1));

			switch(n) {
				case 1: {
					board.placePiece(1, 1);
					return;
				}
				case 2: {
					board.placePiece(2, 1);
					return;
				}
				case 3: {
					board.placePiece(3, 1);
					return;
				}
				case 4: {
					board.placePiece(1, 2);
					return;
				}
				case 5: {
					board.placePiece(2, 2);
					return;
				}
				case 6: {
					board.placePiece(3, 2);
					return;
				}
				case 7: {
					board.placePiece(1, 3);
					return;
				}
				case 8: {
					board.placePiece(2, 3);
					return;
				}
				case 9: {
					board.placePiece(3, 3);
					break; //return;
				}
			}
		} else {
			System.out.printf("[MainActionListener] Unregistered action command \"%s\" triggered.\n", command);
		}
	}
}
