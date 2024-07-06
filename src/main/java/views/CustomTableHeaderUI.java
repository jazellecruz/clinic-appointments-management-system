package main.java.views;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;


public class CustomTableHeaderUI extends DefaultTableCellRenderer {
    public CustomTableHeaderUI() {
        setHorizontalAlignment(SwingConstants.LEFT); 
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        setFont(new Font("Poppins Medium", 0 , 12));
        setForeground(new Color(135, 145, 137));
        setText((value == null) ? "" : value.toString());

        return this;
    }
}

