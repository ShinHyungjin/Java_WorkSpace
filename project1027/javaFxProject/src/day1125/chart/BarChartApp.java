package day1125.chart;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class BarChartApp extends Application{
	BarChart barChart;
	CategoryAxis x;	// x축 (유럽,북미,아시아)
	NumberAxis y;	// y축 (코로나 감염자 수)
	
	public void start(Stage stage) throws Exception {
		x = new CategoryAxis();
		y = new NumberAxis();
		
		x.setLabel("Area");
		y.setLabel("People");
		
		XYChart.Series s = new XYChart.Series();
		s.setName("아시아");
		s.getData().add(new XYChart.Data("20만명",20));
		
		XYChart.Series s2 = new XYChart.Series();
		s2.setName("유럽");
		s2.getData().add(new XYChart.Data("68만명",68));
		
		XYChart.Series s3 = new XYChart.Series();
		s3.setName("남미");
		s3.getData().add(new XYChart.Data("8만명",8));
		
		
		barChart = new BarChart(x, y);
		
		barChart.getData().addAll(s,s2,s3);
		barChart.setLegendSide(Side.RIGHT);
		
		showWindow(stage, barChart);
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
