import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerSelect1 extends JPanel implements ActionListener{

	dialogPU dialog = new dialogPU();

	JLabel l1;

	JButton backBtn, startBtn, btnSettings;
	JButton [] pb = new JButton[6];

	public static JTextField [] ptf = new JTextField[6];

	public static int [] status = new int[6];

	String [][] p = {
			{"Player 1", "RED"},
			{"Player 2", "YELLOW"},
			{"Player 3", "GREEN"},
			{"Player 4", "BLUE"},
			{"Player 5", "CYAN"},
			{"Player 6", "MAGENTA"}
	};

	public static Color [] btnColor = {Color.RED,Color.YELLOW,Color.GREEN,
			Color.BLUE,Color.CYAN,Color.MAGENTA};
	public static Color color1;

	public static int totalPlayer, point;
	public static String name, color;


	// -----------------------------------------------------------------------------------------
	public PlayerSelect1() {

		// Set layout ----------------
		setLayout(new GridBagLayout());
		setBackground(Color.decode("#EBD6B1"));

		GridBagConstraints container = new GridBagConstraints();


		// create back btn ----------------
		backBtn = new JButton("<");
		backBtn.setBackground(Color.decode("#F3C94E"));
		backBtn.setForeground(Color.decode("#000000"));
		backBtn.setFont(new Font("Arial", Font.BOLD, 24));
		backBtn.addActionListener(this);		

		container.anchor = GridBagConstraints.NORTHWEST;
		container.insets = new Insets(5, 5, 5, 5);

		add(backBtn, container);	


		// create settings btn ----------------
		btnSettings = new JButton("X");
		btnSettings.setBackground(Color.decode("#F3C94E"));
		btnSettings.setForeground(Color.decode("#000000"));
		btnSettings.setFont(new Font("Arial", Font.BOLD, 24));
		btnSettings.addActionListener(this);
		container.anchor = GridBagConstraints.NORTHEAST;	
		container.gridx = 2;
		add(btnSettings, container);


		// modify container ----------------
		container.insets = new Insets(5, 5, 5, 5);
		container.weightx = 0.5;
		container.weighty = 0.5;
		container.anchor = GridBagConstraints.CENTER;		

		l1 = new JLabel("Choose your Color");
		l1.setFont(new Font("Arial", Font.BOLD, 32));

		container.gridx = 1;
		container.gridy = 0;
		add(l1, container);


		// create player buttons ----------------
		int x = 0;
		int y = 1;

		for (int i = 0 ; i < 6; i++) {
			pb[i] = new JButton();
			pb[i].setPreferredSize(new Dimension(50, 50));
			pb[i].setBackground(btnColor[i]);
			pb[i].addActionListener(this);

			container.gridx = x;
			container.gridy = y;
			add(pb[i], container);

			x = x + 1;

			if (x == 3) {
				x = 0;
				y = 3;
			}
		}


		// create player name textField ----------------
		// 
		x = 0;
		y = 2;

		for (int j = 0 ; j < 6; j++) {
			ptf[j] = new JTextField();
			ptf[j].setBackground(Color.decode("#CA9064"));
			ptf[j].setPreferredSize(new Dimension(200, 40));
			ptf[j].setFont(new Font("Arial", Font.PLAIN, 24));
			ptf[j].setDocument(new JTextFieldLimit(10));
			ptf[j].setEnabled(false);

			container.gridx = x;
			container.gridy = y;
			add(ptf[j], container);

			x = x + 1;
			if (x == 3) {
				x = 0;
				y = 4;
			}
		}


		// create start game button ---------------
		startBtn = new JButton("Start Game");
		startBtn.setForeground(Color.decode("#000000"));
		startBtn.setBackground(Color.decode("#F3C94E"));
		startBtn.setFont(new Font("Arial", Font.PLAIN, 24));
		startBtn.setPreferredSize(new Dimension(300, 50));
		startBtn.addActionListener(this);

		container.gridx = 1;
		container.gridy = 5;
		add(startBtn, container);	
	}


	// -----------------------------------------------------------------------------------------
	// create JOptionPane to set minimum 3 player ----------------
	public class NotEnoughPlayer {
		JFrame f;
		NotEnoughPlayer() {
			f = new JFrame();
			JOptionPane.showMessageDialog(f, "Requires 3 or more player to start the game.");
		}
	}


	// -----------------------------------------------------------------------------------------
	// create actionPerformed----------------
	public void actionPerformed(ActionEvent btnclick) {
		MainMenu.playClick2();
		
		
		// back btn event ----------------
		if (btnclick.getSource() == backBtn) {
			CardLayoutManager.showPage(1);
		}

		// settings btn event ---------------
		if (btnclick.getSource() == btnSettings){
			dialog.settings();
		} 


		// +1 player if enabled ----------------
		for (int k = 0 ; k < 6 ; k++) {
			if (btnclick.getSource() == pb[k] && ptf[k].isEnabled() == false){
				ptf[k].setEnabled(true);
				ptf[k].setBackground(Color.decode("#FFFFFF"));
				ptf[k].setText(p[k][0]);
				status[k] = 1;
				totalPlayer+=1;
			}
			else if (btnclick.getSource() == pb[k] && ptf[k].isEnabled() == true) {
				ptf[k].setEnabled(false);
				ptf[k].setBackground(Color.decode("#CA9064"));
				ptf[k].setText(" ");
				status[k] = 0;
				totalPlayer-=1;
			}
		}


		// start btn event ---------------
		if(btnclick.getSource() == startBtn) {
			
			
			// run a method to get totalPlayer ---------------
			GameFlow.getTotalPlayer();	
			
			
			// store player information into player arrayList ---------------
			if (totalPlayer >= 3) {
				for (int i = 0 ; i < 6 ; i++) {
					if (ptf[i].isEnabled() == true) {
						name = ptf[i].getText();
						color = p[i][1];
						color1 = btnColor[i];
						GameFlow.getDetail();
					}	
				}

				
				// shuffle the player arrayList ---------------
				GameFlow.shufflePlayer();

				// set turn to 0 ---------------
				GameFlow.setTurn();

				// set page to 1 ---------------
				GameFlow.setPage();
				
				// set storyTeller to 0 ---------------
				GameFlow.declareST();

				// display for STTurn ---------------
				STTurn.hidePlayer();
				STTurn.setLabel1();
				STTurn.setScore();

				// create main deck ---------------
				GameFlow.createMainDeck();

				// create player hand ---------------
				GameFlow.createPlayerHand();

				// display player hand ---------------
				STTurn.displayPlayerCards();

				// Open STTurn class ---------------
				CardLayoutManager.showPage(4);
			}

			else {
				new NotEnoughPlayer();
				CardLayoutManager.showPage(3);
			}
		}	
	}
}
