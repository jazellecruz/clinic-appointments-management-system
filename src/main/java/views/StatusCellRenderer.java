
package main.java.views;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import main.java.views.CircleIcon;

public class StatusCellRenderer extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        // Call superclass implementation to get the default rendering component
        JLabel cellComponent = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
           
        Color bgColor = getColorForValue(value.toString());
        CircleIcon statusIcon = new CircleIcon(bgColor);
        cellComponent.setOpaque(true);
        cellComponent.setIcon(statusIcon);
        
        return cellComponent;
    }

    private Color getColorForValue(String value) {

        if (value.equals("Pending")) {
            return new Color(254, 185, 65);
        } else if (value.equals("Confirmed")) {
            return new Color(54, 174, 124);
        } else if (value.equals("Canceled")){
            return new Color(235, 83, 83);
        } else if (value.equals("Completed")){
            return new Color(24, 116, 152);
        } else {
            return Color.gray;
        }
    }
     
}
