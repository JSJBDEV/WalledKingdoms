package gd.rf.acro.walledkingdoms.Items.tool;

import gd.rf.acro.walledkingdoms.WalledKingdoms;

public class ItemAxe extends net.minecraft.item.ItemAxe {
    private String name;

    public ItemAxe(ToolMaterial material, String name) {
        super(material, 8f, -3.1f);
        setRegistryName(name);
        setUnlocalizedName(name);
        this.name = name;
        setCreativeTab(WalledKingdoms.tab);
    }

    public void registerItemModel() {
        WalledKingdoms.proxy.registerItemRenderer(this, 0, name);
    }
}
