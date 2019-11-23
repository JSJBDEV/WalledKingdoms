package gd.rf.acro.walledkingdoms.Dominion;

import gd.rf.acro.walledkingdoms.Utils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.village.Village;
import net.minecraft.world.World;

public class Dominion {
    //dominion refers to structures outside the walls of a kingdom, these can be custom generated but also include normal minecraft villages


    public static void makeVillageCensus(World world, BlockPos pos, EntityPlayer player) {

        if(!world.isRemote)
        {
            Village village = world.getVillageCollection().getNearestVillage(pos, 50);
            BlockPos center = village.getCenter();
            int villagerCount = village.getNumVillagers();
            int playerReputation = village.getPlayerReputation(player.getPersistentID());
            int villageRadius = village.getVillageRadius();
            player.setHeldItem(EnumHand.OFF_HAND,Utils.createBook(
                    player.getName(),
                    "Info on the village at " + center.getX() + "," + center.getZ(),
                    "Village Center: " + center,
                    "Number of Villagers: " + villagerCount,
                    "Village Radius: " + villageRadius,
                    "Player Reputation: " + playerReputation));
        }

    }
}
