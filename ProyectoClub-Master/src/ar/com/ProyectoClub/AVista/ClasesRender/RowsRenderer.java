package ar.com.ProyectoClub.AVista;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
/*
 * Clase para colorear una fila(No es un Jframe)
 */
public class RowsRenderer extends DefaultTableCellRenderer  {

	private int columna;

	public RowsRenderer(int Colpatron) {
		this.columna = Colpatron;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,int row, int column) {		
		table.setForeground(Color.black);
		setBackground(Color.white);
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		if(table.getValueAt(row,columna).equals(false)){
			this.setForeground(Color.RED);
		}
		else if(table.getValueAt(row,columna).equals(true)){
			this.setForeground(Color.black);
		}
		return this;
	}
	
	public int getColumna() {
		return columna;
	}
	public void setColumna(int columna) {
		this.columna = columna;
	}
}
