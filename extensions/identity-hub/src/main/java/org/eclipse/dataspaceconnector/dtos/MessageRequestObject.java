package org.eclipse.dataspaceconnector.dtos;

public class MessageRequestObject {
    private final Descriptor descriptor;
    private final String data;

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
}
