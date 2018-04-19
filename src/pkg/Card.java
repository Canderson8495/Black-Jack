package pkg;
import java.io.File;

import javafx.scene.image.Image;
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
		File file = new File("C:\\Code\\Java\\Black-Jack\\src\\images\\"+suit.charAt(0)+value+".png");
		Image image = new Image(file.toURI().toString());
		ImageView iv = new ImageView(image);
		return iv;
	}
	@Override
	public String toString() {
		return "Card [value=" + value + ", suit=" + suit + "]";
	}
}
