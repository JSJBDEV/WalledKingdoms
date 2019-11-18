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
    public static ItemDebug debug = new ItemDebug("debug");

    //Vanity items for goldsmith/silversmith
    public static ItemBase ringGold = new ItemBase("ring_gold");
    public static ItemBase ringEmerald = new ItemBase("ring_emerald");
    public static ItemBase ringDiamond = new ItemBase("ring_diamond");
    public static ItemBase ringEnder = new ItemBase("ring_enderpearl");

    public static ItemTrinket circletEnder = new ItemTrinket("circlet_enderpearl");

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
            mineCharm,story,bow,debug,

            //Vanity items for goldsmith/silversmith
            ringGold,ringEmerald,ringDiamond,ringEnder

            ,circletEnder


        );
    }

    public static void registerModels() {
        mineCharm.registerItemModel();
        story.registerItemModel();
        bow.registerItemModel();
        debug.registerItemModel();

        //Vanity items for goldsmith/silversmith
        ringGold.registerItemModel();
        ringEmerald.registerItemModel();
        ringDiamond.registerItemModel();
        ringEnder.registerItemModel();

        circletEnder.registerItemModel();
    }
}
