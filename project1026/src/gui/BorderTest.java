package gui;
import java.awt.*;
class BorderTest
{
	public static void main(String[] args) 
	{
		Frame frame = new Frame();

		frame.setSize(500,500);
		frame.setVisible(true);
		Button bt_north = new Button("North");
		Button bt_south = new Button("South");
		Button bt_west = new Button("West");
		Button bt_east = new Button("East");
		Button bt_center = new Button("Center");

		frame.setLayout(new BorderLayout());
		frame.add(bt_north, BorderLayout.NORTH);
		frame.add(bt_south, BorderLayout.SOUTH);
		frame.add(bt_west, BorderLayout.WEST);
		frame.add(bt_east, BorderLayout.EAST);
		// ���ʹ� ��������ʾƵ� Default �̱� ������ �����ص� ����ȴ�.
		frame.add(bt_center);



	}
}
