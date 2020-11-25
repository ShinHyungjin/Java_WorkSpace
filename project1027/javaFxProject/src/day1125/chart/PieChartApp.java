package day1125.chart;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class PieChartApp extends Application{
	PieChart pieChart;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void showWindow(Stage stage, Parent parent) {
		// Window 안에는 무조건 Scene 이라 불리는 컨테이너가 와야함 1윈도우 1씬
		Scene s = new Scene(parent);

		stage.setScene(s);

		stage.setWidth(500);
		stage.setHeight(500);
		stage.show();

	}

	@Override
	public void start(Stage stage) throws Exception {
		pieChart = new PieChart();
		PieChart.Data s1 = new PieChart.Data("안드로이드폰", 6);	//PieChart가 가지고있는 Data 객체 선언
		PieChart.Data s2 = new PieChart.Data("아이폰", 3);
		PieChart.Data s3 = new PieChart.Data("윈도우폰", 1);
		
		pieChart.getData().add(s1);
		pieChart.getData().add(s2);
		pieChart.getData().add(s3);
		
		pieChart.setLegendSide(Side.RIGHT); //차트 라벨의 위치 조정
		
		showWindow(stage, pieChart);
	}
}
