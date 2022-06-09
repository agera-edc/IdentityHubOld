package org.eclipse.dataspaceconnector.identityhub.api.featuredetection;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.eclipse.dataspaceconnector.dtos.FeatureDetection;

/**
 * API controller to provide Feature Detection object.
 */
@Tag(name = "FeatureDetection")
@Produces({"application/json"})
@Consumes({"application/json"})
@Path("/featuredetection")

// TODO: Move logic to common endpoint instead of having this controller.
public class FeatureDetectionController {

    @GET
    public FeatureDetection featureDetection() {
        return new FeatureDetection.Builder().build();
    }
}
