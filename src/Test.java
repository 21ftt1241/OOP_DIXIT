import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class Test extends JPanel implements ActionListener {

	JPanel playerCard = new JPanel();
	JButton[] imageBtn = new JButton[6];
	Color[] colorBtn = {Color.RED,Color.ORANGE,Color.YELLOW,Color.GREEN,Color.BLUE,Color.MAGENTA};

	public Test() {
		
		setLayout(new GridBagLayout());
		setBackground(Color.WHITE);
		
		GridBagConstraints gb = new GridBagConstraints();
		gb.anchor = GridBagConstraints.NORTH;
		
		for (int i = 0; i < 6; i++) {
			imageBtn[i] = new JButton();
			imageBtn[i].setPreferredSize(new Dimension(180,400));
			imageBtn[i].setBackground(colorBtn[i]);
			imageBtn[i].addActionListener(this);
			
			gb.insets = new Insets(0,10,0,10);
			
			add(imageBtn[i], gb);
			
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent btnClick) {
		// TODO Auto-generated method stub
		
		// Remove Highlight
		
		for (int i = 0; i < 6; i++) {
			Border emptyBorder = BorderFactory.createEmptyBorder();
			imageBtn[i].setBorder(emptyBorder);
			imageBtn[i].setBackground(colorBtn[i]);
		}
		
		// Highlight
		
		for (int i = 0; i < 6; i++) {
			if(btnClick.getSource() == imageBtn[i]) {
				imageBtn[i].setBorder(BorderFactory.createCompoundBorder(
						BorderFactory.createLineBorder(Color.CYAN, 5),
						BorderFactory.createEmptyBorder(
						imageBtn[i].getBorder().getBorderInsets(imageBtn[i]).top,
						imageBtn[i].getBorder().getBorderInsets(imageBtn[i]).left,
						imageBtn[i].getBorder().getBorderInsets(imageBtn[i]).bottom,
						imageBtn[i].getBorder().getBorderInsets(imageBtn[i]).right)));
				
				imageBtn[i].setBackground(Color.GRAY);
			}
		}
	}

}
