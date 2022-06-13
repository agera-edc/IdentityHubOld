package org.eclipse.dataspaceconnector.identityhub.store;

import org.eclipse.dataspaceconnector.identityhub.dtos.HubObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * In memory store of Hub Objects.
 */
// TODO: Add tests when the logic to store objects is defined
// TODO: Handle concurrency
public class IdentityHubInMemoryStore implements IdentityHubStore {

    private final Collection<HubObject> hubObjects = new ArrayList<>();

    @Override
    public Collection<HubObject> getAll() {
        return List.copyOf(hubObjects);
    }

    @Override
    public void add(HubObject hubObject) {
        hubObjects.add(hubObject);
    }
}
