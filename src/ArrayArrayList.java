import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.Border;

import java.util.Collections;

public class ArrayArrayList extends JPanel implements ActionListener {

	JButton[] imageBtn = new JButton[6];

	ArrayList<String> playerCard[] = new ArrayList[3];
	ArrayList<String> discardCard = new ArrayList<>();

	JLabel[] imageLabel = new JLabel[6];

	GridBagConstraints gb = new GridBagConstraints();

	public ArrayArrayList() {

		CardList.addList();

		Collections.shuffle(CardList.cardList);

		for(int i = 0; i < 3; i++){

			playerCard[i]=new ArrayList<>();

			for (int j = 0; j < 6; j++) {

				System.out.println("Card left: " + CardList.cardList.size());
				playerCard[i].add(CardList.cardList.get(0));
				CardList.cardList.remove(0);
			}
		}

		for (int i = 0; i < 6; i++) {
			System.out.println("Player[0] card " + i + ": " + playerCard[0].get(i));
		}

		//		for (int i = 0; i < 6; i++) {
		//			System.out.println("Player[1] card " + i + ": " + playerCard[1].get(i));
		//		}
		//		
		//		for (int i = 0; i < 6; i++) {
		//			System.out.println("Player[2] card " + i + ": " + playerCard[2].get(i));
		//		}

		setLayout(new GridBagLayout());
		setBackground(Color.WHITE);


		gb.anchor = GridBagConstraints.NORTH;

		for (int i = 0; i < 6; i++) {

			ImageIcon icon = new ImageIcon(getClass().getResource(playerCard[0].get(i)));
			imageLabel[i] = new JLabel(icon);
			imageBtn[i] = new JButton();
			imageBtn[i].setPreferredSize(new Dimension(180,400));
			imageBtn[i].add(imageLabel[i]);
			imageBtn[i].addActionListener(this);

			gb.insets = new Insets(0,10,0,10);

			add(imageBtn[i], gb);

		}
	}
	

	@Override
	public void actionPerformed(ActionEvent btnClick) {
		// TODO Auto-generated method stub

		// Remove Highlight

		for (int i = 0; i < 6; i++) {
			Border emptyBorder = BorderFactory.createEmptyBorder();
			imageBtn[i].setBorder(emptyBorder);
		}

		// Highlight

		for (int i = 0; i < 6; i++) {
			if(btnClick.getSource() == imageBtn[i]) {

				discardCard.add(playerCard[0].get(i));
				playerCard[0].remove(i);
				playerCard[0].add(CardList.cardList.get(0));
				CardList.cardList.remove(0);

				for (int i2 = 0; i2 < 6; i2++) {
					ImageIcon icon = new ImageIcon(getClass().getResource(playerCard[0].get(i2)));
					imageLabel[i2].setIcon(icon);
				}


				System.out.println("Player 1 hand: " + playerCard[0].size());
				System.out.println("Discard card: " + discardCard.size());
				for (int i2 = 0; i2 < 6; i2++) {
					System.out.println("Player[0] card " + i2 + ": " + playerCard[0].get(i2));
				}
				for (int i3 = 0; i3 < discardCard.size(); i3++) {
					System.out.println("Discard card " + i3 + ": " + discardCard.get(i3));
				}
				//				System.out.println("Discard card 0 name: " + discardCard.get(0));
				//				System.out.println("Discard card 1 name: " + discardCard.get(1));
				//				System.out.println("Discard card 2 name: " + discardCard.get(2));
				//				System.out.println("Discard card 3 name: " + discardCard.get(3));
				//				System.out.println("Discard card 4 name: " + discardCard.get(4));
				//				System.out.println("Discard card 5 name: " + discardCard.get(5));
				//				System.out.println("Discard card 6 name: " + discardCard.get(6));

				imageBtn[i].setBorder(BorderFactory.createCompoundBorder(
						BorderFactory.createLineBorder(Color.CYAN, 5),
						BorderFactory.createEmptyBorder(
								imageBtn[i].getBorder().getBorderInsets(imageBtn[i]).top,
								imageBtn[i].getBorder().getBorderInsets(imageBtn[i]).left,
								imageBtn[i].getBorder().getBorderInsets(imageBtn[i]).bottom,
								imageBtn[i].getBorder().getBorderInsets(imageBtn[i]).right)));

				imageBtn[i].setBackground(Color.GRAY);
			}
		}
	}
}
