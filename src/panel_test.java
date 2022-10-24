import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class panel_test implements ActionListener {
	
	//make buttons
	public JButton b1, b2, b3;
	public JLabel lb;
	public JFrame mainWindow = new JFrame();
	public JPanel container = new JPanel();
	public JPanel mainMenu = new JPanel();
	public JPanel startOne = new JPanel();
	
	CardLayout cl = new CardLayout();
	
	
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
		container.setLayout(cl);
		startOne.setBackground(Color.green);
		
		mainMenu.setLayout(new GridBagLayout());
		
		//set things to grids using this
		GridBagConstraints gb = new GridBagConstraints();
		
		gb.gridx = 1;
		gb.gridy = 0;
	    gb.insets = new Insets(20, 0, 0, 0);
	    mainMenu.add(lb, gb);
		
		gb.gridx = 1;
		gb.gridy = 1;
		mainMenu.add(b1, gb);
		
		gb.gridx = 1;
		gb.gridy = 2;
		mainMenu.add(b2, gb);
		
		gb.gridx = 1;
		gb.gridy = 3;
		mainMenu.add(b3, gb);
		
		//import start_game class, put it inside a local variable
		JPanel startGame = new start_game();
		JPanel gameRules = new game_rules();
		
		container.add(mainMenu, "1");
		container.add(startGame, "2");
		container.add(gameRules, "3");
		cl.show(container, "1");
		
		mainWindow.add(container);
		mainWindow.setTitle("Dixit | Main Menu");
		mainWindow.setSize(600,600);
		mainWindow.setVisible(true);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		}

	@Override
	public void actionPerformed(ActionEvent btnclick) {
		if(btnclick.getSource() == b1) {
			System.out.println("Starting game!");
			cl.show(container, "2");
		}
		else if(btnclick.getSource() == b2) {
			System.out.println("Game Rules!!");
			cl.show(container, "3");
			
		}
		else if(btnclick.getSource() == b3) {
			System.exit(0); 
		}
	}
	
	//main method
		public static void main(String[] args)  {
			panel_test run = new panel_test();
		}
}
