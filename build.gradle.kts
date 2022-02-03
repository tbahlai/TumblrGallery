buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }

    val versionCode: String by project
    val versionName: String by project

    extra["versionCode"] = when (project.hasProperty("versionCode")) {
        true -> versionCode.toInt()
        false -> ProjectCompileConfig.defaultVersionCode
    }
    extra["versionName"] = when (project.hasProperty("versionName")) {
        true -> versionName
        false -> ProjectCompileConfig.defaultVersionName
    }

    println("""
        versionCode: ${extra["versionCode"]}
        versionName: ${extra["versionName"]}
    """.trimIndent())

    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.gradleVersion}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationVersion}")
    }
}

configurations.all {
    resolutionStrategy {
        force(
            "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}",
            "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinVersion}",
            "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlinVersion}"
        )
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven(url = "https://jitpack.io")
        maven(url = "https://maven.google.com/")
        maven(url = "https://oss.sonatype.org/content/repositories/snapshots")
    }
}

