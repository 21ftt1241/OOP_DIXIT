import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PlayerSelect extends JPanel implements ActionListener{
	static JButton backBtn = new JButton("<");
	static JLabel bruh = new JLabel("Korewa test");
	JPanel playerScreen = new JPanel();
	
	public PlayerSelect() {

		setLayout(new GridBagLayout());
		setBackground(Color.GRAY);
		
		GridBagConstraints gb = new GridBagConstraints();
		gb.anchor = GridBagConstraints.NORTHWEST;
		gb.insets = new Insets(20,20,0,0);
		
		add(backBtn, gb);
		backBtn.addActionListener(this);
		
		gb.weightx = 0.5;
		gb.weighty = 0.5;
		gb.insets = new Insets(0,0,0,0);
		gb.anchor = GridBagConstraints.CENTER;
		
		playerScreen.setLayout(new GridBagLayout());
		playerScreen.setPreferredSize(new Dimension(800,600));
		playerScreen.add(bruh);
			
		add(playerScreen, gb);
	}
	
	public void actionPerformed(ActionEvent back) {
		System.out.println("Go back listens");
		CardLayoutManager.showPage(1);
	}
}
