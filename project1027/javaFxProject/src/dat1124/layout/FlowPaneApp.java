package dat1124.layout;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

//AWT의 FlowLayout과 같은 기능 (공간이 부족할경우 다음행으로..) , TilePane과 같아보이지만, 요소들의 크기를 달리할 수 있다는 점에서 다름
public class FlowPaneApp extends Application{

	public void start(Stage stage) throws Exception {
		FlowPane parent = new FlowPane(Orientation.VERTICAL, 10, 10); // Orientation , margin 
		
		Button [] bt = new Button[10];
		
		for(int i=0; i<bt.length; i++) {
			bt[i] = new Button(i+"버튼");
			bt[i].setPrefSize(100+(i*5), 100+(i*5));
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
