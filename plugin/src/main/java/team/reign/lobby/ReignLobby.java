package team.reign.lobby;

import org.bukkit.plugin.java.JavaPlugin;

public class ReignLobby extends JavaPlugin {

    @Override
    public void onEnable() {
        ReignLobbyCore lobbyCore = new ReignLobbyCore();
        lobbyCore.init();
    }

    public void onDisable() {
        ReignLobbyCore lobbyCore = new ReignLobbyCore();
        lobbyCore.finalize();
    }
}