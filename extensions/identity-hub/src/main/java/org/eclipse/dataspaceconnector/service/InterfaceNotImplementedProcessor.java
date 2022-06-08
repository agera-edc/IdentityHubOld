package org.eclipse.dataspaceconnector.service;

import org.eclipse.dataspaceconnector.dtos.MessageResultObject;
import org.eclipse.dataspaceconnector.dtos.MessageStatus;

import java.util.List;

public class InterfaceNotImplementedProcessor implements MessageProcessor {

    @Override
    public MessageResultObject process(String data) {
        return new MessageResultObject("messageId", MessageStatus.INTERFACE_NOT_IMPLEMENTED, List.of());
    }
}
