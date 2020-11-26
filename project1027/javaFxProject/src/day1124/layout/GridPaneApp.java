package day1124.layout;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//swing의 GridLayout과 같이 행,열로 구성 다만, 생성자인자는 없고 부착시 행,열이 결정됨
public class GridPaneApp extends Application {

	public void start(Stage stage) throws Exception {
		GridPane parent = new GridPane();
		
		Button [] bt = new Button[6];
		for(int i=0; i<bt.length; i++) {
			bt[i] = new Button(i+"번");
			bt[i].setPrefWidth(100);
			bt[i].setPrefHeight(100);
		}
		
		for(int i=0, k=0; i<2; i++) {
			for(int j=0; j<3; j++, k++) {
				parent.add(bt[k], j, i);
			}
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
