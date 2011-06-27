package de.viadee.roo.sep.rooswingcomponents;

import javax.swing.table.AbstractTableModel;

public class RooTableModel extends AbstractTableModel{
	
	String[] columnNames;
	Object[][] data;
	
	public RooTableModel(String[] columnNames, Object[][] data){
		this.columnNames = columnNames;
		this.data = data;
	}
	
	public void setData(Object[][] data) {
		this.data = data;
	}
	
	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}
	
	@Override
	public String getColumnName(int col) {
        return columnNames[col];
    }
}
