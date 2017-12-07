package ar.com.ProyectoClub.AVista.ClasesRender;

import java.awt.Component;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RowsRende extends DefaultTableCellRenderer {
	private int columna ;

	public RowsRende (int colPatron){
		this.columna = colPatron;
	}
	
	@Override
	public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column)
	{        
	    setBackground(Color.white);
	    table.setForeground(Color.black);
	   
	    if(value instanceof JButton){
	    	JButton btn = (JButton) value;
	    	return btn;
	    }
	   
	    
	    
	    if(table.getValueAt(row,columna).equals(false))
	    {
	        this.setForeground(Color.RED);
	    }else if(table.getValueAt(row,columna).equals(true)){
	    	this.setForeground(Color.black);
	    }
	    
	    
	    
	    
	    return  super.getTableCellRendererComponent(table, value, selected, focused, row, column);
	    
	    
	    
	    
	    
	 /* 
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
			if(!table.getValueAt(row,1).equals(true) && btn.getName().equals("btnCuotas"))
				btn.setEnabled(false);
		    return btn;
		}
	*/
	
	
	
	
	}
	
	
	
}
