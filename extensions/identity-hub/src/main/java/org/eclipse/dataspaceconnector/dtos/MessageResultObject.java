package org.eclipse.dataspaceconnector.dtos;

import java.util.List;

/**
 * See <a href="https://identity.foundation/decentralized-web-node/spec/#response-objects">Response Object documentation</a>
 * and <a href="https://identity.foundation/decentralized-web-node/spec/#messages">message documentation</a>.
 */
public class MessageResultObject {
    private final String messageId;
    private final MessageStatus status;
    private final List<HubObject> entries;

    public MessageResultObject(String requestId, MessageStatus status, List<HubObject> entries) {
        this.messageId = requestId;
        this.status = status;
        this.entries = entries;
    }

    public String getMessageId() {
        return messageId;
    }

    public MessageStatus getStatus() {
        return status;
    }

    public List<HubObject> getEntries() {
        return entries;
    }
}