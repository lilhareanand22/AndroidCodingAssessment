# Walkthrough - Fixing Gradle Sync Error "Cannot add extension with name 'kotlin'"

I have resolved the Gradle sync and build issues. The primary cause was a conflict between the explicit Kotlin plugin application and the "Built-in Kotlin" feature introduced in Android Gradle Plugin (AGP) 9.3.1.

## Changes Made

### [app](file:///C:/Users/Varsha/Documents/WorkSpcace/Jetpack_Compose_Trainng_Sources_Code/AndroidCodingAssessment/app)

#### [build.gradle.kts](file:///C:/Users/Varsha/Documents/WorkSpcace/Jetpack_Compose_Trainng_Sources_Code/AndroidCodingAssessment/app/build.gradle.kts)
- **Removed `alias(libs.plugins.kotlin.android)`**: AGP 9.3.1 now provides built-in Kotlin support. Applying the plugin explicitly caused a duplicate registration of the `kotlin` extension.
- **Updated `compileSdk` and `targetSdk` to 37**: Some dependencies (like `androidx.lifecycle` 2.11.0) required compiling against Android 37 APIs.

```diff
 plugins {
     alias(libs.plugins.android.application)
-    alias(libs.plugins.kotlin.android)
     alias(libs.plugins.kotlin.compose)
     alias(libs.plugins.hilt)
     alias(libs.plugins.ksp)
 }

 android {
     namespace = "android.ai.androidcodingassessment"
     compileSdk {
-        version = release(36) {
+        version = release(37) {
             minorApiLevel = 1
         }
     }

     defaultConfig {
         applicationId = "android.ai.androidcodingassessment"
         minSdk = 24
-        targetSdk = 36
+        targetSdk = 37
         versionCode = 1
         versionName = "1.0"
```

### [Root Project](file:///C:/Users/Varsha/Documents/WorkSpcace/Jetpack_Compose_Trainng_Sources_Code/AndroidCodingAssessment)

#### [gradle.properties](file:///C:/Users/Varsha/Documents/WorkSpcace/Jetpack_Compose_Trainng_Sources_Code/AndroidCodingAssessment/gradle.properties)
- **Added `android.disallowKotlinSourceSets=false`**: This unblocks KSP (and other plugins) that still use the `kotlin.sourceSets` DSL, which is restricted by default when using AGP's built-in Kotlin.

```diff
 org.gradle.configuration-cache=true
 # Kotlin code style for this project: "official" or "obsolete":
 kotlin.code.style=official
+android.disallowKotlinSourceSets=false
```

## Verification Results

### Automated Tests
- Ran `./gradlew :app:assembleDebug` - **Passed**
- Ran `./gradlew :app:help` - **Passed**

The project now syncs and builds successfully.
