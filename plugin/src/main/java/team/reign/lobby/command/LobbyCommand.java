package team.reign.lobby.command;

import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import team.reign.lobby.ReignLobby;
import team.reign.lobby.file.FileCreator;
import team.reign.lobby.file.YamlFile;

import java.util.List;

@Command(names = {"reingnlobby", "rlobby"})
public class LobbyCommand implements CommandClass {


    final Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("ReignLobby");

    public LobbyCommand(ReignLobby lobby) {
        FileCreator fileCreator = new FileCreator(lobby);
        FileConfiguration messages = fileCreator.getMessages();
    }

    @Command(names = {"help" , ""}, permission = "rlobby.help", desc = "Help command.")
    public void helpCommand(CommandSender sender){
        List<String> helpList = messages.getStringList("messages.help");
        for(String message : helpList){
            sender.sendMessage(message);
        }
    }
    @Command(names = {"reload",""}, permission = "rlobby.reload",desc = "Reload command.")
    public void reloadCommand(CommandSender sender){

    }
}
