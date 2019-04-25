import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

//import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    val kotlinVersion = "1.3.30"
    kotlin("jvm") version kotlinVersion apply false

    id("org.springframework.boot") version "2.2.0.M2" apply false
    id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion apply false
    id("org.jetbrains.kotlin.plugin.jpa") version kotlinVersion apply false
    id("io.spring.dependency-management") version "1.0.7.RELEASE"
    //id("org.jetbrains.dokka") version "0.9.18"
}

var ktorVersion = "1.1.1"
var kotlinVersion = "1.3.30"
var arrowVersion = "0.9.0-SNAPSHOT"

allprojects {
    group = "net.nprod"
    version = "0.0.1"
    repositories {
        mavenCentral()
        jcenter()
        maven { setUrl("https://dl.bintray.com/bjonnh/RDF4K") }
        maven { setUrl("https://oss.jfrog.org/artifactory/oss-snapshot-local/") }
    }
    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
        kotlinOptions.freeCompilerArgs = listOf("-Xjsr305=strict")
    }
/*

    dependencyManagement {
        val bootVersion: String by project

        imports {
            mavenBom("org.springframework.boot:spring-boot-dependencies:$bootVersion")
        }
    }*/
}

subprojects {
    version = "1.0"
}

/*
tasks {
    val dokka by getting(DokkaTask::class) {
        outputFormat = "html"
        outputDirectory = "$buildDir/output"
        sourceDirs = files(subprojects.map { p -> File(p.projectDir, "/src/main/kotlin") })
    }
}
*/