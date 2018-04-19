package pkg;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.ContentDisplay;




import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.*;

public class BlackJackMain extends Application{
	GameMaster gm = new GameMaster();
	Group hand1 = new Group();
	Group hand2 = new Group();
	Group hand3 = new Group();
	Group hand4 = new Group();
	StackPane pane = new StackPane();
	BorderPane playerPane = new BorderPane();
	Label p1 = new Label();
	Label p2 = new Label();
	Label p3 = new Label();
	Label p4 = new Label();
	
	@Override
	public void start(Stage primaryStage) {
		
		gm.newRound();
		HBox controls = new HBox();
		VBox vBox = new VBox();
		String gmPot = Integer.toString(gm.getPot());
		System.out.println(gm.deck.dealCard());
		

		controls.setSpacing(10);
		controls.setAlignment(Pos.CENTER);
		vBox.setAlignment(Pos.BOTTOM_RIGHT);
		Button hit = new Button("Hit");
		Button fold = new Button("Fold");
		Button hold = new Button("Hold");
		Button bet = new Button("Bet");
		Label money = new Label(Integer.toString(gm.players[0].getMoney()));
		Label pot = new Label(gmPot);

		p1.setText("Player 1: " + gm.players[0].getHand().getSum());
		p2.setText("Player 2: " + gm.players[1].getHand().getSum());
		p3.setText("Player 3: " + gm.players[2].getHand().getSum());
		p4.setText("Player 4: " + gm.players[3].getHand().getSum());
		p1.setTranslateY(100);
		p2.setTranslateX(100);
		p3.setTranslateY(-100);
		p4.setTranslateX(-100);
		hand1 = gm.players[0].getHand().getHandImage();
		hand2 = gm.players[1].getHand().getHandImage();
		hand3 = gm.players[2].getHand().getHandImage();
		hand4 = gm.players[3].getHand().getHandImage();


		money.setMinWidth(50);
		
		TextField betAmount = new TextField(); 
		betAmount.setPromptText("$");
		betAmount.setPrefColumnCount(3);
		controls.getChildren().add(bet);
		controls.getChildren().add(hit);
		controls.getChildren().add(hold);
		controls.getChildren().add(fold);
		vBox.getChildren().add(money);
		vBox.getChildren().add(betAmount);
		pane.getChildren().add(pot);
		pane.getChildren().addAll(p1,p2,p3,p4,hand1,hand2,hand3,hand4);
		hand1.setTranslateY(300);
		hand2.setTranslateX(300);
		hand3.setTranslateY(-300);
		hand4.setTranslateX(-300);
		


		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(pane);
		borderPane.setBottom(controls);
		borderPane.setRight(vBox);
		BorderPane.setAlignment(controls, Pos.CENTER);
		
		Scene scene = new Scene(borderPane, 500, 500);
		primaryStage.setTitle("BlackJack");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		//Button Actions
		
		bet.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				gm.addPot(gm.players[0].bet(Integer.parseInt(betAmount.getText())));
				money.setText(Integer.toString(gm.players[0].getMoney()));
				pot.setText(Integer.toString(gm.getPot()));
				//Gm.play() will then process through the AI's turns.


			}
		});
		fold.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				
				//Busting is essentially the same folding, you won't be considered for any financial holdings, and you want be able to participate in the following rounds.
				//As of now NPCs do not have functionality to bet, so this button will have minimal functionality.
				gm.players[0].setBust(true);
				//Gm.play() will then process through the AI's turns.
				money.setText(Integer.toString(gm.players[0].getMoney()));
				pot.setText(Integer.toString(gm.getPot()));
				playAI();
				

			}
		});
		hold.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				
				//Busting is essentially the same folding, you won't be considered for any financial holdings, and you want be able to participate in the following rounds.
				//As of now NPCs do not have functionality to bet, so this button will have minimal functionality.
				gm.players[0].setHold(true);
				//Gm.play() will then process through the AI's turns.
				money.setText(Integer.toString(gm.players[0].getMoney()));
				pot.setText(Integer.toString(gm.getPot()));
				playAI();

			}
		});
		hit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				
				//Busting is essentially the same folding, you won't be considered for any financial holdings, and you want be able to participate in the following rounds.
				//As of now NPCs do not have functionality to bet, so this button will have minimal functionality.
				gm.players[0].addCard(gm.deck.dealCard());
				System.out.println("The sum of player is " + gm.players[0].getHand().getSum());
				//Gm.play() will then process through the AI's turns.
				money.setText(Integer.toString(gm.players[0].getMoney()));
				pot.setText(Integer.toString(gm.getPot()));
				playAI();
			}
		});

		
	}
	public void playAI() {
		try {
			
			pane.getChildren().remove(0);
			hand1 = gm.players[0].getHand().getHandImage();
			pane.getChildren().add(hand1);
			p1.setText("Player 1: " + gm.players[0].getHand().getSum());
			gm.play(1);
			Thread.sleep(1000);
			pane.getChildren().remove(0);
			hand2 = gm.players[1].getHand().getHandImage();
			pane.getChildren().add(hand2);
			p2.setText("Player 2: " + gm.players[1].getHand().getSum());
			gm.play(2);
			Thread.sleep(1000);
			pane.getChildren().remove(0);
			hand3 = gm.players[2].getHand().getHandImage();
			pane.getChildren().add(hand3);
			p3.setText("Player 3: " + gm.players[2].getHand().getSum());
			gm.play(3);
			Thread.sleep(1000);
			pane.getChildren().remove(0);
			hand4 = gm.players[3].getHand().getHandImage();
			pane.getChildren().add(hand4);
			p4.setText("Player 4: " + gm.players[3].getHand().getSum());
			hand1.setTranslateY(300);
			hand2.setTranslateX(300);
			hand3.setTranslateY(-300);
			hand4.setTranslateX(-300);
			gm.checkEnd();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
