package org.eclipse.dataspaceconnector.identityhub.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.eclipse.dataspaceconnector.dtos.MessageRequestObject;
import org.eclipse.dataspaceconnector.dtos.MessageResponseObject;
import org.eclipse.dataspaceconnector.dtos.RequestObject;
import org.eclipse.dataspaceconnector.dtos.RequestStatus;
import org.eclipse.dataspaceconnector.dtos.ResponseObject;
import org.eclipse.dataspaceconnector.service.MessageProcessor;
import org.eclipse.dataspaceconnector.service.MessageProcessorFactory;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

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

