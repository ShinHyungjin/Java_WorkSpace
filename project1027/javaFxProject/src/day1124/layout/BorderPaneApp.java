package day1124.layout;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

// Swing의 border와 다를바없음
public class BorderPaneApp extends Application {
	

	public void start(Stage stage) throws Exception {
		BorderPane parent = new BorderPane();
		
		Button top = new Button("Top");
		Button right = new Button("Right");
		Button bottom = new Button("Bottom");
		Button left = new Button("Left");
		Button center = new Button("Center");
		
		parent.setTop(top);
		parent.setRight(right);
		parent.setBottom(bottom);
		parent.setLeft(left);
		parent.setCenter(center);
	
		showWindow(stage, parent);
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
