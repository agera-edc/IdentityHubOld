package org.eclipse.dataspaceconnector.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.dataspaceconnector.dtos.MessageResultObject;
import org.eclipse.dataspaceconnector.dtos.MessageStatus;
import org.eclipse.dataspaceconnector.dtos.VerifiableCredential;
import org.eclipse.dataspaceconnector.store.IdentityHubStore;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

public class CollectionsWriteProcessor implements MethodProcessor {

    private IdentityHubStore identityHubStore;
    private ObjectMapper mapper;

    public CollectionsWriteProcessor(IdentityHubStore identityHubStore) {

        this.identityHubStore = identityHubStore;
        this.mapper = new ObjectMapper();
    }

    public MessageResultObject process(byte[] data) {
        // TODO: Save the requestId?
        var requestId = UUID.randomUUID().toString();
        try {
            var decodedData = new String(Base64.getUrlDecoder().decode(data));
            var credential = mapper.readValue(decodedData, VerifiableCredential.class);
            identityHubStore.add(credential);
            var entries = new ArrayList<>(identityHubStore.getAll());
            var result = new MessageResultObject(requestId, MessageStatus.OK, entries);
            return result;
        } catch (JsonProcessingException e) {
            new MessageResultObject(requestId, MessageStatus.MALFORMED_MESSAGE, List.of());
        }
        throw new IllegalStateException("Unexpected error");
    }
}
