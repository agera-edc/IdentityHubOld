package org.eclipse.dataspaceconnector.identityhub.processor;

import org.eclipse.dataspaceconnector.identityhub.dtos.HubObject;
import org.eclipse.dataspaceconnector.identityhub.dtos.MessageResponseObject;
import org.eclipse.dataspaceconnector.identityhub.dtos.MessageStatus;
import org.eclipse.dataspaceconnector.identityhub.store.IdentityHubStore;

import java.util.ArrayList;
import java.util.List;

import static org.eclipse.dataspaceconnector.identityhub.dtos.MessageResponseObject.MESSAGE_ID_VALUE;

/**
 * Processor of "CollectionsQuery" messages, returning the list of {@link HubObject}s available in the {@link IdentityHubStore}
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
