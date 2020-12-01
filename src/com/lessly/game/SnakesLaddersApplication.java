package com.lessly.game;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;


/**
 * 
 * @author lessly
 * This class is main class for Snakes and Ladder application 
 */
public class SnakesLaddersApplication {

	public static void main(String[] args){
		//Initialize scanner.
		Scanner scan = new Scanner (System.in);
		
		//Prompt for number of players.
		int numPlayers = 0;
		while (numPlayers <= 0 || numPlayers >2 ){
			System.out.print("Please enter the number of player (1-2): " );
			numPlayers = scan.nextInt();
		}
		
		//Initialize the players.
		List<Player> players = new ArrayList<Player>();
		for (int idx = 0; idx < numPlayers; idx++){
			Player player = new Player("Player " + idx);
			players.add(player);
		}
		
		//Initialize the board.
		Board board = new Board(players);
		
		//Loop until a player reaches the final spot.
		//Players take turns to roll the die and move on the board
		boolean done = false;
		int playerIdx = 0;
		while (!done){
			//Player takes turn
			Player currPlayer = players.get(playerIdx);
			int roll = currPlayer.takeTurn();
			
			//Update the board
			done = board.movePlayer(currPlayer, roll);
		}
	}
}
