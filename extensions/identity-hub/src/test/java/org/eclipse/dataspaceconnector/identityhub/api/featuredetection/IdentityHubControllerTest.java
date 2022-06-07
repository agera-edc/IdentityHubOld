package org.eclipse.dataspaceconnector.identityhub.api.featuredetection;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.dataspaceconnector.dtos.RequestObject;
import org.eclipse.dataspaceconnector.identityhub.client.ApiClient;
import org.eclipse.dataspaceconnector.identityhub.client.ApiClientFactory;
import org.eclipse.dataspaceconnector.junit.launcher.EdcRuntimeExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

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
    void queryCollections() throws IOException, InterruptedException, URISyntaxException {
        ObjectMapper mapper = new ObjectMapper();
        RequestObject requestObject = new RequestObject("id", "target", List.of());
        String serializedRequestObject = mapper.writeValueAsString(requestObject);

        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .uri(new URI(API_URL + "/identity-hub"))
                .POST(HttpRequest.BodyPublishers.ofString(serializedRequestObject)).build();

        var response = apiClient
                .getHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        // TODO: Do some assertions.
        System.out.println(response);
    }

}
