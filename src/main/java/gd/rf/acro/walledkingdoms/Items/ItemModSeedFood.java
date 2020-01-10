package gd.rf.acro.walledkingdoms.Items;

import gd.rf.acro.walledkingdoms.WalledKingdoms;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.potion.PotionEffect;

public class ItemModSeedFood extends ItemSeedFood {
    private String name;
    public ItemModSeedFood(String name, int hunger, float saturation, Block cropBlock, Block soil) {
        super(hunger, saturation, cropBlock, soil);
        this.name=name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(WalledKingdoms.tab);
    }


    public ItemModSeedFood(String name, int hunger, float saturation, Block cropBlock, Block soil, PotionEffect effect, float probability) {
        super(hunger, saturation, cropBlock, soil);
        super.setPotionEffect(effect, probability);
        this.name=name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(WalledKingdoms.tab);
    }

    public void registerItemModel() {WalledKingdoms.proxy.registerItemRenderer(this, 0, name); }

}
