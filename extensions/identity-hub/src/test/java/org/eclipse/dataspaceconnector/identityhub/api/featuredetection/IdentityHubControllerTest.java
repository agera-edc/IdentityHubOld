package org.eclipse.dataspaceconnector.identityhub.api.featuredetection;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.internal.ValidatableResponseImpl;
import io.restassured.specification.RequestSpecification;
import org.bouncycastle.util.encoders.Base64;
import org.eclipse.dataspaceconnector.dtos.Descriptor;
import org.eclipse.dataspaceconnector.dtos.MessageRequestObject;
import org.eclipse.dataspaceconnector.dtos.RequestObject;
import org.eclipse.dataspaceconnector.dtos.VerifiableCredential;
import org.eclipse.dataspaceconnector.identityhub.client.ApiClient;
import org.eclipse.dataspaceconnector.identityhub.client.ApiClientFactory;
import org.eclipse.dataspaceconnector.junit.launcher.EdcExtension;
import org.eclipse.dataspaceconnector.junit.launcher.EdcRuntimeExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

@ExtendWith(EdcExtension.class)
public class IdentityHubControllerTest {

    static final String API_URL = "http://localhost:8181/api";
    ApiClient apiClient = ApiClientFactory.createApiClient(API_URL);
    ObjectMapper mapper = new ObjectMapper();

    @Test
    void queryCollections() throws IOException {
        RequestObject requestObject = new RequestObject("id", "target", List.of());
        String serializedRequestObject = mapper.writeValueAsString(requestObject);
        baseRequest()
                .body(serializedRequestObject)
                .post()
                .then()
                .statusCode(200);
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
        String serializedRequestObject = mapper.writeValueAsString(requestObject);

        var result = baseRequest()
                .body(serializedRequestObject)
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
