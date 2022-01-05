package team.reign.lobby.file;

import org.bukkit.configuration.InvalidConfigurationException;
import team.reign.lobby.loader.Loader;
import team.reign.lobby.ReignLobby;

import java.io.IOException;


public class FileCreator implements Loader {

    private final ReignLobby reignLobby;
    private YamlFileRegistry yamlFileRegistry;

    public FileCreator(ReignLobby reignLobby) {
        this.reignLobby = reignLobby;
    }

    @Override
    public void load() {
        try {
           yamlFileRegistry = YamlFileRegistry.create(reignLobby, "config", "messages");
        } catch(IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public YamlFileRegistry getYamlFileRegistry() {
        return yamlFileRegistry;
    }

}
