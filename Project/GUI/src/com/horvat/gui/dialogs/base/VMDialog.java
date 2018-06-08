package com.horvat.gui.dialogs.base;

import java.awt.Window;

public abstract class VMDialog<VM> extends BaseDialog<Object, VM> {
    public VMDialog(Window owner, String title, int width, int height, VM viewModel) {
        super(owner, title, width, height, viewModel);
    }
}
