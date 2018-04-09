package pkg;
//We need to add a implement playable vs nonplayable- non playable adding the logic.
public class Player {
	private boolean bust = false;
	private int pot;
	private Hand hand;
	//Player has a pot.
	//Player can be a NPC or a PC. 
	//Player can have a hand that can have cards added and removed.
	//Player can bet
	public int bet(int bet) {
		try {
			if(pot < bet) {
				throw new Exception("Pot can't go below zero");
			}else {
				pot -= bet;
			}
			return bet;
		}catch(Exception e) {
			System.out.println(e);
			return -1;
		}
	}
	public void addMoney(int money) {
		this.pot += money;
	}
}
