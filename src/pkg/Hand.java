package pkg;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> hand = new ArrayList<Card>();
	int sum;
	
	public void addCard(Card card) {
		hand.add(card);
		//Constantly adds the new Card to a running sum;
		//TODO: Add compatiblity for Ace, and face cards.
		addSum(card.getValue()+1);
		
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
