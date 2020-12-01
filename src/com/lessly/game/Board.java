package com.lessly.game;

import java.util.HashMap;

import java.util.List;
import java.util.Map;


/**
 * 
 * 
 * @author lessly
 * This class is used to initialize board and help to moves by a player
 */

public class Board {

	//Constant values: Board size, and number of snakes and ladders
	private final int ROWS = 10;
	private final int COLS = 10;
	private final int NO_OF_SNAKES = 6;
	private final int NO_OF_LADDERS = 3;
	

	//Board variables
	private int[][] gameBoard;
	private int[][] snakes;
	private int[][] ladders;

	//Map of player positions.
	//Key = player, Value = player position
	Map<Player, Integer> playerPositions;

	/**
	 * Initialize the fields.
	 * @param numPlayers The number of players.
	 */
	public Board(List<Player> players){

		//Initialize the player positions
		this.playerPositions = new HashMap<Player, Integer>();
		for (Player player : players){
			this.playerPositions.put(player, 0);
		}

		//Set up the ROWS X COLS board
		gameBoard = new int[ROWS][COLS];
		for (int row = 0; row < ROWS; row++){
			for (int col = 0; col < COLS; col++){
				gameBoard[row][col] = row*ROWS + col + 1;
			}
		}

		//Set the snakes, ladders, powerups, and disadvantages
		setSnakes();
		setLadders();

	}

	/**
	 * Moves the given player based on the value provided.
	 * @param player The player to move.
	 * @param value The spaces to move.
	 * @return True if the player reaches the final (100) spot, else false.
	 */
	public boolean movePlayer(Player player, int value){

		//Compute the new position
		int position = playerPositions.get(player);
		position += value;


		if (position >= 100){
			//If the new position is 100 (or above), the player wins!
			playerPositions.put(player, 100);
			return true;
		} else {
			//If the new position is less than 100

			//Check if the new position is the starting point for a snake
			for (int idx = 0; idx < NO_OF_SNAKES; idx++){
				if (snakes[idx][0] == position){
					//If the new position is the starting point for a snake
					//Move the player to the end position for the snake
					position = snakes[idx][1];
					playerPositions.put(player, position);
					
					System.out.println("Uh oh. " + player + " takes snake from " + snakes[idx][0] + " to " + snakes[idx][1]);

					return false;
				}
			}

			//Check if the new position is the starting point for a ladder
			for (int idx = 0; idx < NO_OF_LADDERS; idx++){
				if (ladders[idx][0] == position){
					//If the new position is the starting point for a ladder
					//Move the player to the end position for the ladder
					position = ladders[idx][1];
					playerPositions.put(player, position);

					System.out.println("\t" + player + " takes ladder from " + ladders[idx][0] + " to " + ladders[idx][1]);
					
					return false;
				}
			}
			
			//If the player is not on a snake/ladder, then just update
			//its position normally
			playerPositions.put(player, position);
			return false;
		}
	}

	/**
	 * Sets the snakes for the board
	 */
	private void setSnakes(){
		snakes = new int[NO_OF_SNAKES][2];

		snakes[0][0] = 10;
		snakes[0][1] = 4;
		snakes[1][0] = 30;
		snakes[1][1] = 42;
		snakes[2][0] = 60;
		snakes[2][1] = 20;
		snakes[3][0] = 64;
		snakes[3][1] = 60;
		snakes[4][0] = 87;
		snakes[4][1] = 24;
		snakes[5][0] = 93;
		snakes[5][1] = 73;
	}

	/**
	 * Sets the ladders for the board
	 */
	private void setLadders(){
		ladders = new int[NO_OF_LADDERS][2];

		ladders[0][0] = 4;
		ladders[0][1] = 13;
		ladders[1][0] = 9;
		ladders[1][1] = 34;
		ladders[2][0] = 25;
		ladders[2][1] = 37;
	}
	
}
