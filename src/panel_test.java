import java.awt.*;
import javax.swing.*;

public class panel_test {

	public static void main(String[] args) {
		JFrame frame = new JFrame("JFrame Example");
		// set the JFrame to fullscreen
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// JFrame bounds when rescaled
		frame.setBounds(100,100,1280,720);

		// create a new panel
		JPanel container = new JPanel();

		container.setBackground(Color.black);
		
		JButton btn1 = new JButton("Start Game");    
		JButton btn2 = new JButton("Game Rules");    
		JButton btn3 = new JButton("Exit Game");
		
		btn1.setFont(new Font("Arial", Font.PLAIN, 32));
		btn2.setFont(new Font("Arial", Font.PLAIN, 32));
		btn3.setFont(new Font("Arial", Font.PLAIN, 32));
		
	    btn1.setPreferredSize(new Dimension(300, 100));
	    btn2.setPreferredSize(new Dimension(300, 100));
	    btn3.setPreferredSize(new Dimension(300, 100));
	    
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.gray);

		panel1.setLayout(new GridBagLayout());
		frame.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 10, 10, 10);
		
		panel1.add(btn1, gbc);
		panel1.add(btn2, gbc);
		panel1.add(btn3, gbc);

		container.add(panel1);
		
		
		frame.add(container);
		
		frame.setVisible(true);
		System.out.println("Test by Mus");
	}

}
