package day1103.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.sun.glass.events.KeyEvent;

public class GamePanel extends JPanel{
	Thread loopt;
	public static final int WIDTH=1600;
	public static final int HEIGHT=900;
	int x,y;
	Hero hero;
	Bullet bullet;
	Graphics2D g2;
	
	Boolean flag = false;
	public GamePanel() {
		createHero();
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		loopt = new Thread() { 
			public void run() {
				while(true) {
					gameLoop();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		loopt.start();
	}
	public void paint(Graphics g) {
		g2 = (Graphics2D)g;
		g2.setColor(Color.white);
		g2.fillRect(0, 0, WIDTH, HEIGHT);
		
		render(g2);
		
		//g2.setColor(Color.RED);
		//g2.fillRect(x, y, 100, 45);
	}
	public void createHero() {
		hero = new Hero(100,100,150,150,0,0);
	}
	public void movekey(int key) {
		switch(key) {
		case KeyEvent.VK_LEFT : 
			hero.velX -= 2;
			break;
		case KeyEvent.VK_RIGHT : 
			hero.velX += 2;
			break;
		case KeyEvent.VK_UP : 
			hero.velY -= 2;
			break;
		case KeyEvent.VK_DOWN : 
			hero.velY += 2;
			break;
		case KeyEvent.VK_SPACE :
			fire();
			break;
		}
	}
	public void stopkey(int key) {
		switch(key) {
		case KeyEvent.VK_LEFT : 
			hero.velX = 0;
			break;
		case KeyEvent.VK_RIGHT : 
			hero.velX = 0;
			break;
		case KeyEvent.VK_UP : 
			hero.velY = 0;
			break;
		case KeyEvent.VK_DOWN : 
			hero.velY = 0;
			break;
		}
	}
	public void fire() {
		bullet = new Bullet(hero.x, hero.y, 50, 50, 10, 10);
	}
	public void tick() {
		hero.tick();
		if(bullet != null)
			bullet.tick();
	}
	public void render(Graphics2D g2) {
		hero.render(g2);
		if(bullet != null)
			bullet.render(g2);
	}
	public void gameLoop() {
		tick();
		this.repaint();
	}
}
