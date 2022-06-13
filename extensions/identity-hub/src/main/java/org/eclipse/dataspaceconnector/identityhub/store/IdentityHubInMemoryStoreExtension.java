package org.eclipse.dataspaceconnector.identityhub.store;

import org.eclipse.dataspaceconnector.spi.system.Inject;
import org.eclipse.dataspaceconnector.spi.system.Provider;
import org.eclipse.dataspaceconnector.spi.system.Provides;
import org.eclipse.dataspaceconnector.spi.system.ServiceExtension;

/**
 * ServiceExtension used to provide an in-memory store of HubObjects.
 */
@Provides(IdentityHubStore.class)
public class IdentityHubInMemoryStoreExtension implements ServiceExtension {

    @Inject
    IdentityHubStore identityHubStore;

    @Provider(isDefault = true)
    public IdentityHubStore defaultIdentityHubStore() {
        return new IdentityHubInMemoryStore();
    }
}
