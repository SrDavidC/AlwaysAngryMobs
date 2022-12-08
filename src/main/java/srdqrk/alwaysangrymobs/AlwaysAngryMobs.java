package srdqrk.alwaysangrymobs;

import org.bukkit.plugin.java.JavaPlugin;
import srdqrk.alwaysangrymobs.crafting.CraftingManager;
import srdqrk.alwaysangrymobs.events.WTBotListener;
import srdqrk.alwaysangrymobs.managers.CommandManager;
import srdqrk.alwaysangrymobs.managers.GameManager;
import srdqrk.alwaysangrymobs.events.Listener;

public final class AlwaysAngryMobs extends JavaPlugin {
    private static AlwaysAngryMobs pl;
    static GameManager gm;
    private CommandManager cm;
    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new Listener(),this);
        this.gm = GameManager.getInstance();
        this.pl = this;
        this.cm = new CommandManager();
        CraftingManager cm = new CraftingManager(pl);
        this.getServer().getPluginManager().registerEvents(new WTBotListener(),this);
        System.out.println("[AAMs] ON");
    }

    @Override
    public void onDisable() {}

    public GameManager getGm() {
        return gm;
    }

    public static AlwaysAngryMobs getInstance(){return pl;}
}

