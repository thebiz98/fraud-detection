package org.example.service.impl;

import org.example.model.BaseUserAction;
import org.example.service.ActionValidatorFactory;
import org.example.service.interfaces.IFraudDetectionService;

public class FraudDetectionServiceImpl implements IFraudDetectionService {

    private final ActionValidatorFactory actionValidatorFactory;

    public FraudDetectionServiceImpl(ActionValidatorFactory actionValidatorFactory) {
        this.actionValidatorFactory = actionValidatorFactory;
    }

    @Override
    public boolean processUserAction(BaseUserAction userAction) {
        return this.actionValidatorFactory.getUserActionValidator(userAction.getUserAction())
                .validateUserAction(userAction);
    }
}
