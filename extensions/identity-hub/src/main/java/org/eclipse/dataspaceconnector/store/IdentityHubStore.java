package org.eclipse.dataspaceconnector.store;

import org.eclipse.dataspaceconnector.dtos.HubObject;

import java.util.Collection;

/**
 * IdentityHubStore store used to store HubObjects.
 * A custom IdentityHubStore store can be injected via service loader as an EDC Service extension.
 */
public interface IdentityHubStore {

    Collection<HubObject> getAll();

    void add(HubObject hubObject);
}
