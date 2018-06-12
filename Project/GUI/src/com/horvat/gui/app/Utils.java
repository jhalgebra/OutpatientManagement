package com.horvat.gui.app;

import com.horvat.bll.viewmodels.base.BaseViewModel;

import javax.swing.JOptionPane;
import java.awt.Component;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Utils {
    public static final DateFormat format = new SimpleDateFormat(com.horvat.bll.helpers.Utils.DATE_WITH_TIME_FORMAT);

    public static void saveDataAndShowStatus(Component parent, BaseViewModel viewModel, Runnable successCallback) {
        JOptionPane.showMessageDialog(
                parent,
                viewModel.saveChanges(successCallback)
                        ? "Data saved successfully"
                        : "Data wasn't saved",
                "Saving data",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
