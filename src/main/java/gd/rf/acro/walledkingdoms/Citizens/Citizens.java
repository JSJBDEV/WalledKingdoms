package gd.rf.acro.walledkingdoms.Citizens;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.commons.lang3.RandomUtils;

import java.util.List;

public class Citizens {

    //A lot of the code in the Citizens package is adapted from https://wiki.mcjty.eu/modding/index.php?title=Mobs-1.12
    //https://docs.google.com/document/d/19HADVE3UCYC2lRt9DEblwthSWLeYv4MVF4ujR1QiF84/edit?usp=sharing

    public static void initVillager(World world, BlockPos pos, boolean mirror)
    {
        List<EntityCitizenPassive> villagers = world.getEntitiesWithinAABB(EntityCitizenPassive.class,new AxisAlignedBB(pos,pos.add(16,32,16)));

        if(villagers.size()>0)
        {
            if(villagers.get(0).getHeldItem(EnumHand.MAIN_HAND).getItem()== Items.AIR) //allows for building specific professions
            {
                giveProfessionItem(villagers.get(0),0,true);
                setCitizenHouse(villagers.get(0),pos,mirror);
            }
        }
    }


    public static void giveProfessionItem(EntityCitizenPassive entity, int profession, boolean isRandom)
    {
        if(isRandom)
        {
            profession = RandomUtils.nextInt(0,5);
        }
        switch (profession)
        {
            case 0: //butcher
                entity.setHeldItem(EnumHand.MAIN_HAND,new ItemStack(Items.PORKCHOP));
                break;
            case 1: //baker
                entity.setHeldItem(EnumHand.MAIN_HAND,new ItemStack(Items.BREAD));
                break;
            case 2: //blacksmith
                entity.setHeldItem(EnumHand.MAIN_HAND,new ItemStack(Blocks.ANVIL));
                break;
            case 3: //goldsmith
                entity.setHeldItem(EnumHand.MAIN_HAND,new ItemStack(Items.GOLD_INGOT));
                break;
            case 4: //builder
                entity.setHeldItem(EnumHand.MAIN_HAND,new ItemStack(Blocks.STONE_BRICK_STAIRS));
                break;
        }
    }
    public static void setCitizenHouse(EntityCitizenPassive entity, BlockPos blockPos, boolean mirror)
    {
        //requires the position that the generator would use (least positive x and z corner)
        ItemStack item = entity.getHeldItem(EnumHand.MAIN_HAND);
        if(!item.hasTagCompound())
        {
            item.setTagCompound(new NBTTagCompound());
        }
        NBTTagCompound tags = item.getTagCompound();
        tags.setBoolean("mirror",mirror);
        tags.setInteger("x",blockPos.getX());
        tags.setInteger("y",blockPos.getY());
        tags.setInteger("z",blockPos.getZ());
    }
}
