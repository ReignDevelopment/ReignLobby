package team.reign.lobby.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import team.reign.lobby.ReignLobby;

public class JoinListener implements Listener {
    public final ReignLobby reignLobby;

    public JoinListener(ReignLobby reignLobby) {
        this.reignLobby = reignLobby;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        FileConfiguration message = reignLobby.getMessages();
        String noperm = message.getString("no-perm");
        if (player.hasPermission("reignlobby.vipjoin")) {

        }else{
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',noperm));
        }
    }
}
