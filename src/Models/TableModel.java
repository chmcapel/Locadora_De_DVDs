/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author A D E P T
 */
public class TableModel extends AbstractTableModel{
    
    private ArrayList lines= null;
    private String[] columns= null;
    
public TableModel(ArrayList lin, String[] col) {
    setLines(lin);
    setColumns(col);
}

    /**
     * @return the lines
     */
    public ArrayList getLines() {
        return lines;
    }

    /**
     * @param lines the lines to set
     */
    public void setLines(ArrayList lines) {
        this.lines = lines;
    }

    /**
     * @return the columns
     */
    public String[] getColumns() {
        return columns;
    }

    /**
     * @param columns the columns to set
     */
    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public int getColumnCount(){
        return columns.length;
    }
    
    public int getRowCount(){
        return lines.size();
    }
    
    public String getColumnName(int numCol){
        return columns[numCol];
    }
    
    public Object getValueAt(int numLin, int numCol) {
        Object[] line = (Object[])getLines().get(numLin);
        return line[numCol];
    }
    
}
