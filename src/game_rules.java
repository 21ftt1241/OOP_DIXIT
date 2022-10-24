import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class game_rules extends JPanel implements ActionListener {
	public JButton backBtn = new JButton("<");
	//CardLayout cl2 = new CardLayout(cl);
	
	public game_rules() {
		setBackground(Color.cyan);
		add(backBtn);
		backBtn.addActionListener(this);
	}

	public void actionPerformed(ActionEvent back) {
		//cl.show(container, "1");
	}
}
