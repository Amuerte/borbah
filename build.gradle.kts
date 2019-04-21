import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import io.github.swagger2markup.tasks.Swagger2MarkupTask
import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val group = "org.amuerte.gaming"
val version = "1.0.0-SNAPSHOT"

plugins {
    val kotlinVersion = "1.3.21"
    val shadowJarVersion = "5.0.0"
    val dokkaVersion="0.9.18"

    kotlin("jvm") version kotlinVersion
    kotlin("kapt") version kotlinVersion
    id("com.github.johnrengelman.shadow") version shadowJarVersion
    id("org.jetbrains.dokka") version dokkaVersion
    id("io.github.lhotari.swagger2markup") version "1.3.3.1"
}

repositories {
    mavenCentral()
    jcenter()
}

sourceSets["test"].withConvention(KotlinSourceSet::class) {
    kotlin.srcDir("src/test/it")
}

dependencies {
    val kotlinStdlibVersion = "stdlib-jdk8"
    val dropwizardVersion = "1.3.9"
    val daggerVersion = "2.22.1"
    val awsSdkVersion = "2.5.25"
    val kotlinTestVersion="3.3.2"
    val mockkVersion="1.9"

    implementation(kotlin(kotlinStdlibVersion))
    implementation("io.dropwizard:dropwizard-core:$dropwizardVersion")
    implementation("com.google.dagger:dagger:$daggerVersion")
    kapt("com.google.dagger:dagger-compiler:$daggerVersion")
    implementation(platform("software.amazon.awssdk:bom:$awsSdkVersion"))
    implementation("software.amazon.awssdk:dynamodb:$awsSdkVersion")
    testImplementation("io.kotlintest:kotlintest-runner-junit5:$kotlinTestVersion")
    testImplementation("io.mockk:mockk:$mockkVersion")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<ShadowJar> {
    mergeServiceFiles()
}

tasks.withType<Jar> {
    manifest.attributes.put("Main-Class", "org.amuerte.gaming.BorbahKt")
}

tasks.withType<Swagger2MarkupTask> {
    swaggerInput = "${project.rootDir}/src/main/resources/api/players-api-swagger2.yml"
    outputDir = file("${project.buildDir}/docs/api/")
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform {
        exclude("**/**TestIT.class")
    }
}

tasks.withType<DokkaTask> {
    outputFormat = "gfm"
}
