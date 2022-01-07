package team.reign.lobby.command;

import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import org.bukkit.command.CommandSender;
import team.reign.lobby.ReignLobby;
import team.reign.lobby.file.FileCreator;
import team.reign.lobby.file.YamlFile;

import java.util.List;

@Command(names = {"reingnlobby", "rlobby"})
public class LobbyCommand implements CommandClass {

    private final ReignLobby lobby;
    private FileCreator fileCreator;
    private final YamlFile messages;

    public LobbyCommand(ReignLobby lobby) {
        FileCreator fileCreator = new FileCreator(lobby);
        this.lobby = lobby;
        this.messages = fileCreator.getMessages();
    }

    @Command(names = {"help" , ""}, permission = "rlobby.help", desc = "Help command.")
    public void helpCommand(CommandSender sender){
        List<String> helpList = messages.getStringList("messages.help");
        for(String message : helpList){
            sender.sendMessage(message);
        }
    }
    @Command(names = {"reload","rl"}, permission = "rlobby.reload",desc = "Reload command.")
    public void reloadMessages() {

    }
}
