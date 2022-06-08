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
import org.eclipse.dataspaceconnector.service.MessageProcessor;
import org.eclipse.dataspaceconnector.service.MessageProcessorFactory;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "IdentityHub")
@Produces({"application/json"})
@Consumes({"application/json"})
@Path("/identity-hub")
public class IdentityHubController {

    private final MessageProcessorFactory messageProcessorFactory;

    public IdentityHubController(MessageProcessorFactory messageProcessorFactory) {
        this.messageProcessorFactory = messageProcessorFactory;
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
        MessageProcessor processor = messageProcessorFactory.create(method);
        return processor.process(messageRequestObject.getData().getBytes(StandardCharsets.UTF_8));
    }

}

