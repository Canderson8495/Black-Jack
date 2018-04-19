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
	@Override
	public void start(Stage primaryStage) {
		StackPane pane = new StackPane();
		BorderPane playerPane = new BorderPane();
		
		HBox hBox = new HBox();
		VBox vBox = new VBox();
		Player player = new Player();
		String playerMoney = Integer.toString(player.getMoney());
		
		gm.newRound();
		String gmPot = Integer.toString(gm.getPot());
		System.out.println(gm.deck.dealCard());
		
		String player1 = Integer.toString(gm.players[0].getHand().getSum());
		String player2 = Integer.toString(gm.players[1].getHand().getSum());
		String player3 = Integer.toString(gm.players[2].getHand().getSum());
		String player4 = Integer.toString(gm.players[3].getHand().getSum());

		hBox.setSpacing(10);
		hBox.setAlignment(Pos.CENTER);
		vBox.setAlignment(Pos.BOTTOM_RIGHT);
		Button hit = new Button("Hit");
		Button fold = new Button("Fold");
		Button hold = new Button("Hold");
		Button bet = new Button("Bet");
		Label money = new Label(playerMoney);
		Label pot = new Label(gmPot);
		Label p1 = new Label("Player 1: " + player1);
	
		
		Label p2 = new Label("Player 2: " + player2);
		Label p3 = new Label("Player 3: " + player3);
		Label p4 = new Label("Player 4: " + player4);
		p1.setTranslateY(100);
		p2.setTranslateX(100);
		p3.setTranslateY(-100);
		p4.setTranslateX(-100);


		money.setMinWidth(50);
		
		TextField betAmount = new TextField(); 
		betAmount.setPromptText("$");
		betAmount.setPrefColumnCount(3);
		hBox.getChildren().add(bet);
		hBox.getChildren().add(hit);
		hBox.getChildren().add(hold);
		hBox.getChildren().add(fold);
		vBox.getChildren().add(money);
		vBox.getChildren().add(betAmount);
		pane.getChildren().add(pot);
		pane.getChildren().addAll(p1,p2,p3,p4);

		bet.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				gm.addPot(player.bet(Integer.parseInt(betAmount.getText())));
				money.setText(Integer.toString(player.getMoney()));
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
				money.setText(Integer.toString(player.getMoney()));
				pot.setText(Integer.toString(gm.getPot()));
				try {
					p1.setText("Player 1: " + gm.players[0].getHand().getSum());
					System.out.println("YOLO");
					gm.play(1);
					Thread.sleep(1000);
					p2.setText("Player 1: " + gm.players[1].getHand().getSum());
					gm.play(2);
					Thread.sleep(1000);
					p3.setText("Player 1: " + gm.players[2].getHand().getSum());
					gm.play(3);
					Thread.sleep(1000);
					p4.setText("Player 1: " + gm.players[3].getHand().getSum());
					gm.checkEnd();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		hold.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				
				//Busting is essentially the same folding, you won't be considered for any financial holdings, and you want be able to participate in the following rounds.
				//As of now NPCs do not have functionality to bet, so this button will have minimal functionality.
				gm.players[0].setHold(true);
				//Gm.play() will then process through the AI's turns.
				money.setText(Integer.toString(player.getMoney()));
				pot.setText(Integer.toString(gm.getPot()));
				try {
					p1.setText("Player 1: " + gm.players[0].getHand().getSum());
					System.out.println("YOLO");
					gm.play(1);
					Thread.sleep(1000);
					p2.setText("Player 1: " + gm.players[1].getHand().getSum());
					gm.play(2);
					Thread.sleep(1000);
					p3.setText("Player 1: " + gm.players[2].getHand().getSum());
					gm.play(3);
					Thread.sleep(1000);
					p4.setText("Player 1: " + gm.players[3].getHand().getSum());
					gm.checkEnd();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

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
				money.setText(Integer.toString(player.getMoney()));
				pot.setText(Integer.toString(gm.getPot()));
				try {
					p1.setText("Player 1: " + gm.players[0].getHand().getSum());
					gm.play(1);
					Thread.sleep(1000);
					p2.setText("Player 1: " + gm.players[1].getHand().getSum());
					gm.play(2);
					Thread.sleep(1000);
					p3.setText("Player 1: " + gm.players[2].getHand().getSum());
					gm.play(3);
					Thread.sleep(1000);
					p4.setText("Player 1: " + gm.players[3].getHand().getSum());
					gm.checkEnd();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		


		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(pane);
		borderPane.setBottom(hBox);
		borderPane.setRight(vBox);
		BorderPane.setAlignment(hBox, Pos.CENTER);
		
		Scene scene = new Scene(borderPane, 500, 500);
		primaryStage.setTitle("BlackJack");
		primaryStage.setScene(scene);
		primaryStage.show();

		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
