package org.eclipse.dataspaceconnector.identityhub.processor;

import org.eclipse.dataspaceconnector.identityhub.dtos.FeatureDetection;
import org.eclipse.dataspaceconnector.identityhub.dtos.HubObject;
import org.eclipse.dataspaceconnector.identityhub.dtos.MessageResponseObject;
import org.eclipse.dataspaceconnector.identityhub.dtos.MessageStatus;
import org.eclipse.dataspaceconnector.identityhub.dtos.WebNodeInterfaces;

import java.util.List;

import static org.eclipse.dataspaceconnector.identityhub.dtos.MessageResponseObject.MESSAGE_ID_VALUE;
import static org.eclipse.dataspaceconnector.identityhub.dtos.WebNodeInterfaces.COLLECTIONS_QUERY;
import static org.eclipse.dataspaceconnector.identityhub.dtos.WebNodeInterfaces.COLLECTIONS_WRITE;

/**
 * Processor of "FeatureDetectionRead" messages
 */
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
