package org.eclipse.dataspaceconnector.identityhub.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * See <a href="https://identity.foundation/decentralized-web-node/spec/#request-objects">Request Object documentation</a>
 */
public class RequestObject {

    private String requestId;
    private String target;
    private List<MessageRequestObject> messages = new ArrayList<>();

    private RequestObject() {
    }

    public String getRequestId() {
        return requestId;
    }

    public String getTarget() {
        return target;
    }

    public List<MessageRequestObject> getMessages() {
        return messages;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder {
        private final RequestObject requestObject;

        private Builder() {
            this(new RequestObject());
        }

        private Builder(RequestObject requestObject) {
            this.requestObject = requestObject;
        }

        @JsonCreator()
        public static RequestObject.Builder newInstance() {
            return new RequestObject.Builder();
        }

        public RequestObject.Builder requestId(String requestId) {
            requestObject.requestId = requestId;
            return this;
        }

        public RequestObject.Builder target(String target) {
            requestObject.target = target;
            return this;
        }

        public RequestObject.Builder addMessageRequestObject(MessageRequestObject messageRequestObject) {
            requestObject.messages.add(messageRequestObject);
            return this;
        }

        public RequestObject build() {
            Objects.requireNonNull(requestObject.getRequestId(), "RequestObject must contain  requestId property.");
            Objects.requireNonNull(requestObject.getTarget(), "RequestObject must contain target property.");
            return requestObject;
        }
    }
}