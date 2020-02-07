package gd.rf.acro.walledkingdoms.Items;

import gd.rf.acro.walledkingdoms.WalledKingdoms;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ItemArmour extends ItemArmor {
    private String name;

    public ItemArmour(ArmorMaterial material, EntityEquipmentSlot slot, String name) {
        super(material, 0, slot);
        setRegistryName(name);
        setUnlocalizedName(name);
        this.name = name;
        setCreativeTab(WalledKingdoms.tab);
    }

    public void registerItemModel() {
        WalledKingdoms.proxy.registerItemRenderer(this, 0, name);
    }
}
