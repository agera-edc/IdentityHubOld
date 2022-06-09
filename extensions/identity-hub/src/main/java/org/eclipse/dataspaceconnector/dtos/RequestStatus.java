package org.eclipse.dataspaceconnector.dtos;

/**
 * See <a href="https://identity.foundation/decentralized-web-node/spec/#response-objects">response objects documentation</a>
 * and <a href="https://identity.foundation/decentralized-web-node/spec/#request-level-status-coding">status doc</a>.
 */
public class RequestStatus extends Status {
    public static final RequestStatus OK = new RequestStatus(200, "The request was successfully processed");
    // TODO: Implement logic + tests for DID_NOT_FOUND and ERROR.
    public static final RequestStatus DID_NOT_FOUND = new RequestStatus(404, "Target DID not found within the Decentralized Web Node");
    public static final RequestStatus ERROR = new RequestStatus(500, "The request could not be processed correctly");

    public RequestStatus(int code, String detail) {
        super(code, detail);
    }
}
