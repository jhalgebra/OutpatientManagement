package com.horvat.gui.entities;

import com.horvat.dl.entities.Appointment;
import com.horvat.dl.entities.IDisplayable;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AlterDataTableModel extends AbstractTableModel {
    private List<Appointment> appointments;
    private List<String> columnNames;
    private List<Class> columnTypes;

    public AlterDataTableModel(List<Appointment> appointments) {
        this.appointments = appointments;

        columnNames = new ArrayList<>();
        columnTypes = new ArrayList<>();
        IDisplayable appointment = appointments.get(0);
        Map<String, Object> displayData = appointment.getDisplayDataGroups().get(IDisplayable.NON_GROUPED_NAME);

        for (String columnName : displayData.keySet()) {
            Object columnValue = displayData.get(columnName);

            columnNames.add(columnName);
            columnTypes.add(columnValue.getClass());
        }

        columnNames.add("");
        columnTypes.add(Object.class);
    }

    @Override
    public int getRowCount() {
        return appointments.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnTypes.get(columnIndex);
    }

    @Override
    public String getColumnName(int column) { return columnNames.get(column); }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        IDisplayable appointment = appointments.get(rowIndex);

        Map<String, Object> data = appointment.getDisplayDataGroups().get(IDisplayable.NON_GROUPED_NAME);

        int i = 0;
        for (String columnName : data.keySet())
            if (i++ == columnIndex)
                return data.get(columnName);

        return null;
    }
}
