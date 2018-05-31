package com.horvat.console.dialogs;

import com.horvat.bll.viewmodels.LoginViewModel;
import com.horvat.console.app.Helpers;
import com.horvat.console.dialogs.base.Dialog;
import com.horvat.dl.entities.Doctor;

public class LoginDialog extends Dialog<LoginViewModel> {

    public LoginDialog(String title, char underlineChar, LoginViewModel viewModel) {
        super(title, underlineChar, viewModel);
    }

    @Override
    protected void askForInput() {
        choice = Helpers.chooseOption("Login as a doctor", "Login as a receptionist");

        if(choice == 1){ //Doctor
            System.out.println();
            System.out.println(Helpers.getUnderlined("Choose a doctor", '-'));

            Doctor doctor = Helpers.chooseOption(viewModel.getDoctors());

            System.out.println("Selected doctor: " + doctor);
        }
        else{ //Receptionist
            System.out.println("Welcome, receptionist...");
        }
    }
}
