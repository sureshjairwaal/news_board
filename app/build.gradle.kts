plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.example.ap_assignmen"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.ap_assignmen"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            /**
             * Please find the api key in the email and add the api key in the build.gradle. Since the project is shared in public repository, Key needs to be secured.
             * */
            buildConfigField("String", "API_KEY", "\"API_KEY\"")
        }
        debug {
            /**
             * Please find the api key in the email and add the api key in the build.gradle. Since the project is shared in public repository, Key needs to be secured.
             * */
            buildConfigField("String", "API_KEY", "\"API_KEY\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
    dataBinding {
        enable = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.databinding.common)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    /*Glide*/
    implementation (libs.glide)
    annotationProcessor(libs.compiler)

    /*Dagger hilt for DI*/
    implementation (libs.hilt.android)
    annotationProcessor (libs.hilt.android.compiler)

    implementation(libs.retrofit)
    implementation (libs.converter.gson)
    implementation(libs.logging.interceptor)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    implementation(libs.androidx.core.ktx.v1130)

    implementation(libs.material.ripple)

}