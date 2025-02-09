package org.example.model;

import org.example.enums.UserAction;

public class Transaction extends BaseUserAction {
    double amount;
    String location;
    String deviceId;
    public Transaction(String userId, double amount, String location, String deviceId) {
        super(userId, UserAction.TRANSACTION);
        this.amount = amount;
        this.location = location;
        this.deviceId = deviceId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getLocation() {
        return location;
    }
}
