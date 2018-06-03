package com.horvat.console.dialogs.base;

public class DialogOption {
    private String label;
    private Runnable action;

    public DialogOption(String label, Runnable action) {
        this.label = label;
        this.action = action;
    }

    public Runnable getAction() {
        return action;
    }

    @Override
    public String toString() {
        return label;
    }
}
