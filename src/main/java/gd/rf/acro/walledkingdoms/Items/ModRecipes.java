package gd.rf.acro.walledkingdoms.Items;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
    public static void init() {
        GameRegistry.addSmelting(ModItems.chickenBreast, new ItemStack(ModItems.chickenBreastCooked), 0.25f);
        GameRegistry.addSmelting(ModItems.chickenDrumstick, new ItemStack(ModItems.chickenDrumstickCooked), 0.25f);
        GameRegistry.addSmelting(ModItems.chickenWing, new ItemStack(ModItems.chickenWingCooked), 0.25f);
        GameRegistry.addSmelting(ModItems.dough, new ItemStack(Items.BREAD), 0.20f);
        GameRegistry.addSmelting(ModItems.riceRaw, new ItemStack(ModItems.riceCooked), 0.20f);
        GameRegistry.addSmelting(ModItems.horseSteak, new ItemStack(ModItems.horseSteakCooked), 0.25f);
        GameRegistry.addSmelting(ModItems.tongue, new ItemStack(ModItems.tongueCooked), 0.25f);
    }
}
