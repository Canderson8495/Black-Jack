package pkg;

import java.util.ArrayList;

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
		addSum(card.getValue());
		/*
		switch(card.getValue) {
		case 1: 
		case 2: 
			sum+= 2;
		}
		*/
		
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
}
