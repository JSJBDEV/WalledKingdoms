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
    private static PotionEffect poison10s = new PotionEffect(MobEffects.POISON, 200);

    public static ItemBase mineCharm = new ItemBase("mine_charm");
    public static StoryBook story = new StoryBook("story");
    public static ItemBow bow = new ItemBow("bow");
    public static ItemDebug debug = new ItemDebug("debug");

    //Carcass Items
    public static ItemBase carcassCow = new ItemBase("carcass_cow");
    public static ItemBase carcassPig = new ItemBase("carcass_pig");
    public static ItemBase carcassSheep = new ItemBase("carcass_sheep");
    public static ItemBase carcassChicken = new ItemBase("carcass_chicken");
    public static ItemBase carcassHorse = new ItemBase("carcass_horse");
    public static ItemBase carcassRabbit = new ItemBase("carcass_rabbit");
    public static ItemBase carcassSquid = new ItemBase("carcass_squid");
    public static ItemBase carcassDonkey = new ItemBase("carcass_donkey");
    public static ItemBase animalFat = new ItemBase("animal_fat");

    //Items for butcher
    public static ItemLevelableTool butchersKnife = new ItemLevelableTool("butchers_knife");
    public static ItemModFood chickenDrumstick = new ItemModFood("chicken_drumstick", 2, 0.3f, true, hunger15s, 0.5f);
    public static ItemModFood chickenWing = new ItemModFood("chicken_wing", 1, 0.2f, true, hunger15s, 0.5f);
    public static ItemModFood chickenBreast = new ItemModFood("chicken_breast", 2, 0.4f, true, hunger15s, 0.5f);
    public static ItemModFood beefMince = new ItemModFood("beef_mince", 3, 0.4f, true, hunger15s, 0.4f);
    public static ItemModFood lambMince = new ItemModFood("lamb_mince", 3, 0.4f, true, hunger15s, 0.4f);
    public static ItemModFood porkMince = new ItemModFood("pork_mince", 3, 0.4f, true, hunger15s, 0.4f);
    public static ItemModFood horseSteak = new ItemModFood("horse_steak", 3, 1.8f, true, hunger15s, 0.4f);
    public static ItemModFood tongue = new ItemModFood("tongue", 2, 0.2f, true, hunger15s, 0.4f);
    public static ItemModFood ham = new ItemModFood("ham", 3, 2.1f, true, hunger15s, 0.4f);
    public static ItemModFood calamari = new ItemModFood("calamari", 2, 0.4f, false, poison10s, 0.3f);

    //Items for Baker
    public static ItemLevelableTool bakingUtensils = new ItemLevelableTool("baking_utensils");
    public static ItemLevelableTool grindStone = new ItemLevelableTool("grind_stone");
    public static ItemLevelableTool smokingRack = new ItemLevelableTool("smoking_rack");
    public static ItemBase flourWheat = new ItemBase("flour_wheat");
    public static ItemBase flourRice = new ItemBase("flour_rice");
    public static ItemBase riceRaw = new ItemBase("rice_raw");
    public static ItemBase dough = new ItemBase("dough");
    public static ItemModFood stewBeef = new ItemModFood("stew_beef",8,13.0f ,false);
    public static ItemModFood pancakes = new ItemModFood("pancakes",4,2.0f ,false);
    public static ItemModFood chickenDrumstickCooked = new ItemModFood("chicken_drumstick_cooked", 4, 5.2f, true);
    public static ItemModFood chickenWingCooked = new ItemModFood("chicken_wing_cooked", 3, 5.0f, true);
    public static ItemModFood chickenBreastCooked = new ItemModFood("chicken_breast_cooked", 5, 6.0f, true);
    public static ItemModFood riceCooked = new ItemModFood("rice_cooked", 5, 7.0f, false);
    public static ItemModFood horseSteakCooked = new ItemModFood("horse_steak_cooked", 7, 12.0f, true);
    public static ItemModFood tongueCooked = new ItemModFood("tongue_cooked", 4, 4.8f, true);
    public static ItemModFood hamSmoked = new ItemModFood("ham_smoked", 6, 9.0f, false);
    public static ItemModFood fishSmoked = new ItemModFood("fish_smoked", 5, 4, false);

    //Items for clockmaker
    public static ItemLevelableTool clockmakersTools = new ItemLevelableTool("clockmakers_tools");

    //Items for Blacksmith
    public static ItemLevelableTool smithsHammer = new ItemLevelableTool("smiths_hammer");

    //Items for goldsmith/silversmith
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

            //Carcass Items
            carcassChicken, carcassCow,carcassHorse, carcassPig, carcassRabbit, carcassSheep, carcassSquid, carcassDonkey,
            animalFat,

            //Items for Butcher
            butchersKnife,
            chickenBreast, chickenDrumstick, chickenWing,
            beefMince, lambMince, porkMince,
            horseSteak, tongue, ham, calamari,

            //Items for Baker
            bakingUtensils, grindStone, smokingRack,
            flourWheat, stewBeef, pancakes, dough, riceRaw, flourRice, riceCooked, chickenBreastCooked, chickenWingCooked,
            chickenDrumstickCooked, horseSteakCooked, tongueCooked, hamSmoked, fishSmoked,

            //Items for Clockmaker
            clockmakersTools,

            //Items for Blacksmith
            smithsHammer,

            //Vanity items for goldsmith/silversmith
            goldsmith,
            ringGold,ringEmerald,ringDiamond,ringEnder,ringbase,
            ceremonialBlade,candlestick,
            plateGold,plateSilver,chaliceGold,
            chaliceSilver,

            //Trinket Items
            circletEnder


        );
    }

    public static void registerModels() {
        mineCharm.registerItemModel();
        story.registerItemModel();
        bow.registerItemModel();
        debug.registerItemModel();

        //Carcass Items
        carcassChicken.registerItemModel();
        carcassCow.registerItemModel();
        carcassHorse.registerItemModel();
        carcassPig.registerItemModel();
        carcassRabbit.registerItemModel();
        carcassSheep.registerItemModel();
        carcassSquid.registerItemModel();
        carcassDonkey.registerItemModel();
        animalFat.registerItemModel();

        //Items for Butcher
        butchersKnife.registerItemModel();
        chickenBreast.registerItemModel();
        chickenDrumstick.registerItemModel();
        chickenWing.registerItemModel();
        beefMince.registerItemModel();
        lambMince.registerItemModel();
        porkMince.registerItemModel();
        horseSteak.registerItemModel();
        tongue.registerItemModel();
        ham.registerItemModel();
        calamari.registerItemModel();

        //Items for Baker
        bakingUtensils.registerItemModel();
        grindStone.registerItemModel();
        smokingRack.registerItemModel();
        flourWheat.registerItemModel();
        stewBeef.registerItemModel();
        pancakes.registerItemModel();
        dough.registerItemModel();
        riceRaw.registerItemModel();
        riceCooked.registerItemModel();
        flourRice.registerItemModel();
        chickenBreastCooked.registerItemModel();
        chickenDrumstickCooked.registerItemModel();
        chickenWingCooked.registerItemModel();
        horseSteakCooked.registerItemModel();
        tongueCooked.registerItemModel();
        hamSmoked.registerItemModel();
        fishSmoked.registerItemModel();

        //Items for clockmaker
        clockmakersTools.registerItemModel();

        //Items for blacksmith
        smithsHammer.registerItemModel();

        //Items for goldsmith/silversmith
        goldsmith.registerItemModel();
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
        ringbase.registerItemModel();

        //Trinket Items
        circletEnder.registerItemModel();
    }
}
