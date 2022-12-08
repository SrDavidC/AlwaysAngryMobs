package srdqrk.alwaysangrymobs.events;

import lombok.var;
import net.minecraft.world.entity.EntityCreature;
import net.minecraft.world.entity.EntityInsentient;
import net.minecraft.world.entity.ai.goal.PathfinderGoalMeleeAttack;
import net.minecraft.world.entity.ai.goal.PathfinderGoalSelector;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalNearestAttackableTarget;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.monster.EntityPigZombie;
import net.minecraft.world.entity.player.EntityHuman;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_18_R1.entity.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.world.EntitiesLoadEvent;
import srdqrk.alwaysangrymobs.managers.GameManager;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Listener implements org.bukkit.event.Listener {

    @EventHandler
    public void onPigmanSpawn(CreatureSpawnEvent e){
        ArrayList entities = getMobsType();
        if (!(entities.contains(e.getEntity().getType())))
            return;
        Entity entity = e.getEntity();
        if (entity instanceof PigZombie && GameManager.getInstance().isAngryPigman()) {
            var pig = (PigZombie) entity;
            CraftPigZombie craft = ((CraftPigZombie) pig);
            EntityPigZombie nms = craft.getHandle();
            setAgressiveIA(nms);

        } else if (entity instanceof IronGolem && GameManager.getInstance().isAngryGolem()) {
            var ironGolem = (IronGolem) entity;
            ((IronGolem) entity).setPlayerCreated(false);
            CraftIronGolem craft = ((CraftIronGolem) ironGolem);
            EntityIronGolem nms = craft.getHandle();
            setAgressiveIA(nms);


        } else if (entity instanceof Wolf && GameManager.getInstance().isAngryWolf()) {
            var wolf = (Wolf) entity;
            CraftWolf craft = ((CraftWolf) wolf);
            EntityWolf nms = craft.getHandle();
            setAgressiveIA(nms);

        } else if (entity instanceof Panda && GameManager.getInstance().isAngryPanda()) {
            var panda = (Panda) entity;
            CraftPanda craft = ((CraftPanda) panda);
            EntityPanda nms = craft.getHandle();
            setAgressiveIA(nms);

        } else if (entity instanceof Dolphin && GameManager.getInstance().isAngryDolphin()) {
            var dolph = (Dolphin) entity;
            CraftDolphin craft = ((CraftDolphin) dolph);
            EntityDolphin nms = craft.getHandle();
            setAgressiveIA(nms);

        } else if (entity instanceof Bee && GameManager.getInstance().isAngryBee()) {
            var bee = (Bee) entity;
            CraftBee craft = ((CraftBee) bee);
            EntityBee nms = craft.getHandle();
            setAgressiveIA(nms);

        } else if (entity instanceof PolarBear && GameManager.getInstance().isAngryPolarBear()) {
            var polar = (PolarBear) entity;
            CraftPolarBear craft = ((CraftPolarBear) polar);
            EntityPolarBear nms = craft.getHandle();
            setAgressiveIA(nms);
        }
    }

    public void chgeMob(Entity entity, ArrayList<EntityType> mobs, World world) {
        if (!(entity instanceof LivingEntity))
            return;
        if (!(mobs.contains(entity.getType())))
            return;
        entity.remove();
        final Entity entityNew =  world.spawnEntity(entity.getLocation(),entity.getType());

        if (entity instanceof PigZombie && GameManager.getInstance().isAngryPigman()) {
            var pig = (PigZombie) entityNew;
            CraftPigZombie craft = ((CraftPigZombie) pig);
            EntityPigZombie nms = craft.getHandle();
            setAgressiveIA(nms);

        } else if (entity instanceof IronGolem && GameManager.getInstance().isAngryGolem()) {
            var ironGolem = (IronGolem) entityNew;
            CraftIronGolem craft = ((CraftIronGolem) ironGolem);
            EntityIronGolem nms = craft.getHandle();
            setAgressiveIA(nms);

        } else if (entity instanceof Wolf && GameManager.getInstance().isAngryWolf()) {
            var wolf = (Wolf) entityNew;
            CraftWolf craft = ((CraftWolf) wolf);
            EntityWolf nms = craft.getHandle();
            setAgressiveIA(nms);

        } else if (entity instanceof Panda && GameManager.getInstance().isAngryPanda()) {
            var panda = (Panda) entityNew;
            CraftPanda craft = ((CraftPanda) panda);
            EntityPanda nms = craft.getHandle();
            setAgressiveIA(nms);

        } else if (entity instanceof Dolphin && GameManager.getInstance().isAngryDolphin()) {
            var dolph = (Dolphin) entityNew;
            CraftDolphin craft = ((CraftDolphin) dolph);
            EntityDolphin nms = craft.getHandle();
            setAgressiveIA(nms);

        } else if (entity instanceof Bee && GameManager.getInstance().isAngryBee()) {
            var bee = (Bee) entityNew;
            CraftBee craft = ((CraftBee) bee);
            EntityBee nms = craft.getHandle();
            setAgressiveIA(nms);

        } else if (entity instanceof PolarBear && GameManager.getInstance().isAngryPolarBear()) {
            var polar = (PolarBear) entityNew;
            CraftPolarBear craft = ((CraftPolarBear) polar);
            EntityPolarBear nms = craft.getHandle();
            setAgressiveIA(nms);
        }
    }

    private ArrayList<EntityType> getMobsType() {
        ArrayList<EntityType> mobs = new ArrayList<>();
        mobs.add(EntityType.ZOMBIFIED_PIGLIN);
        mobs.add(EntityType.IRON_GOLEM);
        mobs.add(EntityType.WOLF);
        mobs.add(EntityType.BEE);
        mobs.add(EntityType.DOLPHIN);
        mobs.add(EntityType.PANDA);
        mobs.add(EntityType.POLAR_BEAR);
        return mobs;
    }

    public void setAgressiveIA(EntityCreature nms) {
        try {
            Class<? extends EntityInsentient> cl = EntityInsentient.class; //nms.getClass()
            Field gf = cl.getDeclaredField("bR");
            gf.setAccessible(true);

            PathfinderGoalSelector goal = (PathfinderGoalSelector) gf.get(nms);
            goal.a(0, new PathfinderGoalMeleeAttack(nms, 1.0D, true));

            Field tf = cl.getDeclaredField("bS");
            tf.setAccessible(true);

            PathfinderGoalSelector target = (PathfinderGoalSelector) tf.get(nms);
            target.a(0, new PathfinderGoalNearestAttackableTarget<>(nms, EntityHuman.class, 10, true, false, null));
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    @EventHandler
    public void onChunkLoad(EntitiesLoadEvent e) {
        ArrayList<EntityType> mobs = getMobsType();
        List<Entity> entities = e.getEntities();
        for (Entity entite : entities) {
            chgeMob(entite, mobs, e.getWorld());
        }

    }

}


