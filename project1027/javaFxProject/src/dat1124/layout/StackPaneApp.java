package dat1124.layout;

import java.awt.Dimension;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

//Stack 구조로 쌓을 수 있는 레이아웃, AWT의 CardLayout과 동일한 기능 (우린 페이지 전환을 직접 제작하여 사용하지 않았음)
public class StackPaneApp extends Application{
	public void start(Stage stage) throws Exception {
		StackPane parent = new StackPane();
		
		Button [] bt = new Button[4];
		
		for(int i=0; i<bt.length; i++) {
			bt[i] = new Button(i+"버튼");
			bt[i].setPrefWidth(300-(i*30));
			bt[i].setPrefHeight(300-(i*30));
			parent.getChildren().add(bt[i]);
		}
		
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
