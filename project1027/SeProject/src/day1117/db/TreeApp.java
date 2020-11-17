package day1117.db;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeApp extends JFrame{
	JTree tree;
	JScrollPane scroll;
	
	public TreeApp() {
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("상품정보");
		
		tree = new JTree(top);
		scroll = new JScrollPane(tree);
		
		createNode(top);
		
		add(scroll);
		
		setSize(400,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	public void createNode(DefaultMutableTreeNode top) {
		DefaultMutableTreeNode[] node = new DefaultMutableTreeNode[4];
		DefaultMutableTreeNode sub = new DefaultMutableTreeNode("악세서리");
		node[0] = new DefaultMutableTreeNode("반지");
		node[1] = new DefaultMutableTreeNode("목걸이");
		node[2] = new DefaultMutableTreeNode("귀고리");
		node[3] = new DefaultMutableTreeNode("팔찌");
		
		for(DefaultMutableTreeNode node2 : node) {
			sub.add(node2);
		}
		top.add(sub);
		
		sub = new DefaultMutableTreeNode("신발");
		node[0] = new DefaultMutableTreeNode("운동화");
		node[1] = new DefaultMutableTreeNode("샌들");
		node[2] = new DefaultMutableTreeNode("슬리퍼");
		node[3] = new DefaultMutableTreeNode("구두");
		
		for(DefaultMutableTreeNode node2 : node) {
			sub.add(node2);
		}
		top.add(sub);
	}
	public static void main(String[] args) {
		new TreeApp();
	}
}