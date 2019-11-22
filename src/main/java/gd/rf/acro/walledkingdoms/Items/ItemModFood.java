package gd.rf.acro.walledkingdoms.Items;

import gd.rf.acro.walledkingdoms.WalledKingdoms;
import net.minecraft.item.ItemFood;

public class ItemModFood extends ItemFood {
    private String name;
    public ItemModFood(String name, int hunger, float saturation, boolean isWolfFood) {
        super(hunger, saturation, isWolfFood);
        this.name=name;
        setUnlocalizedName(name);
        setRegistryName(name);
    }

    public void registerItemModel() {WalledKingdoms.proxy.registerItemRenderer(this, 0, name); }

}
