package org.example.service.impl;

import org.example.config.Validations;
import org.example.dao.LoginDAO;
import org.example.dao.UserDAO;
import org.example.model.BaseUserAction;
import org.example.model.LoginEvent;
import org.example.service.interfaces.IUserActionValidator;

import java.util.List;

public class LoginValidator implements IUserActionValidator {

    private final LoginDAO loginDAO;
    private final UserDAO userDAO;
    private final Validations loginValidations;

    public LoginValidator(LoginDAO loginDAO, UserDAO userDAO, Validations loginValidations) {
        this.loginDAO = loginDAO;
        this.userDAO = userDAO;
        this.loginValidations = loginValidations;
    }

    @Override
    public boolean validateUserAction(BaseUserAction userAction) {
        LoginEvent loginEvent = (LoginEvent) userAction;
        List<LoginEvent> loginEventList = this.loginDAO.getLoginEventHistory(userAction.getUserId());


        // check how many wrongful attemtps in last 5 mins
        // check if defaulter window is still active

        return false;
    }
}
