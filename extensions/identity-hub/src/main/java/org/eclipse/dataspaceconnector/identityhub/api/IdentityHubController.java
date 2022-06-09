package org.eclipse.dataspaceconnector.identityhub.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.eclipse.dataspaceconnector.identityhub.dtos.MessageRequestObject;
import org.eclipse.dataspaceconnector.identityhub.dtos.MessageResponseObject;
import org.eclipse.dataspaceconnector.identityhub.dtos.RequestObject;
import org.eclipse.dataspaceconnector.identityhub.dtos.RequestStatus;
import org.eclipse.dataspaceconnector.identityhub.dtos.ResponseObject;
import org.eclipse.dataspaceconnector.identityhub.service.MessageProcessor;
import org.eclipse.dataspaceconnector.identityhub.service.MessageProcessorFactory;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "IdentityHub")
@Produces({"application/json"})
@Consumes({"application/json"})
@Path("/identity-hub")
/**
 * Identity Hub controller, exposing an endpoint to process <a href="https://identity.foundation/decentralized-web-node/spec/#request-objects">Request Objects</a>.
 */
public class IdentityHubController {

    private final MessageProcessorFactory messageProcessorFactory;

    public IdentityHubController(MessageProcessorFactory messageProcessorFactory) {
        this.messageProcessorFactory = messageProcessorFactory;
    }

    @POST
    public ResponseObject handleRequest(RequestObject requestObject) {
        List<MessageResponseObject> replies = requestObject.getMessages()
                .stream()
                .map(this::processMessage)
                .collect(Collectors.toList());

        return ResponseObject.Builder.newInstance()
                .requestId(requestObject.getRequestId())
                .status(RequestStatus.OK)
                .replies(replies)
                .build();
    }

    private MessageResponseObject processMessage(MessageRequestObject messageRequestObject) {
        String method = messageRequestObject.getDescriptor().getMethod();
        MessageProcessor processor = messageProcessorFactory.create(method);
        byte[] bytes = messageRequestObject.getData();
        return processor.process(bytes);
    }

}

