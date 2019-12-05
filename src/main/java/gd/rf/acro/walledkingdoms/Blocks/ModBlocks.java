package gd.rf.acro.walledkingdoms.Blocks;

import gd.rf.acro.walledkingdoms.WalledKingdoms;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

/**
 * Created by Acro on 13/08/2018.
 */
public class ModBlocks {
    public static BlockBase bricks = new BlockBase(Material.ROCK,"stone_brick").setCreativeTab(WalledKingdoms.tab);
    public static MapPainter painter = new MapPainter(Material.ROCK,"painter").setCreativeTab(WalledKingdoms.tab);
    public static BlockWorkTable worktable = new BlockWorkTable(Material.ROCK,"worktable");


    public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(
                bricks,
                painter,
                worktable




        );

    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        registry.registerAll(
                bricks.createItemBlock(),
                painter.createItemBlock(),
                worktable.createItemBlock()





        );

    }

    public static void registerModels() {
        bricks.registerItemModel(Item.getItemFromBlock(bricks));
        painter.registerItemModel(Item.getItemFromBlock(painter));
        worktable.registerItemModel(Item.getItemFromBlock(painter));


    }
}
