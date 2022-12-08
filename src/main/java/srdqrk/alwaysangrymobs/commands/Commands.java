package srdqrk.alwaysangrymobs.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Subcommand;
import co.aikar.commands.annotation.Syntax;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import srdqrk.alwaysangrymobs.AlwaysAngryMobs;
import srdqrk.alwaysangrymobs.crafting.CraftingManager;
import srdqrk.alwaysangrymobs.managers.GameManager;
import srdqrk.alwaysangrymobs.utils.Utils;

@CommandAlias("alwaysangrymobs|aam")
@CommandPermission("aam.admin")
public class Commands extends BaseCommand{
    private GameManager gm = AlwaysAngryMobs.getInstance().getGm();

    public void onSend(CommandSender sender){
        sender.sendMessage(Utils.prefix +  "Hey! Hello my Queen/King, for help type /aam help");
    }
    @Subcommand("angryPigZombie")
    @CommandAlias("angryPigZombie")
    @Syntax("angryPigzombie <true/false> ")
    public void onAgryPig(CommandSender sender, boolean bool){
        if (bool == true){
            gm.setAngryPigman(true);
            sender.sendMessage(Utils.prefix + ChatColor.RED + "Zombified Piglin is now a hostile mob");
        }
        else {
            gm.setAngryPigman(false);
            sender.sendMessage(Utils.prefix + ChatColor.RED + "Zombified Piglin is now a neutral mob");
        }
    }
    @Subcommand("angryIronGolem")
    @CommandAlias("angryIronGolem")
    @Syntax("angryIronGolem <true/false> ")
    public void onAngryIronGolem(CommandSender sender, boolean bool){
        if (bool == true){
            gm.setAngryGolem(true);
            sender.sendMessage(Utils.prefix + ChatColor.RED + "IronGolem is now a hostile mob");
        }
        else {
            gm.setAngryPigman(false);
            sender.sendMessage(Utils.prefix + ChatColor.RED + "IronGolem is now a neutral mob");
        }
    }
    @Subcommand("angryWolf")
    @CommandAlias("angryWolf")
    @Syntax("angryWolf <true/false> ")
    public void onAngryWolf(CommandSender sender, boolean bool){
        if (bool == true){
            gm.setAngryWolf(true);
            sender.sendMessage(Utils.prefix + ChatColor.RED + "The wolf is now a hostile mob");
        }
        else {
            gm.setAngryWolf(false);
            sender.sendMessage(Utils.prefix + ChatColor.RED + "The wolf is now a neutral mob");
        }
    }
    @Subcommand("angryAll")
    @CommandAlias("angryAll")
    @Syntax("angryAll <true/false> ")
    public void onAngrAll(CommandSender sender, boolean bool){
        if (bool == true){
            gm.setAngryWolf(true);
            gm.setAngryGolem(true);
            gm.setAngryPigman(true);
            gm.setAngryBee(true);
            gm.setAngryDolphin(true);
            gm.setAngryPanda(true);
            gm.setAngryPolarBear(true);
            sender.sendMessage(Utils.prefix + ChatColor.RED + "The neutral mobs are now HOSTILES");
        }
        else {
            gm.setAngryWolf(false);
            gm.setAngryGolem(false);
            gm.setAngryPigman(false);
            gm.setAngryBee(false);
            gm.setAngryDolphin(false);
            gm.setAngryPanda(false);
            gm.setAngryPolarBear(false);
            sender.sendMessage(Utils.prefix + ChatColor.RED + "The neutral mobs are now NEUTRALS");
        }
    }
}
