package org.eclipse.dataspaceconnector.identityhub.api.featuredetection;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

/**
 * API controller to provide Feature Detection object.
 */
@Tag(name = "FeatureDetection")
@Produces({"application/json"})
@Consumes({"application/json"})
@Path("/featuredetection")
public class FeatureDetectionController {

    @GET
    public Response featureDetection() {
        return Response.ok().build();
    }
}
