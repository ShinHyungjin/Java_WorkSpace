package day1103.game;

import java.awt.Color;
import java.awt.Graphics2D;

public class Hero extends GameObject{
	public Hero(int x,int y,int width,int height,int velX,int velY) {
		super(x,y,width,height,velX,velY);
	}
	public void tick() {
		this.x += this.velX;
		this.y += this.velY;
	}
	public void render(Graphics2D g2) {
		g2.setColor(Color.RED);
		g2.fillRect(x, y, 100, 45);
	}

}
