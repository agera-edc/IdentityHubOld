package org.eclipse.dataspaceconnector.identityhub.service;

import org.eclipse.dataspaceconnector.identityhub.dtos.HubObject;
import org.eclipse.dataspaceconnector.identityhub.dtos.MessageResponseObject;
import org.eclipse.dataspaceconnector.identityhub.dtos.MessageStatus;
import org.eclipse.dataspaceconnector.identityhub.store.IdentityHubStore;

import java.util.ArrayList;
import java.util.List;

import static org.eclipse.dataspaceconnector.identityhub.dtos.MessageResponseObject.MESSAGE_ID_VALUE;

/**
 * MessageProcessor used to process RequestObject with method "CollectionsQuery", in order to query HubOjects.
 */
public class CollectionsQueryProcessor implements MessageProcessor {

    private IdentityHubStore identityHubStore;

    public CollectionsQueryProcessor(IdentityHubStore identityHubStore) {
        this.identityHubStore = identityHubStore;
    }

    @Override
    public MessageResponseObject process(byte[] data) {
        List<HubObject> entries = new ArrayList<>(identityHubStore.getAll());
        return MessageResponseObject.Builder.newInstance()
                .messageId(MESSAGE_ID_VALUE)
                .status(MessageStatus.OK)
                .entries(entries)
                .build();
    }
}
