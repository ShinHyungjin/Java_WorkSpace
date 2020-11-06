package day1106.db;

import javax.swing.table.AbstractTableModel;

public class ProductController extends AbstractTableModel{
	String [][] data = {};
	String [] column = {"product_id","subcategory_id","product_name","brand","price","filename"};
	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public int getColumnCount() {
		return column.length;
	}

	@Override
	public Object getValueAt(int row, int col) {
		return data[row][col];
	}
	@Override
	public String getColumnName(int col) {
		return column[col];
	}
	
}
