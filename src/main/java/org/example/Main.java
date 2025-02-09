package org.example;

import org.example.config.Validations;
import org.example.dao.LoginDAO;
import org.example.dao.TransactionDAO;
import org.example.dao.UserDAO;
import org.example.model.LoginEvent;
import org.example.model.Transaction;
import org.example.service.ActionValidatorFactory;
import org.example.service.impl.FraudDetectionServiceImpl;
import org.example.service.interfaces.IFraudDetectionService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Transaction transaction = new Transaction("123", 1000, "Delhi", "dev-xyz");
        Transaction transaction2 = new Transaction("123", 1000, "Mumbai", "dev-xyz");
        Transaction transaction3 = new Transaction("123", 1000, "Delhi", "dev-abc");
        LoginEvent loginEvent = new LoginEvent("123", "10.24.24.123", "dev-xyz");

        TransactionDAO transactionDAO = new TransactionDAO();
        LoginDAO loginDAO = new LoginDAO();
        UserDAO userDAO = new UserDAO();

        Validations transactionValidations = new Validations();
        Validations loginValidations = new Validations();

        ActionValidatorFactory actionValidatorFactory = new ActionValidatorFactory(transactionDAO, loginDAO, userDAO,
                transactionValidations, loginValidations);

        IFraudDetectionService fraudDetectionService = new FraudDetectionServiceImpl(actionValidatorFactory);

        boolean transactionValidity = fraudDetectionService.processUserAction(transaction2);
        if(transactionValidity) {
            System.out.println("Valid transaction");
        } else {
            System.out.println("Invalid transaction");
        }
        boolean loginValidity = fraudDetectionService.processUserAction(loginEvent);
    }

    private static void testTransactions(IFraudDetectionService fraudDetectionService) {
        Transaction transaction = new Transaction("123", 1000, "Delhi", "dev-xyz");
        Transaction transaction2 = new Transaction("123", 1000, "Mumbai", "dev-xyz");
        Transaction transaction3 = new Transaction("123", 1000, "Delhi", "dev-abc");
        boolean transactionValidity = fraudDetectionService.processUserAction(transaction);
        if(transactionValidity) {
            System.out.println("Valid transaction");
        } else {
            System.out.println("Invalid transaction");
        }
    }
}