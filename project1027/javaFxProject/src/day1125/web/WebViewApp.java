package day1125.web;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebViewApp extends Application{
	WebView webView;
	@Override
	public void start(Stage stage) throws Exception {
		webView = new WebView();
		webView.getEngine().load("file:///D:/IT_Korea_Class/JavaScript/project1008/%EB%B9%84%ED%96%89%EA%B8%B0%EA%B2%8C%EC%9E%84.html");
		
		webView.setPrefSize(500, 500);
		
		showWindow(stage, webView);
		
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
