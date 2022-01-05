package team.reign.lobby.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import team.reign.lobby.ReignLobby;
import team.reign.lobby.file.FileCreator;
import team.reign.lobby.file.YamlFile;


public class QuitListener implements Listener {

    private final YamlFile messages;

    public QuitListener(ReignLobby lobby) {
        FileCreator fileCreator = new FileCreator(lobby);
        this.messages = fileCreator.getMessages();
    }

    @EventHandler
    public void onLeavePlayer(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        String leaveMessage = messages.getString("message.leave-message").replace("%player%", player.getName());
        event.setQuitMessage(leaveMessage);
    }
}
