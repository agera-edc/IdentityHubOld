package org.eclipse.dataspaceconnector.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.dataspaceconnector.dtos.MessageResponseObject;
import org.eclipse.dataspaceconnector.dtos.MessageStatus;
import org.eclipse.dataspaceconnector.dtos.VerifiableCredential;
import org.eclipse.dataspaceconnector.store.IdentityHubStore;

import java.util.Base64;
import java.util.List;
import java.util.UUID;

public class CollectionsWriteProcessor implements MessageProcessor {

    private IdentityHubStore identityHubStore;
    private ObjectMapper mapper;

    public CollectionsWriteProcessor(IdentityHubStore identityHubStore) {

        this.identityHubStore = identityHubStore;
        this.mapper = new ObjectMapper();
    }

    public MessageResponseObject process(byte[] data) {
        var requestId = UUID.randomUUID().toString();
        try {
            var decodedData = new String(Base64.getUrlDecoder().decode(data));
            var credential = mapper.readValue(decodedData, VerifiableCredential.class);
            identityHubStore.add(credential);
            var result = MessageResponseObject.Builder.newInstance().messageId(requestId).status(MessageStatus.OK).entries(List.of()).build();
            return result;
        } catch (JsonProcessingException e) {
            return MessageResponseObject.Builder.newInstance().messageId(requestId).status(MessageStatus.MALFORMED_MESSAGE).entries(List.of()).build();
        }
    }
}
