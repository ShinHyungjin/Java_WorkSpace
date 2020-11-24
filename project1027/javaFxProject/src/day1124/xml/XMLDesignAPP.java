package day1124.xml;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
 * AWT 및 Swing의 디자인 구성 방식은 순수 Java 만으로 제작해야하여 제한이 많고 유지보수가 어렵다
 * FX는 Java와 XML로 가능하며, 디자인은 XML로 제작하는것이 바람직하다
 * */

public class XMLDesignAPP extends Application{

	public void start(Stage stage) throws Exception {
		//XML 연동 DOMParser or SAX Parser...
		FXMLLoader loader = new FXMLLoader();
		URL url = this.getClass().getClassLoader().getResource("day1124/xml/main.fxml");

		VBox parent = (VBox)loader.load(url);
		
		showWindow(stage,parent);
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