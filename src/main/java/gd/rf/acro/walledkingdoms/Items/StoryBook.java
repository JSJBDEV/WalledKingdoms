package gd.rf.acro.walledkingdoms.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class StoryBook extends ItemBase {
    public StoryBook(String name) {
        super(name);
    }

    @Override
    public ItemBase setCreativeTab(CreativeTabs tab) {
        return this;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {

        return super.onItemRightClick(world,player,hand);
    }
}
