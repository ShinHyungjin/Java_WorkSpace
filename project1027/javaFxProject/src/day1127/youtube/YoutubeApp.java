package day1127.youtube;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class YoutubeApp extends Application{


	public void start(Stage stage) throws Exception {
		BorderPane border = (BorderPane)FXMLLoader.load(this.getClass().getClassLoader().getResource("day1127/youtube/layout.fxml"));
		
		showWindow(stage, border);
		
		}
		
		public void showWindow(Stage stage, Parent parent) {
			// Window 안에는 무조건 Scene 이라 불리는 컨테이너가 와야함 1윈도우 1씬
			Scene s = new Scene(parent);

			stage.setScene(s);

			stage.setWidth(500);
			stage.setHeight(500);
			stage.show();
		}
		
		public static void main(String[] args) {
			launch(args);
		}
}
