package org.example.service;

import org.example.config.Validations;
import org.example.dao.LoginDAO;
import org.example.dao.TransactionDAO;
import org.example.dao.UserDAO;
import org.example.enums.UserAction;
import org.example.service.impl.LoginValidator;
import org.example.service.impl.TransactionValidator;
import org.example.service.interfaces.IUserActionValidator;

public class ActionValidatorFactory {

    private final IUserActionValidator transactionVerificationService;
    private final IUserActionValidator loginVerificationService;

    public ActionValidatorFactory(TransactionDAO transactionDAO, LoginDAO loginDAO, UserDAO userDAO,
                                  Validations transactionValidations, Validations loginValidations) {
        this.loginVerificationService = new LoginValidator(loginDAO, userDAO, loginValidations);
        this.transactionVerificationService = new TransactionValidator(transactionDAO, userDAO, transactionValidations);
    }

    public IUserActionValidator getUserActionValidator(UserAction userAction) {
        switch (userAction) {
            case LOGIN:
                return loginVerificationService;
            case TRANSACTION:
                return transactionVerificationService;
            default:
                throw new IllegalArgumentException("Invalid user action");
        }
    }
}
