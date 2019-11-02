package gd.rf.acro.walledkingdoms.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

import java.util.List;

import static gd.rf.acro.walledkingdoms.Generator.createKingdom;
import static gd.rf.acro.walledkingdoms.Utils.readLines;

public class StoryBook extends ItemBase {
    public StoryBook(String name) {
        super(name);
    }

    @Override
    public StoryBook setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        if(!world.isRemote)
        {
            if (!player.getHeldItem(hand).hasTagCompound()) {
                NBTTagCompound tags = new NBTTagCompound();
                Scoreboard scoreboard = world.getScoreboard();
                tags.setInteger("kingdom", scoreboard.getOrCreateScore("world", scoreboard.getObjective("WK_KingdomsInit")).getScorePoints());
                scoreboard.getOrCreateScore("world", scoreboard.getObjective("WK_KingdomsInit")).incrementScore();
                player.getHeldItem(hand).setTagCompound(tags);
            }

            String pref = DimensionManager.getCurrentSaveRootDirectory() + "/WalledKingdoms/" + player.getHeldItem(hand).getTagCompound().getInteger("kingdom") + "/";
            List<String> info = readLines(pref + "politics.wk");

            if (player.getDistanceSq(Integer.parseInt(info.get(3)), player.posY, Integer.parseInt(info.get(4))) < 50) {
                createKingdom(world, 0, player);
                player.setHeldItem(hand,new ItemStack(Items.WRITABLE_BOOK));
            } else {
                for (String piece : info) {
                    player.sendMessage(new TextComponentString(piece));
                }

                player.sendMessage(new TextComponentString("HINT: move closer to the above coordinates to locate the city, then right click this again!"));
            }

        }


        return super.onItemRightClick(world,player,hand);
    }
}
