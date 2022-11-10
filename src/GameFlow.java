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
	public static String wName, wClr;
	
	
	
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
	
	public static void resetPlayer() {
		for (int i = 0 ; i < totalPlayer ; i++) {
			playerArrList.remove(0);
		}
		
	}
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
	
	
	public static void cardChecker() {
		
		for (int i = 0 ; i < totalPlayer; i++) {
			
			for (int j = 0 ; j < totalPlayer ; j++) {
				
				if (playerArrList.get(i).getPC().equals(playerArrList.get(j).getVC())) {
					playerArrList.get(i).setCC(playerArrList.get(i).getCC() + 1);
				}
			}
		}
	}
	
	public static void pointCalc() {
		
		// 1. For loop to allocate marks for the players
		for (int i = 0 ; i < totalPlayer ; i++) {	
			
			// 2.1. The following if is used to check if the player is a ST
			if (playerArrList.get(i).getPC().equals(stCard)) {
				
				// 3.1. Check if everyone has voted for the ST card or none at all
				if (playerArrList.get(i).getCC() == (totalPlayer-1) || playerArrList.get(i).getCC() == 0) {
					
					System.out.println(playerArrList.get(i).getCC());
					System.out.println("dpt masuk ke test");
					
					// Loop to allocate marks for the voter
					for (int k = 0 ; k < totalPlayer ; k++) {
						
						if (playerArrList.get(k).getPC().equals(stCard)) {
							continue;
						}
						else {
							// 2 points for everyone
							playerArrList.get(k).setPoint(playerArrList.get(k).getPoint()+2);
						}
					}				
				}
				
				// 3.2. If not everyone voted for the ST card
				else {
					
					// ST receiving points for being voted atleast once
					playerArrList.get(i).setPoint(playerArrList.get(i).getPoint()+3);
					System.out.println("dapat add point here");
					
					// Loop to allocate marks for voter
					for (int k = 0 ; k < totalPlayer ; k++) {

						// Points added for voter
						if (playerArrList.get(k).getVC().equals(stCard)) {
							playerArrList.get(k).setPoint(playerArrList.get(k).getPoint()+3);
						}
					}
				}
			}
		}
		
		// 4. This loop is to add additional 1 point if others voted for their card
		for (int l = 0 ; l < totalPlayer ; l++) {
			
			if (playerArrList.get(l).getPC().equals(stCard)) {
				continue;
			}
			
			else {
				
				for (int l1 = 0 ; l1 < totalPlayer; l1++) {
					
					if (playerArrList.get(l).getPC().equals(playerArrList.get(l1).getVC())) {
						playerArrList.get(l).setPoint(playerArrList.get(l).getPoint()+1);
					}
				}
			}
		}
		
		for (int k = 0 ; k < totalPlayer ; k++) {
			playerArrList.get(k).setCC(0);
		}
	}
	
	public static void pointChecker() {
		
		dialogPU dialog = new dialogPU();
		
		int highest = 0;
		// winner
		
		
		
		for (int i = 0 ; i < totalPlayer ; i++) {

			if (playerArrList.get(i).getPoint() > 30) {
				
				if (playerArrList.get(i).getPoint() > highest) {
					highest = playerArrList.get(i).getPoint();
					wName = playerArrList.get(i).getNameArr();
					wClr = playerArrList.get(i).getClrArr();
				}
				
				dialog.dialogEnd();
			}
		}
	}
	
	public static void addClrToPLV() {
		for (int i = 0 ; i < totalPlayer ; i++) {
			
			for (int j = 0 ; j < totalPlayer ; j++) {
				if (playerArrList.get(i).getPC().equals(tempTableCard.get(j))) {
					STTurn.plVoting[j].setBackground(playerArrList.get(i).getClr1Arr());
				}
			}
		}
	}
	
	
	
	public static void addClrToVoter() {
		for (int i = 0 ; i < totalPlayer ; i++) {
			
			for (int j = 0 ; j < totalPlayer ; j++) {
				
				if (playerArrList.get(i).getVC().equals(tempTableCard.get(j))) {
					STTurn.voters[j].setBackground(playerArrList.get(i).getClr1Arr());
				}
				
				
				
			}
		}
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
	
	
	public static void checkss() {
		
//		for (int i = 0 ; i < totalPlayer; i++) {
//			System.out.println(playerArrList.get(i).getNameArr() + " " + 
//					playerArrList.get(i).getClrArr() + " " +
//					playerArrList.get(i).getClr1Arr() + " " +
//					playerArrList.get(i).getPoint() + " [PC: " +
//					playerArrList.get(i).getPC() + "] [VC: " +
//					playerArrList.get(i).getVC() + "] " +
//					playerArrList.get(i).getCC());
//		}
		
		for (int i = 0 ; i < totalPlayer; i++) {
			System.out.println(playerArrList.get(i).getNameArr() + ": " + playerArrList.get(i).getPoint() + " points.");
		}
		
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
			STTurn.enablePlayerInfo();
			STTurn.updatePlayerInfo();
			page = 2;
			
		}
		
		// Text
		else if (page == 2) {
			STTurn.displayPlayerCards();
			STTurn.setLabel2();
			STTurn.displayPage1();
			STTurn.disablePlayerInfo();
			STTurn.updatePlayerInfo();
			page = 1;
			
		}
		
		
	}
	
	public static void pageChecker1() {
		
		// Card
		if (page == 1) {
			STTurn.displayPage2();
			STTurn.enablePlayerInfo();
			page = 2;
			
		}
		
		// Text
		else if (page == 2) {
			STTurn.setLabel3();
			STTurn.displayPage1();
			STTurn.disablePlayerInfo();
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
		playerArrList.get(turn).setPC(playerHand[turn].get(tempCard));
		tableCard.add(playerHand[turn].get(tempCard));
		playerHand[turn].remove(tempCard);
	}
	
	public static void storeIntoVC() {
		
		int tempCard = STTurn.tempCard;
		playerArrList.get(turn).setVC(tempTableCard.get(tempCard));
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
