package team.reign.lobby.listener.protect;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import team.reign.lobby.ReignLobby;
import team.reign.lobby.file.FileCreator;
import team.reign.lobby.file.YamlFile;

public class BlockProtect implements Listener {

    private final YamlFile config;

    public BlockProtect(ReignLobby lobby) {
        FileCreator fileCreator = new FileCreator(lobby);
        this.config = fileCreator.getMessages();
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if (config.getBoolean("lobby-protection")) {
            event.setCancelled(false);
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if (config.getBoolean("lobby-protection")) {
            event.setCancelled(false);
        }
    }
}
