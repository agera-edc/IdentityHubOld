package org.eclipse.dataspaceconnector.identityhub.api.featuredetection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.restassured.specification.RequestSpecification;
import org.bouncycastle.util.encoders.Base64;
import org.eclipse.dataspaceconnector.dtos.Descriptor;
import org.eclipse.dataspaceconnector.dtos.MessageRequestObject;
import org.eclipse.dataspaceconnector.dtos.RequestObject;
import org.eclipse.dataspaceconnector.dtos.VerifiableCredential;
import org.eclipse.dataspaceconnector.junit.launcher.EdcExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

@ExtendWith(EdcExtension.class)
public class IdentityHubControllerTest {

    private static final String API_URL = "http://localhost:8181/api";
    private static final Faker FAKER = new Faker();

    @Test
    void queryCollections() {
        var requestId = FAKER.internet().uuid();
        var target = FAKER.internet().url();
        var nonce = FAKER.internet().uuid();

        RequestObject requestObject = RequestObject.Builder.newInstance()
            .requestId(requestId)
            .target(target)
            .addMessageRequestObject(MessageRequestObject.Builder.newInstance()
                .descriptor(Descriptor.Builder.newInstance()
                        .method("CollectionsQuery")
                        .nonce(nonce)
                        .build())
                .build())
            .build();

        baseRequest()
            .body(requestObject)
            .post()
        .then()
            .statusCode(200)
            .body("requestId", equalTo(requestId))
            .body("replies", hasSize(1))
            .body("replies[0].status.code", equalTo(200))
            .body("replies[0].status.detail", equalTo("The message was successfully processed"))
            .body("replies[0].entries", hasSize(0));
    }

    @Test
    void writeCollections() throws IOException {
        var requestId = FAKER.internet().uuid();
        var target = FAKER.internet().url();
        var nonce = FAKER.internet().uuid();
        var verifiableCredentialId = FAKER.internet().uuid();

        ObjectMapper mapper = new ObjectMapper();
        VerifiableCredential credential = VerifiableCredential.Builder.newInstance().id(verifiableCredentialId).build();
        byte[] data = Base64.encode(mapper.writeValueAsString(credential).getBytes(StandardCharsets.UTF_8));

        RequestObject requestObject = RequestObject.Builder.newInstance()
            .requestId(requestId)
            .target(target)
            .addMessageRequestObject(MessageRequestObject.Builder.newInstance()
                .descriptor(Descriptor.Builder.newInstance()
                        .method("CollectionsWrite")
                        .nonce(nonce)
                        .build())
                .data(data)
                .build())
            .build();

        baseRequest()
            .body(requestObject)
            .post()
        .then()
            .statusCode(200)
            .body("requestId", equalTo(requestId))
            .body("replies", hasSize(1))
            .body("replies[0].status.code", equalTo(200))
            .body("replies[0].status.detail", equalTo("The message was successfully processed"))
            .body("replies[0].entries", hasSize(0));
    }

    @Test
    void featureDetection() {
        var requestId = FAKER.internet().uuid();
        var target = FAKER.internet().url();
        var nonce = FAKER.internet().uuid();

        var requestObject = RequestObject.Builder.newInstance()
                .requestId(requestId)
                .target(target)
                .addMessageRequestObject(
                        MessageRequestObject.Builder.newInstance()
                                .descriptor(Descriptor.Builder.newInstance()
                                        .method("FeatureDetectionRead")
                                        .nonce(nonce)
                                        .build())
                                .build())
                .build();

        baseRequest()
            .body(requestObject)
            .post()
        .then()
            .statusCode(200)
            .body("requestId", equalTo(requestId))
            .body("replies", hasSize(1))
            .body("replies[0].entries", hasSize(1))
            .body("replies[0].entries[0].interfaces.collections['CollectionsQuery']", is(true))
            .body("replies[0].entries[0].interfaces.collections['CollectionsWrite']", is(true));
    }

    @Test
    void invalidMessageMethod() {
        var requestId = FAKER.internet().uuid();
        var target = FAKER.internet().url();
        var nonce = FAKER.internet().uuid();

        var requestObject = RequestObject.Builder.newInstance()
                .requestId(requestId)
                .target(target)
                .addMessageRequestObject(
                    MessageRequestObject.Builder.newInstance()
                        .descriptor(Descriptor.Builder.newInstance()
                                .method("Not supported")
                                .nonce(nonce)
                                .build())
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

    private RequestSpecification baseRequest() {
        return given()
                .baseUri(API_URL)
                .basePath("/identity-hub")
                .contentType(JSON)
            .when();
    }
}
