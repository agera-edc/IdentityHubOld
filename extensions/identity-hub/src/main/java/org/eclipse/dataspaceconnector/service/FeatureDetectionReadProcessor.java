package org.eclipse.dataspaceconnector.service;

import org.eclipse.dataspaceconnector.dtos.*;

import java.util.List;

import static org.eclipse.dataspaceconnector.dtos.MessageResponseObject.MESSAGE_ID_VALUE;
import static org.eclipse.dataspaceconnector.dtos.WebNodeInterfaces.COLLECTIONS_QUERY;
import static org.eclipse.dataspaceconnector.dtos.WebNodeInterfaces.COLLECTIONS_WRITE;

public class FeatureDetectionReadProcessor implements MessageProcessor {

    @Override
    public MessageResponseObject process(byte[] data) {
        List<HubObject> entries = List.of(
                FeatureDetection.Builder.newInstance().interfaces(
                        WebNodeInterfaces.Builder.newInstance()
                            .supportedCollection(COLLECTIONS_QUERY)
                            .supportedCollection(COLLECTIONS_WRITE)
                            .build()
                ).build()
        );
        return MessageResponseObject.Builder.newInstance()
                .messageId(MESSAGE_ID_VALUE)
                .status(MessageStatus.OK)
                .entries(entries)
                .build();
    }
}
