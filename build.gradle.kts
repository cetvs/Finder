buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.1.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}