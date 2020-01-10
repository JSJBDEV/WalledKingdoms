package gd.rf.acro.walledkingdoms.Blocks;

import gd.rf.acro.walledkingdoms.Items.ModItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class BlockOnion extends BlockCrops {
    protected String name;

    public BlockOnion(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
    }

    @Override
    protected Item getSeed() {
        return ModItems.onion;
    }

    @Override
    protected Item getCrop() {
        return ModItems.onion;
    }


}
