@file:Suppress("MemberVisibilityCanBePrivate", "SpellCheckingInspection")

object AndroidX {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompatVersion}"
    const val cardview = "androidx.cardview:cardview:${Versions.cardviewVersion}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerViewVersion}"
    const val legacy = "androidx.legacy:legacy-support-v4:${Versions.legacySupportV4Version}"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycleVersion}"
    const val lifecycleProcess = "androidx.lifecycle:lifecycle-process:${Versions.lifecycleVersion}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
    const val securityCrypto = "androidx.security:security-crypto:${Versions.securityVersion}"
    const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtsVersion}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtsVersion}"
}

object Third {
    const val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
    const val glideOkHttp = "com.github.bumptech.glide:okhttp3-integration:${Versions.glideVersion}"
    const val rxJava2 = "io.reactivex.rxjava2:rxjava:${Versions.rxJava2Version}"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroidVersion}"
    const val rxKotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlinVersion}"

    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttpVersion}"
    const val retrofit2 = "com.squareup.retrofit2:retrofit:${Versions.retrofit2Version}"
    const val retrofit2RxAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit2Version}"
    const val converterScalars = "com.squareup.retrofit2:converter-scalars:${Versions.retrofit2Version}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit2Version}"

    const val photoview = "com.github.chrisbanes:PhotoView:2.3.0"
    const val desugaring = "com.android.tools:desugar_jdk_libs:1.0.10"

    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"
    const val jsonPatch = "com.github.beyondeye:kjsonpatch:0.3.1"
    const val viewBindingPropertyDelegate = "com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.5.3"
    const val keyboardVisibilityEvent = "net.yslibrary.keyboardvisibilityevent:keyboardvisibilityevent:3.0.0-RC3"

}

object Testing {
    const val robolectric = "org.robolectric:robolectric:${Versions.robolectricVersion}"
    const val junit = "junit:junit:${Versions.junitVersion}"
    const val mockk = "io.mockk:mockk:${Versions.mockkVersion}"
}

object Debug {
    const val slf4j = "org.slf4j:slf4j-jdk14:${Versions.slf4jVersion}"
    const val timberLogs = "com.jakewharton.timber:timber:4.7.1"
}

object Google {
    const val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"
    const val material = "com.google.android.material:material:${Versions.materialVersion}"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger2Version}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger2Version}"
    const val daggerAndroidProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger2Version}"
}

object Versions {
    //AndroidX
    const val appcompatVersion = "1.2.0"
    const val coreKtxVersion = "1.7.0"
    const val cardviewVersion = "1.0.0"
    const val recyclerViewVersion = "1.3.0-alpha01"
    const val legacySupportV4Version = "1.0.0"
    const val constraintLayoutVersion = "2.1.0-beta01"
    const val lifecycleVersion = "2.3.1"
    const val securityVersion = "1.1.0-alpha01"
    const val navigationVersion = "2.4.0-alpha10"
    const val fragmentKtsVersion = "1.3.4"
    const val activityKtsVersion = "1.3.0-alpha05"

    //Third
    const val materialVersion = "1.4.0-alpha01"
    //Testing
    const val robolectricVersion = "4.4"
    const val junitVersion = "4.12"
    const val mockkVersion = "1.9.3"
    //Debug
    const val slf4jVersion = "1.7.28"
    //Google
    const val okhttpVersion = "4.4.0"
    const val retrofit2Version = "2.8.1"
    const val dagger2Version = "2.38.1"
    const val glideVersion= "4.11.0"
    const val rxJava2Version = "2.2.9"
    const val rxAndroidVersion = "2.1.1"
    const val rxKotlinVersion = "2.4.0"
    const val gsonVersion = "2.8.6"

    const val kotlinVersion = "1.5.21"
    const val gradleVersion = "7.0.2"
}

object ProjectCompileConfig {
    const val compileSdkVersion = 31
    const val buildToolsVersion = "30.0.2"
    const val minSdkVersion = 26
    const val targetSdkVersion = 31
    const val defaultVersionCode = 1
    const val defaultVersionName = "1.0.0"
    const val applicationId = "com.tbahlai.tumblrgallery"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object AppConstants {
    const val serverApiBaseUrl = "\"https://api.tumblr.com\""
}

object SignConfig {
    const val signingKeyPassword = "\"CcEqqSrYdQ5qTHFWssSMof4tPZ89sfx6AXYNQ4eoXHMgPJE03U\""
}
