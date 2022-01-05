package team.reign.lobby.service;

import team.reign.lobby.ReignLobby;
import team.reign.lobby.core.Service;
import org.bukkit.Bukkit;
import team.reign.lobby.file.FileCreator;
import team.reign.lobby.loads.CommandLoader;
import team.reign.lobby.loads.ListenerLoader;
import team.reign.lobby.loader.Loader;
import team.reign.lobby.util.ChatUtil;

public class ReignLobbyService implements Service {

    private final ReignLobby lobby;

    public ReignLobbyService(ReignLobby lobby) {
        this.lobby = lobby;
    }

    @Override
    public void start(){
        registerLoaders(new FileCreator(lobby), new ListenerLoader(lobby), new CommandLoader(lobby));
        log("&c[ReignLobby]&8: &fCore activado correctamente!");
    }

    @Override
    public void stop(){
        log("&c[ReignLobby]&8: &fCore desactivado correctamente!");
    }

    private void registerLoaders(Loader... loaders){
        for(Loader loader : loaders) {
            loader.load();
        }
    }

    public void log(String string){
        Bukkit.getConsoleSender().sendMessage(ChatUtil.color(string));
    }
}
