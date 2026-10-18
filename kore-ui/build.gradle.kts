plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.vanniktech.mavenPublish)
}

val libraryVersion = providers.gradleProperty("PUBLISH_VERSION").getOrElse("1.0.0-SNAPSHOT")

kotlin {
    androidLibrary {
        namespace = "com.ceos.development.kore.ui"
        compileSdk = 36
        minSdk = 24

        withHostTestBuilder {
        }

        withDeviceTestBuilder {
            sourceSetTreeName = "test"
        }.configure {
            instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }

    sourceSets {
        jvm()
        androidMain.dependencies {
            implementation(libs.compose.uiToolingPreview)
            implementation(libs.androidx.activity.compose)

        }

        commonMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)
            implementation(libs.compose.components.resources)
            implementation(libs.compose.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)
        }

        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutinesSwing)
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
    coordinates("com.ceosdevelopment", "kore-ui", libraryVersion)

    publishToMavenCentral()

    signAllPublications()

    pom {
        name = "Kore-UI"
        description = "Reusable Kotlin Multiplatform UI components and theming"
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