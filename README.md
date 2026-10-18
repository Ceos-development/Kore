# Kore

Kore is a Kotlin Multiplatform library project with two Maven Central artifacts:

| Library | Maven coordinate | Description |
|---|---|---|
| Kore | `com.ceosdevelopment:kore` | Common Kotlin extensions, logging, navigation, and localization utilities |
| Kore UI | `com.ceosdevelopment:kore-ui` | Reusable Compose Multiplatform UI components and theming |

Both libraries currently publish Android and JVM variants. Add either dependency to a Gradle project:

```kotlin
dependencies {
    implementation("com.ceosdevelopment:kore:1.0.0")
    implementation("com.ceosdevelopment:kore-ui:1.0.0")
}
```

Use only the dependencies for the libraries your project needs. Replace `1.0.0` with the version you want to use.

## Publishing

Publishing is automated by the GitHub Actions release workflow. Before the first release:

1. Create and verify the `com.ceosdevelopment` namespace in the Maven Central Portal.
2. Add these repository secrets in **Settings → Secrets and variables → Actions**:
   - `MAVEN_CENTRAL_USERNAME` and `MAVEN_CENTRAL_PASSWORD`: Maven Central Portal publishing credentials.
   - `SIGNING_KEY_ID`, `SIGNING_PASSWORD`, and `GPG_KEY_CONTENTS`: the signing key ID, its passphrase, and the ASCII-armored private key.
3. Create a GitHub release whose tag is the desired version, without a `v` prefix (for example, `1.0.0`). The workflow publishes both artifacts using that version.

The default local version is `1.0.0-SNAPSHOT`. To build or publish locally with another version, pass `-PPUBLISH_VERSION=1.0.0` to Gradle. Local Maven publication can be checked with `./gradlew publishToMavenLocal`.
