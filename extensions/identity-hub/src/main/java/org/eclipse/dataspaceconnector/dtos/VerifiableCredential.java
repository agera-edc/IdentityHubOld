package org.eclipse.dataspaceconnector.dtos;

public class VerifiableCredential implements HubObject {
    String dummyField;

    public String getDummyField() {
        return dummyField;
    }

    public void setDummyField(String dummyField) {
        this.dummyField = dummyField;
    }

    public VerifiableCredential() {
    }

    public VerifiableCredential(String dummyField) {
        this.dummyField = dummyField;
    }
}
