package org.eclipse.dataspaceconnector.identityhub.api.featuredetection;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.internal.ValidatableResponseImpl;
import io.restassured.specification.RequestSpecification;
import org.bouncycastle.util.encoders.Base64;
import org.eclipse.dataspaceconnector.dtos.Descriptor;
import org.eclipse.dataspaceconnector.dtos.MessageRequestObject;
import org.eclipse.dataspaceconnector.dtos.Descriptor;
import org.eclipse.dataspaceconnector.dtos.MessageRequestObject;
import org.eclipse.dataspaceconnector.dtos.RequestObject;
import org.eclipse.dataspaceconnector.dtos.VerifiableCredential;
import org.eclipse.dataspaceconnector.identityhub.client.ApiClient;
import org.eclipse.dataspaceconnector.identityhub.client.ApiClientFactory;
import org.eclipse.dataspaceconnector.junit.launcher.EdcExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

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

    @Test
    void invalidMessageMethod() {
        String requestId = "id";
        var requestObject = RequestObject.Builder.newInstance()
                .requestId(requestId)
                .target("target")
                .addMessageRequestObject(
                        MessageRequestObject.Builder.newInstance()
                                .descriptor(new Descriptor("Not supported", "", "", ""))
                                .build())
                .build();

        baseRequest()
            .body(requestObject)
            .post()
        .then()
            .statusCode(200)
            .body("requestId", equalTo(requestId))
            .body("replies", hasSize(1))
            .body("replies[0].status.code", equalTo(501))
            .body("replies[0].status.detail", equalTo("The interface method is not implemented"));
    }

    @Test
    void writeCollections() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Descriptor descriptor = new Descriptor("CollectionsWrite", "", "", "");
        VerifiableCredential credential = new VerifiableCredential();
        String data = new String(Base64.encode(mapper.writeValueAsString(credential).getBytes(StandardCharsets.UTF_8)));
        MessageRequestObject message = new MessageRequestObject(descriptor, data);
        var messages = List.of(message);
        RequestObject requestObject = new RequestObject("id", "target", messages);

        var result = baseRequest()
                .body(requestObject)
                .post()
                .then()
                .statusCode(200);
        // TODO: Improve assertion
    }

    private RequestSpecification baseRequest() {
        return given()
                .baseUri(API_URL)
                .basePath("/identity-hub")
                .contentType("application/json")
            .when();
    }
}