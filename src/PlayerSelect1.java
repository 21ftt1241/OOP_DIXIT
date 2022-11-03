import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerSelect1 extends JPanel implements ActionListener{
	
	JButton backBtn, startBtn;
	JLabel l1;
	
	JButton [] pb = new JButton[6];
	JTextField [] ptf = new JTextField[6];
	
	String [][] p = {
			{"Player 1", "RED"},
			{"Player 2", "YELLOW"},
			{"Player 3", "GREEN"},
			{"Player 4", "BLUE"},
			{"Player 5", "CYAN"},
			{"Player 6", "MAGENTA"}
	};
	
	public static int [] status = new int[6];
	
	public static Color [] btnColor = {Color.RED,Color.YELLOW,Color.GREEN,
			Color.BLUE,Color.CYAN,Color.MAGENTA};
	
	public static int totalPlayer, finalPlayer;
	public static String [] pName;
	
	public static String [][] pInfo;
	public static Color [] pClr;
	
	public PlayerSelect1() {
		
		setLayout(new GridBagLayout());
		setBackground(Color.WHITE);
		
		GridBagConstraints container = new GridBagConstraints();
		
		backBtn = new JButton("<");
		backBtn.addActionListener(this);		
		
		container.anchor = GridBagConstraints.NORTHWEST;
		container.insets = new Insets(5, 5, 5, 5);
		add(backBtn, container);
		
		
		
		container.insets = new Insets(5, 5, 5, 5);
		container.weightx = 0.5;
		container.weighty = 0.5;
		container.anchor = GridBagConstraints.CENTER;
		
		l1 = new JLabel("Choose your Color");
		l1.setFont(new Font("Arial", Font.PLAIN, 32));
		
		container.gridx = 1;
		container.gridy = 0;
		add(l1, container);
		
//		Player buttons
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
		
//		Player Name TextField
		
		x = 0;
		y = 2;
		
		for (int j = 0 ; j < 6; j++) {
			ptf[j] = new JTextField();
			ptf[j].setPreferredSize(new Dimension(200, 40));
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

		
//		StartGame Button
		startBtn = new JButton("Start Game");
		startBtn.setPreferredSize(new Dimension(300, 50));
		startBtn.addActionListener(this);
		
		container.gridx = 1;
		container.gridy = 5;
		add(startBtn, container);	
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
				
				TestGrab.getPlayerInfo(pInfo);
				TestGrab.getPlayerColor(pClr);
				
				TestGrab.bruh();
				
				
				
				// create the next page
//				TestGrab.CreateButton();
				
				CardLayoutManager.showPage(69);
			}
			
			else {
				new NotEnoughPlayer();
				CardLayoutManager.showPage(3);
			}
			
			
			
		}	
	}
}
