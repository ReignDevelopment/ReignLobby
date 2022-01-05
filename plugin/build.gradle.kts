plugins {
    id("com.github.johnrengelman.shadow") version("7.1.1")
}
//Para poner en plugin.yml @version@
tasks {
    processResources {
        filesMatching("**/*.yml") {
            filter<org.apache.tools.ant.filters.ReplaceTokens>(
                    "tokens" to mapOf("version" to project.version)
            )
        }
    }
}


dependencies {
    api(project(":api"))
    implementation("me.fixeddev:commandflow-bukkit:0.4.0")
    compileOnly("org.spigotmc:spigot:1.8.8-R0.1-SNAPSHOT")
}