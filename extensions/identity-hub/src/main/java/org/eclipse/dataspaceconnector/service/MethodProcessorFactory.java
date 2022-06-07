package org.eclipse.dataspaceconnector.service;

public class MethodProcessorFactory {

    public MethodProcessor create(String method) {
        switch (method) {
            case "CollectionsQuery":
                return new CollectionsQueryProcessor();
            case "CollectionsWrite":
                return new CollectionsWriteProcessor();
            default:
                throw new IllegalArgumentException("Bad method: " + method);
        }
    }
}
