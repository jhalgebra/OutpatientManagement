package com.horvat.gui.dialogs.doctor;

import com.horvat.bll.viewmodels.doctor.AlterDataViewModel;
import com.horvat.gui.app.Utils;
import com.horvat.gui.dialogs.base.VMDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AlterDataDialog extends VMDialog<AlterDataViewModel> {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;

    public AlterDataDialog(Window owner, String title, int width, int height, AlterDataViewModel viewModel) {
        super(owner, title, width, height, viewModel);
        setContentPane(contentPane);
        initListeners();
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
        close();
    }

    private void onCancel() {
        close();
    }
}
