package org.eclipse.dataspaceconnector.identityhub.store;

import org.eclipse.dataspaceconnector.identityhub.dtos.HubObject;

import java.util.ArrayList;
import java.util.Collection;

/**
 * In memory store of Hub Objects.
 */
// TODO: Add tests when the logic to store objects is defined
// TODO: Handle concurrency
public class IdentityHubInMemoryStore implements IdentityHubStore {

    private final Collection<HubObject> hubObjects = new ArrayList<>();

    @Override
    public Collection<HubObject> getAll() {
        return hubObjects;
    }

    @Override
    public void add(HubObject hubObject) {
        hubObjects.add(hubObject);
    }
}
