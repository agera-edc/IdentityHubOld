package org.eclipse.dataspaceconnector.dtos;

import java.util.List;

/**
 * See <a href="https://identity.foundation/decentralized-web-node/spec/#response-objects">Response Object documentation</a>
 */
public class ResponseObject {
    private final String requestId;
    private final RequestStatus status;
    private final List<MessageResultObject> replies;

    public ResponseObject(String requestId, RequestStatus status, List<MessageResultObject> replies) {
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
}
