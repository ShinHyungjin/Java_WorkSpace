package day1127.youtube;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.web.WebView;

public class MainUIController implements Initializable{
	//개발자가 직접 lookup 하는게 아니라 시스템에 의해 자동으로 객체를 주입(injection)받자
	@FXML
	Button bt;
	@FXML
	TextField t_url, t_title;
	@FXML
	TilePane tilePane;
	
	
	//URL은 사용중인 layout.fxml의 경로가 넘어온다
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("Button : " + bt);
		System.out.println("URL : " + t_url);
		System.out.println("Title : " + t_title);
		System.out.println("TilePane : " + tilePane);
		
		bt.setOnAction((e) -> {
			createThumb();
		});
	}
	//유튜브 썸네일 생성하기
	public void createThumb() {
		try {
			BorderPane border = (BorderPane)FXMLLoader.load(this.getClass().getClassLoader().getResource("day1127/youtube/thumb.fxml"));
			WebView webView = (WebView)border.lookup("#webView");
			Label la_title = (Label)border.lookup("#la_title");
			
			StringBuffer sb = new StringBuffer();
			
//			sb.append("<iframe");
//			sb.append(" width=\"200\" height=\"155\"");
//			sb.append(" src=\""+ t_url.getText() +"\"");
//			sb.append(" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write;");
//			sb.append(" encrypted-media; gyroscope; picture-in-picture\" allowfullscreen>");
//			sb.append("</iframe>");
			
			webView.getEngine().loadContent(t_url.getText() , "text/html"); // youtube 영상의 url이 아닌 소스코드 붙여넣기 하면 됨

			la_title.setText(t_title.getText());
			
			tilePane.getChildren().add(border);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
