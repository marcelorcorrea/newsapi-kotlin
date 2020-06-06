val kotlinVersion: String by project
val retrofitVersion: String by project
val koinVersion: String by project
val mockkVersion: String by project

plugins {
    kotlin("jvm") version "1.3.72"
    id("com.github.johnrengelman.shadow") version "5.2.0"
    id("org.jlleitschuh.gradle.ktlint") version "9.2.1"
}

group = "com.marcelorcorrea"
version = "1.0-SNAPSHOT"

kotlin.sourceSets["main"].kotlin.srcDirs("kotlin/src")
kotlin.sourceSets["test"].kotlin.srcDirs("kotlin/test")

sourceSets["main"].resources.srcDirs("resources")
sourceSets["test"].resources.srcDirs("testresources")

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.7")
    implementation(group = "com.squareup.retrofit2", name = "retrofit", version = retrofitVersion)
    implementation(group = "com.squareup.retrofit2", name = "converter-jackson", version = retrofitVersion)
    implementation(group = "org.koin", name = "koin-core", version = koinVersion)
    implementation(group = "com.fasterxml.jackson.module", name = "jackson-module-kotlin", version = "2.11.0")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    test {
        useJUnitPlatform()
    }
    ktlint {
        additionalEditorconfigFile.set(file(".editorconfig"))
    }
}
