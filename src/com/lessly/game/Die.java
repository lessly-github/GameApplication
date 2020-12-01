package com.lessly.game;

import java.util.Random;

/**
 * 
 * 
 * @author lessly
 *
 */

public class Die {

	private Random random;
	
	/**
	 * Initialize the fields
	 */
	public Die(){
		random = new Random();
	}
	
	
	public int rollD6(){
		return random.nextInt(6)+1;
	}
}
