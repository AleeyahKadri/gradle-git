plugins {
    id("groovy")
    id("maven-publish")
    id("com.jfrog.bintray") version "1.1"
    id("org.ajoberstar.defaults") version "0.5.3"
}

group = "org.ajoberstar"
description = "Git plugins for Gradle."

// This third-party extension is dynamically typed, so Groovy interop is required in Kotlin DSL.
configure<Any>("defaults") {
    withGroovyBuilder {
        setProperty("id", "ajoberstar")
        setProperty("bintrayRepo", "maven")
        setProperty("bintrayPkg", "gradle-git")
        setProperty("bintrayLabels", listOf("gradle", "git", "semver"))
        setProperty(
            "developers",
            listOf(
                mapOf(
                    "id" to "ajoberstar",
                    "name" to "Andrew Oberstar",
                    "email" to "andrew@ajoberstar.org"
                )
            )
        )
        setProperty("copyrightYears", "2012-2017")
    }
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
    add("compile", localGroovy())
    add("compile", gradleApi())
    add("compile", "org.ajoberstar:grgit:1.9.3")
    add("compile", "com.github.zafarkhaja:java-semver:0.9.0")
    add("testCompile", "org.spockframework:spock-core:1.0-groovy-2.3")
    add("testRuntime", "cglib:cglib-nodep:3.1")
}

wrapper {
    gradleVersion = "2.1"
}
