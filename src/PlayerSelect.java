import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PlayerSelect extends JPanel implements ActionListener{

	dialogPU dialog = new dialogPU();

	JPanel playerScreen = new JPanel();


	//Inside playerScreen JPanel
	JLabel l1;
	JButton [] pb = new JButton[6];
	JButton backBtn, startBtn, btnSettings;
	JTextField [] ptf = new JTextField[6];

	//Player 2D Array
	String [][] p = {
			{"Player 1", "RED"},
			{"Player 2", "YELLOW"},
			{"Player 3", "GREEN"},
			{"Player 4", "BLUE"},
			{"Player 5", "CYAN"},
			{"Player 6", "MAGENTA"}
	};

	//Check status
	public static int [] status = new int[6];

	public static Color [] btnColor = {Color.RED,Color.YELLOW,Color.GREEN,
			Color.BLUE,Color.CYAN,Color.MAGENTA};

	public static int totalPlayer;
	public static Color color1;
	public static String name, color;

	public static int point;


	public PlayerSelect() {

		totalPlayer = 0;

		setLayout(new GridBagLayout());
		setBackground(Color.GRAY);

		//Back button
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.insets = new Insets(20,20,0,0);
		add(backBtn, gbc);
		backBtn.addActionListener(this);

		btnSettings = new JButton("Settings");
		btnSettings.addActionListener(this);
		gbc.anchor = GridBagConstraints.NORTHEAST;	
		gbc.gridx = 2;
		add(btnSettings, gbc);

		//Label
		l1 = new JLabel("Choose your Color");
		l1.setFont(new Font("Arial", Font.PLAIN, 32));


		GridBagConstraints gb = new GridBagConstraints();
		playerScreen.setLayout(new GridBagLayout());
		playerScreen.setPreferredSize(new Dimension(1280,720));
		gb.gridx = 1;
		gb.gridy = 0;
		gb.weighty = 0.01;

		playerScreen.add(l1, gb);

		//		Player buttons
		int x = 0;
		int y = 1;

		for (int i = 0 ; i < 6; i++) {
			pb[i] = new JButton();
			pb[i].setPreferredSize(new Dimension(50, 50));
			pb[i].setBackground(btnColor[i]);
			pb[i].addActionListener(this);

			gb.gridx = x;
			gb.gridy = y;
			playerScreen.add(pb[i], gb);

			x = x + 1;

			if (x == 3) {
				x = 0;
				y = 3;
			}

		}

		//		Player Name TextField

		x = 0;
		y = 2;

		for (int j = 0 ; j < 6; j++) {
			ptf[j] = new JTextField();
			ptf[j].setPreferredSize(new Dimension(200, 40));
			ptf[j].setDocument(new JTextFieldLimit(10));
			ptf[j].setEnabled(false);

			gb.gridx = x;
			gb.gridy = y;
			playerScreen.add(ptf[j], gb);

			x = x + 1;
			if (x == 3) {
				x = 0;
				y = 4;
			}

		}

		//		StartGame Button
		startBtn = new JButton("Start Game");
		startBtn.setPreferredSize(new Dimension(300, 50));
		startBtn.addActionListener(this);

		gb.gridx = 1;
		gb.gridy = 5;
		playerScreen.add(startBtn, gb);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0,0,0,0);
		gbc.weightx = 1;
		gbc.weighty = 1;
		add(playerScreen, gbc);
	}

	public class NotEnoughPlayer {
		JFrame f;
		NotEnoughPlayer() {
			f = new JFrame();
			JOptionPane.showMessageDialog(f, "Requires 3 or more player to start the game.");
		}
	}


	public void actionPerformed(ActionEvent btnclick) {

		if (btnclick.getSource() == backBtn) {
			CardLayoutManager.showPage(1);
		}

		if (btnclick.getSource() == btnSettings){
			dialog.settings();
		} 


		//		Button performs

		for (int k = 0 ; k < 6 ; k++) {
			if (btnclick.getSource() == pb[k] && ptf[k].isEnabled() == false){
				ptf[k].setEnabled(true);
				ptf[k].setText(p[k][0]);

				status[k] = 1;

				totalPlayer+=1;
			}
			else if (btnclick.getSource() == pb[k] && ptf[k].isEnabled() == true) {
				ptf[k].setEnabled(false);
				ptf[k].setText(" ");
				status[k] = 0;
				totalPlayer-=1;
			}
		}


		//		Start game logics

		if(btnclick.getSource() == startBtn) {

			GameFlow.getTotalPlayer();	

			if (totalPlayer >= 3) {
				for (int i = 0 ; i < 6 ; i++) {
					if (ptf[i].isEnabled() == true) {

						name = ptf[i].getText();
						color = p[i][1];
						color1 = btnColor[i];

						GameFlow.getDetail();

					}	
				}

				GameFlow.shuffleCard();
				STTurn.setLabel();
				GameFlow.test1();

				CardLayoutManager.showPage(4);
			}

			else {
				new NotEnoughPlayer();
				CardLayoutManager.showPage(3);
			}
		}	
	}
}
