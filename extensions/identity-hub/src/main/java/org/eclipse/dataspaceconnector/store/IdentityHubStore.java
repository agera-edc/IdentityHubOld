package org.eclipse.dataspaceconnector.store;

import org.eclipse.dataspaceconnector.dtos.HubObject;

import java.util.Collection;

public interface IdentityHubStore {

    Collection<HubObject> getAll();

    void add(HubObject hubObject);
}
