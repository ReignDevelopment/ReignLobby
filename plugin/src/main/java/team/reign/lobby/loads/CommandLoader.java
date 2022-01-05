package team.reign.lobby.loads;

import me.fixeddev.commandflow.CommandManager;
import me.fixeddev.commandflow.annotated.AnnotatedCommandTreeBuilder;
import me.fixeddev.commandflow.annotated.AnnotatedCommandTreeBuilderImpl;
import me.fixeddev.commandflow.annotated.part.PartInjector;
import me.fixeddev.commandflow.annotated.part.defaults.DefaultsModule;
import me.fixeddev.commandflow.bukkit.BukkitCommandManager;
import me.fixeddev.commandflow.bukkit.factory.BukkitModule;
import team.reign.lobby.ReignLobby;
import team.reign.lobby.command.LobbyCommand;
import team.reign.lobby.file.FileCreator;
import team.reign.lobby.loader.Loader;

public class CommandLoader implements Loader {

    private final ReignLobby lobby;

    public CommandLoader(ReignLobby lobby) {
        this.lobby = lobby;
        load();
    }

    @Override
    public void load() {
        registerCommands();
    }
    public void registerCommands(){
        PartInjector injector = PartInjector.create();
        injector.install(new DefaultsModule());
        injector.install(new BukkitModule());

        AnnotatedCommandTreeBuilder treeBuilder = new AnnotatedCommandTreeBuilderImpl(injector);

        CommandManager commandManager = new BukkitCommandManager("lobby");
        commandManager.registerCommands(treeBuilder.fromClass(new LobbyCommand(lobby)));
    }
}
