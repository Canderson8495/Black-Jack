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
public class Deck {
	ArrayList<Integer> clubs = new ArrayList<Integer>();
	ArrayList<Integer> spades = new ArrayList<Integer>();
	ArrayList<Integer> hearts = new ArrayList<Integer>();
	ArrayList<Integer> diamonds = new ArrayList<Integer>();
	public Deck() {
		for(int x = 1; x <= 13; x++) {
			clubs.add(x);
			spades.add(x);
			hearts.add(x);
			diamonds.add(x);
		}
	}
	
}
