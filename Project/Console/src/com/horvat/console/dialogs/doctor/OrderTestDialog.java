package com.horvat.console.dialogs.doctor;

import com.horvat.bll.viewmodels.doctor.OrderTestViewModel;
import com.horvat.console.app.Helpers;
import com.horvat.console.dialogs.base.Dialog;

public class OrderTestDialog extends Dialog<OrderTestViewModel> {
    public OrderTestDialog(String title, char underlineChar, OrderTestViewModel viewModel) {
        super(title, underlineChar, viewModel);
    }

    @Override
    protected void askForInput() {
        viewModel.setDetails(Helpers.enterString("details"));
        viewModel.setName(Helpers.enterString("name"));
        viewModel.setTestDate(Helpers.readDateInFuture("Enter date", true));

        dialogNavigator.goBackOnSuccess(
                this,
                () -> viewModel.getPatient().getTests().add(viewModel.getTest()),
                DoctorMenuDialog.class
        );
    }
}
