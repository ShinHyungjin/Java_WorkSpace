package dat1124.layout;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class PaneTest extends Application{
	public void start(Stage stage) throws Exception {
		
		FlowPane parent = new FlowPane(10,20);
		
		TextField tf = new TextField();
		Button bt = new Button("버튼");
		TextArea ta = new TextArea();
		
		tf.setPrefSize(370, 50);
		bt.setPrefSize(100, 50);
		ta.setPrefSize(480, 390);
		
		parent.getChildren().add(tf);
		parent.getChildren().add(bt);
		parent.getChildren().add(ta);
		
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
