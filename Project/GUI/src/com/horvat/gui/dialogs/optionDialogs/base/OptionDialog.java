package com.horvat.gui.dialogs.optionDialogs.base;

import com.horvat.gui.dialogs.base.BaseDialog;

import java.awt.Window;

public class OptionDialog<T> extends BaseDialog<T, Object> {
    public OptionDialog(Window owner, String title, int width, int height) {
        super(owner, title, width, height, null);
    }
}
