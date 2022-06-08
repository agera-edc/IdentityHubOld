package org.eclipse.dataspaceconnector.service;

import org.eclipse.dataspaceconnector.store.IdentityHubStore;

public class MessageProcessorFactory {
    private final IdentityHubStore identityHubStore;

    public MessageProcessorFactory(IdentityHubStore identityHubStore) {
        this.identityHubStore = identityHubStore;
    }

    public MessageProcessor create(String method) {
        switch (method) {
            case "CollectionsQuery":
                return new CollectionsQueryProcessor();
            case "CollectionsWrite":
                return new CollectionsWriteProcessor(identityHubStore);
            default:
                return new InterfaceNotImplementedProcessor();
        }
    }
}
