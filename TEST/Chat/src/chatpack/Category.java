package chatpack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Category extends JFrame {
//프로그래밍 운동 레슨 인테리어 요리 외국어 교육 뷰티
	JPanel p_north;
	JPanel p_center;
	JPanel p_south;

	JPanel p_image, p_card;
	JLabel la_title, la_service;

	String[] title = { "요가", "필라테스", "헬스", "수영", "골프", "스키" };
	String dir = "/SoomCo/src/com/soomco/category/";
	String[] src = { "", "", "", "", "", "" };
	int n = 0;
	
	ImageIcon icon;

	public Category() {

		super("소카테고리");

		p_north = new JPanel(); // 카테고리아이콘 올라갈 영역
		p_center = new JPanel();// 인기서비스 라벨 올라갈 영역
		p_south = new JPanel();// 카테고리 이미지 패널 올라갈 영역
		
		icon = ImageUtil.getIcon(this.getClass(), "res/CookingIcon.png", 200, 150);
		Image img = icon.getImage();
		
		for (int i = 0; i < 6; i++) {
			la_title = new JLabel(title[n], SwingConstants.CENTER);

			p_image = new JPanel() {
				public void paintComponent(Graphics g) {
					g.drawImage(img, 0, 0, this);
				}
			};
			p_card = new JPanel(); // 이미지, 라벨 같이 넣을 패널
			p_south.add(p_card);
			p_card.add(p_image);
			p_card.add(la_title);
			n++; // 타이틀 변경
			// 하나의 카테고리 카드 생성
			p_card.setPreferredSize(new Dimension(200, 200));
			p_image.setPreferredSize(new Dimension(200, 150));
			// p_image.setBackground(Color.cyan);
			la_title.setPreferredSize(new Dimension(70, 20));
		}

		p_center.setPreferredSize(new Dimension(600, 100));
		p_center.setBackground(Color.green);
		la_service = new JLabel("인기 서비스", SwingConstants.CENTER);
		la_service.setPreferredSize(new Dimension(100, 100));
		p_center.add(la_service);

		p_north.setPreferredSize(new Dimension(600, 100));
		add(p_north, BorderLayout.NORTH);
		add(p_center, BorderLayout.CENTER);

		// p_south.add(p_card);

		// 카테고리 카드 붙이기
		add(p_south, BorderLayout.SOUTH);
		p_south.setPreferredSize(new Dimension(600, 500));

		p_north.setBackground(Color.blue);
		p_south.setBackground(Color.YELLOW);

		setSize(800, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new Category();
	}
}