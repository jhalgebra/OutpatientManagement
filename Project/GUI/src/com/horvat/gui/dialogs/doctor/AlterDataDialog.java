package com.horvat.gui.dialogs.doctor;

import com.horvat.bll.viewmodels.FillAppointmentViewModel;
import com.horvat.bll.viewmodels.doctor.AlterDataViewModel;
import com.horvat.dl.entities.Appointment;
import com.horvat.gui.dialogs.FillAppointmentDialog;
import com.horvat.gui.dialogs.base.VMDialog;
import com.horvat.gui.entities.ButtonCellRenderer;
import com.horvat.gui.entities.AlterDataTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AlterDataDialog extends VMDialog<AlterDataViewModel> {
    private JPanel contentPane;
    private JButton buttonDone;
    private JPanel pnlMain;
    private JTable tblAppointments;

    public AlterDataDialog(Window owner, String title, int width, int height, AlterDataViewModel viewModel) {
        super(owner, title, width, height, viewModel);
        setContentPane(contentPane);
        initListeners();

        tblAppointments.setModel(new AlterDataTableModel(viewModel.getPatient().getAppointments()));
        tblAppointments
                .getColumnModel()
                .getColumn(tblAppointments.getColumnCount() - 1)
                .setCellRenderer(new ButtonCellRenderer("Edit"));
        tblAppointments.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int appointmentIndex = tblAppointments.getSelectedRow();

                if (tblAppointments.getSelectedColumn() == tblAppointments.getColumnCount() - 1) {
                    FillAppointmentDialog fillAppointmentDialog = new FillAppointmentDialog(
                            AlterDataDialog.this,
                            "Edit " + viewModel.getPatient().getBasicDetails().getName() + "'s appointment",
                            400, 400,
                            new FillAppointmentViewModel(viewModel.getDoctor(), viewModel.getPatient(),
                                    viewModel.getPatient().getAppointments().get(appointmentIndex)
                            )
                    );

                    Appointment appointment = fillAppointmentDialog.showDialog();
                    viewModel.getPatient().getAppointments().set(appointmentIndex, appointment);
                    tblAppointments.repaint();
                }
            }
        });
    }

    private void initListeners() {
        buttonDone.addActionListener(e -> onOK());

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

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        contentPane = new JPanel();
        contentPane.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 1, new Insets(10, 10, 10, 10), -1, -1));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        contentPane.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, 1, null, null, null, 0, false));
        buttonDone = new JButton();
        buttonDone.setText("Done");
        panel1.add(buttonDone, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        pnlMain = new JPanel();
        pnlMain.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        contentPane.add(pnlMain, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        pnlMain.add(scrollPane1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        tblAppointments = new JTable();
        scrollPane1.setViewportView(tblAppointments);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }
}
