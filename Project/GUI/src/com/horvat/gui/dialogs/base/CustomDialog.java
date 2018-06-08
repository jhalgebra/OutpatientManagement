package com.horvat.gui.dialogs.base;

import java.awt.*;

public abstract class CustomDialog extends BaseDialog<Object, Object> {
    public CustomDialog(Window owner, String title, int width, int height) {
        super(owner, title, width, height, null);
    }
}
