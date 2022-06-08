package org.eclipse.dataspaceconnector.dtos;

/**
 * See <a href="https://identity.foundation/decentralized-web-node/spec/#response-objects">response objects documentation</a>
 * and <a href="https://identity.foundation/decentralized-web-node/spec/#request-level-status-coding">status doc</a>.
 */
public class RequestStatus {
    public static final RequestStatus OK = new RequestStatus(200, "The request was successfully processed");
    public static final RequestStatus DID_NOT_FOUND = new RequestStatus(404, "Target DID not found within the Decentralized Web Node");
    public static final RequestStatus ERROR = new RequestStatus(500, "The request could not be processed correctly");

    private final int status;
    private final String detail;

    public RequestStatus(int status, String detail) {
        this.status = status;
        this.detail = detail;
    }

    public int getStatus() {
        return status;
    }

    public String getDetail() {
        return detail;
    }
}
