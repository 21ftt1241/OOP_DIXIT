import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GameFlow {

	public static int totalPlayer, turn;
	public String pName, pClr;
	public int pPoint;
	public Color pClr1;
	public static int page;
	
	
	
	static ArrayList<GameFlow> playerArrList = new ArrayList<GameFlow>();
	
	static ArrayList<String> mainDeck = new ArrayList<String>();
	
	public static ArrayList<String> playerHand[]; 
	
	
	public static ArrayList<String> player1Deck = new ArrayList<String>();
	static ArrayList<String> player2Deck = new ArrayList<String>();
	static ArrayList<String> player3Deck = new ArrayList<String>();
	static ArrayList<String> player4Deck = new ArrayList<String>();
	static ArrayList<String> player5Deck = new ArrayList<String>();
	static ArrayList<String> player6Deck = new ArrayList<String>();
	
	
	
	
	public GameFlow(String name, String color, Color color1, int point) {
		pName = name;
		pClr = color;
		pClr1 = color1;
		pPoint = point;
	}
	
	// Test
	public static void test1() {
		
		for (int i = 0 ; i < playerArrList.size(); i++) {
			System.out.print(playerArrList.get(i).getNameArr());
			System.out.print(" " + playerArrList.get(i).getClrArr());
			System.out.print(" " + playerArrList.get(i).getPoint());
			System.out.println();
		}
		
		
	}
	
	public static void setTurn() {
		turn = 0;
	}
	
//	public static void getPage() {
//		page = STTurn.page;
//	}
	
	public static void addPoint() {
		int testPoint = 2;
		playerArrList.get(1).setPoint(testPoint);
	}
	
	public static void shuffleCard() {
		Collections.shuffle(playerArrList);
	}
	
	public static void pageChecker() {
		
		if (page == 1) {
			
			STTurn.displayPage2();
//			page = 2;
			STTurn.displayPlayerCards();
			System.out.println(page);
		}
		else if (page == 2) {
			
			STTurn.displayPage1();
//			page = 1;
			System.out.println(page);
		}
	}
	
//	public static void testt() {
//		System.out.println(playerHand);
//	}
	
	public static void grabber() {
		page = 1;
		System.out.println(page);
	}
	
	
//	public static void displayPlayerCards() {
//		for (int i = 0; i < 6; i++) {
//			ImageIcon icon = new ImageIcon(player1Deck.get(0));
//			STTurn.image = new JLabel(icon);
//			STTurn.cardBtn[i].add(STTurn.image);
//		}
//	}
	
	
	
	
	//testing for mainDeck
	
	
	
	
	
	
	
	// GameFlow Variable Logics
	
	public void turnChecker() {
		if (turn+1 == totalPlayer) {
			turn = 0;
		}
	}
	
	
	// Player ArrayList
	
	public String getNameArr() {
		return pName;
	}
	
	public String getClrArr() {
		return pClr;
	}
	
	public Color getClr1Arr() {
		return pClr1;
	}
	
	public int getPoint() {
		return pPoint;
	}
	
	public void setPoint(int point) {
		pPoint = point;
	}
	
	
	// Methods for PlayerSelect
	public static void createArrList() {
		
	}
	
	public static void insertIntoArrList() {
		
	}
	
	public static void getTotalPlayer() {
		totalPlayer = PlayerSelect1.totalPlayer;
	}
	
	public static void getDetail() {
		int pPoint = 0;
		String pName;
		String pClr;
		Color pClr1;
		
		pName = PlayerSelect1.name; 
		pClr = PlayerSelect1.color;
		pClr1 = PlayerSelect1.color1;
		
		playerArrList.add(new GameFlow(pName,pClr, pClr1, pPoint));
	}

	
	
	
	
	
	// Methods for STTurn
	
	public static void setLabel1() {
		
		
	}
	
	
	
	// ArrayList methods for card related
	
	public static void createMainDeck() {
		
		for (int i = 0 ; i < 84 ; i++) {
			mainDeck.add("resources/images/dixit_cards/" + (i+1) + ".png");
//			System.out.println(mainDeck.get(i));;
		}
		
		
	}
	
	public static void createPlayerDeck() {
		
		getTotalPlayer();
		System.out.println(totalPlayer);
		ArrayList<String> playerHand[] = new ArrayList[totalPlayer];
		
		for (int i = 0 ; i < totalPlayer ; i++) {
			playerHand[i] = new ArrayList<>();
			
			for (int j = 0 ; j < 6 ; j++) {
				playerHand[i].add(mainDeck.get(0));
				mainDeck.remove(0);
			}
			
			System.out.println(playerHand[i]);
		}
		
		
		
	}
	

//	For reference: 
//	update points
	
//	GameFlow.playerArrList.get(0).setPoint(var point);
	
//	for (int i = 0 ; i < GameFlow.playerArrList.size(); i++) {
//		System.out.println(GameFlow.playerArrList.get(i).getPoint());
//	}
	
	
	
	
}
