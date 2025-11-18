// Converted from Groovy to Kotlin DSL
// Note: Some plugins and dependencies from the original build may not be available
// in modern repositories due to JCenter shutdown. Updated to use available versions.

plugins {
    groovy
    `maven-publish`
    // Note: These legacy plugins are no longer available:
    // id("com.jfrog.bintray") version "1.1"
    // id("org.ajoberstar.defaults") version "0.5.3"
}

group = "org.ajoberstar"
description = "Git plugins for Gradle."

// Original defaults configuration (plugin not available)
// configure<org.ajoberstar.gradle.defaults.DefaultsExtension> {
//     id = "ajoberstar"
//     bintrayRepo = "maven"
//     bintrayPkg = "gradle-git"
//     bintrayLabels = listOf("gradle", "git", "semver")
//     developers = listOf(
//         mapOf("id" to "ajoberstar", "name" to "Andrew Oberstar", "email" to "andrew@ajoberstar.org")
//     )
//     copyrightYears = "2012-2017"
// }

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
}

configurations.all {
    // use local groovy
    exclude(group = "org.codehaus.groovy")
}

repositories {
    mavenCentral()
    // Note: JCenter is deprecated and shutdown, but original used jcenter()
}

dependencies {
    // groovy
    implementation(localGroovy())

    // gradle api
    implementation(gradleApi())

    // grgit
    // Note: Original version 1.9.3 not available, using 1.8.0-rc.1 from Maven Central
    implementation("org.ajoberstar:grgit:1.8.0-rc.1")

    // semver
    implementation("com.github.zafarkhaja:java-semver:0.9.0")

    // testing
    testImplementation("org.spockframework:spock-core:1.0-groovy-2.3")
    testRuntimeOnly("cglib:cglib-nodep:3.1")
}

tasks.wrapper {
    // Note: Original was 2.1, updated to 7.6.4 for Java 17 compatibility and Kotlin DSL support
    gradleVersion = "7.6.4"
}


