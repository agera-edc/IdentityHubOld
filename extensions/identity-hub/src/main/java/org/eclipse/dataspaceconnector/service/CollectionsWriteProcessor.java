package org.eclipse.dataspaceconnector.service;

import org.apache.commons.lang3.NotImplementedException;
import org.eclipse.dataspaceconnector.dtos.MessageResultObject;
import org.eclipse.dataspaceconnector.spi.system.Inject;
import org.eclipse.dataspaceconnector.store.IdentityHubStore;

public class CollectionsWriteProcessor implements MethodProcessor {

    private IdentityHubStore identityHubStore;

    public CollectionsWriteProcessor(IdentityHubStore identityHubStore) {
        this.identityHubStore = identityHubStore;
    }

    public MessageResultObject process(String data) {
        // TODO: change data type to byte[]
        // base64Url decode data
        // deserialize it into a VerifiableCredential model
        // Save it inmemory in idhub store
        // return MessageResultObject with all entries
        //throw new NotImplementedException("not implemented");
        return null;
    }
}
