# Tasks - Fix Gradle Sync Error: "Cannot add extension with name 'kotlin'"

- `[x]` Identify the conflicting plugin by commenting out plugins in `app/build.gradle.kts`
- `[x]` Resolve the "kotlin" extension conflict (Removed redundant `kotlin-android` plugin for AGP 9.3.1)
- `[x]` Resolve KSP source set conflict with `android.disallowKotlinSourceSets=false`
- `[x]` Resolve `compileSdk` version conflict (Updated to 37)
- `[x]` Verify the fix with `./gradlew :app:assembleDebug`
- `[x]` List down the changes made for the user
