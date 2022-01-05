package team.reign.lobby.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import team.reign.lobby.ReignLobby;
import team.reign.lobby.file.FileCreator;
import team.reign.lobby.file.YamlFile;

import java.util.List;

public class JoinListener implements Listener {

    private final YamlFile messages;

    public JoinListener(ReignLobby lobby) {
        FileCreator fileCreator = new FileCreator(lobby);
        this.messages = fileCreator.getMessages();
    }

    @EventHandler
    public void onJoinPlayer(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        List<String> messageVipJoin = messages.getStringList("message.join-vip");
        messageVipJoin.replaceAll(line -> line.replace("%player%", player.getName()));
        if (player.hasPermission("rlobby.donator")) {
            for(String message : messageVipJoin){
                Bukkit.broadcastMessage(message);
            }
        }
        String welcomeMessage = messages.getString("message.welcome-message").replace("%player%", player.getName());
        event.setJoinMessage(welcomeMessage);
    }
}
