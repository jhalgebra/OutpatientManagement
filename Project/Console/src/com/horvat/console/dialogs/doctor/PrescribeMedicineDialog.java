package com.horvat.console.dialogs.doctor;

import com.horvat.bll.viewmodels.doctor.PrescribeMedicineViewModel;
import com.horvat.console.app.Utils;
import com.horvat.console.dialogs.base.Dialog;
import javafx.util.Pair;

import java.util.List;

public class PrescribeMedicineDialog extends Dialog<PrescribeMedicineViewModel> {
    private List<Pair<Integer, String>> medicine;

    public PrescribeMedicineDialog(String title, char underlineChar, PrescribeMedicineViewModel viewModel) {
        super(title, underlineChar, viewModel);

        medicine = viewModel.getMedicines();
    }

    @Override
    protected void askForInput() {
        viewModel.setQuantity(Utils.read(
                Double::parseDouble,
                item -> item > 0,
                "Enter quantity"
        ));
        viewModel.setMedicineName(Utils.chooseOption(medicine).getValue());

        dialogNavigator.goBackOnSuccess(
                this,
                () -> viewModel.getPatient().getPrescribedMedicine().add(viewModel.getMedicine()),
                DoctorMenuDialog.class
        );
    }
}
