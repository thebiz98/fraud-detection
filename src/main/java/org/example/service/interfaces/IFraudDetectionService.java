package org.example.service.interfaces;

import org.example.model.BaseUserAction;

public interface IFraudDetectionService {
    boolean processUserAction(BaseUserAction userAction);
}
