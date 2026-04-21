plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.vanniktech.mavenPublish)
}

kotlin {
    jvm()

    // Target declarations - add or remove as needed below. These define
    // which platforms this KMP module supports.
    // See: https://kotlinlang.org/docs/multiplatform-discover-project.html#targets
    androidLibrary {
        namespace = "com.ceos.development.kore"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()

        withHostTestBuilder {
        }

        withDeviceTestBuilder {
            sourceSetTreeName = "test"
        }.configure {
            instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlin.stdlib)
                // Add KMP dependencies here
            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }

        androidMain {
            dependencies {
                // Add Android-specific dependencies here. Note that this source set depends on
                // commonMain by default and will correctly pull the Android artifacts of any KMP
                // dependencies declared in commonMain.
            }
        }

        getByName("androidDeviceTest") {
            dependencies {
                implementation(libs.runner)
                implementation(libs.core)
                implementation(libs.junit)
            }
        }
    }

}

mavenPublishing {
    publishToMavenCentral()

    signAllPublications()

    coordinates("com.ceosdevelopment", "kore", "1.0.0-SNAPSHOT")

    pom {
        name = "Kore"
        description = "A set of methods and classes used throughout my applications"
        inceptionYear = "2026"
        url = "https://github.com/Ceos-development/Kore"
        licenses {
            license {
                name = "MIT"
                url = "https://opensource.org/licenses/MIT"
            }
        }
        developers {
            developer {
                id = "Ceos-development"
                name = "Ceos development"
                email = "jean.christophe.decary.ceos@gmail.com"
                url = "https://www.ceosdevelopment.com/"
            }
        }
        scm {
            url = "https://github.com/Ceos-development/Kore"
        }
    }
}