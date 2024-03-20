android {
    namespace = "${Config.namespace}core_database"
}

dependencies {
    implementation(project(Dependencies.Module.core_network))
    implementation(Dependencies.DaggerHilt.daggerHilt)
    Dependencies.Kotlin.list.forEach { implementation(it) }
    Dependencies.UnitTest.list.forEach { androidTestImplementation(it) }
    Dependencies.Room.list.forEach { implementation(it) }
    Dependencies.Moshi.list.forEach { implementation(it) }
    kapt(Dependencies.RoomCompilerKapt.roomCompiler)
    testImplementation(Dependencies.TestImpl.junitTestImpl)
    implementation(Dependencies.LifecycleRuntime.lifecycleRuntime)
}