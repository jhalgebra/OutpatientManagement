package com.horvat.console.dialogs.base;

import com.horvat.console.app.Helpers;

import java.util.ArrayList;
import java.util.List;

public class DialogNavigator {
    private List<Dialog> dialogs = new ArrayList<>();

    public DialogNavigator(Dialog first) {
        dialogs.add(first);
    }

    public void reprintCurrentDialog() {
        dialogs.get(dialogs.size() - 1).print();
    }

    public void reprintCurrentDialogAfterInput(int numLinesToPrintAfter){
        Helpers.waitForInput(numLinesToPrintAfter);
        reprintCurrentDialog();
    }

    public void goToNewDialog(Dialog dialog) {
        dialogs.add(dialog);
        dialog.print();
    }

    public boolean canGoToPreviousDialog(){
        return dialogs.size() > 1;
    }

    public boolean goToPreviousDialog() {
        if (!canGoToPreviousDialog())
            return false;

        dialogs.remove(dialogs.size() - 1);
        reprintCurrentDialog();
        return true;
    }

    public void backToFirstMenu(){
        for(int i = dialogs.size() - 1; i > 0; i--)
            dialogs.remove(i);

        reprintCurrentDialog();
    }

    public void backToFirstMenuAfterInput(int numLinesToPrintAfter){
        Helpers.waitForInput(numLinesToPrintAfter);

        backToFirstMenu();
    }
}
