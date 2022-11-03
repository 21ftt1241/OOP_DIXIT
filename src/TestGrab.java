import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestGrab extends JPanel implements ActionListener{
	
	JButton backBtn;
	
	static GridBagConstraints container = new GridBagConstraints();
	static JButton [] testColor;
	
	static String [][] pInfo;
	static Color [] pClr;
	
	static int totalPlayer;
	static JButton [] pb = new JButton[6];
	
	public TestGrab() {
		
		
		
		
		
		for (int i = 0 ; i < totalPlayer ; i++) {
			System.out.println(pInfo[i][0] + " " + pInfo[i][1]);
		}
		
		
				
//		System.out.println(totalPlayer);
		
		setLayout(new GridBagLayout());
		setBackground(Color.WHITE);		
		
		backBtn = new JButton("<");
//		backBtn.setBackground(pClr[0]);
		backBtn.addActionListener(this);		
		
		container.anchor = GridBagConstraints.NORTH;
		container.gridx = 1;
		container.gridy = 0;
		
		container.insets = new Insets (5, 5, 5, 5);
		
		add(backBtn, container);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		
		container.insets = new Insets (5, 5, 5, 5);
		container.weightx = 1;
		container.weightx = 1;
		container.anchor = GridBagConstraints.CENTER;
		
		
		for (int i = 0 ; i < 6; i++) {
			pb[i] = new JButton(i + "");
			pb[i].setPreferredSize(new Dimension(50, 50));
			pb[i].setBackground(PlayerSelect1.btnColor[i]);
			panel1.add(pb[i]);	
		}
		
		container.gridx = 1;
		container.gridy = 1;
		
		add(panel1, container);
		
		
		
	}
		
	public static String[][] getPlayerInfo(String [][] array1) {
		return pInfo = array1;
	}
	
	public static Color[] getPlayerColor(Color [] pClr1) {
		return pClr = pClr1;
	}
	
	public void actionPerformed(ActionEvent btnclick) {
		
		if (btnclick.getSource() == backBtn) {
			
			totalPlayer = PlayerSelect1.totalPlayer;
			
			System.out.println(totalPlayer);
			
			CardLayoutManager.showPage(69);
			
		}
			
	}
	
	public static void bruh() {
		
		for (int i = 0 ; i < 6 ; i++) {
			if (PlayerSelect1.status[i] == 0) {
				pb[i].setVisible(false);
			}
		}
		
	}


		
		

}
