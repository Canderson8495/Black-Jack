package pkg;
//We need to add a implement playable vs nonplayable- non playable adding the logic.
public class Player {
	private boolean bust = false;
	private boolean hold = false;
	private int money;
	private Hand hand = new Hand();
	//Player has a money.
	//Player can be a NPC or a PC. 
	//Player can have a hand that can have cards added and removed.
	//Player can bet
	public int bet(int bet) {
		try {
			if(money < bet) {
				throw new Exception("money can't go below zero");
			}else {
				money -= bet;
			}
			return bet;
		}catch(Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	public boolean isHold() {
		return hold;
	}
	public void setHold(boolean hold) {
		this.hold = hold;
	}
	public void addMoney(int money) {
		this.money += money;
	}
	
	
	//ToDo add logic for a NPC betting and using hit feature.
	
	
	
	public boolean isBust() {
		return bust;
	}
	public void setBust(boolean bust) {
		this.bust = bust;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public Hand getHand() {
		return hand;
	}
	public void setHand(Hand hand) {
		this.hand = hand;
	}
	
	public void addCard(Card card) {
		hand.addCard(card);
		System.out.println("WE GOT A CARD");
		if(hand.getSum()> 21) {
			System.out.println("Bust");
			bust = true;
		}
	}
	
	//CONSTRUCTOR
	public Player(int money, Hand hand) {
		super();
		this.money = money;
		this.hand = hand;
	}
	public Player(int money) {
		super();
		this.money = money;
	}
	public Player() {
		super();
		this.money = 1000;
	}
}
