package org.example.service;

import org.example.config.Validations;
import org.example.dao.LoginDAO;
import org.example.dao.TransactionDAO;
import org.example.dao.UserDAO;
import org.example.model.Transaction;
import org.example.service.impl.FraudDetectionServiceImpl;
import org.example.service.interfaces.IFraudDetectionService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FraudDetectionTest {

    TransactionDAO transactionDAO = new TransactionDAO();
    LoginDAO loginDAO = new LoginDAO();
    UserDAO userDAO = new UserDAO();

    Validations transactionValidations = new Validations();
    Validations loginValidations = new Validations();

    ActionValidatorFactory actionValidatorFactory = new ActionValidatorFactory(transactionDAO, loginDAO, userDAO,
            transactionValidations, loginValidations);

    IFraudDetectionService fraudDetectionService = new FraudDetectionServiceImpl(actionValidatorFactory);

    @Test
    public void testValidTransaction() {
        Transaction transaction = new Transaction("123", 1000, "Delhi", "dev-xyz");
        boolean transactionValidity = fraudDetectionService.processUserAction(transaction);
        assertTrue(transactionValidity);
    }

    @Test
    public void testInvalidLocationTransaction() {
        Transaction transaction = new Transaction("123", 1000, "Mumbai", "dev-xyz");
        boolean transactionValidity = fraudDetectionService.processUserAction(transaction);
        assertFalse(transactionValidity);
    }

    @Test
    public void testInvalidDeviceTransaction() {
        Transaction transaction = new Transaction("123", 1000, "Delhi", "dev-abc");
        boolean transactionValidity = fraudDetectionService.processUserAction(transaction);
        assertFalse(transactionValidity);
    }


}
