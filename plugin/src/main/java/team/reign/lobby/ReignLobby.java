package team.reign.lobby;

import org.bukkit.plugin.java.JavaPlugin;
import team.reign.lobby.module.MainModule;
import team.reign.lobby.service.ReignLobbyService;

import javax.inject.Inject;


public class ReignLobby extends JavaPlugin {

    private final ReignLobbyService lobbyCore = new ReignLobbyService(this);

    @Override
    public void onEnable() {
        lobbyCore.start();
    }

    public void onDisable() {
        lobbyCore.stop();
    }
}