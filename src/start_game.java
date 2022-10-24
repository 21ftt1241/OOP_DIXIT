import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//extends JPanel means that it will act as a JPanel
public class start_game extends JPanel {
	public JButton backBtn = new JButton("<");
	
	public start_game() {
		setLayout(new GridLayout(1, 1));
		setBackground(Color.LIGHT_GRAY);
		add(backBtn);
		backBtn.setPreferredSize(new Dimension (20,20));
	}

}
