import kotlin.reflect.full.memberProperties

interface GroupLibs {
    val list: List<String>
}

object Dependencies {

    object Kotlin : GroupLibs {
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"

        override val list: List<String>
            get() = listOf(
                Kotlin.coreKtx
            )
    }

    object Module {
        const val core_network = ":core-network"
    }

    val modules: List<String> by lazy {
        Module::class.memberProperties.map {
            it.name.replace("_", "-")
        }
    }

    object Gradle {
        const val kotlinPlugin =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
        const val androidTools = "com.android.tools.build:gradle:${Versions.gradlePluginVersion}"
        const val gradlePlugin = "gradle-plugin"
        const val kotlinGradlePlugin =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    }

    object LifecycleRuntime {
        const val lifecycleRuntime =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeVersion}"
    }

    object DaggerHilt {
        const val daggerHilt = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
        const val daggerHiltKapt = "com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}"
    }

    object Glide {
        const val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
    }

    object Moshi: GroupLibs {
        const val moshi = "com.squareup.moshi:moshi:${Versions.moshiVersion}"
        const val moshiConvert = "com.squareup.retrofit2:converter-moshi:${Versions.retrofitVersion}"

        override val list: List<String>
            get() = listOf(
                Moshi.moshi,
                Moshi.moshiConvert
            )
    }

    object Compose : GroupLibs {
        const val activityCompose =
            "androidx.activity:activity-compose:${Versions.activityComposeVersion}"
        const val composeUi = "androidx.compose.ui:ui"
        const val composeUiGraphics = "androidx.compose.ui:ui-graphics"
        const val composeUiTooling = "androidx.compose.ui:ui-tooling-preview"
        const val material3 = "androidx.compose.material3:material3"

        override val list: List<String>
            get() = listOf(
                Compose.activityCompose,
                Compose.composeUi,
                Compose.composeUiGraphics,
                Compose.composeUiTooling,
                Compose.material3
            )
    }

    object UnitTest : GroupLibs {
        const val core = "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"
        const val junit = "androidx.test.ext:junit:${Versions.junitVersion}"

        override val list: List<String>
            get() = listOf(
                UnitTest.core,
                UnitTest.junit,
            )
    }

    object ComposeUnitTest : GroupLibs {
        const val composeUiTest = "androidx.compose.ui:ui-test-junit4"
        const val composeBomUnitTest = "androidx.compose:compose-bom:${Versions.composeBomVersion}"

        override val list: List<String>
            get() = listOf(
                ComposeUnitTest.composeUiTest,
                ComposeUnitTest.composeBomUnitTest
            )
    }

    object TestImpl {
        const val junitTestImpl = "junit:junit:${Versions.junitTestVersion}"
    }

    object DebugTest : GroupLibs {
        const val composeUiTooling = "androidx.compose.ui:ui-tooling"
        const val composeTestManifest = "androidx.compose.ui:ui-test-manifest"

        override val list: List<String>
            get() = listOf(
                DebugTest.composeUiTooling,
                DebugTest.composeTestManifest
            )
    }
}