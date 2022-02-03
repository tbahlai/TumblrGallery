plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdk = ProjectCompileConfig.compileSdkVersion

    defaultConfig {
        applicationId = ProjectCompileConfig.applicationId

        versionCode = rootProject.extra["versionCode"].toString().toInt()
        versionName = rootProject.extra["versionName"].toString()

        minSdk = ProjectCompileConfig.minSdkVersion
        targetSdk = ProjectCompileConfig.targetSdkVersion

        testInstrumentationRunner = ProjectCompileConfig.testInstrumentationRunner

        buildConfigField("String", "API_URL", AppConstants.serverApiBaseUrl)
        buildConfigField("String", "API_KEY", SignConfig.signingKeyPassword)
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = CompileOptions.javaVersion
        targetCompatibility = CompileOptions.javaVersion
    }

    kotlinOptions {
        jvmTarget = CompileOptions.javaVersion.toString()
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    coreLibraryDesugaring(Third.desugaring)

    api(Third.stdlib)
    api(Google.material)
    api(Google.gson)

    api(AndroidX.coreKtx)
    api(AndroidX.securityCrypto) {
        exclude(group = "com.google.protobuf")
    }
    api(AndroidX.lifecycleRuntime)
    api(AndroidX.constraintlayout)
    api(AndroidX.appcompat)
    api(AndroidX.legacy)
    api(AndroidX.recyclerview)
    api(AndroidX.lifecycleProcess)
    api(AndroidX.cardview)
    api(AndroidX.navigationFragmentKtx)
    api(AndroidX.navigationUiKtx)
    api(AndroidX.activityKtx)
    api(AndroidX.fragmentKtx)

    api(Third.glide)
    api(Third.glideOkHttp) {
        exclude(group = "glide-parent")
    }
    api(Third.rxJava2)
    api(Third.rxAndroid)
    api(Third.rxKotlin)
    api(Third.okhttp)
    api(Third.retrofit2)
    api(Third.retrofit2RxAdapter)
    api(Third.converterScalars)
    api(Third.converterGson)

    api(Third.photoview)
    api(Debug.timberLogs)
    api(Third.viewBindingPropertyDelegate)

    api(Third.jsonPatch)

    api(Third.keyboardVisibilityEvent)

    kapt(Google.daggerCompiler)
    kapt(Google.daggerAndroidProcessor)
    implementation(Google.daggerAndroidSupport)

    testImplementation(Testing.junit)
    testImplementation(Testing.mockk)
    testImplementation(Testing.robolectric)

    debugImplementation(Debug.slf4j)
}

repositories {
    mavenCentral()
}
