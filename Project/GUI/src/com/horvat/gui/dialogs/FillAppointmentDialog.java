package com.horvat.gui.dialogs;

import com.horvat.bll.viewmodels.FillAppointmentViewModel;
import com.horvat.dl.entities.Appointment;
import com.horvat.gui.app.Utils;
import com.horvat.gui.dialogs.base.VMDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FillAppointmentDialog extends VMDialog<FillAppointmentViewModel> {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;

    public FillAppointmentDialog(Window owner, String title, int width, int height, FillAppointmentViewModel viewModel) {
        super(owner, title, width, height, viewModel);
        setContentPane(contentPane);
        initListeners();

        Appointment appointment = viewModel.getAppointment();

        if(appointment != null){
            //Fill controls
        }
    }

    private void initListeners() {
        buttonOK.addActionListener(e -> onOK());

        buttonCancel.addActionListener(e -> onCancel());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(
                e -> onCancel(),
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT
        );
    }

    private void onOK() {


        Utils.saveDataAndShowStatus(this, viewModel, this::close);
    }

    private void onCancel() {
        close();
    }

    public static void main(String[] args) {
        FillAppointmentDialog dialog = new FillAppointmentDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
