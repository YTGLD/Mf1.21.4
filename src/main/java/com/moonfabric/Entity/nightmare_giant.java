package com.moonfabric.Entity;

import com.mojang.logging.LogUtils;
import com.moonfabric.HandlerMain;
import com.moonfabric.HasCurio;
import com.moonfabric.Ievent.AllEvent;
import com.moonfabric.init.InItEntity;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.task.SonicBoomTask;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.WardenBrain;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.server.network.DebugInfoSender;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Unit;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.util.List;
import java.util.UUID;

public class nightmare_giant extends TameableZombie {
    private static final Logger LOGGER = LogUtils.getLogger();
    private int tendrilPitch;
    private int lastTendrilPitch;
    private int heartbeatCooldown;
    public AnimationState roaringAnimationState = new AnimationState();
    public AnimationState sniffingAnimationState = new AnimationState();
    public AnimationState emergingAnimationState = new AnimationState();
    public AnimationState diggingAnimationState = new AnimationState();
    public AnimationState attackingAnimationState = new AnimationState();
    public AnimationState chargingSonicBoomAnimationState = new AnimationState();

    public nightmare_giant(EntityType<? extends nightmare_giant> entityType, World world) {
        super(entityType, world);
    }
    public static DefaultAttributeContainer.Builder addAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.MAX_HEALTH, 300).add(EntityAttributes.MOVEMENT_SPEED, 0.30000001192092896).add(EntityAttributes.KNOCKBACK_RESISTANCE, 1.0).add(EntityAttributes.ATTACK_KNOCKBACK, 1.5).add(EntityAttributes.ATTACK_DAMAGE, 22);
    }
    @Nullable
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_ZOMBIE_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_ZOMBIE_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ZOMBIE_DEATH;
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_WARDEN_STEP, 10.0F, 1.0F);
    }
    public void handleStatus(byte status) {
        if (status == 4) {
            this.roaringAnimationState.stop();
            this.attackingAnimationState.start(this.age);
        } else if (status == 61) {
            this.tendrilPitch = 10;
        } else if (status == 62) {
            this.chargingSonicBoomAnimationState.start(this.age);
        } else {
            super.handleStatus(status);
        }

    }

    @Override
    public boolean tryAttack(ServerWorld world, Entity target) {
        this.getWorld().sendEntityStatus(this, (byte) 4);
        this.playSound(SoundEvents.ENTITY_WARDEN_ATTACK_IMPACT, 10.0F, this.getSoundPitch());
        SonicBoomTask.cooldown(this, 40);
        return super.tryAttack(world,target);
    }

    public  int time ;

    @Override
    public void onDeath(DamageSource damageSource) {
        if (this.getCommandTags().contains(HasCurio.Giant_Boom)){
            this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 12.5f, true, World.ExplosionSourceType.NONE);
        }
    }
    int sZombieTime = 0;


    public void tick() {
        time++;
        if (sZombieTime>0){
            sZombieTime--;
        }
        if (!this.getCommandTags().contains(HasCurio.Giant_Time)) {
            time += 3;
        }else {
            time+=2;
        }
        if (this.time > 3600){
            this.discard();
        }
        {
            Vec3d playerPos = this.getPos();
            float range = 16;
            List<cell_zombie> entities =
                    this.getWorld().getEntitiesByClass(cell_zombie.class,
                            new Box(playerPos.x - range,
                                    playerPos.y - range,
                                    playerPos.z - range,
                                    playerPos.x + range,
                                    playerPos.y + range,
                                    playerPos.z + range), EntityPredicates.EXCEPT_SPECTATOR);

            for (cell_zombie ignored : entities) {
                if (this.age % 20 == 1) {
                    this.heal(entities.size());
                }
            }
        }
        if (this.getOwner()!= null) {
            if (this.getOwner().getLastAttacker()!= null&& HandlerMain.IsNoon(this,this.getOwner().getLastAttacker())) {
                if (!(this.getOwner().getLastAttacker() == (this))) {
                    this.setTarget(this.getOwner().getLastAttacker());
                }
            }
            if (this.getOwner().getAttacking()!= null&& HandlerMain.IsNoon(this,this.getOwner().getAttacking())) {
                if (!(this.getOwner().getAttacking() == (this))) {
                    this.setTarget(this.getOwner().getAttacking());
                }

            }
            if (this.getOwner().getAttacker()!= null&& HandlerMain.IsNoon(this,this.getOwner().getAttacker())) {
                if (!(this.getOwner().getAttacker() == (this))) {
                    this.setTarget(this.getOwner().getAttacker());
                }
            }
        }

        if (this.getTarget() != null) {
            if (this.getTarget()  instanceof TameableZombie) {
                this.setTarget(null);
            }
        }
        if (this.getTarget() != null&&this.getOwner() != null) {
            if (this.getTarget() == this.getOwner()) {
                this.setTarget(null);
            }
        }
        Vec3d playerPos = this.getPos().add(0, 0.75, 0);
        int range = 20;
        List<MobEntity> entities = this.getEntityWorld().getEntitiesByClass(MobEntity.class, new Box(playerPos.x - range, playerPos.y - range, playerPos.z - range, playerPos.x + range, playerPos.y + range, playerPos.z + range), EntityPredicates.EXCEPT_SPECTATOR);
        for (MobEntity mob : entities) {
            if (this.getTarget() == null) {
                if (!(mob instanceof TameableZombie)) {
                    this.setTarget(mob);
                    if (sZombieTime<=0){
                        if (this.getOwner()!=null) {
                            for (int i = 0; i < 2; i++) {
                                cell_zombie cellZombie = new cell_zombie(InItEntity.cell_zombie, this.getEntityWorld());
                                cellZombie.setPos(this.getX(), this.getY(), this.getZ());
                                cellZombie.setOwnerUuid(this.getOwnerUuid());
                                cellZombie.addCommandTag(AllEvent.DamageCell);
                                cellZombie.addCommandTag("hasNig");
                                this.getWorld().playSound(null,this.getBlockPos(),SoundEvents.BLOCK_TRIAL_SPAWNER_AMBIENT_OMINOUS, SoundCategory.AMBIENT,10,10);
                                this.getWorld().spawnEntity(cellZombie);
                                sZombieTime = 300;
                            }
                        }
                    }
                }
            }
        }
        if (this.getTarget()!=null) {
            if (!this.getTarget().isAlive()) {
                this.setTarget(null);
            }
        }
        World var2 = this.getWorld();
        if (var2 instanceof ServerWorld) {
            if (this.isPersistent() || this.cannotDespawn()) {
                WardenBrain.resetDigCooldown(this);
            }
        }

        super.tick();
        if (this.getWorld().isClient()) {


            this.lastTendrilPitch = this.tendrilPitch;
            if (this.tendrilPitch > 0) {
                --this.tendrilPitch;
            }

            if (this.heartbeatCooldown > 0) {
                --this.heartbeatCooldown;
            }

            switch (this.getPose()) {
                case EMERGING:
                    this.addDigParticles(this.emergingAnimationState);
                    break;
                case DIGGING:
                    this.addDigParticles(this.diggingAnimationState);
            }
        }
    }
    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new SitGoal(this));
        this.goalSelector.add(4, new PounceAtTargetGoal(this, 0.4F));
        this.goalSelector.add(5, new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.add(6, new FollowOwnerGoal(this, 1.0, 10.0F, 2.0F));
        this.goalSelector.add(7, new AnimalMateGoal(this, 1.0));
        this.goalSelector.add(8, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(10, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(10, new LookAroundGoal(this));
        this.targetSelector.add(1, new TrackOwnerAttackerGoal(this));
        this.targetSelector.add(2, new AttackWithOwnerGoal(this));
        this.targetSelector.add(3, (new RevengeGoal(this)).setGroupRevenge());

    }

    private void addDigParticles(AnimationState animationState) {
        if ((float)animationState.getTimeInMilliseconds(age) < 4500.0F) {
            Random random = this.getRandom();
            BlockState blockState = this.getSteppingBlockState();
            if (blockState.getRenderType() != BlockRenderType.INVISIBLE) {
                for(int i = 0; i < 30; ++i) {
                    double d = this.getX() + (double)MathHelper.nextBetween(random, -0.7F, 0.7F);
                    double e = this.getY();
                    double f = this.getZ() + (double)MathHelper.nextBetween(random, -0.7F, 0.7F);
                    this.getWorld().addParticle(new BlockStateParticleEffect(ParticleTypes.BLOCK, blockState), d, e, f, 0.0, 0.0, 0.0);
                }
            }
        }

    }

    public void onTrackedDataSet(TrackedData<?> data) {
        if (POSE.equals(data)) {
            switch (this.getPose()) {
                case EMERGING:
                    this.emergingAnimationState.start(this.age);
                    break;
                case DIGGING:
                    this.diggingAnimationState.start(this.age);
                    break;
                case ROARING:
                    this.roaringAnimationState.start(this.age);
                    break;
                case SNIFFING:
                    this.sniffingAnimationState.start(this.age);
            }
        }

        super.onTrackedDataSet(data);
    }

    protected void sendAiDebugData() {
        super.sendAiDebugData();
        DebugInfoSender.sendBrainDebugData(this);
    }


    public boolean canImmediatelyDespawn(double distanceSquared) {
        return false;
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return false;
    }

    @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
        this.getBrain().remember(MemoryModuleType.DIG_COOLDOWN, Unit.INSTANCE, 1200L);
        if (spawnReason == SpawnReason.TRIGGERED) {
            this.setPose(EntityPose.EMERGING);
            this.getBrain().remember(MemoryModuleType.IS_EMERGING, Unit.INSTANCE, WardenBrain.EMERGE_DURATION);
            this.playSound(SoundEvents.ENTITY_WARDEN_AGITATED, 5.0F, 1.0F);
        }

        return super.initialize(world, difficulty, spawnReason, entityData);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        cell_giant line = InItEntity.cell_giant.create(world,SpawnReason.BREEDING);
        if (line != null) {
            UUID uuid = this.getOwnerUuid();
            if (uuid != null) {
                line.setOwnerUuid(uuid);
                line.setTamed(true, true);
            }
        }
        return line;

    }


    public void updateAttackTarget(LivingEntity target) {
        this.getBrain().forget(MemoryModuleType.ROAR_TARGET);
        this.getBrain().remember(MemoryModuleType.ATTACK_TARGET, target);
        this.getBrain().forget(MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE);
        SonicBoomTask.cooldown(this, 200);
    }


    protected void pushAway(Entity entity) {
        if (!this.isAiDisabled() && !this.getBrain().hasMemoryModule(MemoryModuleType.TOUCH_COOLDOWN)) {
            this.getBrain().remember(MemoryModuleType.TOUCH_COOLDOWN, Unit.INSTANCE, 20L);
        }
        super.pushAway(entity);
    }



}
