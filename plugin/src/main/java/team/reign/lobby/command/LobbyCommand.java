package team.reign.lobby.command;

import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import org.bukkit.command.CommandSender;
import team.reign.lobby.file.YamlFile;
import team.reign.lobby.file.YamlFileRegistry;

import java.util.List;

@Command(names = {"reingnlobby", "rlobby"})
public class LobbyCommand implements CommandClass {

    private final YamlFile messages;

    public LobbyCommand(YamlFileRegistry yamlFileRegistry) {
        this.messages = yamlFileRegistry.getFile("messages");
    }

    @Command(names = {"help" , ""}, permission = "rlobby.admin")
    public void helpCommand(CommandSender sender){
        List<String> helpList = messages.getStringList("messages.help");
        for(String message : helpList){
            sender.sendMessage(message);
        }
    }
}
