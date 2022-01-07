package team.reign.lobby.listener.join;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinFly implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onJoinPlayer(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("rlobby.fly")) {
            player.setAllowFlight(true);
            player.setFlying(true);
        }
    }
}
