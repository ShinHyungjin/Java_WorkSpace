package day1123.fxtest;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class test extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
			BorderPane b = new BorderPane();
			Button bt = new Button();
			
			bt.setText("클릭 전");
			bt.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					bt.setText("클릭 후");
				}
			});
			
			b.setCenter(bt);
			Scene s = new Scene(b, 300,250);
			primaryStage.setScene(s);
			primaryStage.setTitle("eventBt");
			primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
