import org.jetbrains.intellij.tasks.PatchPluginXmlTask
import org.jetbrains.intellij.tasks.PublishTask

group = "be.jbeckers"
version = "1.0"

repositories {
    mavenCentral()
}

plugins {
    java
    id("org.jetbrains.intellij") version "0.4.10"
}

intellij {
    version = "LATEST-EAP-SNAPSHOT"
}

tasks {
    getByName<PatchPluginXmlTask>("patchPluginXml") {
        pluginId("be.jbeckers.compare_tab_with_editor2")
        pluginDescription("Allows to compare file selected by right click on tab with currently edited file.")
        changeNotes("Updated for Intellij 2019.2+, since some deprecated APIs were removed")
        version("1.0")
        sinceBuild("192")
    }

    getByName<PublishTask>("publishPlugin") {
        findProperty("pluginsRepoToken")?.let { token(it) }
    }
}