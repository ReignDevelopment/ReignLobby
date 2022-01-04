package team.reign.lobby;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import team.reign.lobby.listeners.JoinListener;
import team.reign.lobby.listeners.WorldListener;

import java.io.*;


public class ReignLobby extends JavaPlugin {
    private FileConfiguration message = null;
    private File messagesFile = null;
    PluginDescriptionFile d = getDescription();
    public String ver = d.getVersion();

    @Override
    public void onEnable() {
        registerMsg();
        registerEvents();
        log("&c[ReignLobby]&8: &fCore activado correctamente!");
        log("&fEstás usando la version: &c" + ver);
    }

    public void onDisable() {
        log("&c[ReignLobby]&8: &fCore desactivado correctamente!");
        log("&6Hasta pronto!");
    }
    public void registerEvents(){
        PluginManager PluginManager = getServer().getPluginManager();
        PluginManager.registerEvents(new JoinListener(this),this);
        PluginManager.registerEvents(new WorldListener(this),this);
    }

    public FileConfiguration getMessages() {
        if (message == null) {
            reloadMessages();
        }
        return message;
    }

    public void reloadMessages() {
        if (message == null) {
            messagesFile = new File(getDataFolder(), "mensajes.yml");
        }
        message = YamlConfiguration.loadConfiguration(messagesFile);
        Reader defConfigStream;
        try {
            defConfigStream = new InputStreamReader(    this.getResource("mensajes.yml"), "UTF8");
            if (defConfigStream != null) {
                YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
                message.setDefaults(defConfig);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void saveMsg() {
        try {
            message.save(messagesFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registerMsg() {
        messagesFile = new File(this.getDataFolder(), "mensajes.yml");
        if (!messagesFile.exists()) {
            this.getMessages().options().copyDefaults(true);
            saveMsg();
        }
    }
        public void log (String s){
            Bukkit.getConsoleSender().sendMessage(color(s));
        }
        public static String color (String str){
            return ChatColor.translateAlternateColorCodes('&', str);
        }
}
