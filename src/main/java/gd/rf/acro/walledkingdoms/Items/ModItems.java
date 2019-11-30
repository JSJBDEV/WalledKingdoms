package gd.rf.acro.walledkingdoms.Items;

import gd.rf.acro.walledkingdoms.WalledKingdoms;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.registries.IForgeRegistry;

/**
 * Created by Acro on 15/08/2018.
 */
public class ModItems {
    //Potion Effect setup for 15 seconds of hunger I
    private static PotionEffect hunger15s = new PotionEffect(MobEffects.HUNGER, 300);

    public static ItemBase mineCharm = new ItemBase("mine_charm");
    public static StoryBook story = new StoryBook("story");
    public static ItemBow bow = new ItemBow("bow");
    public static ItemDebug debug = new ItemDebug("debug");

    //Carcass Items for butcher
    public static ItemBase carcassCow = new ItemBase("carcass_cow");
    public static ItemBase carcassPig = new ItemBase("carcass_pig");
    public static ItemBase carcassSheep = new ItemBase("carcass_sheep");
    public static ItemBase carcassChicken = new ItemBase("carcass_chicken");
    public static ItemBase carcassHorse = new ItemBase("carcass_horse");
    public static ItemBase carcassRabbit = new ItemBase("carcass_rabbit");
    public static ItemBase carcassSquid = new ItemBase("carcass_squid");
    public static ItemBase carcassDonkey = new ItemBase("carcass_donkey");
    public static ItemBase animalFat = new ItemBase("animal_fat");

    //Meats for butcher
    public static ItemModFood chickenDrumstick = new ItemModFood("chicken_drumstick", 2, 0.3f, true, hunger15s, 0.4f);
    public static ItemModFood chickenWing = new ItemModFood("chicken_wing", 1, 0.2f, true, hunger15s, 0.4f);
    public static ItemModFood chickenBreast = new ItemModFood("chicken_breast", 2, 0.4f, true, hunger15s, 0.4f);

    public static ItemLevelableTool butchersKnife = new ItemLevelableTool("butchers_knife");

    //Food Items for Baker
    public static ItemBase flourWheat = new ItemBase("flour_wheat");
    public static ItemModFood stewBeef = new ItemModFood("stew_beef",8,13.0f ,false);
    public static ItemModFood pancakes = new ItemModFood("pancakes",4,2.0f ,false);

    //Items for clockmaker
    public static ItemLevelableTool clockmakersTools = new ItemLevelableTool("clockmakers_tools");

    //Items for Blacksmith
    public static ItemLevelableTool smithsHammer = new ItemLevelableTool("smiths_hammer");

    //Vanity items for goldsmith/silversmith
    public static ItemBase ringGold = new ItemBase("ring_gold");
    public static ItemBase ringEmerald = new ItemBase("ring_emerald");
    public static ItemBase ringDiamond = new ItemBase("ring_diamond");
    public static ItemBase ringEnder = new ItemBase("ring_enderpearl");
    public static ItemBase ceremonialBlade = new ItemBase("ceremonial_blade");
    public static ItemBase candlestick = new ItemBase("candlestick");
    public static ItemBase plateGold = new ItemBase("plate_gold");
    public static ItemBase plateSilver = new ItemBase("plate_silver");
    public static ItemBase chaliceGold = new ItemBase("chalice_gold");
    public static ItemBase chaliceSilver = new ItemBase("chalice_silver");
    public static ItemLevelableTool goldsmith = new ItemLevelableTool("goldsmith");
    public static ItemBase ringbase = new ItemBase("ring_base");

    //Trinket Items
    public static ItemTrinket circletEnder = new ItemTrinket("circlet_enderpearl");

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
            mineCharm,story,bow,debug,

            //Carcass Items for Butcher
            carcassChicken, carcassCow,carcassHorse, carcassPig, carcassRabbit, carcassSheep, carcassSquid, carcassDonkey,
            animalFat,

            //Meat Items for Butcher
            chickenBreast, chickenDrumstick, chickenWing,

            butchersKnife,

            //Food Items for Baker
            flourWheat, stewBeef, pancakes,

            //Items for Clockmaker
            clockmakersTools,

            //Items for Blacksmith
            smithsHammer,

            //Vanity items for goldsmith/silversmith
            ringGold,ringEmerald,ringDiamond,ringEnder,ceremonialBlade,candlestick,plateGold,plateSilver,chaliceGold,
            chaliceSilver,goldsmith,ringbase,

            //Trinket Items
            circletEnder


        );
    }

    public static void registerModels() {
        mineCharm.registerItemModel();
        story.registerItemModel();
        bow.registerItemModel();
        debug.registerItemModel();

        //Carcass Items for Butcher
        carcassChicken.registerItemModel();
        carcassCow.registerItemModel();
        carcassHorse.registerItemModel();
        carcassPig.registerItemModel();
        carcassRabbit.registerItemModel();
        carcassSheep.registerItemModel();
        carcassSquid.registerItemModel();
        carcassDonkey.registerItemModel();
        animalFat.registerItemModel();

        chickenBreast.registerItemModel();
        chickenDrumstick.registerItemModel();
        chickenWing.registerItemModel();

        butchersKnife.registerItemModel();

        //Food Items for Baker
        flourWheat.registerItemModel();
        stewBeef.registerItemModel();
        pancakes.registerItemModel();

        //Items for clockmaker
        clockmakersTools.registerItemModel();

        //Items for blacksmith
        smithsHammer.registerItemModel();

        //Vanity items for goldsmith/silversmith
        ringGold.registerItemModel();
        ringEmerald.registerItemModel();
        ringDiamond.registerItemModel();
        ringEnder.registerItemModel();
        ceremonialBlade.registerItemModel();
        candlestick.registerItemModel();
        plateGold.registerItemModel();
        plateSilver.registerItemModel();
        chaliceGold.registerItemModel();
        chaliceSilver.registerItemModel();
        goldsmith.registerItemModel();
        ringbase.registerItemModel();

        //Trinket Items
        circletEnder.registerItemModel();
    }
}
