package day1124.layout;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

//absolute (절대위치) 지정 pane
public class AnchorPaneApp extends Application {
	public void start(Stage stage) throws Exception {
		System.out.println(Thread.currentThread().getName() + "\t start 호출");
		
		AnchorPane parent = new AnchorPane(); // absolute (절대위치) 지정 pane
		
		
		Button bt1 = new Button("버튼1");
		Button bt2 = new Button("버튼2");
		Button bt3 = new Button("버튼3");
		
		parent.getChildren().add(bt1);
		parent.getChildren().add(bt2);
		parent.getChildren().add(bt3);
		
		bt1.setLayoutX(0);
		bt1.setLayoutY(50);
		bt2.setLayoutX(200);
		bt2.setLayoutY(50);
		bt3.setLayoutX(400);
		bt3.setLayoutY(50);
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
