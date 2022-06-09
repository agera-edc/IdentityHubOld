package org.eclipse.dataspaceconnector.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * MessageResponseObject are objects in the replies of a <a href="https://identity.foundation/decentralized-web-node/spec/#response-objects">Response Object </a>.
 * See <a href="https://identity.foundation/decentralized-web-node/spec/#messages">message documentation</a>.
 */
@JsonDeserialize(builder = MessageResponseObject.Builder.class)
public class MessageResponseObject {
    private String messageId;
    private MessageStatus status;
    private List<HubObject> entries;

    private MessageResponseObject(String messageId, MessageStatus status, List<HubObject> entries) {
        this.messageId = messageId;
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

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {
        private MessageResponseObject messageResponseObject;

        private Builder() {
            messageResponseObject = new MessageResponseObject("", null, List.of());
        }

        @JsonCreator()
        public static Builder newInstance() {
            return new Builder();
        }

        public Builder messageId(String messageId) {
            messageResponseObject.messageId = messageId;
            return this;
        }

        public Builder status(MessageStatus status) {
            messageResponseObject.status = status;
            return this;
        }

        public Builder entries(List<HubObject> entries) {
            messageResponseObject.entries = Collections.unmodifiableList(entries);
            return this;
        }

        public MessageResponseObject build() {
            // TODO: Validate that messageId is a stringified Version 1 CID of the associated message.
            Objects.requireNonNull(messageResponseObject.messageId, "MessageResponseObject must contain messageId property.");
            Objects.requireNonNull(messageResponseObject.status, "MessageResponseObject must contain status property.");
            return messageResponseObject;
        }
    }
}
