plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.myproject.viewmodel_testing"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.myproject.viewmodel_testing"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.retrofit)
    implementation(libs.okhttp)
    implementation(libs.loggin.interceptor)
    implementation(libs.converter.gson)
    implementation(libs.gson)

    implementation(libs.kotlin.coroutine)
    testImplementation(libs.kotlin.coroutine.test)

    implementation(libs.glide)

    testImplementation(libs.mockwebserver)

    testImplementation(libs.mockito.core)
    testImplementation(libs.mockito.kotlin)

}