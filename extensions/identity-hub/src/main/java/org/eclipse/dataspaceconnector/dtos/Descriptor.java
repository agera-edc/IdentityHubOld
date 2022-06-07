package org.eclipse.dataspaceconnector.dtos;

public class Descriptor {
    private final String method;
    private final String nonce;
    private final String dataCid;
    private final String dataFormat;

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
