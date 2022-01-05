package team.reign.lobby;

import org.bukkit.plugin.java.JavaPlugin;

public class ReignLobby extends JavaPlugin {

    private final ReignLobbyCore lobbyCore = new ReignLobbyCore();

    @Override
    public void onEnable() {
        lobbyCore.init();
    }

    public void onDisable() {
        lobbyCore.finalize();
    }
}