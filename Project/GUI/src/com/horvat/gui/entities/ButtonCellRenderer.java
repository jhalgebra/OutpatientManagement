package com.horvat.gui.entities;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ButtonCellRenderer extends JButton implements TableCellRenderer {
    public ButtonCellRenderer(String text) {
        super(text);
    }

    public ButtonCellRenderer(String text, Runnable onClick){
        super(text);

        if(onClick != null)
            addActionListener(e -> onClick.run());
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return this;
    }
}
