plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.doom"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.doom"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

}

dependencies { }
