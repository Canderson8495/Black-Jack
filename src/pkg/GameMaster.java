package pkg;
public class GameMaster {
	public static int ante = 25;
	//I need to make this accessible to the BlackJack Main class. That can be either through making it public or adding some get functions.
	public Player[] players = new Player[4]; 
	private Deck deck = new Deck();
	public GameMaster() {
		//This for loop initialized all players in "players" array with the no arg constructor of Player Class.
		//The no arg constructor of Player Class intializes the player object with 1000 units of money
		for(int x = 0; x < players.length; x++) {
			players[x] = new Player();
		}
	}
	public void play() {
		//Postponed until UI.
		//Logic for going through one round of turns.
	}
	public void newRound() {
		//Shuffles
		deck.shuffle();
		//Takes card from top and places into players hand
		for(int x = 0; x < players.length; x++) {
			//Probable cause of bug if hand of player is not passed directly to this class for immediate adjustments like javafx.getChildren.add();
			players[x].getHand().addCard(deck.dealCard());
			players[x].getHand().addCard(deck.dealCard());
			players[x].bet(ante);
		}
	}
}
