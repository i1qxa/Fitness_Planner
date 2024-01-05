plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
    id("com.google.devtools.ksp") version "1.9.21-1.0.15" apply false
}
allprojects{
    repositories{
        maven("https://www.jitpack.io")
    }
}