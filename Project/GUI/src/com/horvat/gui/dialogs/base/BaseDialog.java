package com.horvat.gui.dialogs.base;

import javax.swing.*;
import java.awt.*;

public abstract class BaseDialog<T, VM> extends JDialog {
    private T result;
    protected VM viewModel;

    public BaseDialog(Window owner, String title, int width, int height, VM viewModel) {
        super(owner, title, ModalityType.APPLICATION_MODAL);
        setSize(width, height);
        setPreferredSize(new Dimension(width, height));
        setLocationRelativeTo(owner);
        this.viewModel = viewModel;
    }

    public T showDialog() {
        pack();
        setVisible(true);
        return result;
    }

    public void close() {
        setVisible(false);
        dispose();
    }

    protected void setResultAndClose(T result) {
        setResult(result);
        close();
    }

    protected void setResult(T result) {
        this.result = result;
    }
}
