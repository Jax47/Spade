package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;

import model.Card.Suit;
import model.Card.Value;
import util.Pair;
/**
 * A class that contain method and operation that relate to Deck object,
 * an arraylist of card object.
 * 
 * @author Joshua Anderson
 *
 */
public class Deck {
	
	/**
	 * 
	 * A method that initialize a deck of card by
	 * creating an arraylist of card object while also
	 * shuffling it as well.
	 * 
	 * @return An arraylist of card object
	 */
	
	public ArrayList<Card> initalizeDeck(){
		ArrayList<Card> deck = new ArrayList<Card>();
		/*
		 * Loop through each enumeration starting with suit 
		 * and then value to create all 52 cards object and
		 * add it to the arraylist. 
		 */
		for(Suit eleS : EnumSet.allOf(Suit.class)){
			for(Value eleV: EnumSet.allOf(Value.class)){
				deck.add(new Card(eleS, eleV));
			}
		}
		
		//Shuffle the deck 
		Collections.shuffle(deck);
		return deck;
	}
	
	/**
	 * A method that remove a specific card from the 
	 * deck(an arraylist of card).
	 * 
	 * @param Deck The arraylist of card object.
	 * @param target The targeted card to be remove from the arraylist.
	 */
	
	public void removeCard(ArrayList<Card> Deck, Pair Target){
		
		//Iterate through each card in the deck while there is still a card in the deck
		for(Iterator<Card> element = Deck.iterator(); element.hasNext();){
			
			//Set variable card to the next card in the deck
			Card card = element.next();
			
			//check if the card is the target 
			if(card.getCard_ID().equals(Target)){
				element.remove();
			}
		}
		
	}

}
