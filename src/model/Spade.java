package model;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

import sort.QuickSort;

/**
 * This is the class that will simulate the 
 * game of Spade. All rule of the game will be 
 * contain within this class.
 * @author Joshua Anderson
 *
 */
public class Spade {
	
	 //Scanner object to be use through out the program
		static Scanner scan = new Scanner(System.in);
		
		//An arraylist that contain all the card that has been played
		protected static ArrayList<Card> history = new ArrayList<Card>();
		
		//
		public ArrayList<Card> getHistory(){
			return history;
		}
		
		
		/**
		 * A method to get the number of players 
		 * playing the game.
		 * 
		 * @return 
		 * 		2: If the user want a two players game.
		 * 		4: If the user want a four players game.
		 * 	   -1: If the user exit out without selecting the number of players. 
		 */
		public static int numPlayers(){
			
			System.out.println("How many player are playing?");
			System.out.println("Enter either: [0]Exit, [2]Two Player or "
					+ "[4]Fours Player.");
			Boolean Bool = true; 
			
			do{
				System.out.print("Enter: ");
				try{
					int players = scan.nextInt(); 
					switch(players){
						case 0: Bool = false; break;
						
						case 2: Bool = false; return 2;
						
						case 4: Bool = false; return 4;
						
						default: System.out.println("Invaild input please enter "
								+ "either: [0]Exit, [2]Two Player or "
								+ "[4]Fours Player."); continue;
					}
				}
				
				catch(InputMismatchException e){
					
					System.out.println("Catch: Invaild input please enter "
							+ "either: [0]Exit, [2]Two Player or "
							+ "[4]Fours Player.");
					System.out.print("Enter: ");
					scan.next();
					
					
				}
				//May cause problem with the stream at the bottom
				//that ask for player name.
				/*finally{
					
					scan.close();
				}*/
			}while(Bool);
			
			return -1;
				
		}
			
		
		/**
		 * A method to pick the player card and remove it from the 
		 * player hand as well. If the user is human this method will print 
		 * player hand to show what card they currently have
		 * 
		 * @param user The player who picking the card
		 * 
		 * @return A card object
		 */
		public static Card pickCard(Player user){
			
			Random rand = new Random();
			
			//Check if player is human or not
			if(user.getName().equals("PC") || user.getName().equals("PC1") ||  user.getName().equals("PC2")){
				if(user.getHand().size() == 1){
					return user.getHand().remove(0);
				}
				int comPick = rand.nextInt(user.getHand().size()-1);
				history.add(user.getHand().get(comPick));
				return user.getHand().remove(comPick);
				
			}
			
			//Assume that the player is human
			
			user.printHand();
			
			//Do not close this scanner stream unless you
			// wish to be stuck in infinity
			System.out.print("Enter card: ");
			int userPick = scan.nextInt();
			System.out.println();
			history.add(user.getHand().get(userPick));
			return user.getHand().remove(userPick);
			
			
		}
		
		
		
		//The game play will be run in main
		public static void main(String[] args){
			Scanner input = new Scanner(System.in);
			
			//Ask user how many players are playing
			int maxTurn = numPlayers();
			
			//An immutable variable to get the top of the Deck
			//i.e the first element in the Deck ArrayList
			final int  top = 0;
			
			//Initialize a card object to use the initializeDeck method
			Card pod = new Card(null, null);
			
			//Create a deck of card
			ArrayList<Card> Deck = pod.initalizeDeck();
			
			if(maxTurn == 2){
				Boolean bool = true;
				//Initialize the computer player object
				Player PC = new Player("PC");
				Player USER = null;
				do{
					try{
						 //Ask user for their name
						 System.out.print("Enter player's name: ");
						 String name = input.next();
						 System.out.println();
						 
						 //Initialize player object with user's name
						 USER = new Player(name);
						 
						 //Exit the loop
						 System.out.println();
						 bool = false;
						 
					}catch(NoSuchElementException e){
						
						System.out.println("Please try again: ");
						input.next();
						
					}
					
				}while(bool);
				
			/*All related code for a two player game goes below this line*/
				
				//A magic variable for the number of turn
				int turn = 26;
				
				//Get the number of card each player need
				//by dividing the total deck by the number of player 
				int deckSize = Deck.size()/ maxTurn;
				
				//Add a card to each player hand until deck is exhausted
				while(deckSize != 0){
					
					PC.getHand().add(Deck.remove(0));
					USER.getHand().add(Deck.remove(0));
					
					//Decrease counter
					deckSize--;
				}
				
				//Sort player hand for easy readability
				QuickSort<Card> sort = new QuickSort<Card>();
				sort.sort(USER.getHand());
				 
				while(turn != 0){
					
					//Print out the card that each player pick
					
					//PC turn
					Card pc = pickCard(PC);
					System.out.println("PC played " + pc.toString());
					System.out.println();
					
					//User Turn
					Card user = pickCard(USER);
					System.out.println( USER.getName() + " played " + user.toString());
					System.out.println();
					
					//If both card are the same suit check the card value
					
					if(pc.getSuit().equals(user.getSuit())){
						if(pc.getValue().getVal() > user.getValue().getVal()){
							//PC card win
							System.out.println(pc.toString() + " beat " + user.toString());
							System.out.println();
							PC.incrementBook();
							turn--;
						}
						else{
							//User card win
							System.out.println(user.toString() + " beat " + pc.toString());
							System.out.println();
							USER.incrementBook();
							turn--;
						}
					}
					
					//If card suit are different check who has the highest suit
					else if(pc.getSuit().getVal() > user.getSuit().getVal()){
						
						//PC card win
						System.out.println(pc.toString() + " beat " + user.toString());
						System.out.println();
						PC.incrementBook();
						turn--;
					}
					
					else{
						
						//User card win
						System.out.println(user.toString() + " beat " + pc.toString());
						System.out.println();
						USER.incrementBook();
						turn--;
					}
					
				}
				//Print how many book each player have
				System.out.println("PC has: " + PC.getBook() + " books");
				
				System.out.println(USER.getName() + " has: " + USER.getBook() + " books");
				
				//Declare who won the game
				if(PC.getBook() > USER.getBook()){
					System.out.println("PC win this match.");
				}
				else if(USER.getBook() > PC.getBook()){
					System.out.println(USER.getName() + " win this match.");
				}
				else{
					System.out.println("The game is tied.");
				}
			
			}
			//End of two player block
			
			/*All related code for a four player game goes below this line*/
			
			else if(maxTurn == 4){
				Boolean bool = true;
				//Initialize two computer player object
				Player PC1 = new Player("PC1");
				Player PC2 = new Player("PC2");
				
				//Initialize the two user player object
				Player USER1 = null;
				Player USER2 = null;
				do{
					
					try{
						
						//Ask Player 1 for their name
						System.out.print("Player 1 enter your name: ");
						String name = input.next();
						
						//Initialize player 1 object with user1's name
						USER1 = new Player(name); 
						
						//New Line
						System.out.println();
						
						//Ask Player 2 for their name
						System.out.print("Player 2 enter your name: ");
						name = input.next();
						
						//Initialize player 2 object with user2's name
						USER2 = new Player(name);
						
						//Exit the loop 
						System.out.println();
						bool = false;
						
					}catch(NoSuchElementException e){
						System.out.print("Please try again: ");
						input.next();
					}
					
				}while(bool);
			/*All code related to a 4 player game goes below this line*/
				
				//Get the number of card each player need
				//by dividing the total deck by the number of player 
				int deckSize = Deck.size()/ maxTurn;
				
				//Add a card to each player hand until deck is exhausted
				while(deckSize != 0){
					
					PC1.getHand().add(Deck.remove(top));
					USER1.getHand().add(Deck.remove(top));
					PC2.getHand().add(Deck.remove(top));
					USER2.getHand().add(Deck.remove(top));
					
					//Decrement the counter
					deckSize--;
					
				}
				
				//Sort player hand for easy readability
				QuickSort<Card> Sort = new QuickSort<Card>();
				
				//Sort Player 1 hand
				Sort.sort(USER1.getHand());
				
				//Sort Player 2 hand
				Sort.sort(USER2.getHand());
				
			
				//Magic variable for the number of turn in the game 
				int turn = 13;
			
				while(turn != 0){
					/*Each players player pick their card
					Compare card to see who won the book
					Increase the winning player book count*/
					
					//PC1 turn 
					Card pc1 = pickCard(PC1);
					System.out.println("PC1 played " + pc1.toString());
					System.out.println();
					
					//USER1 turn
					Card user1 = pickCard(USER1);
					System.out.println( USER1.getName() + " played " + user1.toString());
					System.out.println();
					
					//PC2 turn
					Card pc2 = pickCard(PC2);
					System.out.println("PC2 played " + pc2.toString());
					System.out.println();
					
					
					//USER2 turn
					Card user2 = pickCard(USER2);
					System.out.println( USER2.getName() + " played " + user2.toString());
					System.out.println();
					
					
					//Check if all card are the same suit
					if(pc1.getSuit().equals(pc2.getSuit())){
						if(pc1.getSuit().equals(user1.getSuit())){
							if(pc1.getSuit().equals(user2.getSuit())){
								//Check who has the highest card value
								
								/*
								 * Warning the code below might be a bit difficult to read. So 
								 * basically what the code is doing is testing all four possible
								 * case for who has the highest card value. 
								 */
								
								//PC1 win
								if(pc1.getValue().getVal() > pc2.getValue().getVal() && pc1.getValue().getVal() > user1.getValue().getVal() 
										&& pc1.getValue().getVal() > user2.getValue().getVal()){
									
									System.out.println("The highest card is " + pc1.toString());
									System.out.println();
									PC1.incrementBook();
									turn--;
								}
								
								//PC2 win
								else if(pc2.getValue().getVal() > pc1.getValue().getVal() && pc2.getValue().getVal() > user1.getValue().getVal() 
										&& pc2.getValue().getVal() > user2.getValue().getVal()){
									
									System.out.println("The highest card is " + pc2.toString());
									System.out.println();
									PC2.incrementBook();
									turn--;
								}
								
								//USER1 win
								else if(user1.getValue().getVal() > pc1.getValue().getVal() && user1.getValue().getVal() > pc2.getValue().getVal() 
										&& user1.getValue().getVal() > user2.getValue().getVal()){
									
									System.out.println("The highest card is " + user1.toString());
									System.out.println();
									USER1.incrementBook();
									turn--;
								}
								
								//USER2 win
								else if(user2.getValue().getVal() > pc1.getValue().getVal() && user2.getValue().getVal() > pc2.getValue().getVal() 
										&& user2.getValue().getVal() > user1.getValue().getVal()){
									
									System.out.println("The highest card is " + user2.toString());
									System.out.println();
									USER2.incrementBook();
									turn--;
								}
							}
						}
					}
					//End of equal suit case check
					
					//Check who has the highest suit
					
					//PC1 win
					else if(pc1.getSuit().getVal() > pc2.getSuit().getVal() && pc1.getSuit().getVal() > user1.getSuit().getVal() 
							&& pc1.getSuit().getVal() > user2.getSuit().getVal()){
						
						System.out.println("The highest card is " + pc1.toString());
						System.out.println();
						PC1.incrementBook();
						turn--;
					}
					
					//PC2 win
					else if(pc2.getSuit().getVal() > pc1.getSuit().getVal() && pc2.getSuit().getVal() > user1.getSuit().getVal() 
							&& pc2.getSuit().getVal() > user2.getSuit().getVal()){
						
						System.out.println("The highest card is " + pc2.toString());
						System.out.println();
						PC2.incrementBook();
						turn--;
					}
					
					//USER1 win
					else if(user1.getSuit().getVal() > pc1.getSuit().getVal() && user1.getSuit().getVal() > pc2.getSuit().getVal() 
							&& user1.getSuit().getVal() > user2.getSuit().getVal()){
						
						System.out.println("The highest card is " + user1.toString());
						System.out.println();
						USER1.incrementBook();
						turn--;
					}
					
					//USER2 win
					else if(user2.getSuit().getVal() > pc1.getSuit().getVal() && user2.getSuit().getVal() > pc2.getSuit().getVal() 
							&& user2.getSuit().getVal() > user1.getSuit().getVal()){
						
						System.out.println("The highest card is " + user2.toString());
						System.out.println();
						USER2.incrementBook();
						turn--;
					}
				}
				
				//Print how many book each player have
				System.out.println("PC1 has: " + PC1.getBook() + " books");
				
				System.out.println(USER1.getName() + " has: " + USER1.getBook() + " books");
				
				System.out.println("PC2 has: " + PC2.getBook() + " books");
				
				System.out.println(USER2.getName() + " has: " + USER2.getBook() + " books");
				
				//Declare who won the game
				
				//PC1 win
				if(PC1.getBook() > USER1.getBook() && PC1.getBook() > USER2.getBook()
						&& PC1.getBook() > PC2.getBook()){
					System.out.println("PC1 win this match.");
				}
				
				//PC2 win
				else if(PC2.getBook() > USER1.getBook() && PC2.getBook() > USER2.getBook()
						&& PC2.getBook() > PC1.getBook()){
					System.out.println("PC2 win this match.");
				}
				
				//USER1 win
				else if(USER1.getBook() > PC1.getBook() && USER1.getBook() > PC2.getBook()
						&& USER1.getBook() > USER2.getBook()){
					System.out.println("PC1 win this match.");
				}
				
				//USER2 win
				else if(USER2.getBook() > PC1.getBook() && USER2.getBook() > PC2.getBook()
						&& USER2.getBook() > USER1.getBook()){
					System.out.println("PC1 win this match.");
				}
				
				else{
					System.out.println("The game is tied.");
				}
			
			//Close all stream here
			input.close();
			scan.close();
			
			}
			//End of 4 player block
		}

}
