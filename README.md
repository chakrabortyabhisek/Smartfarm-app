# Smart Farm Monitoring App

This is an Android app for monitoring weather and soil conditions in smart farming.

## Technologies Used

- Kotlin
- Jetpack Compose
- MVVM Architecture
- REST API Integration (Weather/Soil APIs)
- Coroutines & Flow
- Firebase (Authentication & Realtime Database)
- Basic Kotlin Multiplatform Mobile (KMM)

## Setup

1. Clone the repository.
2. Open in Android Studio or VS Code with Kotlin extension.
3. Add your API keys for weather (OpenWeatherMap) and soil APIs in the code.
4. Add google-services.json for Firebase in app/ directory.
5. Build and run the app.

## Features

- User authentication with Firebase Auth
- Weather data fetching from REST API
- Soil data fetching from REST API
- Real-time updates using Firebase Realtime Database
- Push notifications using Firebase Messaging
- MVVM architecture with ViewModels and Repositories
- Coroutines and Flow for asynchronous operations
- Jetpack Compose for UI

## API Keys

Replace "your_api_key" and "your_key" with actual API keys in the code.

## Firebase Setup

1. Create a Firebase project.
2. Enable Authentication, Realtime Database, and Cloud Messaging.
3. Download google-services.json and place in app/ directory.

## Build

Use Android Studio to build or run `./gradlew build` if Gradle wrapper is set up.
<img width="411" height="736" alt="Screenshot 2026-04-28 001538" src="https://github.com/user-attachments/assets/48df6538-da07-4521-9d64-4c28e7e5f5a8" />
