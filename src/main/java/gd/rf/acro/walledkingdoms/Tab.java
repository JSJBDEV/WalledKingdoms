package gd.rf.acro.walledkingdoms;

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
        return new ItemStack(Blocks.STONE_BRICK_STAIRS);
    }
}
