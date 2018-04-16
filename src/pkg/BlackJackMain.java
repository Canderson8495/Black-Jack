package pkg;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;




import javafx.scene.text.Text;
import javafx.stage.Stage;


public class BlackJackMain extends Application{
	@Override
	public void start(Stage primaryStage) {
		StackPane pane = new StackPane();
		HBox hBox = new HBox();
		VBox vBox = new VBox();
		Player player = new Player();
		String playerMoney = Integer.toString(player.getMoney());
		GameMaster gm = new GameMaster();
		String gmPot = Integer.toString(gm.getPot());


		hBox.setSpacing(10);
		hBox.setAlignment(Pos.CENTER);
		vBox.setAlignment(Pos.BOTTOM_RIGHT);
		Button hit = new Button("Hit");
		Button fold = new Button("Fold");
		Button hold = new Button("Hold");
		Button bet = new Button("Bet");
		Label money = new Label(playerMoney);
		Label pot = new Label(gmPot);
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
				gm.play();

			}
		});
		hold.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				
				//Busting is essentially the same folding, you won't be considered for any financial holdings, and you want be able to participate in the following rounds.
				//As of now NPCs do not have functionality to bet, so this button will have minimal functionality.
				gm.players[0].setHold(true);
				//Gm.play() will then process through the AI's turns.
				gm.play();

			}
		});
		hit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				
				//Busting is essentially the same folding, you won't be considered for any financial holdings, and you want be able to participate in the following rounds.
				//As of now NPCs do not have functionality to bet, so this button will have minimal functionality.
				gm.players[0].addCard(gm.deck.dealCard());
				//Gm.play() will then process through the AI's turns.
				gm.play();

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
