package org.eclipse.dataspaceconnector.dtos;

/**
 * See <a href="https://identity.foundation/decentralized-web-node/spec/#response-objects">response objects documentation</a>
 * and <a href="https://identity.foundation/decentralized-web-node/spec/#message-level-status-coding">status doc</a>.
 */
public class MessageStatus {
    public static final MessageStatus OK = new MessageStatus(200, "The message was successfully processed");
    public static final MessageStatus MALFORMED_MESSAGE = new MessageStatus(400, "The message was malformed or improperly constructed");
    public static final MessageStatus FAILED_AUTHORIZATION = new MessageStatus(401, "The message failed authorization requirements");
    public static final MessageStatus INTERFACE_NOT_IMPLEMENTED = new MessageStatus(501, "The request could not be processed correctly");

    private final int status;
    private final String detail;

    public MessageStatus(int status, String detail) {
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
