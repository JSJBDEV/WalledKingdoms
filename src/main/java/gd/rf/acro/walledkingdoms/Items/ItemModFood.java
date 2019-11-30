package gd.rf.acro.walledkingdoms.Items;

import gd.rf.acro.walledkingdoms.WalledKingdoms;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.PotionEffect;

public class ItemModFood extends ItemFood {
    private String name;
    public ItemModFood(String name, int hunger, float saturation, boolean isWolfFood) {
        super(hunger, saturation, isWolfFood);
        this.name=name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(WalledKingdoms.tab);
    }


    public ItemModFood(String name, int hunger, float saturation, boolean isWolfFood, PotionEffect effect, float probability) {
        super(hunger, saturation, isWolfFood);
        super.setPotionEffect(effect, probability);
        this.name=name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(WalledKingdoms.tab);
    }

    public void registerItemModel() {WalledKingdoms.proxy.registerItemRenderer(this, 0, name); }

}
