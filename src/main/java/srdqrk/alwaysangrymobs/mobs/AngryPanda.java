//package srdqrk.alwaysangrymobs.mobs;
//
//import net.minecraft.server.level.ServerPlayer;
//import net.minecraft.world.entity.EntityType;
//import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
//import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
//import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
//import org.bukkit.Location;
//import org.bukkit.craftbukkit.v1_18_R1.CraftWorld;
//
//
//public class AngryPanda extends net.minecraft.world.entity.animal.Panda {
//    public AngryPanda(Location loc){
//        super(EntityType.PANDA, ((CraftWorld) loc.getWorld()).getHandle());
//
//        this.setPos(loc.getX(), loc.getY(), loc.getZ());
//        this.setAggressive(true);
//    }
//
//    @Override
//    public void registerGoals() {
//        this.goalSelector.addGoal(0, new LookAtPlayerGoal(this, ServerPlayer.class, 8.0F));
//        this.goalSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, ServerPlayer.class, true, false));
//        this.goalSelector.addGoal(2, new MeleeAttackGoal(this,1.0D, true));
//    }
//}
