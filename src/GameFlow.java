import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GameFlow {

	public static int totalPlayer, turn=0;
	public String pName, pClr;
	public int pPoint;
	public Color pClr1;
	
	
	
	static ArrayList<GameFlow> s = new ArrayList<GameFlow>();
	
	
	public GameFlow(String name, String color, Color color1, int point) {
		pName = name;
		pClr = color;
		pClr1 = color1;
		pPoint = point;
	}
	
	// Test
	public static void test1() {
		
		for (int i = 0 ; i < s.size(); i++) {
			System.out.print(s.get(i).getNameArr());
			System.out.print(" " + s.get(i).getClrArr());
			System.out.print(" " + s.get(i).getPoint());
			System.out.println();
		}
		
		
	}
	
	public static void shuffleCard() {
		Collections.shuffle(s);
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
	
	
	// methods for Player Select
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
		
		pName = PlayerSelect.name; 
		pClr = PlayerSelect.color;
		pClr1 = PlayerSelect.color1;
		
		s.add(new GameFlow(pName,pClr, pClr1, pPoint));
	}

	
	
	
	
	
	// Methods for STTurn
	
	public static void setLabel1() {
		
		
	}
	
//	For reference: 
//	update points
	
//	GameFlow.s.get(0).setPoint(var point);
	
//	for (int i = 0 ; i < GameFlow.s.size(); i++) {
//		System.out.println(GameFlow.s.get(i).getPoint());
//	}
	
	
	
	
}
