import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class STTurn extends JPanel implements ActionListener {
	
	JPanel score = new JPanel();
	static JPanel text = new JPanel();
	
	JPanel contLayout = new JPanel();
	
	static JPanel[] plPanel = new JPanel[6];
	static Color[] pClr = {Color.RED, Color.YELLOW, Color.GREEN, 
			Color.BLUE, Color.CYAN, Color.MAGENTA};
	
//	int[] point = {0, 0, 0, 0, 0, 0};
	
	static JLabel one = new JLabel();
	
	static GridBagConstraints gb2 = new GridBagConstraints();
	
	// display points
	static JLabel npoint[] = new JLabel[6];
	
	// cards
	static JPanel cardsMainPanel = new JPanel();
	static JPanel buttonMainPanel = new JPanel();
	static JButton cont1 = new JButton();
	static JLabel label1 = new JLabel();
	static JLabel label2 = new JLabel();
	
	
//	public static int page;
	public static JLabel image[] = new JLabel[6];
	
	static JPanel displayCards = new JPanel();
	static JButton[] cardBtn = new JButton[6];
	
	static int j = 1;
	
	
	
	static ImageIcon icon;
	
	public STTurn(){
//		page = 1;
		GameFlow.grabber();
		GameFlow.setTurn();
		
		GameFlow.setPage();
		
		GameFlow.setTurn();
		
		setLayout(new GridBagLayout());
		setBackground(Color.WHITE);
		
		
		// 1st Panel: Player Score
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
		
		
		
		// 2nd Panel: Display Text
		text.setLayout(new GridBagLayout());
		text.setBackground(Color.GRAY);
		text.setPreferredSize(new Dimension(700,400));
		
		gb2.insets = new Insets(55,0,55,0);
		
		one = new JLabel("Color (Username)");
		one.setFont(new Font("ARIAL", Font.PLAIN, 24));
		
		JLabel two = new JLabel("Storyteller's Turn");
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
        
        
        // 3rd Panel: Display Cards
        GridBagConstraints gb3 = new GridBagConstraints();
        
        cardsMainPanel.setLayout(new GridBagLayout());
        cardsMainPanel.setBackground(Color.WHITE);
        
        // Label
        label1 = new JLabel("Storyteller turn");
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
			
			icon = new ImageIcon("resources/images/dixit_cards/1.png");
			icon = new ImageIcon("dixit_cards/1.png");
			image[i] = new JLabel();
			image[i].setIcon(icon);
//	
			cardBtn[i] = new JButton();
			cardBtn[i].setPreferredSize(new Dimension(160,300));
			cardBtn[i].add(image[i]);
			gb4.insets = new Insets(0,10,0,10);
			displayCards.add(cardBtn[i], gb4);
			
		}
		//
		gb3.insets = new Insets(20,0,20,0);
		
		gb3.gridx = 0;
        gb3.gridy = 1;
        cardsMainPanel.add(displayCards, gb3);
        
		// add everything to the cardsMainPanel
		gb2.gridx = 1;
	    gb2.gridy = 1;
	    add(cardsMainPanel, gb2);
	        
	    cardsMainPanel.setVisible(false);
        
	    
	    
        // 4th Panel: Label2 and Button
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
//	    GridBagConstraints gb6 = new GridBagConstraints();
//        contLayout.setLayout(new GridBagLayout());
        
		cont1 = new JButton("Continue");
		cont1.setPreferredSize(new Dimension(200,50));
		cont1.addActionListener(this);
		
		gb5.gridx = 0;
		gb5.gridy = 1;
		buttonMainPanel.add(cont1, gb5);
		
		GridBagConstraints gbf = new GridBagConstraints();
		gbf.insets = new Insets(5,0,5,0);
		gbf.gridx = 1;
		gbf.gridy = 2;
		add(buttonMainPanel, gbf);
		
	}
	 
	public void actionPerformed(ActionEvent btnClick) {
		if (btnClick.getSource() == cont1) {			
			GameFlow.pageChecker();
//			GameFlow.grabber();
		}
	}
	
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
	
	public static void displayPlayerCards() {
		
		
		for (int i = 0; i < 6; i++) {
			
//			icon = new ImageIcon(getClass().getResource(GameFlow.playerHand[0].get(i)));
			String link = GameFlow.playerHand[1].get(i);
			System.out.println(link);
//			icon = new ImageIcon("dixit_cards/" + (j) + ".png");
			icon = new ImageIcon(STTurn.class.getResource(link));
//			String link = GameFlow.playerHand[1].get(i);
//			System.out.println(link);
			icon = new ImageIcon(GameFlow.playerHand[0].get(i));
//			icon = new ImageIcon("dixit_cards/" + (i+1) + ".png");
			
//			image[i] = new JLabel();
			image[i].setIcon(icon);
//			cardBtn[i].add(image);
			j++;
		}
		
	}
	
	
	
	public static void setLabel() {

		one.setText(GameFlow.playerArrList.get(GameFlow.turn).getClrArr() + " (" + GameFlow.playerArrList.get(GameFlow.turn).getNameArr() + ")");
		
		for (int i = 0 ; i < GameFlow.playerArrList.size(); i++) {
			
			for (int j = 0 ; j < 6 ; j++) {
				if (GameFlow.playerArrList.get(i).getClr1Arr() == pClr[j]) {					
					npoint[j].setText(String.valueOf(GameFlow.playerArrList.get(i).getPoint()));
				}
			}
		}
		
		for (int i = 0 ; i < 6 ; i++) {
			if (PlayerSelect1.status[i] == 0) {
				plPanel[i].setVisible(false);
				npoint[i].setText("0");
			}
		}
	}
}
