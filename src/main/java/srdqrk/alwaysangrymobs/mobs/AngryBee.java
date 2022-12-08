//package srdqrk.alwaysangrymobs.mobs;
//
//import net.minecraft.world.entity.EntityType;
//import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
//import org.bukkit.Location;
//import org.bukkit.craftbukkit.v1_18_R1.CraftWorld;
//
//
//public class AngryBee extends net.minecraft.world.entity.animal.Bee {
//    public AngryBee(Location loc){
//        super(EntityType.BEE, ((CraftWorld) loc.getWorld()).getHandle());
//        this.setPos(loc.getX(), loc.getY(), loc.getZ());
//
//    }
//
//    @Override
//    public void registerGoals() {
//        this.goalSelector.addGoal(0, new MeleeAttackGoal(this,1.0D, true));
//    }
//}
