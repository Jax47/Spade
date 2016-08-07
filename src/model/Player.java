package model;

import java.util.ArrayList;
import java.util.EnumSet;

/**
 * An class contain method in regard to 
 * the player object.
 * @author Joshua Anderson
 *
 */
public class Player {
	
	/* The three core data of the player object
	 * Player's Name
	 * Player's Hand - an arraylist of card that represent the player's hand
	 * Book - the number of hand the player won
	 */
	private String name;
	private ArrayList<Card> hand;
	private int book;
	
	/**
	 * Initialize player object
	 * 
	 * @param name Player's name
	 * \@param hand an arraylist of card that represent the player's hand.\Commented out
	 * @param book the number of hand the player won
	 */
	public Player(String name /*ArrayList<Card> hand*/){
		
		this.name = name;
		this.hand = new ArrayList<Card>();
		this.book = 0;
		
	}
	
	///////Getter method//////////////////// 
	public String getName(){
		return this.name;
	}
	
	public ArrayList<Card> getHand(){
		return this.hand;
	}
	
	public int getBook(){
		return this.book;
	}
	///////Getter method////////////////////
	
	/**
	 * A method to add card to a player's hand
	 * 
	 * @param card The card to be added to the player object.
	 */
	public void add(Card card) throws Exception{
		/*
		 * If the card to be added is already in this player hand
		 * throw Exception.
		 */
		if(this.hand.contains(card)){
					
				throw new Exception("This card is already in the player hand.");
		}
		//Add card to player's hand
		this.hand.add(card);
	}
	/**
	 * Method that increment the number of book
	 */
	public void incrementBook(){
		this.book++;
	}
	
	/**
	 * A method to find the weakness of the 
	 * card object pass in as the argument.
	 *
	 * 
	 * @param card The card that is being check
	 */
	public ArrayList<Card> weakness(Card card){
		//Check if the card is a null object
		if(card.equals(null)){
			throw new NullPointerException("Can't check an null object must be a card object.");
		}
		
		//A list that contain all the value that is greater than the 
		//card object. 
		ArrayList<Card> valueList = new ArrayList<Card>();
		
		//Check if the card is an Ace
		if(card.getValue().getVal() == 14){
			//This card can't be beat
			return valueList; 
		}
		
		//A for loop to iterate thru all the Card value comparing 
		//each card's value.
		for(Card.Value val : EnumSet.allOf(Card.Value.class)){
			
			if(card.getValue().getVal() > val.getVal()){
				continue;
			}
			else if(card.getValue().getVal() < val.getVal()){
				valueList.add(new Card(card.getSuit(), val));
			}
			
			else if(card.getValue().getVal() == val.getVal()){
				continue;
			}
		}
		
		return valueList;
	}
	
	/**
	 * A method that return the chance of a given card chance to win 
	 * a book.
	 * 
	 * @param card The card object to be check.
	 * @param cardWeakness An arraylist of the card to be check weakness.
	 * @param user The user whose card is being check 
	 * 
	 * @return Will return a possibility of the card chance to win a book.
	 */
	public double bestCard(Card card, ArrayList<Card> cardWeakness, Player user){
		//TODO: Add a method to check player hand and return the chance of winning with a given card

		//Check if the arraylist is empty
		if(cardWeakness.isEmpty()){
			return 1;
		}

		//Loop though the arraylist and remove the card that the player have.
		for(Card item : cardWeakness){
			if(user.hand.contains(item)){
				cardWeakness.remove(item);
			}
		}

		/*Check game history to see if any of the card had already been played
		 * and remove it from the arraylist. */ 
		for(Card item: cardWeakness){
			//Check if the card was already played
			if(model.Spade.history.contains(item)){
				cardWeakness.remove(item);
			}
		}

		return 0;
	}

	
	/*public String toString(){
	
		return this.name + " has " + this.book + " books." ;
		
	}*/
	
	/**
	 * A method that print the index of each card in 
	 * a player hand.
	 */
	public void printHand(){
		
		for(Card card : this.hand){
			
			System.out.println("Card " + this.hand.indexOf(card) + " is a " + 
					card.getValue() + " of " + card.getSuit() + ".");
		}
		System.out.println();
	} 
	
}
