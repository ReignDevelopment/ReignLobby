package team.reign.lobby;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import team.reign.lobby.file.FileCreator;
import team.reign.lobby.listeners.ListenerLoader;
import team.reign.lobby.util.ChatUtil;

import java.util.Arrays;
import java.util.List;

public class ReignLobby extends JavaPlugin {

    private final PluginDescriptionFile descriptionFile = getDescription();
    private final String version = descriptionFile.getVersion();

    @Override
    public void onEnable() {
        List<Loader> loaders = Arrays.asList(new ListenerLoader(this), new FileCreator(this));
        log("&c[ReignLobby]&8: &fCore activado correctamente!");
        log("&fEstás usando la version: &c" + version);
    }

    public void onDisable() {
        log("&c[ReignLobby]&8: &fCore desactivado correctamente!");
        log("&6Hasta pronto!");
    }

    public void log (String string){
        Bukkit.getConsoleSender().sendMessage(ChatUtil.color(string));
    }
}