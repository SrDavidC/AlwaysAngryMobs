package srdqrk.alwaysangrymobs.managers;


import co.aikar.commands.PaperCommandManager;
import srdqrk.alwaysangrymobs.AlwaysAngryMobs;
import srdqrk.alwaysangrymobs.commands.Commands;
import srdqrk.alwaysangrymobs.commands.Test;

public class CommandManager {
    PaperCommandManager commandManager;
    public CommandManager(){
        this.commandManager = new PaperCommandManager(AlwaysAngryMobs.getInstance());
        commandManager.registerCommand(new Test());
        commandManager.registerCommand(new Commands());
    }
}
