package org.eclipse.dataspaceconnector.dtos;

public class MessageRequestObject {
    private Descriptor descriptor;
    private String data;

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
