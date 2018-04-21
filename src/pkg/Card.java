package pkg;
import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//This is essentially just a struct with a constructor
public class Card {
	private boolean hidden;
	public boolean isHidden() {
		return hidden;
	}
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
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
	public Card(boolean hidden) {
		this.hidden = hidden;
	}
	public ImageView getCardImage() {
		File file = new File("C:\\Users\\PC\\Documents\\GitHub\\Black-Jack\\src\\images\\"+suit.charAt(0)+value+".png");
		if(hidden)
			file = new File("C:\\Users\\PC\\Documents\\GitHub\\Black-Jack\\src\\images\\back.png");
		Image image = new Image(file.toURI().toString());
		ImageView iv = new ImageView(image);
		iv.setFitHeight(250);
		iv.setFitWidth(200);
		return iv;
	}
	@Override
	public String toString() {
		return "Card [value=" + value + ", suit=" + suit + "]";
	}
}
