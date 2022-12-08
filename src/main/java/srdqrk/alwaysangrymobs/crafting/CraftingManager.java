package srdqrk.alwaysangrymobs.crafting;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import srdqrk.alwaysangrymobs.AlwaysAngryMobs;
import srdqrk.alwaysangrymobs.crafting.recipes.EnchantedEmerald;
import srdqrk.alwaysangrymobs.crafting.recipes.EnchantedGold;
import srdqrk.alwaysangrymobs.crafting.recipes.EnchantedGoldBlock;
import srdqrk.alwaysangrymobs.crafting.recipes.TheNewNotch;

public class CraftingManager {
    public CraftingManager(AlwaysAngryMobs wtBot){
        EnchantedEmerald enchantedEmerald = new EnchantedEmerald(new NamespacedKey(wtBot,"enchantedEmerald"));
        EnchantedGold enchantedGold = new EnchantedGold(new NamespacedKey(wtBot,"enchantedGold"));
        EnchantedGoldBlock enchantedGoldBlock = new EnchantedGoldBlock(new NamespacedKey(wtBot,"enchantGoldBlock"));
        TheNewNotch thenewNotch = new TheNewNotch(new NamespacedKey(wtBot,"thenewNotch"));

        enchantedEmerald.setEnabled(true);
        enchantedGold.setEnabled(true);
        enchantedGoldBlock.setEnabled(true);
        thenewNotch.setEnabled(true);

        Bukkit.addRecipe(enchantedGold.getRecipe());
        Bukkit.addRecipe(enchantedEmerald.getRecipe());
        Bukkit.addRecipe(enchantedGoldBlock.getRecipe());
        Bukkit.addRecipe(thenewNotch.getRecipe());
    }
}
