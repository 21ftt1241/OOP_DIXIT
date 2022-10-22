import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class panel_test extends JFrame implements ActionListener {
	
	//make buttons
	public JButton b1, b2, b3;
	public JLabel lb;
	
	
	//define buttons
	public void createButton() {
		
		b1 = new JButton("Start Game");
		b2 = new JButton("Game Rules");
		b3 = new JButton("Exit Game");
		lb = new JLabel("DIXIT");
		
		b1.setPreferredSize(new Dimension(200, 100));
		b2.setPreferredSize(new Dimension(200, 100));
		b3.setPreferredSize(new Dimension(200, 100));
		
		lb.setFont(new Font("Arial", Font.PLAIN, 32));
		b1.setFont(new Font("Arial", Font.PLAIN, 24));
		b2.setFont(new Font("Arial", Font.PLAIN, 24));
		b3.setFont(new Font("Arial", Font.PLAIN, 24));
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

	}
	
	//panels stuff
	public panel_test() {
		
		createButton();
		setLayout(new GridBagLayout());
		
		//set things to grids using this
		GridBagConstraints gb = new GridBagConstraints();
		
		gb.gridx = 1;
		gb.gridy = 0;
	    gb.insets = new Insets(20, 0, 0, 0);
	    add(lb, gb);
		
		gb.gridx = 1;
		gb.gridy = 1;
		add(b1, gb);
		
		gb.gridx = 1;
		gb.gridy = 2;
		add(b2, gb);
		
		gb.gridx = 1;
		gb.gridy = 3;
		add(b3, gb);
		
		setTitle("Dixit | Main Menu");
		setSize(600,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		}
	
	//main method
	public static void main(String[] args)  {
		panel_test bruh = new panel_test();
	}

	@Override
	public void actionPerformed(ActionEvent btnclick) {
		if(btnclick.getSource() == b1) {
			System.out.println("Starting game!");
		}
		else if(btnclick.getSource() == b2) {
			System.out.println("Game Rules!!");
		}
		else if(btnclick.getSource() == b3) {
		System.exit(0); 
		}
	}

}
