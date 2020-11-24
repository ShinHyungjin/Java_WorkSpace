package day1123.fxtest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/*
 * FX 생명주기 
 * main -> 생성자 -> init -> start -> stop
 * FX Thread는 main을 통해 launch가 실행되면, FX Application Thread와 FX Launcher가 생성된다
 * */
public class AppMain extends Application{
	int count = 1;

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + "\tmain 호출");
		launch(args);
	}

	// Stage가 앱의 윈도우이다
	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println(Thread.currentThread().getName() + "\tstart 호출");
		
		VBox parent = new VBox();
		Button bt = new Button("하이");
		parent.getChildren().add(bt);
		bt.setPrefSize(200, 200);
		TextField t = new TextField("gggg");
		parent.getChildren().add(t);
		t.setFont(new Font("Verdana", 25));
		
		bt.setOnAction((e) -> {
			bt.setText("나 눌름?");
			System.out.println("누름 횟수" + count++);
		});
		
		Scene s1 = new Scene(parent,300,300);
		
		primaryStage.setMaxHeight(500);
		primaryStage.setMaxWidth(500);
		primaryStage.setScene(s1);
		primaryStage.show();
	}
	@Override
	public void init() throws Exception {
		System.out.println(Thread.currentThread().getName() + "\tinit 호출");
	}
	@Override
	public void stop() throws Exception {
		System.out.println(Thread.currentThread().getName() + "\tstop 호출");
	}
	public AppMain() {
		System.out.println(Thread.currentThread().getName() + "\t생성자 호출");
	}
}
