package org.eclipse.dataspaceconnector.dtos;

/**
 * See <a href="https://identity.foundation/decentralized-web-node/spec/#message-descriptors">message descriptor documentation</a>.
 */
public class Descriptor {
    private String method;
    private String nonce;
    private String dataCid;
    private String dataFormat;

    private Descriptor() {
    }

    private Descriptor(String method, String nonce, String dataCid, String dataFormat) {
        this.method = method;
        this.nonce = nonce;
        this.dataCid = dataCid;
        this.dataFormat = dataFormat;
    }

    public String getMethod() {
        return method;
    }

    public String getNonce() {
        return nonce;
    }

    public String getDataCid() {
        return dataCid;
    }

    public String getDataFormat() {
        return dataFormat;
    }

    public static class Builder {

        private Descriptor descriptor;

        public static Builder newInstance() {
            return new Builder();
        }

        private Builder() {
            // Descriptor default field for simplicity for now.
            descriptor = new Descriptor("", "", "", "");
        }

        public Builder method(String method) {
            descriptor.method = method;
            return this;
        }

        public Builder nonce(String nonce) {
            descriptor.nonce = nonce;
            return this;
        }

        public Builder dataCid(String dataCid) {
            descriptor.dataCid = dataCid;
            return this;
        }

        public Builder dataFormat(String dataFormat) {
            descriptor.dataFormat = dataFormat;
            return this;
        }

        public Descriptor build() {
            return descriptor;
        }
    }
}