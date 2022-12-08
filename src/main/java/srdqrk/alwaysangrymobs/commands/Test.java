package srdqrk.alwaysangrymobs.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Material;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.UUID;

@CommandAlias("pepe")
public class Test extends BaseCommand{
    @Default
    @Syntax("yes")
    public void onSend(Player sender){
        sender.sendMessage("asd");
        ItemStack notch = getCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTI0ZjNjODQ2ZDU1MmNiZGMzNjZkODc1MWRkNGJmYWJkZTYwYTNhZGFkNTM1YzM2MjBiMWEwYWY1ZDNmNTUzYSJ9fX0=");
        sender.getInventory().setItemInMainHand(notch);


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

