package com.horvat.bll.viewmodels.receptionist;

import com.horvat.bll.viewmodels.base.BaseViewModel;
import com.horvat.dal.IRepository;
import com.horvat.dal.RepositoryFactory;
import com.horvat.dl.entities.Bill;
import com.horvat.dl.entities.Patient;
import javafx.util.Pair;

import java.math.BigDecimal;
import java.util.List;

public class IssueBillViewModel extends BaseViewModel {
    private Patient patient;
    private Bill bill;
    private BigDecimal amount;
    private String paymentType;

    public IssueBillViewModel(Patient patient) {
        this.patient = patient;
    }

    @Override
    public boolean saveChanges(Runnable successCallback){
        IRepository repository = RepositoryFactory.getRepository();

        bill = repository.insertBill(
                paymentType,
                patient.getId(),
                amount);

        boolean changesSaved = bill != null;

        if(successCallback != null && changesSaved)
            successCallback.run();

        return changesSaved;
    }

    public Patient getPatient() {
        return patient;
    }

    public Bill getBill() {
        return bill;
    }

    public void setAmount(BigDecimal amount){
        this.amount = amount;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public List<Pair<Integer, String>> getPaymentTypes(){
        return RepositoryFactory.getRepository().getPaymentTypes();
    }
}
