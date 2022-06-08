package org.eclipse.dataspaceconnector.dtos;

/**
 * See <a href="https://identity.foundation/decentralized-web-node/spec/#response-objects">response objects documentation</a>
 * and <a href="https://identity.foundation/decentralized-web-node/spec/#request-level-status-coding">status doc</a>.
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
