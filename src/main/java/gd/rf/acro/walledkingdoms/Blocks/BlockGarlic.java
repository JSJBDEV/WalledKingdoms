package gd.rf.acro.walledkingdoms.Blocks;

import gd.rf.acro.walledkingdoms.Items.ModItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class BlockGarlic extends BlockCrops {
    protected String name;

    public BlockGarlic(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
    }

    @Override
    protected Item getSeed() {
        return ModItems.garlic;
    }

    @Override
    protected Item getCrop() {
        return ModItems.garlic;
    }


}
