import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class STTurn extends JPanel implements ActionListener {
	
	static JButton exitBtn;
	static String [][] pInfo;
	static Color [] pClr1;
	
	JPanel score = new JPanel();
	static JPanel text = new JPanel();
	JPanel cont = new JPanel();
	
	static JPanel[] plPanel = new JPanel[6];
	Color[] pClr = {Color.RED, Color.YELLOW, Color.GREEN, 
			Color.BLUE, Color.CYAN, Color.MAGENTA};
	
	int[] point = {0, 0, 0, 0, 0, 0};
	
	static JLabel one = new JLabel();
	
	static GridBagConstraints gb2 = new GridBagConstraints();
	
	public STTurn(){
		
		setLayout(new GridBagLayout());
		setBackground(Color.WHITE);
		
		//Exit button
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.NORTHEAST;
		gbc.insets = new Insets(20,20,0,0);
		gbc.gridx = 2;
		add(exitBtn, gbc);
		exitBtn.addActionListener(this);
		
		score.setLayout(new GridBagLayout());
		score.setBackground(Color.WHITE);
		GridBagConstraints gb1 = new GridBagConstraints();
		
		
		for(int i = 0; i < 6; i++) {
			
			plPanel[i] = new JPanel();
			plPanel[i].setPreferredSize(new Dimension(50,50));
			plPanel[i].setBackground(pClr[i]);
			
			JLabel npoint = new JLabel(String.valueOf(point[i]));
			
			plPanel[i].add(npoint);
			
			gb1.insets = new Insets(0,10,0,10);
			
			score.add(plPanel[i], gb1);
			
		}
		
		gb1.gridx = 1;
		gb1.gridy = 0;
		add(score, gb1);
		
		text.setLayout(new GridBagLayout());
		text.setBackground(Color.GRAY);
		text.setPreferredSize(new Dimension(700,400));
		
		gb2.insets = new Insets(55,0,55,0);
		
		one = new JLabel("Color (Username)");
		one.setFont(new Font("ARIAL", Font.PLAIN, 24));
		
		JLabel two = new JLabel("Storyteller's Turn");
		two.setFont(new Font("ARIAL", Font.PLAIN, 40));
		
		JLabel three = new JLabel("Press continue if ready");
		three.setFont(new Font("ARIAL", Font.PLAIN, 20));
		
		gb2.gridx = 0;
        gb2.gridy = 0;
        text.add(one, gb2);
        
        gb2.gridx = 0;
        gb2.gridy = 1;
        text.add(two, gb2);
        
        gb2.gridx = 0;
        gb2.gridy = 2;
        text.add(three, gb2);
        
        gb2.gridx = 1;
        gb2.gridy = 1;
        add(text, gb2);
        
        cont.setLayout(new GridBagLayout());
        GridBagConstraints gb3 = new GridBagConstraints();
		
		JButton cont = new JButton("continue");
		cont.setPreferredSize(new Dimension(200,50));
		
		gb3.gridx = 1;
		gb3.gridy = 2;
		add(cont, gb3);
		
	}
	
	
	public static void setLabel() {

		one.setText(GameFlow.s.get(GameFlow.turn).getClrArr() + " (" + GameFlow.s.get(GameFlow.turn).getNameArr() + ")");
		
		for (int i = 0 ; i < 6 ; i++) {
			if (PlayerSelect1.status[i] == 0) {
				plPanel[i].setVisible(false);
			}
		}
		
        
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
