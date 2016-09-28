package controller;

import java.awt.*;

import javax.swing.*;

import model.*;
import view.*;

public class SpadeController {
	
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
				button = new JButton(card.getValue().toString(), view.getClubIC());
				view.getClub().add(button);
				break;
			case Diamond:
				button = new JButton(card.getValue().toString(), view.getDiamondIC());
				view.getDiamond().add(button);
				break;
			case Heart:
				button = new JButton(card.getValue().toString(), view.getHeartIC());
				view.getHeart().add(button);
				break;
			case Spade:
				button = new JButton(card.getValue().toString(), view.getSpadeIC());
				view.getSpade().add(button);
				break;
			default:
				//Return an error if none of the suit are a match
				break;}
		}
		
	

}
