package Model;

import java.awt.Dimension;
import java.util.Collection;
import java.util.Set;

import Util.Pair;

/*
 * $Id:
 * 
 * $Log:
 * 
 * @Joshua Anderson
 * 
 */

/**
 * A class that initialize Card object with the following data
 * 		Value: The value of the card ie. 1 - 10
 * 		Suit: The four card suit, Spade, Heart, etc
 * 		Card_ID: An unique integer assign to each initialize card
 * 
 * 
 * @author Joshua Anderson
 *
 */
public class Card implements Comparable<Card> {
	
	/*
	 * A enumeration of the suit value with integer from 4 to 1 assign
	 * with Spade assign the highest value 4 and Heart assign the 
	 * lowest value 1. 
	 */
	public enum Suit{Spade(4), Club(3), Diamond(2), Heart(1);
		
		private final int val;
		
		//Constructor for enum Value
		private Suit(int val){
			 this.val = val;
		}
		
		//Getter for Suit's val
		public int getVal(){
			return this.val;
		}
	
	};
	
	/*
	 * An enumeration of the value shown on the card staring from 2
	 * to 10 and including King, Queen, Jack and Ace. Each value will
	 * have an integer assign to it as according to the rule of the 
	 * card game 'Spade'.
	 * 
	 * 	Ace: 14
	 * 	King: 13
	 * 	Queen: 12
	 * 	Jack: 11
	 * 	Ten: 10
	 * 	.
	 * 	.
	 * 	.
	 * 	Three: 3
	 * 	Two: 2
	 * 
	 * 
	 */
	public enum Value{
		//All card's value with their numeric counterpart
		Two(2),
		Three(3),
		Four(4),
		Five(5),
		Six(6),
		Seven(7),
		Eight(8),
		Nine(9),
		Ten(10),
		Jack(11),
		Queen(12),
		King(13),
		Ace(14);
		
		private final int val;
		
		//Constructor for enum Value
		private Value(int val){
			
			this.val = val;
		}
		
		//Getter for Value's val
		public int getVal(){
			
			return this.val;
		}	
	
	}
	
	//The card's suit and value object
	private final Suit suit;
	private final Value val;
	
	//The card unique id
	private final Pair Card_ID;
	
	public Card(Suit suit, Value val){
		this.suit = suit;
		this.val = val;
		this.Card_ID = new Pair(this.suit.getVal(), this.val.getVal());
		
	}
	
	
	@Override
	public int compareTo(Card o) {
		// TODO Auto-generated method stub
		return 0;
	}


}
