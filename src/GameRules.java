import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameRules extends JPanel implements ActionListener {
	static JButton backBtn = new JButton("<");
	JPanel RulesTab = new JPanel();
	JPanel PointsTab = new JPanel();
	
	JLabel RuleLbl1 = new JLabel("Game Rules");
	JLabel RuleLbl2 = new JLabel("Point System");
	
	JTabbedPane tabbedPane = new JTabbedPane();
	
	public GameRules() {
		//setLayout(new GridBagLayout());
		//set things to grids using this
		//GridBagConstraints gb = new GridBagConstraints();		
		RulesTab.add(RuleLbl1);  
		
		PointsTab.add(RuleLbl2);
		
		tabbedPane.add("Game Rules", RulesTab);
		tabbedPane.add("Point System",PointsTab);
		add(tabbedPane);
		add(backBtn);
		
		setLayout(null);
		setBackground(Color.cyan);
		backBtn.setBounds(10, 10, 50, 30);
		tabbedPane.setBounds(50,50,500,300);  
		
		backBtn.addActionListener(this);
	}

	public void actionPerformed(ActionEvent back) {
		System.out.println("Go back listens");
		CardLayoutManager.showPage(1);
	}
}
