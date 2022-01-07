package team.reign.lobby.loads;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.event.Listener;
import team.reign.lobby.ReignLobby;
import team.reign.lobby.listener.join.JoinDonator;
import team.reign.lobby.listener.join.JoinFly;
import team.reign.lobby.listener.join.JoinQuitMessages;
import team.reign.lobby.listener.protect.BlockProtect;
import team.reign.lobby.listener.protect.DamageProtect;
import team.reign.lobby.loader.Loader;


public class ListenerLoader implements Loader {

    private final ReignLobby lobby;

    public ListenerLoader(ReignLobby lobby) {
        this.lobby = lobby;
        load();
    }

    @Override
    public void load() {
        registerListeners(new JoinDonator(lobby),
                          new JoinQuitMessages(lobby),
                          new DamageProtect(), new BlockProtect(lobby), new JoinFly());

    }

    private void registerListeners(Listener... listeners){
        PluginManager pluginManager = Bukkit.getPluginManager();
        for(Listener listener: listeners) {
            pluginManager.registerEvents(listener, lobby);
        }
    }

}
