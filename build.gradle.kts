import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.0"
}

val archiveName = rootProject.name

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
}
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.10")
    implementation("io.papermc.paper:paper-api:1.18.1-R0.1-SNAPSHOT")
    implementation("io.github.monun:tap-api:4.3.0")
    implementation("io.github.monun:kommand-api:2.8.0")
    implementation("net.projecttl:InventoryGUI-api:4.1.8")
    implementation("io.github.monun:heartbeat-coroutines:0.0.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0-native-mt")
    implementation("io.github.dolphin2410:worldgen:0.0.1")
}

tasks {

    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "16"
    }

    processResources {
        filesMatching("*.yml") {
            expand(project.properties)
        }

        filteringCharset = "UTF-8"
    }

    register<Jar>("paperJar") {
        archiveBaseName.set(this@Build_gradle.archiveName)
        archiveClassifier.set("")
        archiveVersion.set("")

        from(sourceSets["main"].output)

        doLast {
            copy {
                from(archiveFile)
                val plugins = File(rootDir, ".server/plugins/")
                into(if (File(plugins, archiveFileName.get()).exists()) File(plugins, "update") else plugins)
            }
        }
    }
}