package org.example.model;

import org.example.enums.UserAction;

public class LoginEvent extends BaseUserAction {
    private String ipAddress;
    private String deviceId;

    public LoginEvent(String userId, String ipAddress, String deviceId) {
        super(userId, UserAction.LOGIN);

    }
}
