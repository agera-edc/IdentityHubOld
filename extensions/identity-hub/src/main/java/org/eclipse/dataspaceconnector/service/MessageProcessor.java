package org.eclipse.dataspaceconnector.service;

import org.eclipse.dataspaceconnector.dtos.MessageResponseObject;

public interface MessageProcessor {

    MessageResponseObject process(byte[] data);
}
