package org.eclipse.dataspaceconnector.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.eclipse.dataspaceconnector.dtos.MessageResultObject;

public interface MethodProcessor {

    MessageResultObject process(byte[] data);
}
