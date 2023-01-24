import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.0.0"
    id("io.spring.dependency-management") version "1.1.0"
    id("org.graalvm.buildtools.native") version "0.9.18"
    kotlin("jvm") version "1.7.22"
    kotlin("plugin.spring") version "1.7.22"
//    id('org.jetbrains.kotlin.jvm' )version '1.7.21'
//    id('org.jetbrains.kotlin.plugin.spring') version '1.7.21'
    id("org.jetbrains.kotlin.kapt") version "1.7.21"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.7.21"
}


// plugins {
//    kotlin("jvm") version "1.7.22"
//    kotlin("plugin.spring") version "1.7.22"
//     id("org.springframework.boot") version "2.7.7"
//     id("io.spring.dependency-management") version "1.0.15.RELEASE"
// }

group = "sdn.sucredito"
version = "0.0.1"
// sourceCompatibility = "17"


repositories {
    mavenCentral()
    // maven { url "https://repo.spring.io/release" }
}

dependencies {

    annotationProcessor("org.projectlombok:lombok")
    compileOnly("org.projectlombok:lombok")
    implementation("com.aventrix.jnanoid:jnanoid:2.0.0")
    implementation("info.picocli:picocli-spring-boot-starter:4.7.0")
    implementation("org.flywaydb:flyway-core")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework.boot:spring-boot-starter-web")
    kapt("info.picocli:picocli-codegen:4.7.0")
    runtimeOnly("com.h2database:h2")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11" // 1.8
}
