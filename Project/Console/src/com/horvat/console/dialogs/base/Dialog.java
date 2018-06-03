package com.horvat.console.dialogs.base;

import com.horvat.bll.viewmodels.base.BaseViewModel;
import com.horvat.console.app.Helpers;

import java.util.ArrayList;
import java.util.List;

public abstract class Dialog<T extends BaseViewModel> {
    protected static DialogNavigator dialogNavigator;

    private String title;
    private char underlineChar;
    private List<Object> dialogEndData;

    protected T viewModel;
    protected List<DialogOption> options;

    public Dialog(String title, char underlineChar, T viewModel) {
        this.title = title;
        this.underlineChar = underlineChar;
        this.viewModel = viewModel;
    }

    public void setDialogEndData(List<Object> dialogEndData) { this.dialogEndData = dialogEndData; }

    public static void initialize(Dialog firstDialog) {
        dialogNavigator = new DialogNavigator(firstDialog);
        dialogNavigator.reprintCurrentDialog();
    }

    public void print() {
        processDialogEndData(dialogEndData);

        System.out.println(System.lineSeparator());

        System.out.println(Helpers.getUnderlined(title, underlineChar));

        askForInput();
    }

    protected void processDialogEndData(List<Object> dialogEndData) { }

    protected void askForInput() {
        if (dialogNavigator.canGoToPreviousDialog()) {
            if (options == null)
                options = new ArrayList<>();

            String label = "Go back to previous menu";
            int lastOptionIndex = options.size() - 1;

            if (lastOptionIndex >= 0 && label.equals(options.get(lastOptionIndex).toString()))
                options.remove(lastOptionIndex);

            options.add(
                    new DialogOption(
                            label,
                            () -> dialogNavigator.goToPreviousDialog()
                    )
            );
        }

        printOptions(null);
    }

    protected void printOptions(String subtitle) {
        if (options == null)
            return;

        if (subtitle != null && subtitle.length() > 0)
            System.out.println(Helpers.getUnderlined(subtitle, '-'));

        DialogOption chosenOption = Helpers.chooseOption(options);

        if (chosenOption != null) {
            Runnable action = chosenOption.getAction();

            if (action != null)
                action.run();
        }
    }

    protected boolean saveChanges(Runnable successCallback) {
        boolean saved = viewModel.saveChanges(successCallback);

        System.out.println(saved
                ? "Data saved successfully"
                : "Data wasn't saved..."
        );

        return saved;
    }
}
