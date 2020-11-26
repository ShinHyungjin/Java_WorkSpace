package day1124.layout;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

// 동일한 크기의 셀을 갖는 배치방법
public class TilPaneApp extends Application{
	
	public void start(Stage stage) throws Exception {
		TilePane parent = new TilePane(Orientation.VERTICAL,10,5); // (ver버-직or ho호-평,가로 10px, 세로 5px 씩 margin)
	
		Button [] bt = new Button[100];
		
		for(int i=0; i<bt.length; i++) {
			bt[i] = new Button(i+"버튼");
			bt[i].setPrefSize(100, 100);
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
