package dat1124.components;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class EventApp extends Application{
	Button bt;
	TextField t;
	ImageView imageView;
	
	public void start(Stage stage) throws Exception {
		bt = new Button("버튼");
		t = new TextField();
		imageView = new ImageView("https://www.urbanbrush.net/web/wp-content/uploads/edd/2018/11/urbanbrush-20181126042312829882.png");
		imageView.setFitWidth(200);
		imageView.setFitHeight(200);
		imageView.setPreserveRatio(true); // 비율 유지
		
		bt.setOnAction((e) -> {
			System.out.println(e.getSource() + "\t나 누름?");
		});
		
		t.setOnKeyReleased((e) -> {
			if(e.getCode() == KeyCode.ENTER) {
				System.out.println("Enter 누름!");
				t.setText("");
			} else {
				System.out.println(e.getCode() + " 누름" + e.getText() + " 나옴"); 
			}
		});
		imageView.setOnMouseClicked((e) -> {
			System.out.println(e.getTarget() + " 누름");
		});
		
		FlowPane parent = new FlowPane(bt,t,imageView); // 가변 매개변수 .. public void test(int... x) 배열로 인식
		
		
		showWindow(stage, parent);
		test(1,2,3,4,5,6);
	}
	
	public void test(int... x) {
		System.out.println(x.length + "개");
		for(int i=0; i<x.length; i++) {
			System.out.print(x[i] + "\t");
		}
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