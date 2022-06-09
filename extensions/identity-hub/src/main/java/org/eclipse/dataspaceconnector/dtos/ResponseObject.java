package org.eclipse.dataspaceconnector.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * See <a href="https://identity.foundation/decentralized-web-node/spec/#response-objects">Response Object documentation</a>
 */
@JsonDeserialize(builder = ResponseObject.Builder.class)
public class ResponseObject {
    private String requestId;
    private RequestStatus status;
    private List<MessageResultObject> replies;

    private ResponseObject(String requestId, RequestStatus status, List<MessageResultObject> replies) {
        this.requestId = requestId;
        this.status = status;
        this.replies = replies;
    }

    public String getRequestId() {
        return requestId;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public List<MessageResultObject> getReplies() {
        return replies;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {
        ResponseObject responseObject;

        private Builder() {
            responseObject = new ResponseObject("", null, List.of());
        }

        @JsonCreator
        public static Builder newInstance() {
            return new Builder();
        }

        public Builder requestId(String requestId) {
            responseObject.requestId = requestId;
            return this;
        }

        public Builder status(RequestStatus status) {
            responseObject.status = status;
            return this;
        }

        public Builder replies(List<MessageResultObject> replies) {
            responseObject.replies = new ArrayList<>(replies);
            return this;
        }

        public ResponseObject build() {
            return responseObject;
        }
    }
}
