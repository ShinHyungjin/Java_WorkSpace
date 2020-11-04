/*
 * 주인공을 정의한다!!
 * */
package day1103.game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

public class Hero extends GameObject {
	GamePanel gamePanel;
	public Hero(Image img, int x, int y, int width, int height, int velX, int velY, GamePanel gamePanel) {
		super(img, x, y, width, height, velX, velY);
		this.gamePanel = gamePanel;
	}

	// 물리량 변화(데이터의 변화)
	public void tick() {
		this.x += this.velX;
		this.y += this.velY;
		rect.x = x;
		rect.y = y;
		collisionCheck();
		}
		
		public void collisionCheck() {
			//총알인 나와 다수의 적군과 교차여부를 판단하여, 교차햇다면 나죽고, 너죽자!!! , 점수로 10올리자!
			for(int i=0;i<gamePanel.enemyList.size();i++) {
				Enemy enemy=gamePanel.enemyList.get(i);	
				if(this.rect.intersects(enemy.rect)) {
					//나죽고(List 에서 제거하면, 더이상 tick(), render() 호출이 일어나지 않으므로 화면에서  사라짐..)
					if(gamePanel.hpList.size() > 1) {
						gamePanel.hpList.remove(gamePanel.hpList.get(gamePanel.hpList.size()-1));
					} else {
						gamePanel.hpList.remove(gamePanel.hpList.get(gamePanel.hpList.size()-1));
						gamePanel.enemyList.remove(enemy);
						gamePanel.score -= 5;
						gamePanel.flag = false;
						gamePanel.over = false;
						break;
					}
						
					
					//너죽자
					gamePanel.enemyList.remove(enemy);
					gamePanel.score -= 5;
					break;
				}
			}
			for(int i=0; i<gamePanel.blockList.size(); i++) {
				Block block = gamePanel.blockList.get(i);
				if(this.rect.intersects(block.rect)) {
					//나죽고(List 에서 제거하면, 더이상 tick(), render() 호출이 일어나지 않으므로 화면에서  사라짐..)
					if(gamePanel.hpList.size() > 1) {
						gamePanel.hpList.remove(gamePanel.hpList.get(gamePanel.hpList.size()-1));
					} else {
						gamePanel.hpList.remove(gamePanel.hpList.get(gamePanel.hpList.size()-1));
						gamePanel.flag = false;
						gamePanel.blockList.remove(block);
						gamePanel.score -= 1;
						gamePanel.over = false;
						break;
					}
					
					
					
					//너죽자
					gamePanel.blockList.remove(block);
					gamePanel.score -= 1;
					break;
				}
			}
			
		}

	// 그래픽 처리 (화면 그려질 처리)
	// 모든 게임 케릭터는 패널에 그려야 하므로, g2를 패널의 paint() 메서드
	// 의 지역변수를 받아오자!!
	public void render(Graphics2D g2) {
		//g2.setColor(Color.RED);
		g2.drawRect(rect.x, rect.y, rect.width, rect.height);
		g2.drawImage(img, rect.x, rect.y, null);

	}

}
