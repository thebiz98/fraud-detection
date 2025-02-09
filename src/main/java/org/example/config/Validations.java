package org.example.config;

import org.example.enums.UserAction;

import java.util.List;

public class Validations {
    private List<Check> checks;

    public List<Check> getChecks() {
        return checks;
    }

    public Validations() {
        this.checks = List.of(new Check(UserAction.TRANSACTION, 1800, "location", "valid", null),
                new Check(UserAction.TRANSACTION, 1800, "deviceId", "valid", null));
    }
}
