package gd.rf.acro.walledkingdoms.Politics;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDesert;
import net.minecraft.world.biome.BiomePlains;
import net.minecraft.world.biome.BiomeSavanna;
import net.minecraft.world.biome.BiomeSnow;
import net.minecraftforge.common.DimensionManager;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static gd.rf.acro.walledkingdoms.Utils.readLines;

public class Politics {
    public static final String[] types = {"Republic of","Kingdom of","Federation of","Demarchy of"};
    public static final String[] residency = {"application","investment","time","employment"};
    public static final String[] revocable = {"no","crimes","minister"};
    public static final String[] hgoods = {"residents","free trade","merchants"};
    public static final String[] lgoods = {"residents","free trade","state rationing"};
    public static final String[] auctions = {"public","residents","private"};
    public static final String[] land = {"application","government","auction"};
    public static final String[] gates = {"Open","Closed","Mercantile"};
    public static final String[] guards = {"lax","reasonable","thorough"};
    public static final String[] punishments = {"confiscation","banishment","revocation","enemy"};
    public static List<String> genImportantInformation(World world)
    {
        List<String> info = new ArrayList<>();

        //basic information

        info.add(types[RandomUtils.nextInt(0,types.length-1)]); //Government type

        info.add(genName(4)); //kingdom name
        info.add("0"); //cultural style

        boolean isAcceptableBiome = false;
        int x=0;
        int z=0;
        while (!isAcceptableBiome)
        {
            x = RandomUtils.nextInt(0,20001)-10000;
            z = RandomUtils.nextInt(0,20001)-10000;
            if(world.getBiome(new BlockPos(x,100,z)) instanceof BiomePlains || world.getBiome(new BlockPos(x,100,z)) instanceof BiomeDesert || world.getBiome(new BlockPos(x,100,z)) instanceof BiomeSavanna || world.getBiome(new BlockPos(x,100,z)) instanceof BiomeSnow)
            {
                isAcceptableBiome = true;
            }
        }
        info.add(""+x);
        info.add(""+z);

        //actual politics
        info.add(residency[RandomUtils.nextInt(0,residency.length-1)]); //residency type
        info.add(revocable[RandomUtils.nextInt(0,revocable.length-1)]); //is residency revocable
        info.add(RandomUtils.nextInt(5,50)+""); //length of stay without residency
        info.add(hgoods[RandomUtils.nextInt(0,hgoods.length-1)]); //who can buy high value goods
        info.add(lgoods[RandomUtils.nextInt(0,lgoods.length-1)]); //who can buy low value goods
        info.add(""); //trade routes
        info.add(""); //routes embargo'd
        info.add(auctions[RandomUtils.nextInt(0,auctions.length-1)]); //how auctions are partaken
        info.add(land[RandomUtils.nextInt(0,land.length-1)]); //how is land assigned
        info.add(gates[RandomUtils.nextInt(0,gates.length-1)]); //are the city gates open
        info.add(guards[RandomUtils.nextInt(0,guards.length-1)]); //how frequently do guards check papers

        info.add(""+RandomUtils.nextInt(0,64)); //residency tax
        info.add(""+RandomUtils.nextInt(0,101)); //low value tax as a %
        info.add(""+RandomUtils.nextInt(0,101)); //high value tax as a %

        info.add(punishments[RandomUtils.nextInt(0,punishments.length-1)]); //no-permit
        info.add(punishments[RandomUtils.nextInt(0,punishments.length-1)]); //vandalism
        info.add(punishments[RandomUtils.nextInt(0,punishments.length-1)]); //assault
        info.add(punishments[RandomUtils.nextInt(0,punishments.length-1)]); //murder
        info.add(punishments[RandomUtils.nextInt(0,punishments.length-1)]); //theft

        /*
          0 - type of country
          1 - country name
          2 - cultural style

          3 - residency type
          4 - revocable residency
          5 - stay without residency
          6 - high value goods
          7 - low value goods
          8 - trade routes
          9 - embargoed routes
          10 - auction style
          11 - land assignment style
          12 - gate state
          13 - guard style
          14 - residency tax
          15 - low value tax
          16 - high value tax

          17 - crime: no permit
          18 - crime: vandalism
          19 - crime: assault
          20 - crime: murder
          21 - crime: theft
         */








        return info;
    }

    public static String genName(int length)
    {
        String[] consonants = {"b","c","d","f","g","h","j","k","l","m","n","p","r","s","t","v","z"};
        String[] vowels = {"a","e","i","o","u","ia","oo"};
        String name = "";
        for (int i = 0; i < length; i++)
        {
            name = name + consonants[RandomUtils.nextInt(0,consonants.length-1)];
            if(i==0){name=name.toUpperCase();}
            name = name + vowels[RandomUtils.nextInt(0,vowels.length-1)];

        }
        return name;
    }

    public static ItemStack getPriceWithTax(int emeralds,int kingdomNo,boolean isHighValue)
    {
        String pref = DimensionManager.getCurrentSaveRootDirectory() + "/WalledKingdoms/"+kingdomNo+"/";
        List<String> politics = readLines(pref+"politics.wk");
        if(isHighValue)
        {
            return new ItemStack(Items.EMERALD,(emeralds+(RandomUtils.nextInt(0,11)-5)+Integer.parseInt(politics.get(16))));
            //base amount +- Sellers margins + VAT (- social status)
        }
        else
        {
            return new ItemStack(Items.EMERALD,(emeralds+RandomUtils.nextInt(0,5)+Integer.parseInt(politics.get(15))));
        }
    }



}
