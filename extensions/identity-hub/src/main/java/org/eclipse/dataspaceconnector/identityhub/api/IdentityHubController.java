package org.eclipse.dataspaceconnector.identityhub.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.eclipse.dataspaceconnector.dtos.MessageRequestObject;
import org.eclipse.dataspaceconnector.dtos.MessageResultObject;
import org.eclipse.dataspaceconnector.dtos.RequestObject;
import org.eclipse.dataspaceconnector.dtos.ResponseObject;
import org.eclipse.dataspaceconnector.dtos.RequestStatus;
import org.eclipse.dataspaceconnector.service.MethodProcessor;
import org.eclipse.dataspaceconnector.service.MethodProcessorFactory;
import org.eclipse.dataspaceconnector.store.IdentityHubStore;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "IdentityHub")
@Produces({"application/json"})
@Consumes({"application/json"})
@Path("/identity-hub")
public class IdentityHubController {

    private IdentityHubStore identityHubStore;
    private final MethodProcessorFactory methodProcessorFactory;

    public IdentityHubController(IdentityHubStore identityHubStore) {
        this.identityHubStore = identityHubStore;
        this.methodProcessorFactory = new MethodProcessorFactory(identityHubStore);
    }

    @POST
    public ResponseObject handleRequest(RequestObject requestObject) {
        List<MessageResultObject> replies = requestObject.getMessages()
                .stream()
                .map(this::processMessage)
                .collect(Collectors.toList());

        return new ResponseObject(requestObject.getRequestId(), RequestStatus.OK, replies);
    }

    private MessageResultObject processMessage(MessageRequestObject messageRequestObject) {
        String method = messageRequestObject.getDescriptor().getMethod();
        MethodProcessor processor = methodProcessorFactory.create(method);
        return processor.process(messageRequestObject.getData());
    }

}

