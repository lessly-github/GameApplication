package com.lessly.game;

import java.util.Scanner;

/**
 * 
 * @author lessly
 * 
 * This class represents Entity called Player
 *
 */

public class Player {

	private String name;
	private boolean hasPowerup;
	private boolean hasDisadv;
	
	//Initialize the fields
	public Player(String name){
		this.name = name;
	}
	

	/**
	 * This method plays out the player's turn.
	 * @return The number of spaces to move on the board.
	 */
	public int takeTurn(){
		
		//Initialize scanner
		Scanner scan = new Scanner(System.in);
		//Prompt user for roll
		System.out.print(name+"'s turn: ");
		String input = scan.nextLine();
		
		//Translate the input to some numeric value between 1 and 9
		int val = 0;
		for (int idx = 0; idx < input.length(); idx++){
			val+= input.charAt(idx);
		}
		val = val % 10;
		if (val == 0){
			val = 1;
		}
		return val;
	}
	
	
	public String toString(){
		return name;
	}
}
