package org.eclipse.dataspaceconnector.identityhub.service;

import org.eclipse.dataspaceconnector.identityhub.dtos.MessageResponseObject;
import org.eclipse.dataspaceconnector.identityhub.dtos.MessageStatus;

import java.util.List;

import static org.eclipse.dataspaceconnector.identityhub.dtos.MessageResponseObject.MESSAGE_ID_VALUE;

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
