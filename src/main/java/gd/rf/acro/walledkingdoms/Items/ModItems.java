package gd.rf.acro.walledkingdoms.Items;

import gd.rf.acro.walledkingdoms.WalledKingdoms;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

/**
 * Created by Acro on 15/08/2018.
 */
public class ModItems {
    public static ItemBase mineCharm = new ItemBase("mine_charm").setCreativeTab(WalledKingdoms.tab);
    public static StoryBook story = new StoryBook("story").setCreativeTab(WalledKingdoms.tab);
    public  static ItemBow bow = new ItemBow("bow");
    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
            mineCharm,story,bow


        );
    }

    public static void registerModels() {
        mineCharm.registerItemModel();
        story.registerItemModel();
        bow.registerItemModel();
    }
}
