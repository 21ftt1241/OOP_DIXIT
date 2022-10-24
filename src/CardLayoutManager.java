import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CardLayoutManager {

	static JFrame mainWindow;
	static CardLayout cl;
	static JPanel container;

	//main method
	public static void main(String[] args)  {

		JFrame mainWindow = new JFrame("Dixit");
		mainWindow.setSize(600,600);
		mainWindow.setVisible(true);
		mainWindow.setLocationRelativeTo(null);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cl = new CardLayout();
		container = new JPanel(cl); //makes the container inherit card layout
		mainWindow.add(container);

		//import MainMenu java class
		MainMenu mainPage = new MainMenu();
		container.add(mainPage, "MainMenu"); //adds Main Menu inside container
		//import GameRules java class
		GameRules ruleGame = new GameRules();
		container.add(ruleGame, "GameRule");

		//Responsible for showing the very first screen of the game
		showPage(1);
	}

	//assigns number to pages, can be used in other java files/classes
	public static void showPage(int pageNumber) {
		switch(pageNumber) {
		case 1: cl.show(container, "MainMenu"); break;
		case 2: cl.show(container, "GameRule"); break;
		}
	}
}
