package view;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
/**
 * 
 * @author Joshua Anderson
 *
 */
public class SpadeView {
	
	//Top level content pane
	private JFrame table;
	private JPanel hand;
	private JPanel spade;
	private JPanel club;
	private JPanel diamond;
	private JPanel heart;
	
	public void buildTable(){
		
		Border blackline = BorderFactory.createLineBorder(Color.BLACK);
		
		//Create top level pane and change to gridbag layout
		table = new JFrame();
		table.setLayout(new GridBagLayout());
		
		//Set application to close on exit
		table.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Set the window to maximized in the screen/monitor
		table.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		//Set the frame to be visible
		table.setVisible(true);
		
		//Create JPanel hand and it related panel and add it to the content pane
		hand = new JPanel();
		hand.setBorder(blackline);
		
		//Create JPanel for each suits and add them to JPanel hand 
		spade = new JPanel();
		club = new JPanel();
		diamond = new JPanel();
		heart = new JPanel();
		
		spade.setBorder(BorderFactory.createTitledBorder(blackline, "Spade"));
		club.setBorder(BorderFactory.createTitledBorder(blackline, "Club"));
		diamond.setBorder(BorderFactory.createTitledBorder(blackline, "Diamind"));
		heart.setBorder(BorderFactory.createTitledBorder(blackline, "Heart"));
		
		hand.add(spade);
		hand.add(club);
		hand.add(diamond);
		hand.add(heart);
		
		
		
		
		
		
	}
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new SpadeView();
			}
		});
	}

}
