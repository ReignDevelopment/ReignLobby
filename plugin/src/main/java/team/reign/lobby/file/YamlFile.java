package team.reign.lobby.file;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.bukkit.ChatColor.translateAlternateColorCodes;


public class YamlFile extends YamlConfiguration {

    private final File file;

    public YamlFile(Plugin plugin, String fileName, String folderPath, File folder)
            throws IOException, InvalidConfigurationException {
        fileName += ".yml";
        this.file = new File(folder, fileName);

        boolean created = true;

        if (!folder.exists()) {
            created = folder.mkdirs();
        }

        if (created) {
            if (!file.exists()) {
                String path = folderPath + File.separator + fileName;
                if (plugin.getResource(path) != null) {
                    plugin.saveResource(path, false);
                } else {
                    save(file);
                }
                load(file);
                return;
            }

            load(file);
            save(file);
        }
    }

    public YamlFile(Plugin plugin, String fileName)
            throws IOException, InvalidConfigurationException {
        this(plugin, fileName, plugin.getName(), plugin.getDataFolder());
    }

    public YamlFile(Plugin plugin, String fileName, String folderPath)
            throws IOException, InvalidConfigurationException {
        this(
                plugin, fileName, folderPath,
                new File(plugin.getDataFolder(), folderPath)
            );
    }

    public void reload() throws IOException, InvalidConfigurationException {
        load(file);
    }

    public void save() throws IOException {
        save(file);
    }

    @Override
    public String getString(String path) {
        return translateAlternateColorCodes('&', super.getString(path));
    }

    @Override
    public String getString(String path, String def) {
        String s = super.getString(path, def);

        return s != null ? translateAlternateColorCodes('&', s) : def;
    }

    @Override
    public List<String> getStringList(String path) {
        List<String> list = super.getStringList(path);

        list.replaceAll(line -> translateAlternateColorCodes('&', line));

        return list;
    }
}