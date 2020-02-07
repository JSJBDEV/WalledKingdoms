package gd.rf.acro.walledkingdoms.Items.tool;

import gd.rf.acro.walledkingdoms.WalledKingdoms;

public class ItemHoe extends net.minecraft.item.ItemHoe {
    private String name;

    public ItemHoe(ToolMaterial material, String name) {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);
        this.name = name;
        setCreativeTab(WalledKingdoms.tab);
    }

    public void registerItemModel() {
        WalledKingdoms.proxy.registerItemRenderer(this, 0, name);
    }
}
