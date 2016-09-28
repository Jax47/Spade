package view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import controller.SpadeController;

import java.awt.*;
/**
 * 
 * @author Joshua Anderson
 *
 */
public class SpadeView {
	
	//Initialize controller obj
	SpadeController control = new SpadeController();
	
	//Top level content pane
	private JFrame table;
	
	//Secondary level Panel for card
	//Act as a container for panels which 
	//will contain JButton
	private JPanel hand;
	
	//Panel that will hold JButton
	private JPanel spade;
	private JPanel club;
	private JPanel diamond;
	private JPanel heart;
	
	//PlaceHolder TextArea
	private JTextArea placeH;
	
	//All the icon for each suit
	ImageIcon spadeIC = new ImageIcon("Icon/Spade/Spade32.png");
	ImageIcon clubIC = new ImageIcon("Icon/Club/Club32.png");
	ImageIcon diamondIC = new ImageIcon("Icon/Diamond/Diamond32.png");
	ImageIcon heartIC = new ImageIcon("Icon/Heart/Heart32.png");
	
	
	 public SpadeView(){
		buildTable();
	}
	
	public void buildTable(){
		
		Border blackline = BorderFactory.createLineBorder(Color.BLACK);
		
		//Create top level pane and change to gridbag layout
		table = new JFrame();
		table.setLayout(new GridBagLayout());
		
		//Set application to close on exit
		table.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Create JPanel hand and it related panel and add it to the content pane
		hand = new JPanel();
		hand.setBorder(BorderFactory.createTitledBorder(blackline, "Player's Hand"));
		
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
		
		//Create placeholder
		placeH = new JTextArea();
		placeH.setEditable(false);
		//Place the placeholder in a JScroll pane
		JScrollPane scroll = new JScrollPane(placeH);
		TitledBorder border = BorderFactory.createTitledBorder(blackline, "GamePlay");
		border.setTitleJustification(TitledBorder.CENTER);
		scroll.setBorder(border);
		
		
		//All gridbag constraint goes here
		
		/////////////Hand constraints/////////////////////// 
		GridBagConstraints handC = new GridBagConstraints();
		//Make the panel fill the display area horizontally
		handC.fill = GridBagConstraints.HORIZONTAL;
		handC.ipadx = 40;
		handC.weightx = 0.5; //Specifies how to distribute extra horizontal space
		handC.gridwidth = 3; //Set the panel to span over 3 cell by width
		handC.gridx = 0;
		handC.gridy = 2;
		
		/////////////////Scroll constraints//////////////////
		GridBagConstraints scrollC = new GridBagConstraints();
		scrollC.fill = GridBagConstraints.BOTH;
		scrollC.weighty= 0.5; ////Specifies how to distribute extra vertical space
		scrollC.gridheight = 2; //Set the scroll to span over 2 cell by height
		scrollC.gridwidth = 2; //Set the scroll to span over 2 cell by width
		scrollC.gridx = 1;
		scrollC.gridy = 0;
		
		
		//Add hand to the content pane
		table.add(hand, handC);
		
		//Add scroll to the content pane
		table.add(scroll, scrollC);
		
		//Set initial size for the panel within the JPanel hand
		if(control.isPanelEmpty(spade)){
			spade.setPreferredSize(new Dimension(125, 75));
		}
		if(control.isPanelEmpty(club)){
			club.setPreferredSize(new Dimension(125, 75));
		}
		if(control.isPanelEmpty(diamond)){
			diamond.setPreferredSize(new Dimension(125, 75));
		}
		if(control.isPanelEmpty(heart)){
			heart.setPreferredSize(new Dimension(125, 75));
		}
		
		//Set the window to maximized in the screen/monitor
		table.setExtendedState(JFrame.MAXIMIZED_BOTH);

		//Set the frame to be visible
		table.setVisible(true);
		
	}
	
	/**
	 * @return the spadeIC ImageIcon
	 */
	public ImageIcon getSpadeIC() {
		return spadeIC;
	}

	/**
	 * @return the clubIC ImageIcon
	 */
	public ImageIcon getClubIC() {
		return clubIC;
	}

	/**
	 * @return the diamondIC ImageIcon
	 */
	public ImageIcon getDiamondIC() {
		return diamondIC;
	}

	/**
	 * @return the heartIC ImageIcon
	 */
	public ImageIcon getHeartIC() {
		return heartIC;
	}

	/**
	 * @return the spade panel
	 */
	public JPanel getSpade() {
		return spade;
	}

	/**
	 * @return the club panel
	 */
	public JPanel getClub() {
		return club;
	}

	/**
	 * @return the diamond panel
	 */
	public JPanel getDiamond() {
		return diamond;
	}

	/**
	 * @return the heart panel
	 */
	public JPanel getHeart() {
		return heart;
	}

	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				SpadeView view = new SpadeView();
			}
		});
	}

}
