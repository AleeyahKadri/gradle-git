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

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
}

configurations {
    all {
        exclude(group = "org.codehaus.groovy")
    }
}

repositories {
    jcenter()
}

dependencies {
    // groovy
    compile(localGroovy())

    // gradle api
    compile(gradleApi())

    // grgit
    compile("org.ajoberstar:grgit:1.9.3")

    // semver
    compile("com.github.zafarkhaja:java-semver:0.9.0")

    // testing
    testCompile("org.spockframework:spock-core:1.0-groovy-2.3")
    testRuntime("cglib:cglib-nodep:3.1")
}

tasks.wrapper {
    gradleVersion = "6.9.4"
}
