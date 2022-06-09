package org.eclipse.dataspaceconnector.service;

import org.eclipse.dataspaceconnector.dtos.MessageResponseObject;
import org.eclipse.dataspaceconnector.dtos.MessageStatus;

import java.util.List;

import static org.eclipse.dataspaceconnector.dtos.MessageResponseObject.MESSAGE_ID_VALUE;

public class InterfaceNotImplementedProcessor implements MessageProcessor {

    @Override
    public MessageResponseObject process(byte[] data) {
        return MessageResponseObject.Builder.newInstance()
                .messageId(MESSAGE_ID_VALUE)
                .status(MessageStatus.INTERFACE_NOT_IMPLEMENTED)
                .entries(List.of())
                .build();
    }
}
