plugins {
    java
}

subprojects {
    apply(plugin="java-library")

    repositories {
        mavenLocal()
        mavenCentral()
        maven("https://repo.codemc.io/repository/nms/")
        maven("https://libraries.minecraft.net/")
        maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
        maven("https://repo.unnamed.team/repository/unnamed-public/")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
    }

}