package org.eclipse.dataspaceconnector.identityhub.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.eclipse.dataspaceconnector.dtos.HubObject;
import org.eclipse.dataspaceconnector.dtos.MessageRequestObject;
import org.eclipse.dataspaceconnector.dtos.MessageResultObject;
import org.eclipse.dataspaceconnector.dtos.RequestObject;
import org.eclipse.dataspaceconnector.dtos.ResponseObject;
import org.eclipse.dataspaceconnector.dtos.Status;
import org.eclipse.dataspaceconnector.dtos.VerifiableCredential;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "IdentityHub")
@Produces({"application/json"})
@Consumes({"application/json"})
@Path("/identity-hub")
public class IdentityHubController {

    @POST
    public ResponseObject get(RequestObject requestObject) {
        List<MessageResultObject> replies = requestObject.getMessages()
                .stream()
                .map(this::processMessage)
                .collect(Collectors.toList());

        return new ResponseObject(
                requestObject.getRequestId(),
                new Status("200", ""),
                replies);
    }

    private MessageResultObject processMessage(MessageRequestObject messageRequestObject) {
        String method = messageRequestObject.getDescriptor().getMethod();

        // dispatch message to corresponding method processor (TBD)
        List<HubObject> entries = processMethod();

        return new MessageResultObject("messageId",
                new Status("200", ""),
                entries);

    }

    @NotNull
    private List<HubObject> processMethod() {
        return List.of(new VerifiableCredential(), new VerifiableCredential());
    }
}

