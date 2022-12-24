plugins {
    id("com.android.application") version AndroidBuild.version apply false
    id("com.android.library") version AndroidBuild.version apply false
    id("org.jetbrains.kotlin.android") version Kotlin.version apply false
    id("org.jetbrains.kotlin.jvm") version Kotlin.jvmVersion apply false
    id("com.google.dagger.hilt.android") version DaggerHilt.version apply false
}