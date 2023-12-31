import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.testng:testng:7.8.0")
}

tasks.named<Test>("test") {
    useTestNG(closureOf<TestNGOptions> {
        suites("src/test/resources/testng.xml")
    })
    testLogging {
        events("PASSED", "FAILED", "SKIPPED")
        exceptionFormat = TestExceptionFormat.FULL
    }
}