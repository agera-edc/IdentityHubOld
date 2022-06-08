package org.eclipse.dataspaceconnector.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.Objects;

/**
 * See <a href="https://identity.foundation/decentralized-web-node/spec/#messages">Message documentation</a>
 */
public class MessageRequestObject {
    private Descriptor descriptor;
    private String data;

    public MessageRequestObject() {
    }

    public MessageRequestObject(Descriptor descriptor, String data) {
        this.descriptor = descriptor;
        this.data = data;
    }

    public Descriptor getDescriptor() {
        return descriptor;
    }

    public String getData() {
        return data;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder {
        private final MessageRequestObject messageRequestObject;

        private Builder() {
            this(new MessageRequestObject());
        }

        private Builder(MessageRequestObject messageRequestObject) {
            this.messageRequestObject = messageRequestObject;
        }

        @JsonCreator()
        public static MessageRequestObject.Builder newInstance() {
            return new MessageRequestObject.Builder();
        }

        public MessageRequestObject.Builder descriptor(Descriptor descriptor) {
            messageRequestObject.descriptor = descriptor;
            return this;
        }

        public MessageRequestObject.Builder target(String data) {
            messageRequestObject.data = data;
            return this;
        }

        public MessageRequestObject build() {
            Objects.requireNonNull(messageRequestObject.getDescriptor(), "MessageRequestObject builder missing descriptor property.");
            return messageRequestObject;
        }
    }

}
