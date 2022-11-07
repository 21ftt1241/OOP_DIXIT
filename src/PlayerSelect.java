import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PlayerSelect extends JPanel implements ActionListener{
	static JButton backBtn = new JButton("<");
	public int totalPlayer, finalPlayer;
	public String [] pName;
	JPanel playerScreen = new JPanel();


	//Inside playerScreen JPanel
	JLabel l1 = new JLabel("Choose your Color");;
	JButton startBtn;
	JButton [] pb = new JButton[6];
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
	
	public static String [][] pInfo;
	public static Color [] pClr;


	public PlayerSelect() {

		totalPlayer = 0;

		setLayout(new GridBagLayout());
		setBackground(Color.GRAY);

		GridBagConstraints gbc = new GridBagConstraints();
		GridBagConstraints gb = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.insets = new Insets(20,20,0,0);
		//gbc.weightx = 0.01;
		//gbc.weighty = 0.01;

		add(backBtn, gbc);
		backBtn.addActionListener(this);



		//gb.insets = new Insets(0,0,0,0);
		//gb.anchor = GridBagConstraints.CENTER;

		//Choose your color JLabel
		l1.setFont(new Font("Arial", Font.PLAIN, 32));

		playerScreen.setLayout(new GridBagLayout());
		playerScreen.setPreferredSize(new Dimension(1000,600));
		gb.gridx = 1;
		gb.gridy = 0;


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
			JOptionPane.showMessageDialog(f,  "Requires 3 or more player to start the game.");
		}
	}


	public void actionPerformed(ActionEvent btnclick) {

		if (btnclick.getSource() == backBtn) {
			CardLayoutManager.showPage(1);
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
			finalPlayer = totalPlayer;
			int x = 0;		

			String [][] pInfo = new String[totalPlayer][2];
			Color [] pClr = new Color[totalPlayer];

			if (totalPlayer >= 3) {

				for (int i = 0 ; i < 6 ; i++) {

					if (ptf[i].isEnabled() == true) {

						pInfo[x][0] = ptf[i].getText();
						pClr[x] = btnColor[i];
						pInfo[x][1] = p[i][1];
						x+=1;
					}	
				}

				STTurn.getPlayerInfo(pInfo);
				STTurn.getPlayerColor(pClr);
				
				STTurn.bruh();

				///run the gameflow punya class
				
				
				// 1. loop (conditionnya ikut points, if ada player yang pointnya
				//    labih dari 30, it stops
				// 2. dalam loop, showpage
				
				
				CardLayoutManager.showPage(4);
			}

			else {
				new NotEnoughPlayer();
				CardLayoutManager.showPage(3);
			}

		}	
	}
}
