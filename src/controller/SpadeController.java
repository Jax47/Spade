package controller;

import java.awt.*;

import javax.swing.*;

import model.*;
import view.*;

public class SpadeController {
	
	Listener listen = new Listener();
	SpadeView view = new SpadeView();
	
	/**
	 * A method that return a boolean on whether a panel 
	 * is empty or not
	 * 
	 * @param panel The panel that being check
	 * 
	 * @return Return <b>true</b> if the panel is empty or <b>false</b> otherwise
	 */
	public boolean isPanelEmpty(JPanel panel){
		
		Component[] array;
		array = panel.getComponents();
		
		for(Component e : array){
			if(e instanceof JButton){
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * A method to add individual card to their respective panel 
	 * in view representation of Spade.
	 * 
	 * @param card
	 */
	public void addCard(Card card){
			JButton button;
			switch(card.getSuit()){
			case Club:
				
				button = new JButton(card.getValue().toString(), view.getClubIC()); //Create new JButton
				button.setActionCommand(card.toString()); //Set actionCommand to the card value and suit
				listen.addButtonListener(button); //Register the button with an action listener
				view.getClub().add(button); //Add the button to the view
				break;
			case Diamond:
				button = new JButton(card.getValue().toString(), view.getDiamondIC()); //Create new JButton
				button.setActionCommand(card.toString()); //Set actionCommand to the card value and suit
				listen.addButtonListener(button); //Register the button with an action listener
				view.getDiamond().add(button); //Add the button to the view 
				break;
			case Heart:
				button = new JButton(card.getValue().toString(), view.getHeartIC()); //Create new JButton
				button.setActionCommand(card.toString()); //Set actionCommand to the card value and suit
				listen.addButtonListener(button); //Register the button with an action listener
				view.getHeart().add(button); //Add the button to the view
				break;
			case Spade:
				button = new JButton(card.getValue().toString(), view.getSpadeIC()); //Create new JButton
				button.setActionCommand(card.toString()); //Set actionCommand to the card value and suit
				listen.addButtonListener(button); //Register the button with an action listener
				view.getSpade().add(button); //Add the button to the view
				break;
			default:
				//Return an error if none of the suit are a match
				break;}
		}
		
	

}
