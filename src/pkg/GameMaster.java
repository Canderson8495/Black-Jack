
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
	int runningBet = 0;
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
		if(currentWinner != -1) {
			players[currentWinner].addMoney(pot);
			pot = 0;
		}
		//resetting pot;
		newRound();
		return currentWinner;
	}
	public void play(int x) {
		Random rng = new Random();
		//for(int x = 1; x < players.length;x++) {
			if(players[x].isHold() || players[x].isBust()) {
			}else {
				if(players[x].getHand().getSum()<17 && rng.nextInt()%5!=0) {
					players[x].addCard(deck.dealCard());
					
				}else {
					players[x].setHold(true);
				}
				if(runningBet > 0) {
					pot += players[x].bet(runningBet);
				}
			}
		//}
	}
	public int winner() {
		int winner = -1;
		int max = 0;
		for(int x = 0; x < players.length; x++) {
			if(players[x].isBust() == false && players[x].getHand().getSum() > max) {
				max = players[x].getHand().getSum();
				winner = x;
			}
		}
	
		return winner;
	}
	public void newRound() {
		//Shuffles
		deck.shuffle();
		//Takes card from top and places into players hand
		for(int x = 0; x < players.length; x++) {
			//Probable cause of bug if hand of player is not passed directly to this class for immediate adjustments like javafx.getChildren.add();
			deck = new Deck();
			players[x].setHand(new Hand());
			players[x].getHand().addCard(deck.dealCard(true));
			players[x].getHand().addCard(deck.dealCard());
			players[x].setHold(false);
			players[x].setBust(false);
			players[x].bet(ante);
		}
		players[0].getHand().getCard(0).setHidden(false);
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
	public boolean checkEnd() {
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
			System.out.println("PLAYER " + winner() + " IS THE WINNER");
		}
		return end;
	}
}

