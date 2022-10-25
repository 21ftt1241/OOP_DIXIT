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
	JTextArea ruleExplain = new JTextArea(10, 30);
		
	public GameRules() {
		//setLayout(new GridBagLayout());
		//set things to grids using this
		//GridBagConstraints gb = new GridBagConstraints();		
		ruleExplain.setEditable(false);
		ruleExplain.append("text");
		RulesTab.setLayout(new BorderLayout());
		
		RulesTab.add(RuleLbl1, BorderLayout.WEST);  
		PointsTab.add(RuleLbl2);
		RulesTab.add(ruleExplain, BorderLayout.EAST);
		
		tabbedPane.add("Game Rules", RulesTab);
		tabbedPane.add("Point System",PointsTab);
		tabbedPane.setFont( new Font(Font.SANS_SERIF,  Font.BOLD, 18));
		add(tabbedPane);
		add(backBtn);
		
		setLayout(null);
		setBackground(Color.cyan);
		backBtn.setBounds(10, 10, 50, 30);
		tabbedPane.setBounds(50,50,500,300);
		setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		
		backBtn.addActionListener(this);
	}

	public void actionPerformed(ActionEvent back) {
		System.out.println("Go back listens");
		CardLayoutManager.showPage(1);
	}
}
