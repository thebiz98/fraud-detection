package org.example.config;

import org.example.enums.UserAction;

public class Check {
    private final UserAction userAction;
    private final int resetTimeSeconds;
    private final String attribute;
    private final String aggregation;
    private final Integer durationSeconds;

    public Check(UserAction userAction, int resetTime, String attribute, String aggregation, Integer duration) {
        this.userAction = userAction;
        this.resetTimeSeconds = resetTime;
        this.attribute = attribute;
        this.aggregation = aggregation;
        this.durationSeconds = duration;
    }

    public UserAction getUserAction() {
        return userAction;
    }

    public String getAggregation() {
        return aggregation;
    }

    public String getAttribute() {
        return attribute;
    }

    public Integer getDurationSeconds() {
        return durationSeconds;
    }

    public int getResetTimeSeconds() {
        return resetTimeSeconds;
    }
}
