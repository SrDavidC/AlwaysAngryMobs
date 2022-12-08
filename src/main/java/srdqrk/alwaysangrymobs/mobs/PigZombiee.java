//package srdqrk.alwaysangrymobs.mobs;
//
//import net.minecraft.server.level.ServerPlayer;
//import net.minecraft.world.InteractionHand;
//import net.minecraft.world.entity.EntityType;
//import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
//import net.minecraft.world.entity.ai.goal.DoorInteractGoal;
//import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
//import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
//import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
//import net.minecraft.world.entity.monster.Skeleton;
//import net.minecraft.world.entity.monster.ZombifiedPiglin;
//import net.minecraft.world.item.ItemStack;
//import org.bukkit.Location;
//import org.bukkit.Material;
//import org.bukkit.craftbukkit.v1_18_R1.CraftWorld;
//import org.bukkit.craftbukkit.v1_18_R1.inventory.CraftItemStack;
//
//public class PigZombiee extends ZombifiedPiglin {
//    public PigZombiee(Location loc){
//        super(EntityType.ZOMBIFIED_PIGLIN, ((CraftWorld) loc.getWorld()).getHandle());
//
//        org.bukkit.inventory.ItemStack bukkitItem = new org.bukkit.inventory.ItemStack(Material.GOLDEN_SWORD);
//        ItemStack nmsItem = CraftItemStack.asNMSCopy(bukkitItem);
//
//        this.setPos(loc.getX(), loc.getY(), loc.getZ());
//        this.setItemInHand(InteractionHand.MAIN_HAND,nmsItem);
//        this.setAggressive(true);
//    }
//
//    @Override
//    public void registerGoals() {
//        this.goalSelector.addGoal(0, new AvoidEntityGoal<>(this, Skeleton.class, 6f, 1d, 1.2d));
//        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, ServerPlayer.class, 8.0F));
//        this.goalSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ServerPlayer.class, true, false));
//        this.goalSelector.addGoal(3, new MeleeAttackGoal(this,1.0D, true));
//
//    }
//}
//    public void chgeMob(Entity entity, ArrayList<EntityType> mobs, World world) {
//        //Bukkit.broadcastMessage(Utils.prefix +  "method");
//        if (!(entity instanceof LivingEntity))
//            return;
//        if (!(mobs.contains(entity.getType())))
//            return;
//        entity.remove();
//        final Entity entityNew =  world.spawnEntity(entity.getLocation(),entity.getType());
//        //ServerLevel w = (((CraftWorld) world).getHandle());
//        if (entity instanceof PigZombie && GameManager.getInstance().isAngryPigman()) {
//            //Bukkit.broadcastMessage("PIGMAN");
//            entity.remove();
//            world.spawnEntity(entity.getLocation(),entity.getType());
//        } else if (entity instanceof IronGolem && GameManager.getInstance().isAngryGolem()) {
//            entity.remove();
//            AngryIronGolem ig = new AngryIronGolem(entity.getLocation());
//            w.tryAddFreshEntityWithPassengers(ig, CreatureSpawnEvent.SpawnReason.CUSTOM);
//        } else if (entity instanceof Wolf && GameManager.getInstance().isAngryWolf()) {
//            entity.remove();
//            AngryWolf wolf = new AngryWolf(entity.getLocation());
//            w.tryAddFreshEntityWithPassengers(wolf, CreatureSpawnEvent.SpawnReason.CUSTOM);
//        } else if (entity instanceof Panda && GameManager.getInstance().isAngryPanda()) {
//            entity.remove();
//            //Bukkit.broadcastMessage("Panda quitao");
//            AngryPanda panda = new AngryPanda(entity.getLocation());
//            w.tryAddFreshEntityWithPassengers(panda, CreatureSpawnEvent.SpawnReason.CUSTOM);
//        } else if (entity instanceof Dolphin && GameManager.getInstance().isAngryDolphin()) {
//            entity.remove();
//            AngryDolphin wolf = new AngryDolphin(entity.getLocation());
//            w.tryAddFreshEntityWithPassengers(wolf, CreatureSpawnEvent.SpawnReason.CUSTOM);
//        } else if (entity instanceof Bee && GameManager.getInstance().isAngryBee()) {
//            entity.remove();
//            AngryBee wolf = new AngryBee(entity.getLocation());
//            Bee bee = (Bee) entity;
//            bee.setAnger(1000);
//            //w.tryAddFreshEntityWithPassengers(wolf, CreatureSpawnEvent.SpawnReason.CUSTOM);
//        } else if (entity instanceof PolarBear && GameManager.getInstance().isAngryPolarBear()) {
//            entity.remove();
//            AngryPolarBear wolf = new AngryPolarBear(entity.getLocation());
//            w.tryAddFreshEntityWithPassengers(wolf, CreatureSpawnEvent.SpawnReason.CUSTOM);
//        }
//e.setCancelled(true);
//            AngryPolarBear wolf = new AngryPolarBear(entity.getLocation());
//            w.tryAddFreshEntityWithPassengers(wolf, CreatureSpawnEvent.SpawnReason.CUSTOM);
//    }
