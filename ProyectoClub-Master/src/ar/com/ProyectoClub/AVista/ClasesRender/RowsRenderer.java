package ar.com.ProyectoClub.AVista.ClasesRender;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JCheckBox;
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
		
		if(value instanceof JButton){
			JButton btn=(JButton)value;
			btn.setEnabled(true);
			if(table.getValueAt(row,columna).equals(false) && btn.getName().equals("btnBaja"))
				btn.setEnabled(false);
			if(table.getValueAt(row,columna).equals(false) && !btn.getName().equals("btnBaja"))
				 btn.setEnabled(true);
			if(table.getValueAt(row,columna).equals(true) && btn.getName().equals("btnHabilitado"))
				btn.setEnabled(false);
			if(table.getValueAt(row,columna).equals(true) && !btn.getName().equals("btnHabilitado"))
				btn.setEnabled(true);
		    return btn;
		}
			
		
		if(value instanceof JCheckBox){
			JCheckBox check=(JCheckBox)value;
			return check;
		}
		
		if(table.getValueAt(row,columna).equals(false)){
			this.setForeground(Color.RED);
		}
		else if(table.getValueAt(row,columna).equals(true)){
			this.setForeground(Color.black);
		}
		return super.getTableCellRendererComponent(table, value, isSelected, 
                hasFocus, row, column);
	}
	
	public int getColumna() {
		return columna;
	}
	public void setColumna(int columna) {
		this.columna = columna;
	}
}
