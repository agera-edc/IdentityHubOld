package org.eclipse.dataspaceconnector.dtos;

import java.util.List;

/**
 * See <a href="https://identity.foundation/decentralized-web-node/spec/#request-objects">Request Object documentation</a>
 */
public class RequestObject {

    private String requestId;
    private String target;
    private List<MessageRequestObject> messages;

    public RequestObject() {}

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

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setMessages(List<MessageRequestObject> messages) {
        this.messages = messages;
    }
}
