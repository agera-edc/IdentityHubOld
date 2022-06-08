package org.eclipse.dataspaceconnector.identityhub.api.featuredetection;

import io.restassured.specification.RequestSpecification;
import org.eclipse.dataspaceconnector.dtos.RequestObject;
import org.eclipse.dataspaceconnector.identityhub.client.ApiClient;
import org.eclipse.dataspaceconnector.identityhub.client.ApiClientFactory;
import org.eclipse.dataspaceconnector.junit.launcher.EdcExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(EdcExtension.class)
public class IdentityHubControllerTest {

    static final String API_URL = "http://localhost:8181/api";
    ApiClient apiClient = ApiClientFactory.createApiClient(API_URL);

    @Test
    void queryCollections() {
        String requestId = "id";
        RequestObject requestObject = new RequestObject(requestId, "target", List.of());

        baseRequest()
            .body(requestObject)
            .post()
        .then()
            .statusCode(200)
            .body("requestId", equalTo(requestId));
    }

    private RequestSpecification baseRequest() {
        return given()
                .baseUri(API_URL)
                .basePath("/identity-hub")
                .contentType("application/json")
            .when();
    }
}
