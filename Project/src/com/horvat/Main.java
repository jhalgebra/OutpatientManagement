package com.horvat;

import com.horvat.bll.helpers.IApplication;
import com.horvat.bll.helpers.Utils;

public class Main {
    public static void main(String[] args) {
        //DatabaseTest.run();

        IApplication application = "Console".equals(Utils.getXmlSetting("AppType"))
                ? new com.horvat.console.app.Application()
                : new com.horvat.gui.app.Application();

        application.start();
    }
}
