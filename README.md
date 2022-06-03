# Identity Hub

Temporary repository to get started with the Identity Hub for the MVD.

## Run identity Hub locally
In order to be able to compile and run this project, you need to follow the instructions below:

### Publish DataspaceConnector artifact
IdentityHub import dependencies from the [eclipse DataSpaceConnector](https://github.com/eclipse-dataspaceconnector/DataSpaceConnector) project.
You need to clone the [eclipse DataSpaceConnector](https://github.com/eclipse-dataspaceconnector/DataSpaceConnector) repository, and publish the DataSpaceConnector artifact locally:

```bash
cd <DataSpaceConnector-root-folder>
# Use same commit as CD pipeline to make sure it is compatible with the EDC version. See ref field on [action.yml](.github/actions/gradle-setup/action.yml)
git checkout 5191d3e6dd9ac5d78264d05ae69edb4d297b606a
./gradlew publishToMavenLocal -Pskip.signing
```

### Generate open api and client
To be able to compile and run this project, you need to follow the [open api instructions](docs/developer/openapi.md) to generate the OpenAPI `yaml` file and generate a REST client.
