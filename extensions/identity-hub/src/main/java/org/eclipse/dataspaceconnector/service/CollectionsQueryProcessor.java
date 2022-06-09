package org.eclipse.dataspaceconnector.service;

import org.eclipse.dataspaceconnector.dtos.HubObject;
import org.eclipse.dataspaceconnector.dtos.MessageResponseObject;
import org.eclipse.dataspaceconnector.dtos.MessageStatus;
import org.eclipse.dataspaceconnector.dtos.VerifiableCredential;
import org.eclipse.dataspaceconnector.store.IdentityHubStore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionsQueryProcessor implements MessageProcessor {

    private IdentityHubStore identityHubStore;

    public CollectionsQueryProcessor(IdentityHubStore identityHubStore) {
        this.identityHubStore = identityHubStore;
    }

    @Override
    public MessageResponseObject process(byte[] data) {
        List<HubObject> entries = new ArrayList<>(identityHubStore.getAll());
        // TODO: Use a temporary constant for messageId
        // TODO: Figure out what is supposed to be messageId and use the right implementation.
        return MessageResponseObject.Builder.newInstance()
                .messageId("messageId")
                .status(MessageStatus.OK)
                .entries(entries)
                .build();
    }
}
