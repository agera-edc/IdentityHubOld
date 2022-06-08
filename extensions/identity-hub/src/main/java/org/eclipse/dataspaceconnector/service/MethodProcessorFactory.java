package org.eclipse.dataspaceconnector.service;

import org.eclipse.dataspaceconnector.store.IdentityHubStore;

public class MethodProcessorFactory {
    private IdentityHubStore identityHubStore;

    public MethodProcessorFactory(IdentityHubStore identityHubStore) {
        this.identityHubStore = identityHubStore;
    }

    public MethodProcessor create(String method) {
        switch (method) {
            case "CollectionsQuery":
                return new CollectionsQueryProcessor();
            case "CollectionsWrite":
                return new CollectionsWriteProcessor(identityHubStore);
            default:
                throw new IllegalArgumentException("Bad method: " + method);
        }
    }
}
