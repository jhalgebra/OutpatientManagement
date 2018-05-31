package com.horvat.console.dialogs.base;

import java.util.ArrayList;
import java.util.List;

public class DialogNavigator {
    private List<Dialog> dialogs = new ArrayList<>();

    public DialogNavigator(Dialog first) {
        dialogs.add(first);
        reprintCurrentDialog();
    }

    public void reprintCurrentDialog() {
        dialogs.get(dialogs.size() - 1).print();
    }

    public void goToNewDialog(Dialog dialog) {
        dialogs.add(dialog);
        dialog.print();
    }

    public boolean goToPreviousDialog() {
        if (dialogs.size() == 0)
            return false;

        dialogs.remove(dialogs.size() - 1);
        reprintCurrentDialog();
        return true;
    }
}
