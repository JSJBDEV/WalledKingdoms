package gd.rf.acro.walledkingdoms;

import gd.rf.acro.walledkingdoms.Blocks.ModBlocks;
import gd.rf.acro.walledkingdoms.Citizens.ModEntities;
import gd.rf.acro.walledkingdoms.Items.ModItems;
import gd.rf.acro.walledkingdoms.Items.ModRecipes;
import gd.rf.acro.walledkingdoms.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = WalledKingdoms.MODID, name = WalledKingdoms.NAME, version = WalledKingdoms.VERSION)
public class WalledKingdoms
{
    public static final String MODID = "walledkingdoms";
    public static final String NAME = "Walled Kingdoms";
    public static final Tab tab = new Tab();
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        System.out.println("resas");
        MinecraftForge.EVENT_BUS.register(Generator.class);
        ModEntities.init();
        ModEntities.initModels();

    }
    @Mod.Instance
    public static WalledKingdoms instance;

    @SidedProxy(serverSide = "gd.rf.acro.walledkingdoms.proxy.CommonProxy", clientSide = "gd.rf.acro.walledkingdoms.proxy.ClientProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());

        // TickEvents are on the FML bus:
        FMLCommonHandler.instance().bus().register(new gd.rf.acro.walledkingdoms.Items.ItemTrinketTick());

        ModRecipes.init();
    }

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            ModItems.register(event.getRegistry());
            //Recipes.init();
            ModBlocks.registerItemBlocks(event.getRegistry());
        }
        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            ModBlocks.register(event.getRegistry());

        }

        @SubscribeEvent
        public static void registerItems(ModelRegistryEvent event) {
            ModItems.registerModels();
            ModBlocks.registerModels();


        }



    }
}
