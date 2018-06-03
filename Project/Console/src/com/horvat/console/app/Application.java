package com.horvat.console.app;

import com.horvat.bll.helpers.IApplication;
import com.horvat.bll.viewmodels.MainMenuViewModel;
import com.horvat.console.dialogs.MainMenuDialog;
import com.horvat.console.dialogs.base.Dialog;

public class Application implements IApplication {
    @Override
    public void start() {
        MainMenuViewModel viewModel = new MainMenuViewModel();
        MainMenuDialog startDialog = new MainMenuDialog("Login", '=', viewModel);

        Dialog.initialize(startDialog);
    }
}
