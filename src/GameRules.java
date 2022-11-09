
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.swing.*;

public class GameRules extends JPanel implements ActionListener {
	
	static JButton backBtn = new JButton("<");
	JPanel RulesTab = new JPanel();
	JPanel PointsTab = new JPanel();
	
	JLabel RuleLbl1 = new JLabel("Game Rules");
	JLabel RuleLbl2 = new JLabel("Point System");
	
	JTabbedPane tabbedPane = new JTabbedPane();
	JTextArea ruleExplain = new JTextArea(10, 1);
	JScrollPane ruleScroll = new JScrollPane(ruleExplain);
	 
	//static final String FILE_PATH = "gamerules.txt";
		
	public GameRules() {
		BufferedReader rulesText = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/resources/text_file/gamerules.txt")));
		
	     
		try {
			ruleExplain.read(rulesText, "gamerules");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setLayout(new GridBagLayout());
		setBackground(Color.GRAY);
		
		GridBagConstraints gb = new GridBagConstraints();
		gb.anchor = GridBagConstraints.NORTHWEST;
		gb.insets = new Insets(20,20,0,0);
		add(backBtn, gb);
		backBtn.addActionListener(this);
		
		gb.insets = new Insets(0,0,0,0);
		gb.weightx = 0.5;
		gb.weighty = 0.5;
		gb.anchor = GridBagConstraints.CENTER;
		
        ruleScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		ruleScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		ruleExplain.setFont(new Font("Arial", Font.PLAIN, 24));
		ruleExplain.setLineWrap(true);
		ruleExplain.setWrapStyleWord(true);
		ruleExplain.setEditable(false);
		//ruleExplain.setLineWrap(true);
		
		

		
		RulesTab.setLayout(new BorderLayout());
		RulesTab.add(RuleLbl1);  
		PointsTab.add(RuleLbl2);
		RulesTab.add(ruleScroll);
		
		tabbedPane.setPreferredSize(new Dimension(800,600));
		tabbedPane.add("Game Rules", RulesTab);
		tabbedPane.add("Point System",PointsTab);
		tabbedPane.setFont( new Font(Font.SANS_SERIF,  Font.BOLD, 18));
		add(tabbedPane, gb);

	}

	public void actionPerformed(ActionEvent back) {
		System.out.println("Go back listens");
		CardLayoutManager.showPage(1);
	}
}
