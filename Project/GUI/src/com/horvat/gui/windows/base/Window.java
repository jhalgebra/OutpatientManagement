package com.horvat.gui.windows.base;

import com.horvat.bll.viewmodels.base.BaseViewModel;

import javax.swing.*;
import java.awt.*;

public abstract class Window<T extends BaseViewModel> extends JFrame {
    protected T viewModel;

    public Window(String title, int width, int height, T viewModel) throws HeadlessException {
        super(title);
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        this.viewModel = viewModel;
    }
}
