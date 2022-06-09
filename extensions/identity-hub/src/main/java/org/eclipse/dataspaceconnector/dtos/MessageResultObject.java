package org.eclipse.dataspaceconnector.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.Collections;
import java.util.List;

/**
 * See <a href="https://identity.foundation/decentralized-web-node/spec/#response-objects">Response Object documentation</a>
 * and <a href="https://identity.foundation/decentralized-web-node/spec/#messages">message documentation</a>.
 */
@JsonDeserialize(builder = MessageResultObject.Builder.class)
public class MessageResultObject {
    private String messageId;
    private MessageStatus status;
    private List<HubObject> entries;

    private MessageResultObject(String messageId, MessageStatus status, List<HubObject> entries) {
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
        private MessageResultObject messageResultObject;

        private Builder() {
            messageResultObject = new MessageResultObject("", null, List.of());
        }

        @JsonCreator()
        public static Builder newInstance() {
            return new Builder();
        }

        public Builder messageId(String messageId) {
            messageResultObject.messageId = messageId;
            return this;
        }

        public Builder status(MessageStatus status) {
            messageResultObject.status = status;
            return this;
        }

        public Builder entries(List<HubObject> entries) {
            messageResultObject.entries = Collections.unmodifiableList(entries);
            return this;
        }

        public MessageResultObject build() {
            return messageResultObject;
        }
    }
}
