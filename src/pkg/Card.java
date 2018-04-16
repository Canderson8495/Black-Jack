package pkg;
import javafx.scene.image.ImageView;

//This is essentially just a struct with a constructor
public class Card {
	private int value;
	private String suit;
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public Card() {}
	public Card(String suit, int value) {
		this.suit = suit;
		this.value = value;
	}
	public ImageView getCardImage() {
		//Return a card image with designated suit.
		return new ImageView();
	}
	@Override
	public String toString() {
		return "Card [value=" + value + ", suit=" + suit + "]";
	}
}
