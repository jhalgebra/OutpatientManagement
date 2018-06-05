package com.horvat.gui.windows;

import com.horvat.bll.viewmodels.MainMenuViewModel;
import com.horvat.dl.helpers.ToStringUtils;
import com.horvat.gui.windows.base.Window;
import javafx.util.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainMenuWindow extends Window<MainMenuViewModel> {
    private JButton btnDoctorLogin;
    private JPanel contentPane;
    private JButton btnReceptionistLogin;
    private JButton btnReports;

    public MainMenuWindow(String title, int width, int height, MainMenuViewModel viewModel) throws HeadlessException {
        super(title, width, height, viewModel);
        setContentPane(contentPane);

        btnDoctorLogin.addActionListener(e -> JOptionPane.showMessageDialog(null, ToStringUtils.construct('=', new Pair<>("Doctors", new ArrayList<>(viewModel.getDoctors())))));
        btnReceptionistLogin.addActionListener(e -> {  });
        btnReports.addActionListener(e -> {  });
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
        contentPane.setLayout(new GridBagLayout());
        btnDoctorLogin = new JButton();
        btnDoctorLogin.setText("Login as a doctor");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        contentPane.add(btnDoctorLogin, gbc);
        btnReceptionistLogin = new JButton();
        btnReceptionistLogin.setText("Login as a receptionist");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        contentPane.add(btnReceptionistLogin, gbc);
        btnReports = new JButton();
        btnReports.setText("View reports");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        contentPane.add(btnReports, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }
}