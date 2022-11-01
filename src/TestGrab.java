import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestGrab extends JPanel implements ActionListener{
	
	JButton backBtn;
	
	PlayerSelect1 g = new PlayerSelect1();
	
	public int x;
	
	int totalPlayer = g.getPlayer();
	
	public TestGrab() {
		
		setLayout(new GridBagLayout());
		setBackground(Color.WHITE);
		
		GridBagConstraints container = new GridBagConstraints();
		
		backBtn = new JButton("<");
//		backBtn.setPreferredSize(new Dimension (40, 40));
		backBtn.addActionListener(this);		
		
		container.anchor = GridBagConstraints.NORTHWEST;
		container.insets = new Insets (5, 5, 5, 5);
		add(backBtn, container);
	}
		
		
	
	public void actionPerformed(ActionEvent btnclick) {
		
		if (btnclick.getSource() == backBtn) {
			System.out.println(totalPlayer);
		}
			
	}
		
		

}
