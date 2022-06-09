package org.eclipse.dataspaceconnector.service;

import org.eclipse.dataspaceconnector.dtos.MessageResultObject;
import org.eclipse.dataspaceconnector.dtos.MessageStatus;

import java.util.List;

public class InterfaceNotImplementedProcessor implements MessageProcessor {

    @Override
    public MessageResultObject process(byte[] data) {
        return MessageResultObject.Builder.newInstance()
                .messageId("messageId")
                .status(MessageStatus.INTERFACE_NOT_IMPLEMENTED)
                .entries(List.of())
                .build();
    }
}
