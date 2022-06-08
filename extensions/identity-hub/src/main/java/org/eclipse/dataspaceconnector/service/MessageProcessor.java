package org.eclipse.dataspaceconnector.service;

import org.eclipse.dataspaceconnector.dtos.MessageResultObject;

public interface MessageProcessor {

    MessageResultObject process(String data);

}
