plugins {
    groovy
    `maven-publish`
    id("com.jfrog.bintray") version "1.1"
    id("org.ajoberstar.defaults") version "0.5.3"
}

group = "org.ajoberstar"
description = "Git plugins for Gradle."

defaults {
    id = "ajoberstar"

    bintrayRepo = "maven"
    bintrayPkg = "gradle-git"
    bintrayLabels = listOf("gradle", "git", "semver")

    developers = listOf(
        mapOf("id" to "ajoberstar", "name" to "Andrew Oberstar", "email" to "andrew@ajoberstar.org")
    )

    copyrightYears = "2012-2017"
}

java.sourceCompatibility = JavaVersion.VERSION_1_7

configurations {
    // use local groovy
    all {
        exclude(group = "org.codehaus.groovy")
    }
}

repositories {
    jcenter()
}

dependencies {
    // groovy
    implementation(localGroovy())

    // gradle api
    implementation(gradleApi())

    // grgit
    implementation("org.ajoberstar:grgit:1.9.3")

    // semver
    implementation("com.github.zafarkhaja:java-semver:0.9.0")

    // testing
    testImplementation("org.spockframework:spock-core:1.0-groovy-2.3")
    testRuntimeOnly("cglib:cglib-nodep:3.1")
}

tasks.wrapper {
    gradleVersion = "6.9.4"
}
