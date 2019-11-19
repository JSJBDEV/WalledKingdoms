package gd.rf.acro.walledkingdoms.Citizens;

import gd.rf.acro.walledkingdoms.Utils;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import org.apache.commons.lang3.RandomUtils;

import java.util.List;

import static gd.rf.acro.walledkingdoms.Utils.readLines;

public class Citizens {

    //A lot of the code in the Citizens package is adapted from https://wiki.mcjty.eu/modding/index.php?title=Mobs-1.12
    //https://docs.google.com/document/d/19HADVE3UCYC2lRt9DEblwthSWLeYv4MVF4ujR1QiF84/edit?usp=sharing

    public static void initVillager(World world, BlockPos pos, boolean mirror,int kingdomNo)
    {
        List<EntityCitizenPassive> villagers = world.getEntitiesWithinAABB(EntityCitizenPassive.class,new AxisAlignedBB(pos,pos.add(16,32,16)));

        if(villagers.size()>0)
        {
            if(villagers.get(0).getHeldItem(EnumHand.MAIN_HAND).getItem()== Items.AIR) //allows for building specific professions
            {
                giveProfessionItem(villagers.get(0),0,true);
                setCitizenHouse(villagers.get(0),pos,kingdomNo,mirror);
            }
        }
    }


    public static int giveProfessionItem(EntityCitizenPassive entity, int profession, boolean isRandom)
    {
        if(isRandom)
        {
            profession = RandomUtils.nextInt(0,7);
        }
        switch (profession)
        {
            case 0: //butcher
                entity.setHeldItem(EnumHand.MAIN_HAND,new ItemStack(Items.PORKCHOP));
                Utils.setIntegerNBTList(entity.getHeldItem(EnumHand.MAIN_HAND),"tasks",0,1,2);
                break;
            case 1: //baker
                entity.setHeldItem(EnumHand.MAIN_HAND,new ItemStack(Items.BREAD));
                Utils.setIntegerNBTList(entity.getHeldItem(EnumHand.MAIN_HAND),"tasks",0,1,2);
                break;
            case 2: //blacksmith
                entity.setHeldItem(EnumHand.MAIN_HAND,new ItemStack(Blocks.ANVIL));
                Utils.setIntegerNBTList(entity.getHeldItem(EnumHand.MAIN_HAND),"tasks",0,1,2);
                break;
            case 3: //goldsmith
                entity.setHeldItem(EnumHand.MAIN_HAND,new ItemStack(Items.GOLD_INGOT));
                Utils.setIntegerNBTList(entity.getHeldItem(EnumHand.MAIN_HAND),"tasks",0,1,2);
                break;
            case 4: //builder
                entity.setHeldItem(EnumHand.MAIN_HAND,new ItemStack(Blocks.STONE_BRICK_STAIRS));
                Utils.setIntegerNBTList(entity.getHeldItem(EnumHand.MAIN_HAND),"tasks",0,1,2);
                break;
            case 5: //clockmaker
                entity.setHeldItem(EnumHand.MAIN_HAND,new ItemStack(Items.CLOCK));
                Utils.setIntegerNBTList(entity.getHeldItem(EnumHand.MAIN_HAND),"tasks",0,1,2);
                break;
            default: //court appointment
                entity.setHeldItem(EnumHand.MAIN_HAND,new ItemStack(Items.DIAMOND));
                Utils.setIntegerNBTList(entity.getHeldItem(EnumHand.MAIN_HAND),"tasks",0,1,2);
                break;
        }
        return profession;
    }
    public static void setCitizenHouse(EntityCitizenPassive entity, BlockPos blockPos,int kingdomNumber, boolean mirror)
    {
        //requires the position that the generator would use (least positive x and z corner)
        ItemStack item = entity.getHeldItem(EnumHand.MAIN_HAND);
        if(!item.hasTagCompound())
        {
            item.setTagCompound(new NBTTagCompound());
        }
        NBTTagCompound tags = item.getTagCompound();
        tags.setBoolean("mirror",mirror);
        tags.setInteger("homex",blockPos.getX());
        tags.setInteger("homey",blockPos.getY());
        tags.setInteger("homez",blockPos.getZ());
        tags.setInteger("kingno",kingdomNumber);
    }

    public static String getHouseTypeFromCurrentCoords(EntityPlayer entity, int kingdomNo)
    {
        String pref = DimensionManager.getCurrentSaveRootDirectory() + "/WalledKingdoms/"+kingdomNo+"/";
        List<String> layout = readLines(pref+"layout.wk");
        List<String> politics = readLines(pref+"politics.wk");
        int x = Integer.parseInt(politics.get(3));
        int z = Integer.parseInt(politics.get(4));

        String[] houses = layout.get((int)Math.floor((entity.posX-x)/16)).split(",");

        return houses[(int)Math.floor((entity.posZ-z)/16)];


    }

    public static String getProfessionNameFromItem(Item item,boolean onlyKeepers)
    {
        if(item==Items.BREAD)
        {
            return "baker";
        }
        if(item==Items.PORKCHOP)
        {
            return "butcher";
        }
        if(item==Items.CLOCK)
        {
            return "clockmaker";
        }
        if(item==Items.GOLD_INGOT)
        {
            return "goldsmith";
        }

        if(item==Item.getItemFromBlock(Blocks.ANVIL))
        {
            return "baker";
        }
        if(!onlyKeepers) //keepers are people who require a worktable to do there job
        {
            if(item==Items.DIAMOND)
            {
                return "court appointment";
            }
            if(item==Item.getItemFromBlock(Blocks.STONE_BRICK_STAIRS))
            {
                return "builder";
            }
            else
            {
                return "unemployed";
            }
        }
        return "vagrant"; //this should never be returned
    }


}
