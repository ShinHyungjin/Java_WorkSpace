package day1111.board;

import javax.swing.table.AbstractTableModel;

public class BoardModel extends AbstractTableModel{
	String [] column = {"board_id","title","writer","regdate","hit"};
	String [][] data = {};
	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public int getColumnCount() {
		return column.length;
	}
	@Override
	public String getColumnName(int col) {
		return column[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		return data[row][col];
	}


}
