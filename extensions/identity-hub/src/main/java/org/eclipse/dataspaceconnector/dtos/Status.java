package org.eclipse.dataspaceconnector.dtos;

/**
 * See https://identity.foundation/decentralized-web-node/spec/#response-objects
 */
public class Status {
    private final String status;
    private final String detail;

    public Status(String status, String detail) {
        this.status = status;
        this.detail = detail;
    }

    public String getStatus() {
        return status;
    }

    public String getDetail() {
        return detail;
    }
}
