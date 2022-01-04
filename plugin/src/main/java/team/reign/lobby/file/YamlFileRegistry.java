package team.reign.lobby.file;


import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.Plugin;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class YamlFileRegistry {

    private final Map<String, YamlFile> filesByName;

    private YamlFileRegistry(Map<String, YamlFile> filesByName) {
        this.filesByName = filesByName;
    }

    public YamlFile createAndAdd(Plugin plugin, String fileName)
            throws IOException, InvalidConfigurationException {
        YamlFile yamlFile = new YamlFile(plugin, fileName);
        filesByName.put(fileName, yamlFile);

        return yamlFile;
    }

    public void remove(String fileName) {
        filesByName.remove(fileName);
    }

    public YamlFile getFile(String name) {
        return filesByName.get(name);
    }

    public static YamlFileRegistry create(Plugin plugin, String... files)
            throws IOException, InvalidConfigurationException {
        Map<String, YamlFile> filesByName = new HashMap<>();

        for (String file : files) {
            String[] split = file.split(":");
            String name = split[0];
            YamlFile yamlFile;

            if (split.length == 1) {
                yamlFile = new YamlFile(plugin, name);
            } else {
                yamlFile = new YamlFile(plugin, name, split[1]);
            }

            filesByName.put(name, yamlFile);
        }

        return new YamlFileRegistry(filesByName);
    }

}
