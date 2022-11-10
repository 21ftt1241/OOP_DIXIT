import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class showCards extends JPanel {
	
	JPanel score = new JPanel();
	JPanel text1 = new JPanel();
	JPanel cardDisplay = new JPanel();
	JButton[] card = new JButton[6];
	JPanel text2 = new JPanel();
	JPanel confirm = new JPanel();
	
	JButton exitOpt = new JButton("X");
	JPanel user = new JPanel();
	
	JPanel[] plPanel = new JPanel[6];
	JPanel[] plVoting = new JPanel[6];
	Color[] pClr = {Color.RED, Color.YELLOW, Color.GREEN, 
			Color.BLUE, Color.CYAN, Color.MAGENTA};
	int[] point = {0, 0, 0, 0, 0, 0};
	
	public showCards() {
		
		setLayout(new GridBagLayout());
		setBackground(Color.WHITE);
		
		score.setLayout(new GridBagLayout());
		score.setBackground(Color.WHITE);
		GridBagConstraints gb1 = new GridBagConstraints();
		
		user.setLayout(new GridBagLayout());
		user.setBackground(Color.WHITE);
		GridBagConstraints gb11 = new GridBagConstraints();
		
		JPanel userClr = new JPanel();
		userClr.setBackground(pClr[0]);
		userClr.setPreferredSize(new Dimension(10,50));
		
		JLabel username = new JLabel("username");
		username.setFont(new Font("ARIAL", Font.PLAIN, 24));
		
		JLabel turn = new JLabel("red turn");
		turn.setFont(new Font("ARIAL", Font.PLAIN, 14));
		
		gb11.gridheight = 2;
		gb11.gridx = 0;
		gb11.gridy = 0;
		user.add(userClr, gb11);
		
		gb11.anchor = GridBagConstraints.WEST;
		gb11.insets = new Insets(0,10,20,0);
		gb11.gridx = 1;
		gb11.gridy = 0;
		user.add(username, gb11);
		
		gb11.anchor = GridBagConstraints.WEST;
		gb11.insets = new Insets(20,10,0,0);
		gb11.gridx = 1;
		gb11.gridy = 1;
		user.add(turn, gb11);
		
		gb11.gridx = 0;
		gb11.gridy = 0;
		add(user, gb1);
		
		for(int i = 0; i < 6; i++) {
			
			plPanel[i] = new JPanel();
			plPanel[i].setPreferredSize(new Dimension(50,50));
			plPanel[i].setBackground(pClr[i]);
			
			JLabel npoint = new JLabel(String.valueOf(point[i]));
			
			plPanel[i].add(npoint, gb1);
			
			gb1.insets = new Insets(0,10,0,10);
			
			score.add(plPanel[i], gb1);
			
		}
		
		gb1.insets = new Insets(20,0,20,0);
		
		gb1.gridx = 1;
		gb1.gridy = 0;
		add(score, gb1);
		
		gb1.gridx = 2;
		gb1.gridy = 0;
		add(exitOpt, gb1);
		
		
		
		
		JLabel stTurn = new JLabel("Storyteller turn");
		
		text1.setLayout(new GridBagLayout());
		text1.setBackground(Color.WHITE);
		GridBagConstraints gb2 = new GridBagConstraints();
		
		gb2.gridx = 1;
		gb2.gridy = 0;
		text1.add(stTurn, gb2);
		
		gb2.insets = new Insets(30,0,30,0);
		
		gb2.gridx = 1;
		gb2.gridy = 1;
		add(text1, gb2);
		
		cardDisplay.setLayout(new GridBagLayout());
		cardDisplay.setBackground(Color.WHITE);
		GridBagConstraints gb3 = new GridBagConstraints();
		
		int x = 0;
		int y = 0;
		
		for(int i = 0; i < 6; i++) {
			
			plVoting[i] = new JPanel();
			plVoting[i].setPreferredSize(new Dimension(150,50));
			plVoting[i].setBackground(pClr[i]);
			
			card[i] = new JButton();
			card[i].setPreferredSize(new Dimension(160,300));
//			card[i].setBackground(image); 
			
			gb3.insets = new Insets(10,10,10,10);
			
			cardDisplay.add(card[i], gb3);
			
		}
		
		gb3.insets = new Insets(20,0,20,0);
		
		gb3.gridx = 1;
		gb3.gridy = 2;
		add(cardDisplay, gb3);
		
		text2.setLayout(new GridBagLayout());
		text2.setBackground(Color.WHITE);
		GridBagConstraints gb4 = new GridBagConstraints();
		
		JLabel pick = new JLabel("Pick a Card");
		
		gb4.gridx = 1;
		gb4.gridy = 0;
		text2.add(pick, gb4);
		
		gb4.insets = new Insets(20,0,20,0);
		
		gb4.gridx = 1;
		gb4.gridy = 3;
		add(text2, gb4);
		
		confirm.setLayout(new GridBagLayout());
		confirm.setBackground(Color.WHITE);
		GridBagConstraints gb5 = new GridBagConstraints();
		
		JButton conf = new JButton("confirm");
		
		gb5.gridx = 1;
		gb5.gridy = 0;
		confirm.add(conf, gb5);
		
		gb5.gridx = 1;
		gb5.gridy = 4;
		add(confirm, gb5);
		
	}
		
}
