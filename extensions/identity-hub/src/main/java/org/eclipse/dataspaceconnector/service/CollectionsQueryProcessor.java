package org.eclipse.dataspaceconnector.service;

import org.eclipse.dataspaceconnector.dtos.HubObject;
import org.eclipse.dataspaceconnector.dtos.MessageResultObject;
import org.eclipse.dataspaceconnector.dtos.MessageStatus;
import org.eclipse.dataspaceconnector.dtos.VerifiableCredential;

import java.util.List;

public class CollectionsQueryProcessor implements MessageProcessor {

    @Override
    public MessageResultObject process(byte[] data) {
        // TODO: Read entries and return the right ones
        List<HubObject> entries = List.of(VerifiableCredential.Builder.newInstance().build(), VerifiableCredential.Builder.newInstance().build());
        // TODO: Use a temporary constant for messageId
        // TODO: Figure out what is supposed to be messageId and use the right implementation.
        return MessageResultObject.Builder.newInstance()
                .messageId("messageId")
                .status(MessageStatus.OK)
                .entries(entries)
                .build();
    }
}
