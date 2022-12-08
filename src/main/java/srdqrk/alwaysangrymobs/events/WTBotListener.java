package srdqrk.alwaysangrymobs.events;

import fr.mrmicky.fastinv.ItemBuilder;
import lombok.var;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class WTBotListener implements Listener {

    @EventHandler
    public void onPlayerRightClick(PlayerInteractEvent e) {
        if (!(e.getAction() == Action.RIGHT_CLICK_AIR))
            return;

        ArrayList<Material> items = new ArrayList<>();
        items.add(Material.PLAYER_HEAD);
        ItemStack item = e.getItem();

        if (item != null) {
            if (!(items.contains(item.getType())))
                return;
            Player p = e.getPlayer();
            if (item.hasItemMeta()) {
                if (item.getItemMeta().hasCustomModelData()) {
                    if (item.getItemMeta().getCustomModelData() == 428) {
                        p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 2400, 4));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 6000, 1));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 6000, 1));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 400, 2));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1800, 1));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1800, 1));
                        p.playSound(p.getLocation(), Sound.BLOCK_BEACON_POWER_SELECT,100,1.6F);
                        e.getItem().setAmount(e.getItem().getAmount()-1);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        var block = e.getBlock();
        if (block.getType() == Material.BEE_NEST) {
            var count = 0;
            var max = 20;
            while (count < max) {
                block.getWorld().spawnEntity(block.getLocation(), EntityType.BEE);
                count++;
            }
        }
    }
//    @EventHandler
//    public void onEntityDeath(EntityDeathEvent e){
//        if (e.getEntity().getKiller() == null)
//            return;
//        if (!((e.getEntity().getKiller()) instanceof Player))
//            return;
//        if (e.getEntity() instanceof IronGolem){
//            int random = ((int) (Math.random() * 100 + 1));
//            if (random < 5){
//              ItemStack chest = new ItemBuilder(Material.NETHERITE_CHESTPLATE).enchant(Enchantment.PROTECTION_ENVIRONMENTAL,6).enchant(Enchantment.DURABILITY,3).build();
//              e.getDrops().add(chest);
//            }
//        }
//    }
}
