import java.util.ArrayList;

public class CardList {

	// ArrayList
	static ArrayList<String> cardList = new ArrayList<String>();

	// Add card list
	public static void addList() {
		for (int i = 0; i < 84; i++) {
			cardList.add("/resources/images/dixit_cards/" + (i + 1) + ".png");
		}
	}

	// Setter
	public void setCardList(ArrayList cardList) {
		this.cardList = cardList;
	}

	// Getter
	public ArrayList getList() {
		return cardList;
	}
}

