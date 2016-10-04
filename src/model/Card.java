package model;

import util.Pair;

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
	
	/**
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
	
	/**
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
	private final Value value;
	
	//The card unique id
	private final Pair Card_ID;
	
	public Card(Suit suit, Value value){
		this.suit = suit;
		this.value = value;
		this.Card_ID = new Pair(this.suit.getVal(), this.value.getVal());
		
	}
	/**
	 * A method to return the card's ID
	 * 
	 * @return the card_ID of the card object
	 */
	public Pair getCard_ID() {
		return Card_ID;
	}
	/**
	 * A method to return the card's Suit value
	 * 
	 * @return The suit value of a card object.
	 */
	public Suit getSuit(){
		return this.suit;
	}
	
	/**
	 * A method to get the card's value however 
	 * for comparison of two card object you 
	 * must append the method getVal() to this method
	 * 
	 * @return An Enum key of a card object.
	 *  
	 */
	public Value getValue(){
		return this.value;
	}
	
	
	/**
	 * A method to compare the suit value and card value
	 * 
	 * @return
	 * 		<b> 1</b>  :if the object being compared is less than the object <br>
	 * 		<b>-1</b>  :if the object being compared is greater than the object <br> 
	 * 		<b> 0</b>  :if the object being compared is equal to the object
	 * 
	 * 		 
	 */
	@Override
	public int compareTo(Card o) {
		// Check if there are null type
		if(this.equals(null) || o.equals(null)){
			System.err.println("Can not compare with a null type.");
			return 0;
		}
		
		// Check if the suit are the same
		if(this.getSuit().equals(o.getSuit())){
			
			//check who has the highest value
			if(this.getValue().getVal() > o.getValue().getVal()){
				return 1;
			}
			//Check who has the lowest value
			else if(this.getValue().getVal() < o.getValue().getVal()){
				return -1;
			}
		}
		//Check who has the highest suit
		else if(this.getSuit().getVal() > o.getSuit().getVal()){
			return 1;
		}
		//Check who has the lowest suit
		else if(this.getSuit().getVal() < o.getSuit().getVal()){
			return -1;
		}
		return 0;
	}
	
	public String toString(){
		
		return this.getValue() + " of " + this.getSuit()+ " .";
	}

}
