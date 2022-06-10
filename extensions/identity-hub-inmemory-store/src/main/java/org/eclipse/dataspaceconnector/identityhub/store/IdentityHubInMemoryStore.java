package org.eclipse.dataspaceconnector.identityhub.store;

import org.eclipse.dataspaceconnector.identityhub.dtos.HubObject;

import java.util.ArrayList;
import java.util.Collection;

/**
 * In memory store of Hub Objects.
 */
// TODO: Handle concurrency
// TODO: use EDC defaulting mechanism as in DefaultServicesExtension
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
