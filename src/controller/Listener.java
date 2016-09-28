package controller;

import java.awt.event.*;

import javax.swing.*;

public class Listener {
	
	SpadeController control;
	
	public void addButtonListener(JButton jbtn){
		
		jbtn.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent ae){
				
				// TODO Auto-generated method stub
				/*Plan to implement code
				 * 
				 * Call pickCard method with the parameter of the card value and suit
				 * 	along with the player who playing the card.
				 * 
				 * Check that the card has been remove from the player hand
				 * 
				 * 	if yes the update the view by removing the card from the list of
				 * 	Button
				 * 
				 * 	if no then throw an error message 
				 * 
				 */
				
			}
			
		});
		
	}

}
