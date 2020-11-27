package day1126.calendar;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/*달력에 사용되는 셀을 정의한다*/
public class Box extends Canvas{
	int width;
	int height;
	String title;
	GraphicsContext context;
	
	public Box(String title, int width,int height) {
		this.width=width;
		this.height=height;
		this.title = title;
		this.setWidth(width);//너비
		this.setHeight(height);//높이
		
		//모든 컴포넌트는 그래픽 처리에 사용되는 객체를 가지고 있다
		context=this.getGraphicsContext2D();
		
		erase();
		renderText(title);
	}
	
	//현재 박스에 그려진 글씨 지우기
	public void erase() {
		context.setFill(Color.YELLOW); //페인트통 물감색을 노란색으로 
		context.fillRect(0,0,100,100); //노란색 채워진 사각형
		
		//구분라인
		context.setStroke(Color.ORANGE); // 선의 색상
		context.strokeRect(0, 0, width, height); //선 채우기
	}
	
	//현재 박스에 글씨 그리기
	public void renderText(String title) {
		this.title = title;
		context.setFill(Color.BLACK);
		context.setFont(new Font(15));
		context.fillText(title, width/2-20, height/2);
	}
}