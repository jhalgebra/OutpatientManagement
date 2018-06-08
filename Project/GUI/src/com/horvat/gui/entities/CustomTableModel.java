package com.horvat.gui.entities;

import com.horvat.dl.entities.IDisplayable;
import javafx.util.Pair;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.*;

public class CustomTableModel<T extends IDisplayable> extends AbstractTableModel {
    //Columns that either display data in cell or one set of information in a popup
    private List<T> data;
    //Columns that display a list of items on click
    private List<Map<String, List<? extends IDisplayable>>> innerData;

    private int columnCount = 0;
    private List<String> columnNames;
    private List<Class> columnTypes;

    public CustomTableModel(List<T> data, List<Integer> complexColumns) {
        this.data = data;
        boolean dataNotEmpty = data != null && data.size() > 0;
        //Just the first collection of columns (for the first row)
        Map<String, List<? extends IDisplayable>> innerData = dataNotEmpty ? data.get(0).getInnerData() : null;
        boolean innerDataNotEmpty = innerData != null && innerData.size() > 0;

        if (dataNotEmpty || innerDataNotEmpty) {
            columnNames = new ArrayList<>();
            columnTypes = new ArrayList<>();

            if (dataNotEmpty)
                addColumns(data.get(0), complexColumns);

            if (innerDataNotEmpty)
                for (String columnName : innerData.keySet())
                    addColumnDefinition(columnName, innerData.get(columnName), complexColumns);

            this.innerData = new ArrayList<>();
            if (innerData != null) {
                this.innerData.add(innerData);

                for (int i = 1; i < data.size(); i++)
                    this.innerData.add(data.get(i).getInnerData());
            }
        }
    }

    private void addColumns(IDisplayable item, List<Integer> complexColumns) {
        Map<String, Map<String, Object>> itemData = item.getDisplayDataGroups();

        for (String key : itemData.keySet()) {
            if (!key.equals(IDisplayable.NON_GROUPED_NAME))
                addColumnDefinition(key, itemData.get(key), complexColumns);
            else {
                Map<String, Object> columns = itemData.get(key);

                for (String columnName : columns.keySet())
                    addColumnDefinition(columnName, columns.get(columnName), complexColumns);
            }
        }
    }

    private void addColumnDefinition(String name, Object value, List<Integer> complexColumns) {
        if (complexColumns != null && (value instanceof Map || value instanceof List))
            complexColumns.add(columnCount);

        columnNames.add(name);
        columnTypes.add(value.getClass());
        columnCount++;
    }

    public Pair<String, Object> getCellContent(int row, int col) {
        IDisplayable item = data.get(row);
        Map<String, Map<String, Object>> itemData = item.getDisplayDataGroups();

        int counter = 0; //columnIndex counter
        for (String key : itemData.keySet()) {
            if (!key.equals(IDisplayable.NON_GROUPED_NAME)) {
                if (counter == col)
                    return new Pair<>(key, itemData.get(key));

                counter++;
            } else
                counter += itemData.get(key).size();
        }

        for (Map<String, List<? extends IDisplayable>> map : this.innerData)
            if (row-- == 0)
                for (String key : map.keySet())
                    if (counter++ == col)
                        return new Pair<>(key, map.get(key));

        return null;
    }

    @Override
    public int getRowCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex >= data.size() || columnIndex >= columnNames.size())
            return null;

        IDisplayable item = data.get(rowIndex);
        Map<String, Map<String, Object>> itemData = item.getDisplayDataGroups();

        int counter = 0; //columnIndex counter
        for (String key : itemData.keySet()) {
            if (!key.equals(IDisplayable.NON_GROUPED_NAME)) {
                if (counter == columnIndex)
                    return "View";//return key; //itemData.get(key);

                counter++;
            } else {
                Map<String, Object> subItems = itemData.get(key);

                for (String innerKey : subItems.keySet()) {
                    if (counter == columnIndex)
                        return subItems.get(innerKey);

                    counter++;
                }
            }
        }

        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames == null
                ? super.getColumnName(column)
                : columnNames.get(column);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnTypes == null
                ? super.getColumnClass(columnIndex)
                : columnTypes.get(columnIndex);
    }
}
