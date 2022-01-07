package team.reign.lobby.file;

import org.bukkit.configuration.InvalidConfigurationException;
import team.reign.lobby.loader.Loader;
import team.reign.lobby.ReignLobby;

import java.io.IOException;


public class FileCreator implements Loader {

    private final ReignLobby lobby;
    private YamlFile config;
    private YamlFile messages;

    public FileCreator(ReignLobby lobby) {
        this.lobby = lobby;
        load();
    }

    @Override
    public void load() {
        try {
            config = new YamlFile(lobby, "config");
            messages = new YamlFile(lobby, "messages");
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public YamlFile getConfig() {
        return config;
    }

    public YamlFile getMessages() {
        return messages;
    }
}
