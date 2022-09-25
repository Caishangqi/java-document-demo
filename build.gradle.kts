plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    implementation("org.junit.jupiter", "junit-jupiter-api", "5.8.2")
    implementation("org.junit.jupiter", "junit-jupiter-engine", "5.8.2")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}