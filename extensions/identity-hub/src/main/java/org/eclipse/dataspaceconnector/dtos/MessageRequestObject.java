package org.eclipse.dataspaceconnector.dtos;

/**
 * See <a href="https://identity.foundation/decentralized-web-node/spec/#messages">Message documentation</a>
 */
public class MessageRequestObject {
    private Descriptor descriptor;
    // TODO: Change data type to byte[]
    private String data;

    public MessageRequestObject() {}

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

    public void setDescriptor(Descriptor descriptor) {
        this.descriptor = descriptor;
    }

    public void setData(String data) {
        this.data = data;
    }
}
