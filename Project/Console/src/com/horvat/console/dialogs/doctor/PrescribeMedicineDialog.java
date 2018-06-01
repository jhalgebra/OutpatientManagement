package com.horvat.console.dialogs.doctor;

import com.horvat.bll.viewmodels.doctor.PrescribeMedicineViewModel;
import com.horvat.console.app.Helpers;
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
        viewModel.setQuantity(Helpers.read(
                Double::parseDouble,
                item -> item > 0,
                "Enter quantity")
        );
        viewModel.setMedicineName(Helpers.chooseOption(medicine).getValue());

        System.out.println(viewModel.saveChanges()
                ? "Data saved successfully"
                : "Data wasn't saved...");
    }
}
