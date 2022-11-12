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
	static JPanel user = new JPanel();
	static JPanel text = new JPanel();
	static JPanel[] plPanel = new JPanel[6];
	static JPanel cardsMainPanel = new JPanel();
	static JPanel buttonMainPanel = new JPanel();
	static JPanel displayCards = new JPanel();

	static JLabel turn = new JLabel();
	static JLabel username = new JLabel();
	static JPanel userClr = new JPanel();


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
	static JButton sVoteBtn = new JButton();
	static JButton vote1Btn = new JButton();
	static JButton vote2Btn = new JButton();
	static JButton nextBtn = new JButton();
	static JButton[] cardBtn = new JButton[6];
	static JButton settBtn = new JButton();

	static ImageIcon icon, newicon;

	static JPanel[] plVoting = new JPanel[6];
	static JPanel[] sixBox = new JPanel[6];
	static JPanel[][] voters = new JPanel[6][5];
	static JPanel votingPanel = new JPanel();
	static JPanel displayVoters = new JPanel();
	static JLabel[] displayST = new JLabel[6];

	// test
	dialogPU dialog = new dialogPU();


	public static int tempCard;

	// -----------------------------------------------------------------------------------------
	public STTurn(){

		GameFlow.setVar();

		setLayout(new GridBagLayout());
		setBackground(Color.decode("#F9DBA5"));


		// 1st Panel (top): Player Score ----------------
		score.setLayout(new GridBagLayout());
		score.setBackground(Color.decode("#F9DBA5"));
		GridBagConstraints gb1 = new GridBagConstraints();

		// added for player turn info (top left) 
		user.setLayout(new GridBagLayout());
		user.setBackground(Color.decode("#F9DBA5"));
		GridBagConstraints gb11 = new GridBagConstraints();
		user.setVisible(false);

		userClr = new JPanel();
		userClr.setBackground(pClr[0]);
		userClr.setPreferredSize(new Dimension(10,50));

		username = new JLabel("username");
		username.setFont(new Font("ARIAL", Font.BOLD, 24));

		turn = new JLabel("red turn");
		turn.setFont(new Font("ARIAL", Font.ITALIC, 14));

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

		gb1.gridx = 0;
		gb1.gridy = 0;
		add(user, gb1);


		// player score
		for(int i = 0; i < 6; i++) {

			plPanel[i] = new JPanel();
			plPanel[i].setPreferredSize(new Dimension(50,50));
			plPanel[i].setBackground(pClr[i]);
			npoint[i] = new JLabel("test");
			npoint[i].setFont(new Font("ARIAL", Font.BOLD, 24));
			plPanel[i].add(npoint[i]);
			gb1.gridx = i + 1;

			gb1.insets = new Insets(0,10,0,10);

			score.add(plPanel[i], gb1);
		}

		gb1.gridx = 1;
		gb1.gridy = 0;
		add(score, gb1);


		// 2nd Panel: Display Text ----------------
		text.setLayout(new GridBagLayout());
		text.setBackground(Color.decode("#CA9064"));
		text.setPreferredSize(new Dimension(700,400));

		gb2.insets = new Insets(20,0,20,0);

		one = new JLabel("Color (Username)");
		one.setFont(new Font("ARIAL", Font.BOLD, 24));

		two = new JLabel("Storyteller's Turn");
		two.setFont(new Font("ARIAL", Font.BOLD, 50));

		JLabel three = new JLabel("Press continue if ready");
		three.setFont(new Font("ARIAL", Font.BOLD, 20));

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


		// 3rd Panel: Display Cards ----------------
		GridBagConstraints gb3 = new GridBagConstraints();

		cardsMainPanel.setLayout(new GridBagLayout());
		cardsMainPanel.setBackground(Color.decode("#CA9064"));

		// label
		label1 = new JLabel("Storyteller Turn");
		label1.setFont(new Font("ARIAL", Font.BOLD, 24));
		gb3.insets = new Insets(10,0,10,0);
		gb3.gridx = 0;
		gb3.gridy = 1;
		cardsMainPanel.add(label1, gb3);

		// card owner (voting results)
		votingPanel.setLayout(new GridBagLayout());
		votingPanel.setBackground(Color.decode("#CA9064"));
		GridBagConstraints gbz = new GridBagConstraints();
		votingPanel.setVisible(false);

		for(int i = 0; i < 6; i++) {

			plVoting[i] = new JPanel();
			plVoting[i].setPreferredSize(new Dimension(200,20));
			plVoting[i].setBackground(pClr[i]);

			displayST[i] = new JLabel("STORYTELLER");
			displayST[i].setFont(new Font("Arial", Font.BOLD, 16));
			plVoting[i].add(displayST[i], gbz);

			gbz.anchor = GridBagConstraints.SOUTH;
			gbz.insets = new Insets(0,10,0,10);
			votingPanel.add(plVoting[i], gbz);
		}

		gb3.gridx = 0;
		gb3.gridy = 2;
		cardsMainPanel.add(votingPanel, gb3);

		// display cards
		GridBagConstraints gb4 = new GridBagConstraints();
		displayCards.setLayout(new GridBagLayout());
		displayCards.setBackground(Color.decode("#CA9064"));

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

		gb3.gridx = 0;
		gb3.gridy = 3;
		cardsMainPanel.add(displayCards, gb3);

		// card voters (voting results)
		displayVoters.setLayout(new GridBagLayout());
		displayVoters.setBackground(Color.decode("#CA9064"));
		GridBagConstraints gbv = new GridBagConstraints();
		displayVoters.setVisible(false);

		for(int i = 0; i < 6; i++) {


			sixBox[i] = new JPanel();

			sixBox[i].setPreferredSize(new Dimension(200,18));
			sixBox[i].setBackground(Color.decode("#CA9064"));

			gbv.insets = new Insets(5,10,5,10);
			displayVoters.add(sixBox[i], gbv);
		}

		for(int j = 0; j < 6; j++) {
			for (int k = 0 ; k < 5 ; k++) {
				voters[j][k] = new JPanel();
				voters[j][k].setPreferredSize(new Dimension(35,18));
				voters[j][k].setBackground(Color.WHITE);

				gbv.insets = new Insets(0,10,0,10);
				sixBox[j].add(voters[j][k], gbv);
			}
		}

		gb3.gridx = 0;
		gb3.gridy = 4;
		cardsMainPanel.add(displayVoters, gb3);

		// Add everything to the cardsMainPanel
		gb2.gridx = 1;
		gb2.gridy = 1;
		add(cardsMainPanel, gb2);

		cardsMainPanel.setVisible(false);


		// 4th Panel: Label2 and Button ----------------
		GridBagConstraints gb5 = new GridBagConstraints();

		buttonMainPanel.setLayout(new GridBagLayout());
		buttonMainPanel.setBackground(Color.decode("#EBD6B1"));

		// Pick a card Label2
		label2 = new JLabel("Pick a card");
		label2.setFont(new Font("Arial", Font.BOLD, 20));
		label2.setBackground(Color.decode("#CA9064"));
		gb5.insets = new Insets(5,0,5,0);
		gb5.gridx = 0;
		gb5.gridy = 0;
		buttonMainPanel.add(label2, gb5);
		label2.setVisible(false);

		// Button
		contBtn = new JButton("Continue");
		contBtn.setBackground(Color.decode("#F3C94E"));
		contBtn.setForeground(Color.decode("#000000"));
		contBtn.setFont(new Font("Arial", Font.BOLD, 24));
		contBtn.setPreferredSize(new Dimension(200,100));
		contBtn.addActionListener(this);
		contBtn.setVisible(true);

		gb5.gridx = 0;
		gb5.gridy = 1;
		buttonMainPanel.add(contBtn, gb5);

		settBtn = new JButton("X");
		settBtn.setBackground(Color.decode("#F3C94E"));
		settBtn.setForeground(Color.decode("#000000"));
		settBtn.setFont(new Font("Arial", Font.BOLD, 24));
		settBtn.addActionListener(this);
		gb5.anchor = GridBagConstraints.NORTHEAST;	
		gb5.gridx = 2;
		gb5.gridy = 0;
		add(settBtn, gb5);

		confBtn = new JButton("Confirm");
		confBtn.setBackground(Color.decode("#F3C94E"));
		confBtn.setForeground(Color.decode("#000000"));
		confBtn.setFont(new Font("Arial", Font.BOLD, 24));
		confBtn.setPreferredSize(new Dimension(200,100));
		confBtn.addActionListener(this);
		confBtn.setVisible(false);

		gb5.gridx = 0;
		gb5.gridy = 2;
		buttonMainPanel.add(confBtn, gb5);

		stBtn = new JButton("Confirm");
		stBtn.setBackground(Color.decode("#F3C94E"));
		stBtn.setForeground(Color.decode("#000000"));
		stBtn.setFont(new Font("Arial", Font.BOLD, 24));
		stBtn.setPreferredSize(new Dimension(200,100));
		stBtn.addActionListener(this);
		stBtn.setVisible(false);

		gb5.gridx = 0;
		gb5.gridy = 3;
		buttonMainPanel.add(stBtn, gb5);

		sVoteBtn = new JButton("Start Voting");
		sVoteBtn.setBackground(Color.decode("#F3C94E"));
		sVoteBtn.setForeground(Color.decode("#000000"));
		sVoteBtn.setFont(new Font("Arial", Font.BOLD, 24));
		sVoteBtn.setPreferredSize(new Dimension(200,50));
		sVoteBtn.addActionListener(this);
		sVoteBtn.setVisible(false);

		gb5.gridx = 0;
		gb5.gridy = 4;
		buttonMainPanel.add(sVoteBtn, gb5);

		vote1Btn = new JButton("Continue");
		vote1Btn.setBackground(Color.decode("#F3C94E"));
		vote1Btn.setForeground(Color.decode("#000000"));
		vote1Btn.setFont(new Font("Arial", Font.BOLD, 24));
		vote1Btn.setPreferredSize(new Dimension(200,50));
		vote1Btn.addActionListener(this);
		vote1Btn.setVisible(false);

		gb5.gridx = 0;
		gb5.gridy = 4;
		buttonMainPanel.add(vote1Btn, gb5);

		vote2Btn = new JButton("Confirm");
		vote2Btn.setBackground(Color.decode("#F3C94E"));
		vote2Btn.setForeground(Color.decode("#000000"));
		vote2Btn.setFont(new Font("Arial", Font.BOLD, 24));
		vote2Btn.setPreferredSize(new Dimension(200,50));
		vote2Btn.addActionListener(this);
		vote2Btn.setVisible(false);

		gb5.gridx = 0;
		gb5.gridy = 4;
		buttonMainPanel.add(vote2Btn, gb5);

		nextBtn = new JButton("Next Round");
		nextBtn.setBackground(Color.decode("#F3C94E"));
		nextBtn.setForeground(Color.decode("#000000"));
		nextBtn.setFont(new Font("Arial", Font.BOLD, 24));
		nextBtn.setPreferredSize(new Dimension(200,50));
		nextBtn.addActionListener(this);
		nextBtn.setVisible(false);

		gb5.gridx = 0;
		gb5.gridy = 4;
		buttonMainPanel.add(nextBtn, gb5);

		GridBagConstraints gbf = new GridBagConstraints();
		gbf.insets = new Insets(5,0,5,0);
		gbf.gridx = 1;
		gbf.gridy = 2;
		add(buttonMainPanel, gbf);
	}


	// actionPerformed ----------------
	public void actionPerformed(ActionEvent btnClick) {
		MainMenu.playClick2();

		// setting btn event
		if (btnClick.getSource() == settBtn){
			dialog.settings();
		}

		// continue btn event
		if (btnClick.getSource() == contBtn) {

			// if statement to for logic checking
			if ((GameFlow.turn == GameFlow.n) && (GameFlow.st == GameFlow.n)) {
				contBtn.setVisible(false);
				confBtn.setVisible(false);
				stBtn.setVisible(true);
				sVoteBtn.setVisible(false);
				vote1Btn.setVisible(false);
				vote2Btn.setVisible(false);
				nextBtn.setVisible(false);
				stBtn.setEnabled(false);
				updateLabel1();
			}
			else {
				contBtn.setVisible(false);
				confBtn.setVisible(true);
				stBtn.setVisible(false);
				sVoteBtn.setVisible(false);
				vote1Btn.setVisible(false);
				vote2Btn.setVisible(false);
				nextBtn.setVisible(false);
				confBtn.setEnabled(false);
			}


			confBtn.setEnabled(false);
			GameFlow.pageChecker();
		}

		// storyTeller btn event
		if (btnClick.getSource() == stBtn) {

			dialogPU dialog = new dialogPU();
			dialog.card_descPU();			

			contBtn.setVisible(true);
			confBtn.setVisible(false);
			stBtn.setVisible(false);
			sVoteBtn.setVisible(false);
			vote1Btn.setVisible(false);
			vote2Btn.setVisible(false);
			nextBtn.setVisible(false);

			GameFlow.deckToHand();
			GameFlow.handToTable();
			GameFlow.turnChecker();
			GameFlow.pageChecker();
		}	


		// confirm btn event
		if (btnClick.getSource() == confBtn) {

			contBtn.setVisible(true);
			confBtn.setVisible(false);
			stBtn.setVisible(false);
			sVoteBtn.setVisible(false);
			vote1Btn.setVisible(false);
			vote2Btn.setVisible(false);
			nextBtn.setVisible(false);

			GameFlow.deckToHand();
			GameFlow.handToTable();
			GameFlow.turnChecker();

			if ((GameFlow.turn == GameFlow.n) && (GameFlow.st == GameFlow.n)) {

				label2.setVisible(false);
				GameFlow.turnChecker();
				disablePlayerInfo();
				updatePlayerInfo();
				hideVote();
				GameFlow.moveToTemp();
				GameFlow.shuffleTableCard();
				votingCards();
				contBtn.setVisible(false);
				confBtn.setVisible(false);
				stBtn.setVisible(false);
				sVoteBtn.setVisible(true);
				vote1Btn.setVisible(false);
				vote2Btn.setVisible(false);
				nextBtn.setVisible(false);
			}
			else {
				GameFlow.pageChecker();				
			}

		}

		// start vote btn event
		if (btnClick.getSource() == sVoteBtn) {

			GameFlow.pageChecker1();
			GameFlow.stCard();

			for (int i = 0 ; i < GameFlow.tableCard.size(); i++) {
				cardBtn[i].setEnabled(true);
			}

			contBtn.setVisible(false);
			confBtn.setVisible(false);
			stBtn.setVisible(false);
			sVoteBtn.setVisible(false);
			vote1Btn.setVisible(true);
			vote2Btn.setVisible(false);
			nextBtn.setVisible(false);
		}


		// continue vote btn event
		if (btnClick.getSource() == vote1Btn) {

			label2.setVisible(true);
			GameFlow.pageChecker1();
			contBtn.setVisible(false);
			confBtn.setVisible(false);
			stBtn.setVisible(false);
			sVoteBtn.setVisible(false);
			vote1Btn.setVisible(false);
			vote2Btn.setVisible(true);
			nextBtn.setVisible(false);
			vote2Btn.setEnabled(false);

			for (int i = 0 ; i < GameFlow.totalPlayer ; i++) {
				for (int j = 0 ; j < GameFlow.totalPlayer ; j++) {
					if (GameFlow.playerArrList.get(GameFlow.turn).getPC() == GameFlow.tempTableCard.get(j)) {
						cardBtn[j].setVisible(false);
					}
					else {
						cardBtn[j].setVisible(true);
					}
				}
			}
		}


		// confirm vote btn event
		if (btnClick.getSource() == vote2Btn) {

			for (int i = 0 ; i < GameFlow.totalPlayer ; i++) {
				cardBtn[i].setVisible(true);
			}

			GameFlow.storeIntoVC();
			GameFlow.turnChecker();
			updatePlayerInfo();

			if (GameFlow.turn == GameFlow.n && GameFlow.st == GameFlow.n) {
				for (int i = 0 ; i < GameFlow.totalPlayer ; i++) {
					cardBtn[i].setEnabled(false);
				}

				label2.setVisible(false);
				GameFlow.cardChecker();
				disablePlayerInfo();
				GameFlow.pointCalc();
				updateScore();
				hideST();
				GameFlow.displayResults();
				contBtn.setVisible(false);
				confBtn.setVisible(false);
				stBtn.setVisible(false);
				sVoteBtn.setVisible(false);
				vote1Btn.setVisible(false);
				vote2Btn.setVisible(false);
				nextBtn.setVisible(true);
				setScore();
			}
			else {
				contBtn.setVisible(false);
				confBtn.setVisible(false);
				stBtn.setVisible(false);
				sVoteBtn.setVisible(false);
				vote1Btn.setVisible(true);
				vote2Btn.setVisible(false);
				nextBtn.setVisible(false);
				GameFlow.pageChecker1();
			}
		}



		// next round btn event
		if (btnClick.getSource() == nextBtn) {	

			for (int i = 0 ; i < GameFlow.totalPlayer ; i++) {
				cardBtn[i].setEnabled(true);
			}

			label2.setVisible(true);

			if (GameFlow.st+1 == GameFlow.totalPlayer) {
				GameFlow.setVar();
				GameFlow.declareST();
				GameFlow.updateTurn();
			}
			else {
				GameFlow.varInc();
				GameFlow.increaseST();
				GameFlow.updateTurn();
			}

			displayAllCard();
			displayPlayerCards();
			setLabel1();
			displayPage1();
			GameFlow.removeTableCard();
			GameFlow.setPage();
			contBtn.setVisible(true);
			confBtn.setVisible(false);
			stBtn.setVisible(false);
			sVoteBtn.setVisible(false);
			vote1Btn.setVisible(false);
			vote2Btn.setVisible(false);
			nextBtn.setVisible(false);
			hidePLVoting();
			hideVoter();
			hideST();
			GameFlow.pointChecker();
		}


		// card btn event
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

				if (tempCard >= 0 && tempCard <6) {
					stBtn.setEnabled(true);
					confBtn.setEnabled(true);
					vote2Btn.setEnabled(true);
				}
			}
		}
	}

	// update the score display ----------------
	public static void updateScore() {
		for (int i = 0 ; i < GameFlow.totalPlayer ; i++) {
			npoint[i].setText(Integer.toString(GameFlow.playerArrList.get(i).getPoint()));
		}
	}


	// Displaying and hiding contents method ----------------
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

	// display player hand ----------------
	public static void displayPlayerCards() {
		for (int i = 0; i < 6; i++) {
			icon = new ImageIcon(STTurn.class.getResource(GameFlow.playerHand[GameFlow.turn].get(i)));
			Image tempimage = icon.getImage(); // transform it 
			Image newimg = tempimage.getScaledInstance(200, 300,  java.awt.Image.SCALE_SMOOTH); // scale it smoothly  
			newicon = new ImageIcon(newimg); 
			image[i].setIcon(newicon);
		}
	}

	// hide cards ----------------
	public static void hideVote() {
		for (int i = 0 ; i < 6; i++) {
			cardBtn[i].setVisible(false);
		}
	}

	// display voting cards ----------------
	public static void votingCards() {
		for (int i = 0; i < GameFlow.tableCard.size(); i++) {
			icon = new ImageIcon(STTurn.class.getResource(GameFlow.tempTableCard.get(i)));
			Image tempimage = icon.getImage(); // transform it 
			Image newimg = tempimage.getScaledInstance(200, 300,  java.awt.Image.SCALE_SMOOTH); // scale it smoothly  
			newicon = new ImageIcon(newimg); 
			image[i].setIcon(newicon);
			cardBtn[i].setVisible(true);
			cardBtn[i].setEnabled(false);
		}
	}

	// displaying all cards ----------------
	public static void displayAllCard() {
		for (int i = 0 ; i < 6; i++) {
			cardBtn[i].setVisible(true);
		}
	}

	// setting and updating label ----------------
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

	public static void updateLabel1() {
		label1.setText("StoryTeller Turn");
	}


	// hide player score (if not joining)
	public static void hidePlayer() {

		for (int i = 0 ; i < 6 ; i++) {
			plPanel[i].setVisible(true);
		}

		for (int i = 0 ; i < 6 ; i++) {
			if (PlayerSelect1.status[i] == 0) {
				plPanel[i].setVisible(false);
				npoint[i].setText("0");
			}
		}
	}

	// display voting results logics ----------------
	// display card owner
	public static void displayPLVoting() {

		for (int i = 0 ; i < 6 ; i++) {
			plVoting[i].setVisible(false);
		}

		for (int i = 0 ; i < GameFlow.totalPlayer ; i++) {
			plVoting[i].setVisible(true);
		}

		votingPanel.setVisible(true);
	}

	// hide card owner
	public static void hidePLVoting() {
		votingPanel.setVisible(false);
	}

	// hide storyTeller label
	public static void hideST() {

		for (int i = 0 ; i < 6 ; i++) {
			displayST[i].setVisible(false);
		}
	}

	// display card voter
	public static void displayVoter() {

		for (int i = 0 ; i < 6 ; i++) {
			sixBox[i].setVisible(false);
		}
		for (int i = 0 ; i < GameFlow.totalPlayer ; i++) {
			sixBox[i].setVisible(true);
		}

		displayVoters.setVisible(true);
	}


	// hide card voters
	public static void hideVoter() {
		displayVoters.setVisible(false);
	}

	// reset the card voters
	public static void hideVoters() {

		for (int i = 0 ; i < 6 ; i++) {
			for (int j = 0 ; j < 5 ; j++) {
				voters[i][j].setBackground(Color.decode("#CA9064"));
			}
		}
	}

	
	// update top panel ----------------
	// update score
	public static void setScore() {
		// update 
		for (int i = 0 ; i < GameFlow.totalPlayer; i++) {
			for (int j = 0 ; j < 6 ; j++) {
				if (GameFlow.playerArrList.get(i).getClr1Arr() == pClr[j]) {
					npoint[j].setText(String.valueOf(GameFlow.playerArrList.get(i).getPoint()));
				}
			}
		}
	}

	// display player info
	public static void enablePlayerInfo() {
		user.setVisible(true);
	}
	
	// hide player info
	public static void disablePlayerInfo() {
		user.setVisible(false);
	}
	
	// update player info
	public static void updatePlayerInfo() {
		String clr = GameFlow.playerArrList.get(GameFlow.turn).getClrArr();
		turn.setText(clr + " turn");
		userClr.setBackground(GameFlow.playerArrList.get(GameFlow.turn).getClr1Arr());
		username.setText(GameFlow.playerArrList.get(GameFlow.turn).getNameArr());
	}
}
