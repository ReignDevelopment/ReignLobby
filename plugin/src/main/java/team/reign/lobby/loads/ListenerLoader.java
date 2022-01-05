package team.reign.lobby.loads;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.event.Listener;
import team.reign.lobby.ReignLobby;
import team.reign.lobby.file.FileCreator;
import team.reign.lobby.listener.DamageListener;
import team.reign.lobby.listener.JoinListener;
import team.reign.lobby.listener.QuitListener;
import team.reign.lobby.loader.Loader;
import team.unnamed.gui.core.GUIListeners;


public class ListenerLoader implements Loader {

    private final ReignLobby reignLobby;
    private final FileCreator fileCreator;

    public ListenerLoader(ReignLobby reignLobby) {
        this.reignLobby = reignLobby;
        this.fileCreator = new FileCreator(reignLobby);
        load();
    }

    @Override
    public void load() {
        registerListeners(new JoinListener(fileCreator.getYamlFileRegistry()),
                          new QuitListener(fileCreator.getYamlFileRegistry()),
                          new DamageListener(),
                          new GUIListeners());;

    }

    private void registerListeners(Listener... listeners){
        PluginManager pluginManager = Bukkit.getPluginManager();
        for(Listener listener: listeners) {
            pluginManager.registerEvents(listener,reignLobby);
        }
    }

}
