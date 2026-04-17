import com.vanniktech.maven.publish.SonatypeHost
plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    id("com.vanniktech.maven.publish") version "0.31.0"
}
java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
    }
}


mavenPublishing {
    // Define coordinates for the published artifact
    coordinates(
        groupId = "com.ceosdevelopment",
        artifactId = "kore",
        version = "1.0.0-SNAPSHOT"
    )

    // Configure POM metadata for the published artifact
    pom {
        name.set("Kore")
        description.set("A package of core component and class")
        inceptionYear.set("2026")
        url.set("https://github.com/Ceos-development/CardPager")

        licenses {
            license {
                name.set("MIT")
                url.set("https://opensource.org/licenses/MIT")
            }
        }

        // Specify developers information
        developers {
            developer {
                id.set("Ceos-development")
                name.set("Ceos development")
                email.set("jean.christophe.decary.ceos@gmail.com")
            }
        }

        // Specify SCM information
        scm {
            url.set("https://github.com/Ceos-development/CardPager")
        }
    }

    // Configure publishing to Maven Central
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    // Enable GPG signing for all publications
    signAllPublications()
}
