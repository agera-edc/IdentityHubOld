package org.eclipse.dataspaceconnector.identityhub.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import org.eclipse.dataspaceconnector.dtos.RequestObject;

import java.util.List;

@Tag(name = "IdentityHub")
@Produces({"application/json"})
@Consumes({"application/json"})
@Path("/identity-hub")
public class IdentityHubController {

    @POST
    public Response get(RequestObject requestObject) {
        return Response.ok(List.of()).build();
    }
}

