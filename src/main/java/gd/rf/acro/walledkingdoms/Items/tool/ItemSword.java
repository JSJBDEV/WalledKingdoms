package gd.rf.acro.walledkingdoms.Items.tool;

import gd.rf.acro.walledkingdoms.WalledKingdoms;
import net.minecraft.item.Item;

public class ItemSword extends net.minecraft.item.ItemSword {
    private String name;

    public ItemSword(ToolMaterial material, String name) {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);
        this.name=name;
        setCreativeTab(WalledKingdoms.tab);
    }

    public void registerItemModel() {
        WalledKingdoms.proxy.registerItemRenderer(this, 0, name);
    }

}
