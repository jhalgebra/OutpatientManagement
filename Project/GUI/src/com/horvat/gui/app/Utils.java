package com.horvat.gui.app;

import com.horvat.bll.viewmodels.base.BaseViewModel;

import javax.swing.JOptionPane;
import java.awt.Component;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Utils {
    public static final DateFormat format = new SimpleDateFormat(com.horvat.bll.helpers.Utils.DATE_WITH_TIME_FORMAT);

    public static void saveDataAndShowStatus(Component parent, BaseViewModel viewModel, String errorMessage, Runnable successCallback) {
        boolean changesSaved = viewModel.saveChanges(successCallback);

        if (changesSaved)
            JOptionPane.showMessageDialog(
                    parent,
                    "Data saved successfully",
                    "Saving data",
                    JOptionPane.INFORMATION_MESSAGE
            );
        else
            JOptionPane.showMessageDialog(
                    parent,
                    "An error occurred..." + System.lineSeparator() + errorMessage,
                    "Saving data",
                    JOptionPane.ERROR_MESSAGE
            );
    }

    public static void printError(Component parent, Exception error){
        JOptionPane.showMessageDialog(
                parent, error.getMessage(),
                "An error occurred", JOptionPane.ERROR_MESSAGE
        );
    }
}
