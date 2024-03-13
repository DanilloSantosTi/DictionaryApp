dependencies {
    Dependencies.Kotlin.list.forEach { implementation(it) }
    Dependencies.UnitTest.list.forEach { androidTestImplementation(it) }
    testImplementation(Dependencies.TestImpl.junitTestImpl)
    implementation(Dependencies.LifecycleRuntime.lifecycleRuntime)
}