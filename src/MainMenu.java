import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainMenu extends JPanel implements ActionListener {
	final JButton b1, b2, b3;
	final JLabel lb;
	//private BufferedImage image;
	public JButton yes_btn, no_btn;
	public JDialog exit;
	
	dialogPU dialog = new dialogPU();

	public MainMenu() {

		ImageIcon icon = new ImageIcon(getClass().getResource("/resources/images/dixit-logo.png")); // assign image to a new ImageIcon
		Image image = icon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(715, 260,  java.awt.Image.SCALE_SMOOTH); // scale it smoothly  
		
		ImageIcon dixitLogo = new ImageIcon(newimg);  // assign to a new ImageIcon instance

		
		b1 = new JButton("Start Game");
		b2 = new JButton("Game Rules");
		b3 = new JButton("Exit Game");
		lb = new JLabel(dixitLogo);
		
		b1.setPreferredSize(new Dimension(200, 100));
		b2.setPreferredSize(new Dimension(200, 100));
		b3.setPreferredSize(new Dimension(200, 100));

		b1.setFont(new Font("Arial", Font.PLAIN, 24));
		b2.setFont(new Font("Arial", Font.PLAIN, 24));
		b3.setFont(new Font("Arial", Font.PLAIN, 24));

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

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
	}
	

	public void actionPerformed(ActionEvent btnclick) {
		
		//Main Menu button performs
		if(btnclick.getSource() == b1) {
			// CardLayoutManager.showPage(3);
			String x = dialog.getText();
			System.out.println(x);
		}
		else if(btnclick.getSource() == b2) {
			CardLayoutManager.showPage(2); //calls CLM class and the showPage method
		}
		else if(btnclick.getSource() == b3) {
			// dialog.dialog_ext();
			dialog.card_descPU();
		}
	}
}
