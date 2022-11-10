import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class STTurn extends JPanel implements ActionListener {
	
	static Color[] pClr = {Color.RED, Color.YELLOW, Color.GREEN, 
			Color.BLUE, Color.CYAN, Color.MAGENTA};

	
	
	JPanel score = new JPanel();
	static JPanel text = new JPanel();
	static JPanel[] plPanel = new JPanel[6];
	static JPanel cardsMainPanel = new JPanel();
	static JPanel buttonMainPanel = new JPanel();
	static JPanel displayCards = new JPanel();
	
	static JLabel one = new JLabel();
	static JLabel two = new JLabel();
	static JLabel npoint[] = new JLabel[6];
	static JLabel label1 = new JLabel();
	static JLabel label2 = new JLabel();
	public static JLabel image[] = new JLabel[6];
	
	static GridBagConstraints gb2 = new GridBagConstraints();
	
	static JButton contBtn = new JButton();
	static JButton confBtn = new JButton();
	static JButton stBtn = new JButton();
	static JButton voteBtn = new JButton();
	static JButton vote1Btn = new JButton();
	static JButton[] cardBtn = new JButton[6];
	
	static ImageIcon icon, newicon;
	
	
	// test
	dialogPU dialog = new dialogPU();
	// String stDesc;
	
	
	// new
	
	public static int tempCard;
	
	// -----------------------------------------------------------------------------------------
	public STTurn(){
	
		GameFlow.varTest();
		
		setLayout(new GridBagLayout());
		setBackground(Color.WHITE);
		
		
		// 1st Panel: Player Score -----------------------------------------------------------------------------------------
		score.setLayout(new GridBagLayout());
		score.setBackground(Color.WHITE);
		GridBagConstraints gb1 = new GridBagConstraints();
		
		for(int i = 0; i < 6; i++) {
			
			plPanel[i] = new JPanel();
			plPanel[i].setPreferredSize(new Dimension(50,50));
			plPanel[i].setBackground(pClr[i]);
			npoint[i] = new JLabel("test");
			plPanel[i].add(npoint[i]);
			
			gb1.insets = new Insets(0,10,0,10);
			
			score.add(plPanel[i], gb1);
		}
		
		gb1.gridx = 1;
		gb1.gridy = 0;
		add(score, gb1);
		
		
		
		// 2nd Panel: Display Text -----------------------------------------------------------------------------------------
		text.setLayout(new GridBagLayout());
		text.setBackground(Color.GRAY);
		text.setPreferredSize(new Dimension(700,400));
		
		gb2.insets = new Insets(55,0,55,0);
		
		one = new JLabel("Color (Username)");
		one.setFont(new Font("ARIAL", Font.PLAIN, 24));
		
		two = new JLabel("Storyteller's Turn");
		two.setFont(new Font("ARIAL", Font.PLAIN, 40));
		
		JLabel three = new JLabel("Press continue if ready");
		three.setFont(new Font("ARIAL", Font.PLAIN, 20));
		
		gb2.gridx = 0;
        gb2.gridy = 0;
        text.add(one, gb2);
        
        gb2.gridx = 0;
        gb2.gridy = 1;
        text.add(two, gb2);
        
        gb2.gridx = 0;
        gb2.gridy = 2;
        text.add(three, gb2);
        
        gb2.gridx = 1;
        gb2.gridy = 1;
        add(text, gb2);
        
        
        // 3rd Panel: Display Cards -----------------------------------------------------------------------------------------
        GridBagConstraints gb3 = new GridBagConstraints();
        
        cardsMainPanel.setLayout(new GridBagLayout());
        cardsMainPanel.setBackground(Color.WHITE);
        
        // Label
        label1 = new JLabel("Storyteller Turn");
        gb3.insets = new Insets(30,0,30,0);
        gb3.gridx = 0;
		gb3.gridy = 0;
		cardsMainPanel.add(label1, gb3);
        
		
		// Cards
		GridBagConstraints gb4 = new GridBagConstraints();
        displayCards.setLayout(new GridBagLayout());
        displayCards.setBackground(Color.WHITE);
 
		gb4.insets = new Insets(55,0,55,0);
		
		for(int i = 0; i < 6; i++) {
			
			icon = new ImageIcon("dixit_cards/1.png");
			
			image[i] = new JLabel();
			image[i].setIcon(icon);
			
			cardBtn[i] = new JButton();
			cardBtn[i].setPreferredSize(new Dimension(200,300));
			cardBtn[i].add(image[i]);
			cardBtn[i].addActionListener(this);
			
			gb4.insets = new Insets(0,10,0,10);
			displayCards.add(cardBtn[i], gb4);
			
		}
		
		gb3.insets = new Insets(20,0,20,0);
		
		gb3.gridx = 0;
        gb3.gridy = 1;
        cardsMainPanel.add(displayCards, gb3);
        
		// Add everything to the cardsMainPanel
		gb2.gridx = 1;
	    gb2.gridy = 1;
	    add(cardsMainPanel, gb2);
	        
	    cardsMainPanel.setVisible(false);
	    
        // 4th Panel: Label2 and Button -----------------------------------------------------------------------------------------
	    GridBagConstraints gb5 = new GridBagConstraints();
	    
	    buttonMainPanel.setLayout(new GridBagLayout());
	    buttonMainPanel.setBackground(Color.WHITE);
	     
	    // Pick a card Label2
	    label2 = new JLabel("Pick a card");
	    gb5.insets = new Insets(5,0,5,0);
	    gb5.gridx = 0;
	    gb5.gridy = 0;
	    buttonMainPanel.add(label2, gb5);
	    label2.setVisible(false);
	     
	    // Button
		contBtn = new JButton("contBtn");
		contBtn.setPreferredSize(new Dimension(200,50));
		contBtn.addActionListener(this);
		contBtn.setVisible(true);
		
		gb5.gridx = 0;
		gb5.gridy = 1;
		buttonMainPanel.add(contBtn, gb5);
		
		confBtn = new JButton("confBtn");
		confBtn.setPreferredSize(new Dimension(200,50));
		confBtn.addActionListener(this);
		confBtn.setVisible(false);
		
		gb5.gridx = 0;
		gb5.gridy = 2;
		buttonMainPanel.add(confBtn, gb5);
		
		stBtn = new JButton("stBtn");
		stBtn.setPreferredSize(new Dimension(200,50));
		stBtn.addActionListener(this);
		stBtn.setVisible(false);
		
		gb5.gridx = 0;
		gb5.gridy = 3;
		buttonMainPanel.add(stBtn, gb5);
		
		voteBtn = new JButton("voteBtn");
		voteBtn.setPreferredSize(new Dimension(200,50));
		voteBtn.addActionListener(this);
		voteBtn.setVisible(false);
		
		gb5.gridx = 0;
		gb5.gridy = 4;
		buttonMainPanel.add(voteBtn, gb5);
		
		vote1Btn = new JButton("vote1Btn");
		vote1Btn.setPreferredSize(new Dimension(200,50));
		vote1Btn.addActionListener(this);
		vote1Btn.setVisible(false);
		
		gb5.gridx = 0;
		gb5.gridy = 4;
		buttonMainPanel.add(vote1Btn, gb5);

		GridBagConstraints gbf = new GridBagConstraints();
		gbf.insets = new Insets(5,0,5,0);
		gbf.gridx = 1;
		gbf.gridy = 2;
		add(buttonMainPanel, gbf);
		
	}
	
	
	// Action Performed -----------------------------------------------------------------------------------------
	public void actionPerformed(ActionEvent btnClick) {
		
		
		// Button continue clicked -----------------------------------------------------------------------------------------
		if (btnClick.getSource() == contBtn) {
			
			if ((GameFlow.turn == GameFlow.n) && (GameFlow.st == GameFlow.n)) {
				contBtn.setVisible(false);
				confBtn.setVisible(false);
				stBtn.setVisible(true);
				voteBtn.setVisible(false);
			}
			else {
				contBtn.setVisible(false);
				confBtn.setVisible(true);
				stBtn.setVisible(false);
				voteBtn.setVisible(false);
			}
			
			GameFlow.pageChecker();
		}
		
		
		if (btnClick.getSource() == stBtn) {
			dialogPU dialog = new dialogPU();
			dialog.card_descPU();			
			
			contBtn.setVisible(true);
			confBtn.setVisible(false);
			stBtn.setVisible(false);
			voteBtn.setVisible(false);
			
			GameFlow.deckToHand();
			GameFlow.handToTable();
//			GameFlow.updateLooper();
			GameFlow.turnChecker(); // balikkan ke 0
			GameFlow.increaseTurn();
			GameFlow.pageChecker(); // move between pages (2nd page = +1 turn)
		}	
		
		if (btnClick.getSource() == confBtn) {
			
			contBtn.setVisible(true);
			confBtn.setVisible(false);
			stBtn.setVisible(false);
			voteBtn.setVisible(false);
			
			GameFlow.deckToHand();
			GameFlow.handToTable();
			GameFlow.turnChecker(); // reset turn
			
			if ((GameFlow.turn == GameFlow.n) && (GameFlow.st == GameFlow.n)) {
				GameFlow.increaseTurn();
//				GameFlow.varInc();
				hideVote();
				GameFlow.moveToTemp();
				GameFlow.shuffleTableCard();
				votingCards();
				contBtn.setVisible(false);
				confBtn.setVisible(false);
				stBtn.setVisible(false);
				voteBtn.setVisible(true);
			}
			else {
				GameFlow.increaseTurn();
				GameFlow.pageChecker(); // nav page 
				GameFlow.updateLooper();
			}
		}
		
		if (btnClick.getSource() == voteBtn) {
			GameFlow.pageChecker1();
			contBtn.setVisible(false);
			confBtn.setVisible(false);
			stBtn.setVisible(false);
			voteBtn.setVisible(false);
			vote1Btn.setVisible(true);
			
			// store counter for how many people voted
			
		}
		
		if (btnClick.getSource() == vote1Btn) {
			GameFlow.pageChecker1();
			GameFlow.increaseTurn();
			contBtn.setVisible(false);
			confBtn.setVisible(false);
			stBtn.setVisible(false);
			voteBtn.setVisible(true);
			vote1Btn.setVisible(false);
		}
		
		
		
		
		// turn increment lapas every turn
		// st mesti increment lapas the last player pick card
		
		
		
		// Card button clicked -----------------------------------------------------------------------------------------
		for (int i = 0 ; i < 6 ; i++) {
			Border emptyBorder = BorderFactory.createEmptyBorder();
			cardBtn[i].setBorder(emptyBorder);
		}
		
		for (int i = 0 ; i < 6 ; i++) {

			if (btnClick.getSource() == cardBtn[i]) {

				cardBtn[i].setBorder(BorderFactory.createCompoundBorder(
						BorderFactory.createLineBorder(Color.CYAN, 5),
						BorderFactory.createEmptyBorder(
								cardBtn[i].getBorder().getBorderInsets(cardBtn[i]).top,
								cardBtn[i].getBorder().getBorderInsets(cardBtn[i]).left,
								cardBtn[i].getBorder().getBorderInsets(cardBtn[i]).bottom,
								cardBtn[i].getBorder().getBorderInsets(cardBtn[i]).right
								)));
				
				tempCard = i;
			}
		}
		
		
		// Move player card to table card -----------------------------------------------------------------------------------------

		
	}
	
	
	// Displaying and hiding contents method-----------------------------------------------------------------------------------------
	public static void displayPage1() {
		text.setVisible(true);
		cardsMainPanel.setVisible(false);
		label1.setVisible(false);
		label2.setVisible(false);
	}
	
	public static void displayPage2() {
		text.setVisible(false);
		cardsMainPanel.setVisible(true);
		label1.setVisible(true);
		label2.setVisible(true);
	}
	
	// Display player hand for Panel 2-----------------------------------------------------------------------------------------
	public static void displayPlayerCards() {
		
		for (int i = 0; i < 6; i++) {
			icon = new ImageIcon(STTurn.class.getResource(GameFlow.playerHand[GameFlow.turn].get(i)));
			Image tempimage = icon.getImage(); // transform it 
			Image newimg = tempimage.getScaledInstance(200, 300,  java.awt.Image.SCALE_SMOOTH); // scale it smoothly  
			newicon = new ImageIcon(newimg); 
			image[i].setIcon(newicon);
			
		}
	}
	
	public static void hideVote() {
		for (int i = 0 ; i < 6; i++) {
			cardBtn[i].setVisible(false);
		}
	}
	
	public static void votingCards() {
		for (int i = 0; i < GameFlow.tableCard.size(); i++) {
			icon = new ImageIcon(STTurn.class.getResource(GameFlow.tempTableCard.get(i)));
			Image tempimage = icon.getImage(); // transform it 
			Image newimg = tempimage.getScaledInstance(200, 300,  java.awt.Image.SCALE_SMOOTH); // scale it smoothly  
			newicon = new ImageIcon(newimg); 
			image[i].setIcon(newicon);
			cardBtn[i].setVisible(true);
		}
	}
	
	// Set Label for Panel 1 -----------------------------------------------------------------------------------------
	public static void setLabel1() {
		one.setText(GameFlow.playerArrList.get(GameFlow.turn).getClrArr() + " (" + GameFlow.playerArrList.get(GameFlow.turn).getNameArr() + ")");
		two.setText("Storyteller's Turn");
	}
	
	public static void setLabel2() {
		one.setText(GameFlow.playerArrList.get(GameFlow.turn).getClrArr() + " (" + GameFlow.playerArrList.get(GameFlow.turn).getNameArr() + ")");
		two.setText("Pick a card");
	}
	
	public static void setLabel3() {
		one.setText(GameFlow.playerArrList.get(GameFlow.turn).getClrArr() + " (" + GameFlow.playerArrList.get(GameFlow.turn).getNameArr() + ")");
		two.setText("Vote a card");
	}
	
	public static void hidePlayer() {
		// Hide player
		for (int i = 0 ; i < 6 ; i++) {
			if (PlayerSelect1.status[i] == 0) {
				plPanel[i].setVisible(false);
				npoint[i].setText("0");
			}
		}
	}
	
	public static void setScore() {
		// update points
		for (int i = 0 ; i < GameFlow.totalPlayer; i++) {
			for (int j = 0 ; j < 6 ; j++) {
				if (GameFlow.playerArrList.get(i).getClr1Arr() == pClr[j]) {					
					npoint[j].setText(String.valueOf(GameFlow.playerArrList.get(i).getPoint()));
				}
			}
		}
	}
}
