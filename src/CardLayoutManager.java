import java.awt.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class CardLayoutManager {

	static JFrame mainWindow = new JFrame("Dixit");
	static CardLayout cl;
	static JPanel container;

	//Main method
	//throws the three because of music related imports
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		//Set JFrame properties
		mainWindow.setSize(1920, 1080);
		mainWindow.setVisible(true);
		mainWindow.setLocationRelativeTo(null);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Introduce new layout
		cl = new CardLayout();
		container = new JPanel(cl); //makes the container inherit card layout
		mainWindow.add(container); //Inside JFrame now have a JPanel with a Card Layout

		//import MainMenu java class
		MainMenu mainPage = new MainMenu();
		container.add(mainPage, "MainMenu"); //adds MainMenu page inside container
		
		//import GameRules java class
		GameRules ruleGame = new GameRules();
		container.add(ruleGame, "GameRule"); //adds GameRule page inside container
		
		STTurn st = new STTurn();
		container.add(st, "Storyteller"); //adds Storyteller page inside container
		
		PlayerSelect1 selectPlayers = new PlayerSelect1();
		container.add(selectPlayers, "PlayerSelect1"); //adds SelectPlayer page inside container
		
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
		}
	}
}
