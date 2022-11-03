import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
		
		//ruleExplain.setEditable(false);
		ruleExplain.setLineWrap(true);
		try(BufferedReader rulesText = new BufferedReader(new FileReader("resources\\text_file/gamerules.txt"))){
		ruleExplain.read(rulesText, "gamerules");

        } catch (IOException e){

            e.printStackTrace();
        }
		
		RulesTab.setLayout(new BorderLayout());
		RulesTab.add(RuleLbl1);  
		PointsTab.add(RuleLbl2);
		RulesTab.add(ruleExplain);
		
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
