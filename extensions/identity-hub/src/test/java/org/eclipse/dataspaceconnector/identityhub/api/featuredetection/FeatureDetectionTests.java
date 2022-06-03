package org.eclipse.dataspaceconnector.identityhub.api.featuredetection;

import org.eclipse.dataspaceconnector.identityhub.client.ApiClient;
import org.eclipse.dataspaceconnector.identityhub.client.ApiClientFactory;
import org.eclipse.dataspaceconnector.identityhub.client.api.FeatureDetectionApi;
import org.eclipse.dataspaceconnector.identityhub.client.models.FeatureDetection;
import org.eclipse.dataspaceconnector.junit.launcher.EdcRuntimeExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.util.ArrayList;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FeatureDetectionTests {

    @RegisterExtension
    static EdcRuntimeExtension edc = new EdcRuntimeExtension(
            ":extensions:identity-hub",
            "identity-hub",
            Map.of()
    );

    final String API_URL = "http://localhost:8181/api";
    ApiClient apiClient = ApiClientFactory.createApiClient(API_URL);
    FeatureDetectionApi featureDetectionClient = new FeatureDetectionApi(apiClient);

    @Test
    void featureDetectionTest() {
        var expectedFeatureDetection = new FeatureDetection().interfaces(new ArrayList<>());
        var response = featureDetectionClient.featureDetection();
        assertThat(response).usingRecursiveComparison().isEqualTo(expectedFeatureDetection);
    }
}
