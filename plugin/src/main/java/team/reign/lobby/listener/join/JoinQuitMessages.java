package team.reign.lobby.listener.join;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import team.reign.lobby.ReignLobby;
import team.reign.lobby.file.FileCreator;
import team.reign.lobby.file.YamlFile;

public class JoinQuitMessages implements Listener {

    private final YamlFile messages;

    public JoinQuitMessages(ReignLobby lobby) {
        FileCreator fileCreator = new FileCreator(lobby);
        this.messages = fileCreator.getMessages();
    }
    @EventHandler
    public void onLeavePlayer(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        String leaveMessage = messages.getString("message.leave-message").replace("%player%", player.getName());
        event.setQuitMessage(leaveMessage);
    }
    @EventHandler (priority = EventPriority.HIGHEST)
    public void onJoinPlayer(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String welcomeMessage = messages.getString("messages.welcome-message").replace("%player%", player.getName());
        event.setJoinMessage(welcomeMessage);
    }
}
