package pkg;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class BlackJackMain extends Application{
	@Override
	public void start(Stage primaryStage) {
		StackPane pane = new StackPane();
		HBox hBox = new HBox();
		VBox vBox = new VBox();
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.CENTER);
		vBox.setAlignment(Pos.BOTTOM_RIGHT);
		Button hit = new Button("Hit");
		Button fold = new Button("Fold");
		Button bet = new Button("Bet");
		Text money = new Text("MOney");
	
		hBox.getChildren().add(bet);
		hBox.getChildren().add(hit);
		hBox.getChildren().add(fold);
		vBox.getChildren().add(money);

		
		
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
