package ar.com.ProyectoClub.AVista.ClasesRender;

import java.awt.Component;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RowsRende extends DefaultTableCellRenderer {// tabla grilla  inmuebley alquiler
	private int columnaElim ;
	private int columnaPagada;
	private   	byte aux1=1;
	private    	byte aux2=0;
	
	public RowsRende (int colPatron){
		this.columnaElim = colPatron;
	}
	
	public RowsRende (int elim,int pagada){
		columnaElim=elim;
		columnaPagada=pagada;
	}
	
	
	
	@Override
	public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column)
	{        
	    setBackground(Color.white);
	    table.setForeground(Color.black);

	    
	    if(value instanceof JButton){
	    	JButton btn = (JButton) value;
	    	btn.setEnabled(true);

	    //	if(table.getValueAt(row,columnaElim).equals(true))
	    	
	    	if((table.getValueAt(row,columnaElim).equals(aux1))&&(table.getValueAt(row, columnaPagada).equals(aux1))&& btn.getName().equals("btnPag"))
	    		btn.setEnabled(false);
	    	if((table.getValueAt(row,columnaElim).equals(aux2))&& btn.getName().equals("btnPag"))
	    		btn.setEnabled(false);
	    	
	    	
	    	if((table.getValueAt(row,columnaElim).equals(aux2))&& btn.getName().equals("btnEli"))
	    		btn.setEnabled(false);
	    	

	    	if((table.getValueAt(row,columnaElim).equals(aux2))&& btn.getName().equals("btnMod"))
	    		btn.setEnabled(false);
	    	
	    	
	    	return btn;
	    }
	    
	    
	    if((table.getValueAt(row,columnaPagada).equals(aux1))&&(table.getValueAt(row,columnaElim).equals(aux1))){
	    	this.setForeground(Color.GREEN);
	    }else {
	    	if((table.getValueAt(row,columnaPagada).equals(aux2))&&(table.getValueAt(row,columnaElim).equals(aux1))){
		    	this.setForeground(Color.black);
	    		}else if(table.getValueAt(row,columnaElim).equals(aux2))
	    			this.setForeground(Color.RED);
	    }
  
	     if(table.getValueAt(row,columnaElim).equals(false))
	    {
	        this.setForeground(Color.RED);
	    }else if(table.getValueAt(row,columnaElim).equals(true)){
	    	this.setForeground(Color.black);
	    }
	    
	   
	    
	    
	    
	    return  super.getTableCellRendererComponent(table, value, selected, focused, row, column);
	    
	  
	
	}
	
	
	
}
