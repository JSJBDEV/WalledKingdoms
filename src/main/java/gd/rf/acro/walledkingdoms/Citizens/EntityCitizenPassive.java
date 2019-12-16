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
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.RandomUtils;

import java.util.List;

import static gd.rf.acro.walledkingdoms.Politics.Politics.genName;
import static gd.rf.acro.walledkingdoms.Utils.readLines;

public class EntityCitizenPassive extends EntityVillager {
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
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIMoveIndoors(this));
        this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
        this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 0.6D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityCitizenPassive.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.applyEntityAI();
    }

    private void applyEntityAI() {

    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        if (!this.hasCustomName()) {
            this.setCustomNameTag(genName(5));

        }
        if (!this.world.isRemote && hand.equals(EnumHand.MAIN_HAND)) {
            player.sendMessage(new TextComponentString("<" + this.getCustomNameTag() + "> " + "Hello " + player.getName() + "!"));

        }


        return super.processInteract(player, hand);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        int x = 0;
        int y = 1000;
        int z = 0;
        if (ticksExisted % 100 == 0 && this.getHeldItem(EnumHand.MAIN_HAND).hasTagCompound()) {
            NBTTagCompound tags = this.getHeldItem(EnumHand.MAIN_HAND).getTagCompound();
            if (tags.getBoolean("shouldPath")) {
                x = tags.getInteger("pathx");
                y = tags.getInteger("pathy");
                z = tags.getInteger("pathz");
            }
        }
        if (ticksExisted % 1000 == 0 && this.getHeldItem(EnumHand.MAIN_HAND).hasTagCompound()) {
            maintainCurrentHouse();
        }

        this.getNavigator().tryMoveToXYZ(x, y, z, 0.6D);

    }

    public void pathToHouse() {
        NBTTagCompound tags = this.getHeldItem(EnumHand.MAIN_HAND).getTagCompound();
        if (tags.getIntArray("tasks")[0] == 1) {
            String pref = DimensionManager.getCurrentSaveRootDirectory() + "/WalledKingdoms/" + tags.getInteger("kingno") + "/";
            List<String> politics = readLines(pref + "politics.wk");
            int x = Integer.parseInt(politics.get(3));
            int z = Integer.parseInt(politics.get(4));

            tags.setInteger("pathx", x + 16 * tags.getIntArray("coords")[0]);
            tags.setInteger("pathz", z + 16 * tags.getIntArray("coords")[1]);
            tags.setInteger("pathy", tags.getInteger("homey"));
            tags.setBoolean("shouldPath", true);
        }
    }

    public void maintainCurrentHouse() {
        NBTTagCompound tags = this.getHeldItem(EnumHand.MAIN_HAND).getTagCompound();
        String house = Citizens.getHouseTypeFromCurrentCoords((int) this.posX, (int) this.posZ, tags.getInteger("kingno"));
        BlockPos exact = Citizens.getExactHouseCoords((int) this.posX, tags.getInteger("homey"), (int) this.posZ, tags.getInteger("kingno"));
        if (house.substring(0, 1).equals("+")) {
            house = house.substring(1);
            Utils.loadStructure(exact, this.world, house, Mirror.LEFT_RIGHT, Rotation.CLOCKWISE_90, true);

        } else {
            Utils.loadStructure(exact, this.world, house, Mirror.NONE, Rotation.NONE, true);
        }
    }
}
