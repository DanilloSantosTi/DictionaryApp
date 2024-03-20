import Dependencies.modules
import com.android.build.gradle.BaseExtension

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Dependencies.Gradle.kotlinPlugin)
        classpath(Dependencies.Gradle.kotlinGradlePlugin)
        classpath(Dependencies.Gradle.androidTools)
        classpath(kotlin(Dependencies.Gradle.gradlePlugin, Versions.kotlinVersion))
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.10")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
    configureAndroid()
}


fun Project.configureAndroid() {
    val isAppModule = name == "app"

    when {
        isAppModule -> configureAppAndroid()
        modules.contains(name) -> configureAndroidLibrary()
        else -> return
    }

    apply(plugin = "kotlin-android")
    apply(plugin = "kotlin-kapt")

    configure<BaseExtension> {
        compileSdkVersion(Config.compileSdk)
        buildToolsVersion(Config.buildToolsVersion)
        namespace = Config.applicationId

        defaultConfig {
            minSdk = Config.minSdk
            targetSdk = Config.targetSdk
            versionCode = Config.versionCode
            versionName = Config.versionName
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            vectorDrawables.useSupportLibrary = true
            multiDexEnabled = true
        }

        lintOptions {
            isCheckReleaseBuilds = false
            isCheckDependencies = true
            isCheckAllWarnings = true
            isWarningsAsErrors = true
            isIgnoreWarnings = true
            isAbortOnError = false
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }
    }
}


fun Project.configureAppAndroid() {
    apply(plugin = "com.android.application")

    configure<BaseExtension> {
        defaultConfig {
            applicationId = Config.applicationId
        }

        testOptions {
            animationsDisabled = true
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
    }
}

fun Project.configureAndroidLibrary() {
    apply(plugin = "com.android.library")
    apply(plugin = "org.jetbrains.kotlin.android")
}

tasks.register("clean").configure {
    delete("build")
}