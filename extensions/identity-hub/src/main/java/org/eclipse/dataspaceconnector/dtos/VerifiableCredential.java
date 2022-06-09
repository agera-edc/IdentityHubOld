package org.eclipse.dataspaceconnector.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = VerifiableCredential.Builder.class)
public class VerifiableCredential implements HubObject {
    String id;

    public String getId() {
        return id;
    }
    private VerifiableCredential() {
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {
        VerifiableCredential verifiableCredential;

        private Builder() {
            verifiableCredential = new VerifiableCredential();
        }

        @JsonCreator
        public static Builder newInstance() {
            return new Builder();
        }

        public Builder id(String id) {
            verifiableCredential.id = id;
            return this;
        }

        public VerifiableCredential build() {
            return verifiableCredential;
        }
    }
}
