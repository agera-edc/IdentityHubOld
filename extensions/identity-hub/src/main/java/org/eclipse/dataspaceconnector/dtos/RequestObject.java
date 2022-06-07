package org.eclipse.dataspaceconnector.dtos;

import java.util.List;

public class RequestObject {
    private final String requestId;
    private final String target;
    private final List<MessageRequestObject> messages;

    public RequestObject(String requestId, String target, List<MessageRequestObject> messages) {
        this.requestId = requestId;
        this.target = target;
        this.messages = messages;
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
}
