package org.eclipse.dataspaceconnector.dtos;

import java.util.List;

public class RequestObject {
    String requestId;
    String target;
    List<MessageObject> messages;

    public RequestObject(String requestId, String target, List<MessageObject> messages) {
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

    public List<MessageObject> getMessages() {
        return messages;
    }
}
