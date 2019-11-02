package gd.rf.acro.walledkingdoms;

import gd.rf.acro.walledkingdoms.Blocks.ModBlocks;
import gd.rf.acro.walledkingdoms.Items.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

/**
 * Created by Acro on 20/02/2018.
 */
public class Tab extends CreativeTabs {
    public Tab() {
        super(WalledKingdoms.MODID);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModItems.story);
    }
}
