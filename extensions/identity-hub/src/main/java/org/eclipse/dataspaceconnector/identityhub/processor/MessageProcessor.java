package org.eclipse.dataspaceconnector.identityhub.processor;

import org.eclipse.dataspaceconnector.identityhub.dtos.MessageResponseObject;
import org.eclipse.dataspaceconnector.identityhub.dtos.WebNodeInterfaces;

/**
 * Each implementor of the MessageProcessor interface handles a message of a different Decentralized Web Node Interface method.
 * See https://identity.foundation/decentralized-web-node/spec/#interfaces for a list of interfaces available.
 *
 * Messages may or may not contain additional data associated with it (when data is desired or required to be present for a given method invocation).
 * The MessageProcessor gets handed over this data in case it is available, or null otherwise.
 *
 * See {@link WebNodeInterfaces} for a list of currently supported interfaces. Currently the only supported interface that accepts data is "CollectionsWrite".
 */
public interface MessageProcessor {

    /**
     * Processes the corresponding message
     * @param data Optional byte array representing the message data
     * @return MessageResponseObject
     */
    MessageResponseObject process(byte[] data);
}
