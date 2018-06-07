package com.horvat.gui.app;

import com.horvat.bll.helpers.IApplication;
import com.horvat.bll.viewmodels.MainMenuViewModel;

import javax.swing.WindowConstants;
import java.awt.EventQueue;

public class Application implements IApplication {
    @Override
    public void start() {
        MainMenuViewModel viewModel = new MainMenuViewModel();
        MainMenuWindow window = new MainMenuWindow("Main Menu", 400, 600, viewModel);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        EventQueue.invokeLater(() -> window.setVisible(true));
    }
}
