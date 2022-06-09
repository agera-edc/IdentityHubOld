package org.eclipse.dataspaceconnector.identityhub.store;

import org.eclipse.dataspaceconnector.dtos.HubObject;
import org.eclipse.dataspaceconnector.store.IdentityHubStore;

import java.util.ArrayList;
import java.util.Collection;

// TODO: Handle concurrency
public class IdentityHubInMemoryStore implements IdentityHubStore {

    Collection<HubObject> hubObjects;

    public IdentityHubInMemoryStore() {
        this.hubObjects = new ArrayList<>();
    }

    @Override
    public Collection<HubObject> getAll() {
        return hubObjects;
    }

    @Override
    public void add(HubObject hubObject) {
        hubObjects.add(hubObject);
    }
}
