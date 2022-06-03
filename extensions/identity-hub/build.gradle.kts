plugins {
    `java-library`
    id("io.swagger.core.v3.swagger-gradle-plugin")
}
val assertj: String by project
val edcVersion: String by project
val edcGroup: String by project
val jupiterVersion: String by project

dependencies{
    implementation("${edcGroup}:core:${edcVersion}")
    implementation("${edcGroup}:http:${edcVersion}")

    testImplementation(project(":rest-client"))
    testImplementation("${edcGroup}:junit-extension:${edcVersion}:test-fixtures")
    testImplementation("${edcGroup}:common-util:${edcVersion}:test-fixtures")
    testImplementation("org.junit.jupiter:junit-jupiter-api:${jupiterVersion}")
    testImplementation("org.assertj:assertj-core:${assertj}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${jupiterVersion}")
}

