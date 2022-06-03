package org.eclipse.dataspaceconnector.dtos;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JsonDeserialize(builder = FeatureDetection.Builder.class)
public class FeatureDetection {
    private static final String type = "FeatureDetection";

    private List<WebNodeInterface> interfaces;

    public String getType() {
        return type;
    }

    public List<WebNodeInterface> getInterfaces() {
        return Collections.unmodifiableList(interfaces);
    }

    private FeatureDetection() {
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

        public FeatureDetection.Builder interfaces(List<WebNodeInterface> interfaces) {
            featureDetection.interfaces = interfaces;
            return this;
        }

        public FeatureDetection build() {
            return featureDetection;
        }

    }
}
