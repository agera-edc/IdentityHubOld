package org.eclipse.dataspaceconnector.service;

import org.eclipse.dataspaceconnector.dtos.MessageResponseObject;
import org.eclipse.dataspaceconnector.dtos.MessageStatus;

import java.util.List;

public class InterfaceNotImplementedProcessor implements MessageProcessor {

    @Override
    public MessageResponseObject process(byte[] data) {
        return MessageResponseObject.Builder.newInstance()
                .messageId("messageId")
                .status(MessageStatus.INTERFACE_NOT_IMPLEMENTED)
                .entries(List.of())
                .build();
    }
}
