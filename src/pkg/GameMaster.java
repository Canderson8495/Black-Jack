
package pkg;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
public class GameMaster {
	//IntegerProperty
	
	
	public static int ante = 25;
	//I need to make this accessible to the BlackJack Main class. That can be either through making it public or adding some get functions.
	public Player[] players = new Player[4]; 
	//implement encapsulation for this if there is time.
	public Deck deck = new Deck();
	public int getRunningBet() {
		return runningBet;
	}
	public void setRunningBet(int runningBet) {
		this.runningBet = runningBet;
	}
	private int pot;
	int runningBet;
	public GameMaster() {
		//This for loop initialized all players in "players" array with the no arg constructor of Player Class.
		//The no arg constructor of Player Class intializes the player object with 1000 units of money
		for(int x = 0; x < players.length; x++) {
			players[x] = new Player();
		}
	}
	//CalculateWin will return the player who won, it will automatically give pot to winner.
	public int calculateWin() {
		int currentWinner = -1;
		int max = 0;
		for(int x = 0; x < players.length; x++) {
			if(players[x].isBust() == false && players[x].getHand().getSum() > max) {
				max = players[x].getHand().getSum();
				currentWinner = x;
			}
		}
		//Giving pot to Winner
		players[currentWinner].addMoney(pot);
		//resetting pot;
		pot = 0;
		newRound();
		System.out.println(currentWinner);
		return currentWinner;
	}
	public void play() {
		Random rng = new Random();
		for(int x = 1; x < players.length;x++) {
//			try {
//				TimeUnit.SECONDS.sleep(1);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			System.out.println("Player " + x + " " +players[x].getHand().getSum());
			if(players[x].isHold() || players[x].isBust()) {
			}else {
				if(players[x].getHand().getSum()<17 && rng.nextInt()%5!=0) {
					players[x].addCard(deck.dealCard());
					System.out.println("Dealing player " + x);
					
				}else {
					players[x].setHold(true);
					System.out.println("Player " + x + " is holding");
				}
				if(runningBet > 0) {
					players[x].bet(runningBet);
				}
			}
		}
		runningBet = 0;
		checkEnd();
	}
	public void newRound() {
		//Shuffles
		deck.shuffle();
		//Takes card from top and places into players hand
		for(int x = 0; x < players.length; x++) {
			//Probable cause of bug if hand of player is not passed directly to this class for immediate adjustments like javafx.getChildren.add();
			deck = new Deck();
			players[x].setHand(new Hand());
			players[x].getHand().addCard(deck.dealCard());
			players[x].getHand().addCard(deck.dealCard());
			players[x].setHold(false);
			players[x].setBust(false);
			players[x].bet(ante);
		}
	}
	public int getPot() {
		return pot;
	}
	public void addPot(int money) {
		pot += money;
	}
	public void setPot(int money) {
		pot = money;
	}
	public void checkEnd() {
		boolean end = true;
		for(int x = 0; x < players.length; x++) {
			if(players[x].isBust() || players[x].isHold()) {
			}else {
				end = false;
				break;
			}
		}
		if(end) {
			System.out.println("ROUND OVER!!!!!!!!!!!!!!!!!!!");
			calculateWin();
		}
	}
}

