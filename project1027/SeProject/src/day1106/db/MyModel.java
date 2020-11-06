package day1106.db;

import javax.swing.table.AbstractTableModel;

public class MyModel extends AbstractTableModel{
	String [][] flower = {
			{"장미","50000","RED","KOREA"},
			{"튤립","70000","PURPLE","FRANCE"},
			{"안개꽃","30000","WHITE","KOREA"}
	};
	String [][] car = {
			{"BMW","7000","WHITE"},
			{"BENZ","3000","BLUE"},
			{"AUDI","1000","GREEN"}
	};
	
	@Override
	public int getRowCount() {
		return flower.length;
	}

	@Override
	public int getColumnCount() {
		return flower[0].length;
	}

	@Override
	public Object getValueAt(int row, int col) {
		return flower[row][col];
	}

}
