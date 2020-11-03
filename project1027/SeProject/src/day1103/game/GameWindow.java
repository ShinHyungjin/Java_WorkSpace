package day1103.game;

import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class GameWindow extends JFrame {
	GamePanel gamepanel;

	public GameWindow() {
		gamepanel = new GamePanel();

		setLayout(new FlowLayout());
		add(gamepanel);

		pack();// 윈도우 안에 있는 내용물크기 까지 줄어든다
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				gamepanel.movekey(e.getKeyCode());
			}
			public void keyReleased(KeyEvent e) {
				gamepanel.stopkey(e.getKeyCode());
			}
		});
	}

	public static void main(String[] args) {
		new GameWindow();
	}
}
