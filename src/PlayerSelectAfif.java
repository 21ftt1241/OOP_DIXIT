import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class PlayerSelectAfif extends JPanel{
	
	public PlayerSelectAfif() {
		
		JLabel label1 = new JLabel("BRUH!");
		add(label1);
		
		
		
		JButton nextButton = new JButton("NEXT");
		nextButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
//				CardLayoutS.showPage(2);
				System.out.println("bruh");
			}
		});
		add(nextButton);
	}

}
