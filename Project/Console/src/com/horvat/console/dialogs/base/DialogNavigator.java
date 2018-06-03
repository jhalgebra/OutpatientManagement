package com.horvat.console.dialogs.base;

import com.horvat.console.app.Helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class DialogNavigator {
    private List<Dialog> dialogs = new ArrayList<>();

    public DialogNavigator(Dialog first) {
        dialogs.add(first);
    }

    public void reprintCurrentDialog() {
        dialogs.get(dialogs.size() - 1).print();
    }

    public void reprintCurrentDialogAfterInput(int numLinesToPrintAfter) {
        Helpers.waitForInput(numLinesToPrintAfter);
        reprintCurrentDialog();
    }

    public void goToNewDialog(Dialog dialog) {
        dialogs.add(dialog);
        dialog.print();
    }

    public boolean canGoToPreviousDialog() {
        return dialogs.size() > 1;
    }

    public boolean goToPreviousDialog() {
        if (!canGoToPreviousDialog())
            return false;

        dialogs.remove(dialogs.size() - 1);
        reprintCurrentDialog();
        return true;
    }

    public void backToFirstMenu() {
        for (int i = dialogs.size() - 1; i > 0; i--)
            dialogs.remove(i);

        reprintCurrentDialog();
    }

    public void backToFirstMenuAfterInput(int numLinesToPrintAfter) {
        Helpers.waitForInput(numLinesToPrintAfter);

        backToFirstMenu();
    }

    private void goBackOnSuccess(Supplier<Boolean> test, Class<? extends Dialog> targetDialog, Supplier<List<Object>> dialogEndData) {
        if (test.get()) {
            Dialog dialog = findTargetDialog(targetDialog);

            if(dialog != null && dialogEndData != null)
                dialog.setDialogEndData(dialogEndData.get());
        }

        reprintCurrentDialog();
    }

    public void goBackOnSuccess(Dialog currentDialog, Runnable successCallback, Class<? extends Dialog> targetDialog) {
        goBackOnSuccess(() -> currentDialog.saveChanges(successCallback), targetDialog, null);
    }

    public void goBackOnSuccess(Dialog currentDialog, Supplier<List<Object>> dialogEndData, Class<? extends Dialog> targetDialog){
        goBackOnSuccess(() -> currentDialog.saveChanges(null), targetDialog, dialogEndData);
    }

    private Dialog findTargetDialog(Class<? extends Dialog> targetDialog) {
        for (int i = dialogs.size() - 1; i >= 0; i--)
            if (dialogs.get(i).getClass().equals(targetDialog)) {
                for (int j = dialogs.size() - 1; j > i; j--)
                    dialogs.remove(j);

                return dialogs.get(i);
            }

        return null;
    }
}
