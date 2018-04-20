/*
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

package pkg;
import java.util.ArrayList;
import java.util.Random;
public class Deck {
	//Might put these 4 together into a 1-50 type of deck, because it'll be easier that way.
	private ArrayList<Card> deck = new ArrayList<Card>();
	
	public Deck() {
		for(int x = 0; x < 4; x++) {
			Card tmp = new Card();
			switch(x) {
			case 0:
				tmp.setSuit("Diamond");
				break;
			case 1:
				tmp.setSuit("Heart");
				break;
			case 2:
				tmp.setSuit("Club");
				break;
			case 3:
				tmp.setSuit("Spade");
				break;
			}
			for(int s = 1; s <= 13; s++) {
				deck.add(new Card(tmp.getSuit(), s));
			}
		}
		shuffle();
	}
	
	public Card dealCard() {
		Card tmp = deck.get(0);
		deck.remove(0);
		return tmp;
	}
	public Card dealCard(boolean hidden) {
		Card tmp = deck.get(0);
		tmp.setHidden(true);
		deck.remove(0);
		return tmp;
	}
	
	public void shuffle() {
		Random rng = new Random();
		Card tmp;
		for(int x = 0; x < 100; x++) {
			tmp = deck.get(0);
			int changed = rng.nextInt(deck.size());
			deck.set(0, deck.get(changed));
			deck.set(changed, tmp);
		}
	}

}
