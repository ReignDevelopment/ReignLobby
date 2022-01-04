package team.reign.lobby.listeners;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import team.reign.lobby.Loader;
import org.bukkit.event.Listener;
import team.reign.lobby.ReignLobby;
import team.reign.lobby.file.FileCreator;
import team.reign.lobby.listeners.player.JoinListener;
import team.reign.lobby.listeners.server.WorldListener;


public class ListenerLoader implements Loader {

    private final ReignLobby reignLobby;
    private final FileCreator fileCreator;

    public ListenerLoader(ReignLobby reignLobby) {
        this.reignLobby = reignLobby;
        this.fileCreator = new FileCreator(reignLobby);
    }

    @Override
    public void load() {
        registerListeners(new JoinListener(fileCreator.getYamlFileRegistry())
                         ,new WorldListener(reignLobby));
    }

    private void registerListeners(Listener... listeners){
        PluginManager pluginManager = Bukkit.getPluginManager();
        for(Listener listener: listeners) {
            pluginManager.registerEvents(listener,reignLobby);
        }
    }

}
