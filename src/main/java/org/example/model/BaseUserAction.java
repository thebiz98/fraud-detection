package org.example.model;

import org.example.enums.UserAction;

public class BaseUserAction {
    String userId;
    UserAction userAction;

    public BaseUserAction(String userId, UserAction userAction) {
        this.userId = userId;
        this.userAction = userAction;
    }

    public String getUserId() {
        return this.userId;
    }

    public UserAction getUserAction() {
        return this.userAction;
    }
}
