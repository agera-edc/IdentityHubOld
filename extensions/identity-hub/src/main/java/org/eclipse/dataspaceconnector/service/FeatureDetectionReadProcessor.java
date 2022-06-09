package org.eclipse.dataspaceconnector.service;

import org.eclipse.dataspaceconnector.dtos.FeatureDetection;
import org.eclipse.dataspaceconnector.dtos.HubObject;
import org.eclipse.dataspaceconnector.dtos.MessageResultObject;
import org.eclipse.dataspaceconnector.dtos.MessageStatus;
import org.eclipse.dataspaceconnector.dtos.WebNodeInterfaces;

import java.util.List;

import static org.eclipse.dataspaceconnector.dtos.WebNodeInterfaces.COLLECTIONS_QUERY;
import static org.eclipse.dataspaceconnector.dtos.WebNodeInterfaces.COLLECTIONS_WRITE;

public class FeatureDetectionReadProcessor implements MessageProcessor {

    @Override
    public MessageResultObject process(byte[] data) {
        List<HubObject> entries = List.of(
                FeatureDetection.Builder.newInstance().interfaces(
                        WebNodeInterfaces.Builder.newInstance()
                            .supportedCollection(COLLECTIONS_QUERY)
                            .supportedCollection(COLLECTIONS_WRITE)
                            .build()
                ).build()
        );
        return MessageResultObject.Builder.newInstance()
                .messageId("messageId")
                .status(MessageStatus.OK)
                .entries(entries)
                .build();
    }
}
