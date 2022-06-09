package org.eclipse.dataspaceconnector.identityhub.store;

import org.eclipse.dataspaceconnector.spi.system.Provides;
import org.eclipse.dataspaceconnector.spi.system.ServiceExtension;
import org.eclipse.dataspaceconnector.spi.system.ServiceExtensionContext;
import org.eclipse.dataspaceconnector.store.IdentityHubStore;

/**
 * ServiceExtension used to provide an in-memory store of HubObjects.
 */
@Provides(IdentityHubStore.class)
public class IdentityHubInMemoryStoreExtension implements ServiceExtension {
    @Override
    public void initialize(ServiceExtensionContext context) {
        context.registerService(IdentityHubStore.class, new IdentityHubInMemoryStore());
    }
}
