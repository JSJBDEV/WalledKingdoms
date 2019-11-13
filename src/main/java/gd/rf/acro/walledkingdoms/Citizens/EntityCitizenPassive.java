package gd.rf.acro.walledkingdoms.Citizens;

import gd.rf.acro.walledkingdoms.Utils;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static gd.rf.acro.walledkingdoms.Politics.Politics.genName;

public class EntityCitizenPassive extends EntityMob {
    private static final DataParameter<Boolean> ARMS_RAISED = EntityDataManager.createKey(EntityCitizenPassive.class, DataSerializers.BOOLEAN);
    public EntityCitizenPassive(World world) {
        super(world);
        setCanPickUpLoot(false);
        setDropItemsWhenDead(false);
    }
    @Override
    protected void entityInit() {
        super.entityInit();
        this.getDataManager().register(ARMS_RAISED, Boolean.FALSE);
    }
    public void setArmsRaised(boolean armsRaised) {
        this.getDataManager().set(ARMS_RAISED, armsRaised);
    }

    @SideOnly(Side.CLIENT)
    public boolean isArmsRaised() {
        return this.getDataManager().get(ARMS_RAISED);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        // Here we set various attributes for our mob. Like maximum health, armor, speed, ...
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.applyEntityAI();
    }
    private void applyEntityAI() {

    }

    @Override
    protected boolean processInteract(EntityPlayer player, EnumHand hand) {
        if(!this.hasCustomName())
        {
            this.setCustomNameTag(genName(5));
        }
        if(this.world.isRemote)
        {
            player.sendMessage(new TextComponentString("<"+this.getCustomNameTag()+"> "+"Hello "+player.getName()+"!"));
        }


        return super.processInteract(player,hand);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if(this.ticksExisted%50==0)
        {
            System.out.println("50 ticks have passed");
        }
    }

}
