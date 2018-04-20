package pkg;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

/*
 * SWITCH STATEMENTS CASES
 * 1 - Ace
 * 2 - 2
 * 3 - 3
 * 4 - 4
 * 5 - 5
 * 6 - 6
 * 7 - 7
 * 8 - 8
 * 9 - 9
 * 10 - 10
 * 11 - Jack
 * 12 - Queen
 * 13 - King
 */


public class Hand {
	private ArrayList<Card> hand = new ArrayList<Card>();
	int sum;
	
	public void addCard(Card card) {
		hand.add(card);
		//Constantly adds the new Card to a running sum;
		//TODO: Add compatiblity for Ace, and face cards.
	
		switch(card.getValue()) {
		case 1: 
			sum += 1;
			break;
		case 2: 
			sum += 2;
			break;
		case 3:
			sum += 3;
			break;
		case 4:
			sum += 4;
			break;
		case 5:
			sum += 5;
			break;
		case 6:
			sum += 6;
			break;
		case 7:
			sum += 7;
			break;
		case 8:
			sum += 8;
			break;
		case 9:
			sum += 9;
			break;
		case 10:
			sum += 10;
			break;
		case 11:
			sum += 10;
			break;
		case 12:
			sum += 10;
			break;
		case 13:
			sum += 10;
			break;


		}

		
	}
	public void resetHand() {
		hand.clear();
	}
	public int getSum() {
		return sum;
		
	}
	public void setSum(int sum) {
		this.sum = sum;
		
	}
	private void addSum(int sum) {
		this.sum += sum;
	}
	public Card getCard(int index) {
		return hand.get(0);
	}
	public ArrayList<Card> getCards() {
		return hand;
		
	}
	public Group getHandImage() {
		Group handGroup = new Group();
		for(int x = 0; x < hand.size(); x++) {
			ImageView iv = hand.get(x).getCardImage();
			iv.setX(x*50);
			handGroup.getChildren().add(iv);
		}
		return handGroup;
	}
	public Group getHandImage(boolean hidden) {
		Group handGroup = new Group();
		for(int x = 1; x < hand.size(); x++) {
			ImageView iv = hand.get(x).getCardImage();
			iv.setX(x*50);
			handGroup.getChildren().add(iv);
		}
		return handGroup;
	}
}
