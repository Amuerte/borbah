import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.openapitools.generator.gradle.plugin.tasks.GenerateTask

val group = "org.amuerte.gaming"
val version = "1.0.0-SNAPSHOT"

plugins {
    val kotlinVersion = "1.3.21"
    val shadowJarVersion = "5.0.0"

    kotlin("jvm") version kotlinVersion
    kotlin("kapt") version kotlinVersion
    id("com.github.johnrengelman.shadow") version shadowJarVersion
    id("org.openapi.generator") version "4.0.0-beta3"
}

repositories {
    mavenCentral()
}

dependencies {
    val kotlinStdlibVersion = "stdlib-jdk8"
    val dropwizardVersion = "1.3.9"
    val daggerVersion = "2.22.1"

    implementation(kotlin(kotlinStdlibVersion))
    implementation("io.dropwizard", "dropwizard-core", dropwizardVersion)
    implementation("com.google.dagger", "dagger", daggerVersion)
    kapt("com.google.dagger:dagger-compiler:$daggerVersion")
}

tasks.withType<ShadowJar> {
    mergeServiceFiles()
}

tasks.withType<Jar> {
    manifest.attributes.put("Main-Class", "org.amuerte.gaming.BorbahKt")
}

tasks.withType<GenerateTask> {
    generateApiDocumentation.set(true)
    generateModelDocumentation.set(true)
    inputSpec.set("$rootDir/src/main/resources/api/players-api.yml")
    apiPackage.set("org.amuerte.gaming.api")
    invokerPackage.set("org.amuerte.gaming.invoker")
    modelPackage.set("org.amuerte.gaming.model")
}

tasks.register<GenerateTask>("generationDoc") {
    generatorName.set("html2")
    outputDir.set("$buildDir/generated/openapi/doc")
}

openApiValidate() {
    inputSpec.set("$rootDir/src/main/resources/api/players-api.yml")
}
