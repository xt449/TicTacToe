package com.github.xt449.tictactoe;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.HashMap;

public class TicTacToeBoard extends JFrame {
	
	private final JButton button1 = new JButton();
	private final JButton button2 = new JButton();
	private final JButton button3 = new JButton();
	private final JButton button4 = new JButton();
	private final JButton button5 = new JButton();
	private final JButton button6 = new JButton();
	private final JButton button7 = new JButton();
	private final JButton button8 = new JButton();
	private final JButton button9 = new JButton();
	
	private final boolean aiFirst;
	private boolean aiTurn;
	private boolean boardFull;

	public boolean playAgain = false;

	public TicTacToeBoard() {
		this.setName("TicTacToeBoard");
		this.setTitle("Tic Tac Toe");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(3, 3, 10, 10));
		this.setSize(400, 432);
		this.setResizable(false);
		
		button1.setActionCommand("buttonClick");
		button2.setActionCommand("buttonClick");
		button3.setActionCommand("buttonClick");
		button4.setActionCommand("buttonClick");
		button5.setActionCommand("buttonClick");
		button6.setActionCommand("buttonClick");
		button7.setActionCommand("buttonClick");
		button8.setActionCommand("buttonClick");
		button9.setActionCommand("buttonClick");

		button1.setFont(new Font(Font.DIALOG, Font.BOLD, 72));
		button2.setFont(new Font(Font.DIALOG, Font.BOLD, 72));
		button3.setFont(new Font(Font.DIALOG, Font.BOLD, 72));
		button4.setFont(new Font(Font.DIALOG, Font.BOLD, 72));
		button5.setFont(new Font(Font.DIALOG, Font.BOLD, 72));
		button6.setFont(new Font(Font.DIALOG, Font.BOLD, 72));
		button7.setFont(new Font(Font.DIALOG, Font.BOLD, 72));
		button8.setFont(new Font(Font.DIALOG, Font.BOLD, 72));
		button9.setFont(new Font(Font.DIALOG, Font.BOLD, 72));

		TicTacToeActionListener actionListener = new TicTacToeActionListener(this);

		button1.addActionListener(actionListener);
		button2.addActionListener(actionListener);
		button3.addActionListener(actionListener);
		button4.addActionListener(actionListener);
		button5.addActionListener(actionListener);
		button6.addActionListener(actionListener);
		button7.addActionListener(actionListener);
		button8.addActionListener(actionListener);
		button9.addActionListener(actionListener);
		
		this.add(button1).setName("button1");
		this.add(button2).setName("button2");
		this.add(button3).setName("button3");
		this.add(button4).setName("button4");
		this.add(button5).setName("button5");
		this.add(button6).setName("button6");
		this.add(button7).setName("button7");
		this.add(button8).setName("button8");
		this.add(button9).setName("button9");
		
		/*
		button1.setDisabledIcon(com.github.xt449.tictactoe.Main.ICON_DISABLED);
		button2.setDisabledIcon(com.github.xt449.tictactoe.Main.ICON_DISABLED);
		button3.setDisabledIcon(com.github.xt449.tictactoe.Main.ICON_DISABLED);
		button4.setDisabledIcon(com.github.xt449.tictactoe.Main.ICON_DISABLED);
		button5.setDisabledIcon(com.github.xt449.tictactoe.Main.ICON_DISABLED);
		button6.setDisabledIcon(com.github.xt449.tictactoe.Main.ICON_DISABLED);
		button7.setDisabledIcon(com.github.xt449.tictactoe.Main.ICON_DISABLED);
		button8.setDisabledIcon(com.github.xt449.tictactoe.Main.ICON_DISABLED);
		button9.setDisabledIcon(com.github.xt449.tictactoe.Main.ICON_DISABLED);
		*/
		
		// SETUP GAME
		
		int response;
		
		do {
			response = JOptionPane.showConfirmDialog(null, "Should the AI play first?", "Tic-Tac-Toe", JOptionPane.YES_NO_OPTION);
		} while(response < 0);
		
		// if the user clicks yes, the AI will play first
		aiFirst = (response == JOptionPane.YES_OPTION);
		
		// START GAME
		
		this.setVisible(true);
		
		aiTurn = aiFirst;
		
		//int update = 0;
		//long time = System.currentTimeMillis();

		boolean lost = false;

		while(!boardFull) {
			if(aiTurn) {
				if(executeAITurn()) {
					lost = true;
					break;
				}
			} else {
				this.setVisible(true);
			}
		}
		
		// END GAME
		
		/*
		button1.removeActionListener(actionListener);
		button2.removeActionListener(actionListener);
		button3.removeActionListener(actionListener);
		button4.removeActionListener(actionListener);
		button5.removeActionListener(actionListener);
		button6.removeActionListener(actionListener);
		button7.removeActionListener(actionListener);
		button8.removeActionListener(actionListener);
		button9.removeActionListener(actionListener);
		
		button1.setEnabled(false);
		button2.setEnabled(false);
		button3.setEnabled(false);
		button4.setEnabled(false);
		button5.setEnabled(false);
		button6.setEnabled(false);
		button7.setEnabled(false);
		button8.setEnabled(false);
		button9.setEnabled(false);
		*/
		
		System.out.println("Game Over");
		response = JOptionPane.showConfirmDialog(null, (lost ? "Game Over" : "Tie Game") + "\n\nPlay Again?", "Tic-Tac-Toe", JOptionPane.YES_NO_OPTION);

		playAgain = (response == JOptionPane.YES_OPTION);

		//this.invalidate();
		this.setVisible(false);
		//this.setEnabled(false);
	}
	
	private void endTurn() {
		aiTurn = !aiTurn;
	}
	
	/**
	 * @param x coordinate starting at 1 from the left.
	 * @param y coordinate starting at 1 from the top.
	 */
	private JButton getButton(int x, int y) {
		if(x < 1 || x > 3 || y < 1 || y > 3) {
			throw new IndexOutOfBoundsException("Parameters must be within 1 and 3");
		}
		
		switch(x) {
			case 1: {
				switch(y) {
					case 1: {
						return button1;
					}
					case 2: {
						return button4;
					}
					case 3: {
						return button7;
					}
				}
				break;
			}
			case 2: {
				switch(y) {
					case 1: {
						return button2;
					}
					case 2: {
						return button5;
					}
					case 3: {
						return button8;
					}
				}
				break;
			}
			case 3: {
				switch(y) {
					case 1: {
						return button3;
					}
					case 2: {
						return button6;
					}
					case 3: {
						return button9;
					}
				}
				break;
			}
		}
		
		throw new IndexOutOfBoundsException();
	}
	
	private String getRowSet(int row) {
		final StringBuilder builder = new StringBuilder();
		
		for(int i = 1; i < 4; i++) {
			builder.append(getButtonContent(i, row));
		}
		
		return builder.toString();
	}
	
	private String getColumnSet(int column) {
		final StringBuilder builder = new StringBuilder();
		
		for(int i = 1; i < 4; i++) {
			builder.append(getButtonContent(column, i));
		}
		
		return builder.toString();
	}

	private String getDiagonalDownSet() {
		return getButtonContent(1, 1) + getButtonContent(2, 2) + getButtonContent(3, 3);
	}
	
	private String getDiagonalUpSet() {
		return getButtonContent(3, 1) + getButtonContent(2, 2) + getButtonContent(1, 3);
	}

	private boolean isButtonEmpty(int x, int y) {
		return getButtonContent(x, y).isEmpty();
	}
	
	private String getButtonContent(int x, int y) {
		return getButton(x, y).getText();
	}
	
	public void placePiece(int x, int y) {
		final JButton button = getButton(x, y);
		
		button.setEnabled(false);

		button.setText((aiTurn != aiFirst ? "O" : "X"));
		
		endTurn();
		boardFull = isBoardFull();
	}
	
	/**
	 * @param aiMoves controls the side for which moves are analysed:
	 * <br>if true looks for moves that the AI can make for lethal</br>
	 * <br>if false looks for moves that the player can make for lethal</br>
	 */
	private HashMap<Integer, Integer> getLethalMoves(boolean aiMoves) {
		final HashMap<Integer, Integer> moves = new HashMap<>();
		final String lethal = (aiMoves ^ aiFirst ? "OO" : "XX");
		
		/* TODO - DEBUG
		System.out.println("Did the AI play first (is X\'s)? " + aiFirst);
		System.out.println("Are we looking for the moves the AI can do? " + aiMoves);
		System.out.println("xor: " + (aiMoves^aiFirst));
		System.out.println(lethal);
		TODO - DEBUG */
		
		for(int i = 1; i < 4; i++) {
			if(getColumnSet(i).equalsIgnoreCase(lethal)) {
				if(isButtonEmpty(i, 1)) {
					moves.put(i, 1);
				} else if(isButtonEmpty(i, 2)) {
					moves.put(i, 2);
				} else {
					moves.put(i, 3);
				}
			}
			
			if(getRowSet(i).equalsIgnoreCase(lethal)) {
				if(isButtonEmpty(1, i)) {
					moves.put(1, i);
				} else if(isButtonEmpty(2, i)) {
					moves.put(2, i);
				} else {
					moves.put(3, i);
				}
			}
		}
		
		if(getDiagonalDownSet().equalsIgnoreCase(lethal)) {
			if(isButtonEmpty(1, 1)) {
				moves.put(1, 1);
			} else if(isButtonEmpty(2, 2)) {
				moves.put(2, 2);
			} else {
				moves.put(3, 3);
			}
		}
		
		if(getDiagonalUpSet().equalsIgnoreCase(lethal)) {
			if(isButtonEmpty(1, 3)) {
				moves.put(1, 3);
			} else if(isButtonEmpty(2, 2)) {
				moves.put(2, 2);
			} else {
				moves.put(3, 1);
			}
		}
		
		return moves;
	}
	
	private boolean executeAITurn() {
		HashMap<Integer, Integer> moves;
		
		// Manage Bot lethal moves
		moves = getLethalMoves(true);

		if(moves.size() > 0) {
			HashMap.Entry<Integer, Integer> move = moves.entrySet().iterator().next();
			
			placePiece(move.getKey(), move.getValue());
			return true;
		}
		// end
		
		// Manage Player lethal moves
		moves = getLethalMoves(false);
		
		if(moves.size() > 0) {
			HashMap.Entry<Integer, Integer> move = moves.entrySet().iterator().next();
			
			placePiece(move.getKey(), move.getValue());
			return false;
		}
		// end
		
		// Middle first
		if(isButtonEmpty(2, 2)) {
			placePiece(2, 2);
			return false;
		}
		// end

		// Corners Second
		if(isButtonEmpty(1, 1)) {
			placePiece(1, 1);
			return false;
		}
		
		if(isButtonEmpty(3, 1)) {
			placePiece(3, 1);
			return false;
		}
		
		if(isButtonEmpty(1, 3)) {
			placePiece(1, 3);
			return false;
		}
		
		if(isButtonEmpty(3, 3)) {
			placePiece(3, 3);
			return false;
		}
		// end

		// Sides Last
		if(isButtonEmpty(3, 2)) {
			placePiece(3, 2);
			return false;
		}

		if(isButtonEmpty(2, 3)) {
			placePiece(2, 3);
			return false;
		}

		if(isButtonEmpty(1, 2)) {
			placePiece(1, 2);
			return false;
		}

		if(isButtonEmpty(2, 1)) {
			placePiece(2, 1);
			return false;
		}
		// end

		System.out.println("Missing rule for moves or board is full.");
		return true;
	}
	
	private boolean isBoardFull() {
		return (getRowSet(1).length() == 3 && getRowSet(2).length() == 3 && getRowSet(3).length() == 3);
	}
}
