package com.horvat.console.dialogs.receptionist;

import com.horvat.bll.viewmodels.receptionist.IssueBillViewModel;
import com.horvat.console.app.Utils;
import com.horvat.console.dialogs.base.Dialog;

public class IssueBillDialog extends Dialog<IssueBillViewModel> {
    public IssueBillDialog(String title, char underlineChar, IssueBillViewModel viewModel) {
        super(title, underlineChar, viewModel);
    }

    @Override
    protected void askForInput() {
        viewModel.setAmount(Utils.readDecimal("Enter amount"));

        viewModel.setPaymentType(Utils.chooseOption(viewModel.getPaymentTypes()).getValue());

        dialogNavigator.goBackOnSuccess(
                this,
                () -> viewModel.getPatient().getBills().add(viewModel.getBill()),
                ReceptionistMenuDialog.class
        );
    }
}
