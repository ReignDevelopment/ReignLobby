package team.reign.lobby.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import team.reign.lobby.ReignLobby;

public class WorldListener implements Listener {

    private final ReignLobby lobby;

    public WorldListener(ReignLobby lobby) {
        this.lobby = lobby;
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {

    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {

    }
}
