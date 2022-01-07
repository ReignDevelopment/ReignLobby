package team.reign.lobby.listener.join;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import team.reign.lobby.ReignLobby;
import team.reign.lobby.file.FileCreator;
import team.reign.lobby.file.YamlFile;

import java.util.List;

public class JoinDonator implements Listener {

    private final YamlFile messages;

    public JoinDonator(ReignLobby lobby) {
        FileCreator fileCreator = new FileCreator(lobby);
        this.messages = fileCreator.getMessages();
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onJoinPlayer(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        List<String> messageVipJoin = messages.getStringList("messages.join-vip");
        messageVipJoin.replaceAll(line -> line.replace("%player%", player.getName()));
        if (player.hasPermission("rlobby.fly")) {
            player.setAllowFlight(true);
            player.setFlying(true);
        }
    }
}
