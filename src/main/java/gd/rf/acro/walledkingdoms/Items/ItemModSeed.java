package gd.rf.acro.walledkingdoms.Items;

import gd.rf.acro.walledkingdoms.WalledKingdoms;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSeeds;

public class ItemModSeed extends ItemSeeds {
    protected String name;

    public ItemModSeed(String name, Block cropBlock, Block soil) {
        super(cropBlock, soil);
        this.name=name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(WalledKingdoms.tab);
    }

    public void registerItemModel() {
        WalledKingdoms.proxy.registerItemRenderer(this, 0, name);
    }
}
