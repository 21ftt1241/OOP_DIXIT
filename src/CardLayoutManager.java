import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class CardLayoutManager {

	static JFrame mainWindow = new JFrame("Dixit");;
	static CardLayout cl;
	static JPanel container;

	//main method
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

		mainWindow.setSize(1280, 720);
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
		
		STTurn st = new STTurn();
		container.add(st, "Storyteller");
		
		showCards sc = new showCards();
		container.add(sc, "showCards");
		
		PlayerSelect1 selectPlayers = new PlayerSelect1();
		container.add(selectPlayers, "PlayerSelect1");
		
		TestGrab grabTest = new TestGrab();
		container.add(grabTest, "TestGrab");

		//Responsible for showing the very first screen of the game
		showPage(1);
	}
	
	//assigns number to pages, can be used in other java files/classes
	public static void showPage(int pageNumber) {
		switch(pageNumber) {
		case 1: cl.show(container, "MainMenu"); 
		break;
		case 2: cl.show(container, "GameRule"); 
		break;
		case 3: cl.show(container, "PlayerSelect1"); 
		break;
		case 4: cl.show(container, "Storyteller"); 
		break;
		case 5: cl.show(container, "showCards"); 
		break;
		case 69: cl.show(container, "TestGrab");
		break;
		}
	}
}
