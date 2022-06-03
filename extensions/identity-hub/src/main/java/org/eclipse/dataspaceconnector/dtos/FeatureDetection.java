package org.eclipse.dataspaceconnector.dtos;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.eclipse.dataspaceconnector.policy.model.Policy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(builder = FeatureDetection.Builder.class)
public class FeatureDetection {
    private static final String type = "FeatureDetection";
    private List<Object> interfaces;

    public String type() {
        return type;
    }

    public List<Object> getInterfaces() {
        return interfaces;
    }

    private FeatureDetection() {
        // TODO: Implement interface data model https://identity.foundation/decentralized-web-node/spec/#interfaces
        interfaces = new ArrayList<>();
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder {
        private final FeatureDetection featureDetection;

        public Builder() {
            featureDetection = new FeatureDetection();
        }

        public static FeatureDetection.Builder newInstance() {
            return new FeatureDetection.Builder();
        }

        public FeatureDetection.Builder interfaces(List<Object> interfaces) {
            featureDetection.interfaces = interfaces;
            return this;
        }

        public FeatureDetection build() {
            return featureDetection;
        }

    }
}
