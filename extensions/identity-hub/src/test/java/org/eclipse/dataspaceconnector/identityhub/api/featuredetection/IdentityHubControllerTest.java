package org.eclipse.dataspaceconnector.identityhub.api.featuredetection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.restassured.specification.RequestSpecification;
import org.bouncycastle.util.encoders.Base64;
import org.eclipse.dataspaceconnector.identityhub.dtos.Descriptor;
import org.eclipse.dataspaceconnector.identityhub.dtos.MessageRequestObject;
import org.eclipse.dataspaceconnector.identityhub.dtos.RequestObject;
import org.eclipse.dataspaceconnector.identityhub.dtos.VerifiableCredential;
import org.eclipse.dataspaceconnector.junit.launcher.EdcExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Assertions.assertThat;
import static org.eclipse.dataspaceconnector.identityhub.dtos.WebNodeInterfaces.COLLECTIONS_QUERY;
import static org.eclipse.dataspaceconnector.identityhub.dtos.WebNodeInterfaces.COLLECTIONS_WRITE;
import static org.eclipse.dataspaceconnector.identityhub.dtos.WebNodeInterfaces.FEATURE_DETECTION_READ;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

@ExtendWith(EdcExtension.class)
public class IdentityHubControllerTest {

    private static final String API_URL = "http://localhost:8181/api";
    private static final Faker FAKER = new Faker();
    private static final String VERIFIABLE_CREDENTIAL_ID = FAKER.internet().uuid();
    private static final String NONCE = FAKER.internet().uuid();
    private static final String TARGET = FAKER.internet().url();
    private static final String REQUEST_ID = FAKER.internet().uuid();
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Test
    void pushAndQueryVerifiableCredentials() throws IOException {
        VerifiableCredential credential = VerifiableCredential.Builder.newInstance().id(VERIFIABLE_CREDENTIAL_ID).build();

        pushVerifiableCredential(credential);
        List<VerifiableCredential> verifiableCredentials = queryVerifiableCredentials();

        assertThat(verifiableCredentials).usingRecursiveFieldByFieldElementComparator().containsExactly(credential);
    }

    private void pushVerifiableCredential(VerifiableCredential credential) throws IOException {
        byte[] data = Base64.encode(OBJECT_MAPPER.writeValueAsString(credential).getBytes(StandardCharsets.UTF_8));

        RequestObject requestObject = RequestObject.Builder.newInstance()
            .requestId(REQUEST_ID)
            .target(TARGET)
            .addMessageRequestObject(MessageRequestObject.Builder.newInstance()
                .descriptor(Descriptor.Builder.newInstance()
                    .method(COLLECTIONS_WRITE)
                    .nonce(NONCE)
                    .build())
                .data(data)
                .build())
            .build();

        baseRequest()
            .body(requestObject)
            .post()
        .then()
            .statusCode(200)
            .body("requestId", equalTo(REQUEST_ID))
            .body("replies", hasSize(1))
            .body("replies[0].status.code", equalTo(200))
            .body("replies[0].status.detail", equalTo("The message was successfully processed"))
            .body("replies[0].entries", hasSize(0));
    }

    private List<VerifiableCredential> queryVerifiableCredentials() {
        RequestObject requestObject = RequestObject.Builder.newInstance()
            .requestId(REQUEST_ID)
            .target(TARGET)
            .addMessageRequestObject(MessageRequestObject.Builder.newInstance()
                .descriptor(Descriptor.Builder.newInstance()
                    .method(COLLECTIONS_QUERY)
                    .nonce(NONCE)
                    .build())
                .build())
            .build();

        return baseRequest()
            .body(requestObject)
            .post()
        .then()
            .statusCode(200)
            .body("requestId", equalTo(REQUEST_ID))
            .body("replies", hasSize(1))
            .body("replies[0].status.code", equalTo(200))
            .body("replies[0].status.detail", equalTo("The message was successfully processed"))
            .extract().body().jsonPath().getList("replies[0].entries", VerifiableCredential.class);
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
                        .method(FEATURE_DETECTION_READ)
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
    void methodNotImplemented() {
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
