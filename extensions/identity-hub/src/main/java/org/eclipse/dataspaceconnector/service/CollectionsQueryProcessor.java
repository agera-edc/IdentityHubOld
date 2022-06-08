package org.eclipse.dataspaceconnector.service;

import org.eclipse.dataspaceconnector.dtos.HubObject;
import org.eclipse.dataspaceconnector.dtos.MessageResultObject;
import org.eclipse.dataspaceconnector.dtos.MessageStatus;
import org.eclipse.dataspaceconnector.dtos.VerifiableCredential;

import java.util.List;

public class CollectionsQueryProcessor implements MethodProcessor {
    @Override
    public MessageResultObject process(String data) {
        List<HubObject> entries = List.of(new VerifiableCredential(), new VerifiableCredential());
        return new MessageResultObject("messageId",
                MessageStatus.OK,
                entries);
    }
}
