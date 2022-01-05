package team.reign.lobby.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import team.reign.lobby.file.YamlFile;
import team.reign.lobby.file.YamlFileRegistry;

import java.util.List;

public class JoinListener implements Listener {

    private final YamlFile config, messages;

    public JoinListener(YamlFileRegistry yamlFileRegistry) {
        this.config = yamlFileRegistry.getFile("config");
        this.messages = yamlFileRegistry.getFile("messages");
    }

    @EventHandler
    public void onJoinPlayer(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        List<String> messageVipJoin = messages.getStringList("message.vipjoin");
        if (player.hasPermission("reignlobby.vipjoin")) {
            for(String message : messageVipJoin){
                Bukkit.broadcastMessage(message);
            }
        }
    }
}
