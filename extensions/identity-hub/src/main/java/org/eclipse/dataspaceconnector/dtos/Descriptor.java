package org.eclipse.dataspaceconnector.dtos;

/**
 * See <a href="https://identity.foundation/decentralized-web-node/spec/#message-descriptors">message descriptor documentation</a>.
 */
public class Descriptor {
    private String method;
    private String nonce;
    private String dataCid;
    private String dataFormat;

    public Descriptor() {
    }

    public Descriptor(String method, String nonce, String dataCid, String dataFormat) {
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

}
