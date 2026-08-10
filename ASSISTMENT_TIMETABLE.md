# ⏱️ 50-Minute Assistment Completion Timetable

This guide provides a structured approach to completing an Android technical assessment within 50 minutes, following Clean Architecture and MVVM patterns with Unit Testing.

---

## 📅 Timetable Breakdown (50 Minutes)

| Time Slot | Phase | Tasks |
| :--- | :--- | :--- |
| **0-5 min** | **Setup & Architecture** | Project structure (packages), Add missing dependencies, Hilt Application class, Themes. |
| **5-15 min** | **Domain Layer** | Define Data Models (`Post.kt`), Repository Interface, and Use Cases. |
| **15-25 min** | **Data Layer** | Retrofit API Interface, Repository Implementation, DTOs, and Mappers. |
| **25-35 min** | **Presentation Layer** | ViewModel implementation, UI State handling (Loading/Success/Error), Hilt Injection. |
| **35-45 min** | **UI Layer (Compose)** | Screens, Components, Scaffold, and basic Navigation. |
| **45-50 min** | **Unit Testing** | ViewModel tests using MockK, Turbine, and Coroutine Test Dispatchers. |

---

## 📦 Basic Setup & Dependencies

Add these to your `app/build.gradle.kts` file.

### 1. Network (Retrofit)
```kotlin
implementation("com.squareup.retrofit2:retrofit:2.9.0")
implementation("com.squareup.retrofit2:converter-gson:2.9.0")
implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")
```

### 2. Dependency Injection (Hilt)
```kotlin
implementation("com.google.dagger:hilt-android:2.51.1")
ksp("com.google.dagger:hilt-compiler:2.51.1")
implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
```

### 3. Image Loading (Coil)
```kotlin
implementation("io.coil-kt:coil-compose:2.6.0")
```

### 4. Unit Testing (Crucial for Assessment)
```kotlin
testImplementation("junit:junit:4.13.2")
testImplementation("io.mockk:mockk:1.13.10")
testImplementation("app.cash.turbine:turbine:1.1.0")
testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.0")
```

---

## 🚀 Pro-Tips for Speed
1. **Focus on Functionality First:** Don't spend too much time on custom styling. Use Material 3 defaults.
2. **Use Mappers:** Keep your API models (DTOs) separate from your Domain models.
3. **Handle Errors:** Always include a basic Error state in your UI to show the reviewer you care about edge cases.
4. **MockK & Turbine:** Use MockK for repository mocks and Turbine to test `StateFlow` or `Flow` emissions in the ViewModel.
