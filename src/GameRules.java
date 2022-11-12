import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.*;

public class GameRules extends JPanel implements ActionListener {

	static JButton backBtn = new JButton("<");
	JPanel RulesTab = new JPanel();
	JPanel PointsTab = new JPanel();
	
	JLabel RuleLbl1 = new JLabel("Game Rules");
	JLabel RuleLbl2 = new JLabel("Point System");

	JTabbedPane tabbedPane = new JTabbedPane();
	JTextArea ruleExplain = new JTextArea(10, 1);
	JTextArea pointExplain = new JTextArea(10, 1);
	JScrollPane ruleScroll = new JScrollPane(ruleExplain);
	JScrollPane pointScroll = new JScrollPane(pointExplain);

	
	//Throws IOException because of BufferedReader
	public GameRules() throws IOException{
		
		//GameRules page properties
		setLayout(new GridBagLayout());
		setBackground(Color.decode("#EBD6B1"));

		//Import rules text from text file
		BufferedReader rulesText = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/resources/text_file/gamerules.txt")));
		ruleExplain.read(rulesText, "gamerules");

		//Import points text from text file
		BufferedReader pointsText = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/resources/text_file/pointsrules.txt")));
		pointExplain.read(pointsText, "gamerules");
		
		//Back Button properties
		GridBagConstraints gb = new GridBagConstraints();
		gb.anchor = GridBagConstraints.NORTHWEST;
		gb.insets = new Insets(20,20,0,0);
		backBtn.setBackground(Color.decode("#F3C94E"));
		backBtn.setForeground(Color.decode("#000000"));
		backBtn.setFont(new Font("Arial", Font.BOLD, 24));
		backBtn.addActionListener(this);
		add(backBtn, gb);

		gb.insets = new Insets(0,0,0,0);
		gb.weightx = 0.5;
		gb.weighty = 0.5;
		gb.anchor = GridBagConstraints.CENTER;
		
		//Always add a vertical scrollbar and never a horizontal one to Rules Tab and Points Tab
		ruleScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		ruleScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		pointScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pointScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		//Game Rules TextArea Properties
		ruleExplain.setFont(new Font("Arial", Font.PLAIN, 24));
		ruleExplain.setLineWrap(true);
		ruleExplain.setWrapStyleWord(true);
		ruleExplain.setEditable(false);
		ruleExplain.setBackground(Color.decode("#FFFFFF"));
		
		//Points System TextArea Properties
		pointExplain.setFont(new Font("Arial", Font.PLAIN, 24));
		pointExplain.setLineWrap(true);
		pointExplain.setWrapStyleWord(true);
		pointExplain.setEditable(false);
		
		//Rules and Points Tab Layout, added to JScrollPane
		RulesTab.setLayout(new BorderLayout());
		PointsTab.setLayout(new BorderLayout());
		PointsTab.add(pointScroll);
		RulesTab.add(ruleScroll);
		
		//JTabbedPane properties
		tabbedPane.setPreferredSize(new Dimension(800,600));
		tabbedPane.add("Game Rules", RulesTab);
		tabbedPane.add("Point System",PointsTab);
		tabbedPane.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 18));
		add(tabbedPane, gb);
	}
	
	//Back button to go back to Main Menu
	public void actionPerformed(ActionEvent back) {
		CardLayoutManager.showPage(1);
	}
}
