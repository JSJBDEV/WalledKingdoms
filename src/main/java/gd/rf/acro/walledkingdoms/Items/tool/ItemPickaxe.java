package gd.rf.acro.walledkingdoms.Items.tool;

import gd.rf.acro.walledkingdoms.WalledKingdoms;

public class ItemPickaxe extends net.minecraft.item.ItemPickaxe {
    private String name;

    public ItemPickaxe(ToolMaterial material, String name) {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);
        this.name = name;
    }

    public void registerItemModel() {
        WalledKingdoms.proxy.registerItemRenderer(this, 0, name);
    }
}
