package team.reign.lobby;

import team.reign.lobby.core.Core;
import org.bukkit.Bukkit;
import team.reign.lobby.file.FileCreator;
import team.reign.lobby.loads.CommandLoader;
import team.reign.lobby.loads.ListenerLoader;
import team.reign.lobby.loader.Loader;
import team.reign.lobby.util.ChatUtil;

public class ReignLobbyCore implements Core {

    private final ReignLobby lobby;

    public ReignLobbyCore(ReignLobby lobby) {
        this.lobby = lobby;
    }

    @Override
    public void init(){
        registerLoaders(new ListenerLoader(lobby), new CommandLoader(lobby), new FileCreator(lobby));
        log("&c[ReignLobby]&8: &fCore activado correctamente!");
    }

    @Override
    public void finalize(){
        log("&c[ReignLobby]&8: &fCore desactivado correctamente!");
        log("&6Hasta pronto!");
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
