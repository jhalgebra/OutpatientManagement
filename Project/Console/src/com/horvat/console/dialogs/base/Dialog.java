package com.horvat.console.dialogs.base;

import com.horvat.bll.viewmodels.base.BaseViewModel;
import com.horvat.console.app.Helpers;

public abstract class Dialog<T extends BaseViewModel> {
    protected static DialogNavigator dialogNavigator;

    private String title;
    private char underlineChar;

    protected T viewModel;
    protected  int choice;

    public Dialog(String title, char underlineChar, T viewModel) {
        this.title = title;
        this.underlineChar = underlineChar;
        this.viewModel = viewModel;
    }

    public static void initialize(Dialog firstDialog){
        dialogNavigator = new DialogNavigator(firstDialog);
    }

    protected abstract void askForInput();

    public void print(){
        System.out.println(Helpers.getUnderlined(title, underlineChar));

        askForInput();
    }
}
