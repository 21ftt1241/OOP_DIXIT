import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GameFlow {

	public static int totalPlayer, turn=0;
	public String pName, pClr;
	public int pPoint;
	public Color pClr1;
	
	
	
	static ArrayList<GameFlow> playerArrList = new ArrayList<GameFlow>();
	
	
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
	
	public static void shuffleCard() {
		Collections.shuffle(playerArrList);
	}
	
	
	
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
	
	
//	For reference: 
//	update points
	
//	GameFlow.playerArrList.get(0).setPoint(var point);
	
//	for (int i = 0 ; i < GameFlow.playerArrList.size(); i++) {
//		System.out.println(GameFlow.playerArrList.get(i).getPoint());
//	}
	
	
	
	
}
