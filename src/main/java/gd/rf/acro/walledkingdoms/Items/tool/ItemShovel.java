package gd.rf.acro.walledkingdoms.Items.tool;

import gd.rf.acro.walledkingdoms.WalledKingdoms;
import net.minecraft.item.ItemSpade;

public class ItemShovel extends ItemSpade {
    private String name;

    public ItemShovel(ToolMaterial material, String name) {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);
        this.name = name;
    }

    public void registerItemModel() {
        WalledKingdoms.proxy.registerItemRenderer(this, 0, name);
    }
}
