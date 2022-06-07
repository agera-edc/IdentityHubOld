package org.eclipse.dataspaceconnector.service;

import org.eclipse.dataspaceconnector.dtos.MessageResultObject;

public interface MethodProcessor {

    MessageResultObject process(String data);
}
