package org.example.dao;

import org.example.model.LoginEvent;

import java.util.List;

public class LoginDAO {

    public void saveLoginEvent(LoginEvent loginEvent) {
        // save login event to database
    }

    public List<LoginEvent> getLoginEventHistory(String userId) {
        // return login events for user
        return null;
    }
}
