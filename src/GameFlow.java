import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GameFlow {

	public static int totalPlayer, turn;
	public String pName, pClr, pc, vc;
	public int pPoint, cc;
	public Color pClr1;
	
	public static int page;
	public static int st, n, looper;
	
	public static String stCard;
	
	
	
	
	static ArrayList<GameFlow> playerArrList = new ArrayList<GameFlow>();
	
	public static ArrayList<String> mainDeck = new ArrayList<String>();
 
	public static ArrayList<String> playerHand[] = new ArrayList[6];
	
	public static ArrayList<String> tableCard = new ArrayList<String>();
	public static ArrayList<String> tempTableCard = new ArrayList<String>();
	
	// tablecard
	// find how many voters
	// logics for calculation
	
	
	public static ArrayList<String> discardedCard = new ArrayList<String>();
		
	public GameFlow(String name, String color, Color color1, int point, String playerCard, String votedCard, int cardCounter) {
		pName = name;
		pClr = color;
		pClr1 = color1;
		pPoint = point;
		pc = playerCard;
		vc = votedCard;
		cc = cardCounter;
	}
	
	// Player ArrayList -----------------------------------------------------------------------------------------
	
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
	
	
	public String getPC() {
		return pc;
	}
	
	public void setPC(String votedCard) {
		pc = votedCard;
	}
	
	public String getVC() {
		return vc;
	}
	
	public void setVC(String votedCard) {
		vc = votedCard;
	}
	
	public int getCC() {
		return cc;
	}
	
	public void setCC(int cardCounter) {
		cc = cardCounter;
	}
	
	
	
	public static void removeTableCard() {
		for (int i = 0 ; i < totalPlayer; i++) {
			tableCard.remove(0);
			tempTableCard.remove(0);
		}
	}
	// Test -----------------------------------------------------------------------------------------
	public static void declareST() {
		st = 0;
	}
	
	public static void increaseST() {
		st += 1;
	}
	
	public static void stChecker() {
		if (st == totalPlayer) {
			st = 0;
		}
	}
	
	public static void setTurn() {
		turn = 0;
	}
	
	public static void updateTurn() {
		turn = st;
	}
	
	public static void increaseTurn() {
		turn += 1;
	}
	
	public static void turnChecker() {
		if (turn+1 == totalPlayer) {
			setTurn();
		}
		else {
			increaseTurn();
		}
	}	
	
	public static void setVar() {
		n = 0;
	}
	
	public static void varInc() {
		n+=1;
	}
	
	public static void stCard() {
		stCard = tableCard.get(0);
	}
	
	
	
	
	// End of Test -----------------------------------------------------------------------------------------
	
	
	
	// Game Logic and Checker  -----------------------------------------------------------------------------------------
	

	
	
	
	public static void setPage() {
		page = 1;
	}
	
	public static void setPage2() {
		page = 2;
	}
	
	public static void addPoint() {
		int testPoint = 2;
		playerArrList.get(1).setPoint(testPoint);
	}
	
	public static void shufflePlayer() {
		Collections.shuffle(playerArrList);
	}
	
	public static void pageChecker() {
		
		// Card
		if (page == 1) {
			STTurn.displayPlayerCards();
			STTurn.setLabel1();
			STTurn.displayPage2();
			page = 2;
			
		}
		
		// Text
		else if (page == 2) {
			STTurn.displayPlayerCards();
			STTurn.setLabel2();
			STTurn.displayPage1();
			page = 1;
			
		}
		
		
	}
	
	public static void pageChecker1() {
		
		// Card
		if (page == 1) {
			STTurn.displayPage2();
			page = 2;
			
		}
		
		// Text
		else if (page == 2) {
			STTurn.setLabel3();
			STTurn.displayPage1();
			page = 1;
			
		}
		
		
	}
	
	
	
	
	

	
	
	// Methods for PlayerSelect -----------------------------------------------------------------------------------------
		
	public static void getTotalPlayer() {
		totalPlayer = PlayerSelect1.totalPlayer;
	}
	
	public static void getDetail() {
		
		String pName, pClr, pCard="", pVCard="";
		Color pClr1;
		int pPoint = 0, cCounter = 0;
		
		pName = PlayerSelect1.name; 
		pClr = PlayerSelect1.color;
		pClr1 = PlayerSelect1.color1;
		
		playerArrList.add(new GameFlow(pName,pClr, pClr1, pPoint, pCard, pVCard, cCounter));
	}
	
	// Methods for STTurn -----------------------------------------------------------------------------------------
	
	
	// ArrayList methods for card related -----------------------------------------------------------------------------------------
	
	public static void createMainDeck() {
		
		for (int i = 0 ; i < 84 ; i++) {
			mainDeck.add("dixit_cards/" + (i+1) + ".png");
		}
		Collections.shuffle(mainDeck);
	}
	
	public static void createPlayerHand() {
		
		getTotalPlayer();

		for (int i = 0 ; i < totalPlayer ; i++) {
			playerHand[i] = new ArrayList<>();
			
			for (int j = 0 ; j < 6 ; j++) {
				playerHand[i].add(mainDeck.get(0));
				mainDeck.remove(0);
			}
		}
	}
	
	public static void deckToHand() {
		playerHand[turn].add(mainDeck.get(0));
		mainDeck.remove(0);
	}
	
	public static void handToTable() {
		int tempCard = STTurn.tempCard;
		
		tableCard.add(playerHand[turn].get(tempCard));
		playerHand[turn].remove(tempCard);
	}
	
	public static void moveToTemp() {
		for (int i = 0; i < totalPlayer ; i++) {
			tempTableCard.add(tableCard.get(i));
		}
	}
	
	public static void shuffleTableCard() {
		Collections.shuffle(tempTableCard);
	}
	
//	For reference: 
//	update points
	
//	GameFlow.playerArrList.get(0).setPoint(var point);
	
//	for (int i = 0 ; i < GameFlow.playerArrList.size(); i++) {
//		System.out.println(GameFlow.playerArrList.get(i).getPoint());
//	}
	
	
	
	
}
