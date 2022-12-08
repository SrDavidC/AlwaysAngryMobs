package srdqrk.alwaysangrymobs.crafting.recipes;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import fr.mrmicky.fastinv.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import srdqrk.alwaysangrymobs.crafting.CustomRecipe;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.UUID;


public class TheNewNotch extends CustomRecipe {
    public TheNewNotch(NamespacedKey namespacedKey){
        super(namespacedKey);

        ItemStack notch = getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTI0ZjNjODQ2ZDU1MmNiZGMzNjZkODc1MWRkNGJmYWJkZTYwYTNhZGFkNTM1YzM2MjBiMWEwYWY1ZDNmNTUzYSJ9fX0=");
        ItemMeta meta = notch.getItemMeta();

        meta.setCustomModelData(428);
        meta.setUnbreakable(true);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "OVERPOWERED PLAYER HEAD");

        notch.setItemMeta(meta);
        notch.addUnsafeEnchantment(Enchantment.DURABILITY,10);

        final ItemStack goldBlock = new ItemBuilder(Material.GOLD_BLOCK).name(ChatColor.LIGHT_PURPLE + "Enchanted Golden Block").enchant(Enchantment.VANISHING_CURSE).build();
        RecipeChoice goldBlockR = new RecipeChoice.ExactChoice(goldBlock);
        final ShapedRecipe recipe = new ShapedRecipe(namespacedKey, notch);

        recipe.shape("AAA","ABA","AAA");
        recipe.setIngredient('A', goldBlockR);
        recipe.setIngredient('B',Material.PLAYER_HEAD);

        setRecipe(recipe);
    }

    public ItemStack getCustomSkull(String base64) {

        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        if (base64.isEmpty()) return head;

        SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);

        profile.getProperties().put("textures", new Property("textures", base64));

        try {
            Method mtd = skullMeta.getClass().getDeclaredMethod("setProfile", GameProfile.class);
            mtd.setAccessible(true);
            mtd.invoke(skullMeta, profile);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException ex) {
            ex.printStackTrace();
        }

        head.setItemMeta(skullMeta);
        return head;
    }

}