package org.eclipse.dataspaceconnector.identityhub.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.Objects;

/**
 * VerifiableCredential is a supported format that can be specified as the data associated with MessageRequestObject.
 * application/vc+ldp - the data is a JSON-LD formatted <a href="https://www.w3.org/TR/vc-data-model/">W3C Verifiable Credential</a>.
 */
// TODO: implement Verifiable Credential model
@JsonDeserialize(builder = VerifiableCredential.Builder.class)
public class VerifiableCredential implements HubObject {
    private String id;

    private VerifiableCredential() {
    }

    public String getId() {
        return id;
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
            Objects.requireNonNull(verifiableCredential.id, "VerifiableCredential must contain id property.");
            return verifiableCredential;
        }
    }
}
