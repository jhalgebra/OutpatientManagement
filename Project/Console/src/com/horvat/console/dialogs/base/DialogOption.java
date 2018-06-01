package com.horvat.console.dialogs.base;

import java.util.function.Consumer;

public class DialogOption {
    private String label;
    private Consumer<Object> action;

    public DialogOption(String label, Consumer<Object> action) {
        this.label = label;
        this.action = action;
    }

    public Consumer<Object> getAction() {
        return action;
    }

    @Override
    public String toString() {
        return label;
    }
}
