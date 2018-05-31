package com.horvat.gui.app;

import com.horvat.bll.helpers.IApplication;

public class Application implements IApplication {
    @Override
    public void start() {
        System.out.println("Started the GUI application.");
    }
}
