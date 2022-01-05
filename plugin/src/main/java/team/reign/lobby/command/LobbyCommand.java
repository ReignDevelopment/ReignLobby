package team.reign.lobby.command;

import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import org.bukkit.command.CommandSender;

@Command(names = {"lobby", "hub"})
public class LobbyCommand implements CommandClass {

    @Command(names = {"help"})
    public void run(CommandSender sender){
        sender.sendMessage("sí");
    }
}
