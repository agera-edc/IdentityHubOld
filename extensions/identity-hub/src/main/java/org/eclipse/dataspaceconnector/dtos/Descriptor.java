package org.eclipse.dataspaceconnector.dtos;

public class Descriptor {
    String method;
    String nonce;
    String dataCid;
    String dataFormat;

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
