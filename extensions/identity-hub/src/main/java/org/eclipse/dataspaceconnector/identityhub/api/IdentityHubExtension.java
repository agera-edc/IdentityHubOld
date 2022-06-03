package org.eclipse.dataspaceconnector.identityhub.api;

import org.eclipse.dataspaceconnector.identityhub.api.health.HealthApiController;
import org.eclipse.dataspaceconnector.spi.WebService;
import org.eclipse.dataspaceconnector.spi.system.Inject;
import org.eclipse.dataspaceconnector.spi.system.ServiceExtension;
import org.eclipse.dataspaceconnector.spi.system.ServiceExtensionContext;

/**
 * EDC extension to boot the services used by the Registration Service.
 */
public class IdentityHubExtension implements ServiceExtension {
    @Inject
    private WebService webService;

    @Override
    public void initialize(ServiceExtensionContext context) {
        var controller = new HealthApiController();
        webService.registerResource(controller);
    }
}
