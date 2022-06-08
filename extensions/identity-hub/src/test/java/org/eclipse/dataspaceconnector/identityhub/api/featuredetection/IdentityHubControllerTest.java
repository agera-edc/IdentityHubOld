package org.eclipse.dataspaceconnector.identityhub.api.featuredetection;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.specification.RequestSpecification;
import org.eclipse.dataspaceconnector.dtos.RequestObject;
import org.eclipse.dataspaceconnector.identityhub.client.ApiClient;
import org.eclipse.dataspaceconnector.identityhub.client.ApiClientFactory;
import org.eclipse.dataspaceconnector.junit.launcher.EdcRuntimeExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class IdentityHubControllerTest {
    @RegisterExtension
    static EdcRuntimeExtension edc = new EdcRuntimeExtension(
            ":extensions:identity-hub",
            "identity-hub",
            Map.of()
    );

    static final String API_URL = "http://localhost:8181/api";
    ApiClient apiClient = ApiClientFactory.createApiClient(API_URL);

    @Test
    void queryCollections() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        RequestObject requestObject = new RequestObject("id", "target", List.of());
        String serializedRequestObject = mapper.writeValueAsString(requestObject);
        baseRequest()
                .body(serializedRequestObject)
                .post()
                .then()
                .statusCode(200);
    }

    private RequestSpecification baseRequest() {
        return given()
                .baseUri(API_URL)
                .basePath("/identity-hub")
                .contentType("application/json")
                .when();
    }
}
