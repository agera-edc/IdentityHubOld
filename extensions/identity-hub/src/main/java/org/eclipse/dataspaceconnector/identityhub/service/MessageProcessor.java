package org.eclipse.dataspaceconnector.identityhub.service;

import org.eclipse.dataspaceconnector.identityhub.dtos.MessageResponseObject;

/**
 * Interface used to processing a single
 * data property may be passed at the Message level that contains the data associated with the message (when data is desired or required to be present for a given method invocation).
 */
public interface MessageProcessor {

    MessageResponseObject process(byte[] data);
}
