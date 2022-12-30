import org.gradle.api.JavaVersion.VERSION_1_8

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.cheroliv.pdf"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.cheroliv.pdf"
        minSdk = 29
//        minSdk = 23
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = VERSION_1_8
        targetCompatibility = VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = VERSION_1_8.toString()
    }


    compileOptions {
        sourceCompatibility(VERSION_1_8)
        targetCompatibility(VERSION_1_8)
    }

    viewBinding {
        android.buildFeatures.viewBinding = true
    }

    packagingOptions {
        resources.excludes.apply {
            add("META-INF/atomicfu.kotlin_module")
            add("META-INF/notice.txt")
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:${properties["core_ktx_version"]}")
    implementation("androidx.appcompat:appcompat:${properties["app_compat_version"]}")
    implementation("com.google.android.material:material:${properties["material_version"]}")
    implementation("androidx.constraintlayout:constraintlayout:${properties["constraint_layout_version"]}")
    androidTestImplementation("org.jetbrains.kotlin:kotlin-test")
    androidTestImplementation("org.jetbrains.kotlin:kotlin-test-junit")
    androidTestImplementation("androidx.test.ext:junit:${properties["androidx_junit_version"]}")
    testImplementation("org.mockito.kotlin:mockito-kotlin:${properties["mockito_kotlin_version"]}")
    androidTestImplementation("org.mockito.kotlin:mockito-kotlin:${properties["mockito_kotlin_version"]}")

    // Retrofit
    testImplementation("com.squareup.retrofit2:retrofit:${properties["retrofit_version"]}")
    testImplementation("com.squareup.retrofit2:converter-moshi:${properties["retrofit_version"]}")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${properties["kotlinx_coroutines_version"]}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${properties["kotlinx_coroutines_version"]}")

    // Kotlin
    implementation("androidx.navigation:navigation-fragment-ktx:${properties["nav_version"]}")
    implementation("androidx.navigation:navigation-ui-ktx:${properties["nav_version"]}")
    // Feature module Support
    implementation("androidx.navigation:navigation-dynamic-features-fragment:${properties["nav_version"]}")
    // Testing Navigation
    androidTestImplementation("androidx.navigation:navigation-testing:${properties["nav_version"]}")

    // Lifecycle components
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${properties["androidx_lifecycle_version"]}")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:${properties["androidx_lifecycle_version"]}")
    implementation("androidx.lifecycle:lifecycle-common-java8:${properties["androidx_lifecycle_version"]}")

    // Kotlin components
    //noinspection GradleDependency
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${properties["kotlin_version"]}")

    // UI
    implementation("androidx.constraintlayout:constraintlayout:${properties["constraint_layout_version"]}")
    implementation("com.google.android.material:material:${properties["material_version"]}")

    // Testing
    androidTestImplementation("androidx.arch.core:core-testing:${properties["androidx_arch_core_version"]}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${properties["espresso_version"]}") {
        exclude("com.android.support", "support-annotations")
    }
    androidTestImplementation("androidx.test.ext:junit:${properties["androidx_junit_version"]}")

    // Koin main features for Android
    implementation("io.insert-koin:koin-core:${properties["koin_version"]}")
    implementation("io.insert-koin:koin-android:${properties["koin_android_version"]}")
    // Jetpack WorkManager
    implementation("io.insert-koin:koin-androidx-workmanager:${properties["koin_android_version"]}")
    // Navigation Graph
    implementation("io.insert-koin:koin-androidx-navigation:${properties["koin_android_version"]}")
    // Koin testing tools
    testImplementation("io.insert-koin:koin-test:${properties["koin_version"]}")
    androidTestImplementation("io.insert-koin:koin-test:${properties["koin_version"]}")
    // Needed JUnit version
    testImplementation("io.insert-koin:koin-test-junit4:${properties["koin_version"]}")
    androidTestImplementation("io.insert-koin:koin-test-junit4:${properties["koin_version"]}")
}