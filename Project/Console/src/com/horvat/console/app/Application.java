package com.horvat.console.app;

import com.horvat.bll.helpers.IApplication;
import com.horvat.bll.viewmodels.LoginViewModel;
import com.horvat.console.dialogs.LoginDialog;
import com.horvat.console.dialogs.base.Dialog;

public class Application implements IApplication {
    @Override
    public void start() {
        LoginViewModel viewModel = new LoginViewModel();
        LoginDialog startDialog = new LoginDialog("Login", '=', viewModel);

        Dialog.initialize(startDialog);
    }
}
