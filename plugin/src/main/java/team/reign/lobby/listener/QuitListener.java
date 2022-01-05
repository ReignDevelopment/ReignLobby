package team.reign.lobby.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import team.reign.lobby.file.YamlFile;
import team.reign.lobby.file.YamlFileRegistry;

public class QuitListener implements Listener {
    private final YamlFile config;

    public QuitListener(YamlFileRegistry yamlFileRegistry) {
        this.config = yamlFileRegistry.getFile("config");
    }
    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        if(config.getBoolean("config.leave-default-message")){
            event.setQuitMessage(null);
        }
    }
}
