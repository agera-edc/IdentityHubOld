package org.eclipse.dataspaceconnector.identityhub.api.featuredetection;
/*
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.dataspaceconnector.dtos.Descriptor;
import org.eclipse.dataspaceconnector.dtos.MessageRequestObject;
import org.eclipse.dataspaceconnector.dtos.RequestObject;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SerializationTest {

    ObjectMapper mapper = new ObjectMapper();

    @Test
    void canSerialized() throws JsonProcessingException {
        RequestObject requestObject = new RequestObject("id", "target", List.of());
        String serializedRequestObject = mapper.writeValueAsString(requestObject);
        System.out.println(serializedRequestObject);
    }

    @Test
    void canDeserialize() throws JsonProcessingException {
        RequestObject requestObject = new RequestObject("id", "target", List.of());
        String serializedRequestObject = mapper.writeValueAsString(requestObject);
        var deser = mapper.readValue(serializedRequestObject, RequestObject.class);
        System.out.println(deser);
    }

    @Test
    void ser() throws JsonProcessingException {
        var descriptor = Descriptor.Builder.newInstance().method("Not supported").build();
        var requestObject = RequestObject.Builder.newInstance()
                .requestId("abc")
                .target("target")
                .addMessageRequestObject(
                        MessageRequestObject.Builder.newInstance()
                                .descriptor(descriptor)
                                .build())
                .build();
        var a = mapper.writeValueAsString(requestObject);
        RequestObject b  = mapper.readValue(a, RequestObject.class);
    }
}
*/