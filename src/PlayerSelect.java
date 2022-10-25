import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PlayerSelect extends JPanel implements ActionListener{
	static JButton backBtn = new JButton("<");
	
	
	public PlayerSelect() {
		add(backBtn);
		backBtn.setBounds(10, 10, 50, 30);
		backBtn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent back) {
		System.out.println("Go back listens");
		CardLayoutManager.showPage(1);
	}
}
