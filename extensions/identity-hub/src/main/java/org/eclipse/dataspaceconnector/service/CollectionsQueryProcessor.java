package org.eclipse.dataspaceconnector.service;

import org.eclipse.dataspaceconnector.dtos.HubObject;
import org.eclipse.dataspaceconnector.dtos.MessageResponseObject;
import org.eclipse.dataspaceconnector.dtos.MessageStatus;
import org.eclipse.dataspaceconnector.store.IdentityHubStore;

import java.util.ArrayList;
import java.util.List;

import static org.eclipse.dataspaceconnector.dtos.MessageResponseObject.MESSAGE_ID_VALUE;

public class CollectionsQueryProcessor implements MessageProcessor {

    private IdentityHubStore identityHubStore;

    public CollectionsQueryProcessor(IdentityHubStore identityHubStore) {
        this.identityHubStore = identityHubStore;
    }

    @Override
    public MessageResponseObject process(byte[] data) {
        List<HubObject> entries = new ArrayList<>(identityHubStore.getAll());
        // TODO: Figure out what is supposed to be messageId and use the right implementation.
        return MessageResponseObject.Builder.newInstance()
                .messageId(MESSAGE_ID_VALUE)
                .status(MessageStatus.OK)
                .entries(entries)
                .build();
    }
}
