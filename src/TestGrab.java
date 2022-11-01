import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestGrab extends JPanel implements ActionListener{
	
	JButton backBtn;
	static int totalPlayer;
	
	static String pName, pClrName;
	static Color pClr;
	
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
			
	public static int getPlayer(int finalPlayer) {
		return totalPlayer = finalPlayer;
	}
	
//	public static String getPlayerInfo(String pName1, String pClrName1) {
//		return pName = pName1;
//	}
//	
//	public static Color getPlayerColor(Color pClr1) {
//		return pClr = pClr1;
//	}
	
	public void actionPerformed(ActionEvent btnclick) {
		
		if (btnclick.getSource() == backBtn) {
			System.out.println(totalPlayer);
		}
			
	}
		
		

}
