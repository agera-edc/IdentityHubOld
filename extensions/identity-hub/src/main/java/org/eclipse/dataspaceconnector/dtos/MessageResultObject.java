package org.eclipse.dataspaceconnector.dtos;

import java.util.List;

/**
 * See <a href="https://identity.foundation/decentralized-web-node/spec/#response-objects">Response Object documentation</a>
 * and <a href="https://identity.foundation/decentralized-web-node/spec/#messages">message documentation</a>.
 */
public class MessageResultObject {
    private final String messageId;
    private final Status status;
    private final List<HubObject> entries;

    public MessageResultObject(String requestId, Status status, List<HubObject> entries) {
        this.messageId = requestId;
        this.status = status;
        this.entries = entries;
    }

    public String getMessageId() {
        return messageId;
    }

    public Status getStatus() {
        return status;
    }

    public List<HubObject> getEntries() {
        return entries;
    }
}
