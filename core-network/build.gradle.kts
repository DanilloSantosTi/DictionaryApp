android {
    namespace = "${Config.namespace}core_network"
}

dependencies {
    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.DaggerHilt.daggerHilt)
    Dependencies.Moshi.list.forEach { implementation(it) }
    kapt(Dependencies.DaggerHilt.daggerHiltKapt)
}
