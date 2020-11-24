package dat1124.components;

import java.net.URL;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ImageViewApp extends Application{
	String url;

	public void start(Stage stage) throws Exception {
		url = "https://www.urbanbrush.net/web/wp-content/uploads/edd/2018/11/urbanbrush-20181126042312829882.png";
		ImageView imageView = new ImageView(url);
		imageView.setPreserveRatio(true); // 비율 유지
		
		FlowPane parent = new FlowPane(imageView);
		
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