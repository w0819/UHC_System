import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.31"
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
    implementation(kotlin("stdlib"))
    implementation("io.papermc.paper:paper-api:1.17.1-R0.1-SNAPSHOT")
    implementation("io.github.monun:tap-api:4.1.10")
    implementation("io.github.monun:kommand-api:2.6.6")
    implementation("net.projecttl:InventoryGUI-api:4.1.8")
    implementation("io.github.monun:heartbeat-coroutines:0.0.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0")
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