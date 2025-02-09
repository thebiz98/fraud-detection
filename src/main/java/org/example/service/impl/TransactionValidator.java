package org.example.service.impl;

import org.example.config.Check;
import org.example.config.Validations;
import org.example.dao.TransactionDAO;
import org.example.dao.UserDAO;
import org.example.model.BaseUserAction;
import org.example.model.Transaction;
import org.example.service.interfaces.IUserActionValidator;

import java.util.List;
import java.util.Set;

public class TransactionValidator implements IUserActionValidator {

    private final TransactionDAO transactionDAO;
    private final UserDAO userDAO;
    private final Validations transactionValidations;

    public TransactionValidator(TransactionDAO transactionDAO, UserDAO userDAO, Validations transactionValidations) {
        this.transactionDAO = transactionDAO;
        this.userDAO = userDAO;
        this.transactionValidations = transactionValidations;
    }

    @Override
    public boolean validateUserAction(BaseUserAction userAction) {
        Transaction transaction = (Transaction) userAction;
        List<Transaction> transactionList = this.transactionDAO.getTransactionHistory(userAction.getUserId());

        transactionList.add(transaction);

        for (Check check : transactionValidations.getChecks()) {
            if(!processCheck(check, transaction, transactionList)) {
                return false;
            }
        }
        return true;
    }

    private boolean processCheck(Check check, Transaction latestTransaction, List<Transaction> transactionList) {
        switch(check.getAttribute()) {
            case "deviceId":
                Set<String> userDevices = this.userDAO.getUSerDevices();
                if(!userDevices.contains(latestTransaction.getDeviceId())) {
                    return false;
                }
                break;
            case "location":
                Set<String> userLocations = this.userDAO.getUserLocations();
                if(!userLocations.contains(latestTransaction.getLocation())) {
                    return false;
                }
                break;
            default:
                throw new IllegalArgumentException("Unrecognised attribute sent for testing");
        }
        return true;
    }
}
