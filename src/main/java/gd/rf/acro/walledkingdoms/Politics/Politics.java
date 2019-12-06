package gd.rf.acro.walledkingdoms.Politics;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDesert;
import net.minecraft.world.biome.BiomePlains;
import net.minecraft.world.biome.BiomeSavanna;
import net.minecraft.world.biome.BiomeSnow;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Politics {

    public static List<String> genImportantInformation(World world)
    {
        List<String> info = new ArrayList<>();

        //basic information
        String[] types = {"Republic of","Kingdom of","Federation of","Demarchy of"};
        info.add(types[RandomUtils.nextInt(0,types.length-1)]); //Government type

        info.add(genName(4)); //kingdom name
        info.add("0"); //cultural style

        //actual politics
        String[] residency = {"application","investment","time","employment"};
        info.add(residency[RandomUtils.nextInt(0,residency.length-1)]); //residency type

        String[] revocable = {"no","crimes","minister"};
        info.add(revocable[RandomUtils.nextInt(0,revocable.length-1)]); //is residency revocable

        info.add(RandomUtils.nextInt(5,50)+""); //length of stay without residency

        String[] hgoods = {"residents","free trade","merchants"};
        info.add(hgoods[RandomUtils.nextInt(0,hgoods.length-1)]); //who can buy high value goods

        String[] lgoods = {"residents","free trade","state rationing"};
        info.add(lgoods[RandomUtils.nextInt(0,lgoods.length-1)]); //who can buy low value goods

        info.add(""); //trade routes

        info.add(""); //routes embargo'd

        String[] auctions = {"public","residents","private"};
        info.add(auctions[RandomUtils.nextInt(0,auctions.length-1)]); //how auctions are partaken

        String[] land = {"application","government","auction"};
        info.add(land[RandomUtils.nextInt(0,land.length-1)]); //how is land assigned

        String[] gates = {"Open","Closed","Mercantile"};
        info.add(gates[RandomUtils.nextInt(0,gates.length-1)]); //are the city gates open

        String[] guards = {"lax","reasonable","thorough"};
        info.add(guards[RandomUtils.nextInt(0,guards.length-1)]); //how frequently do guards check papers

        info.add(""+RandomUtils.nextInt(0,64)); //residency tax
        info.add(""+RandomUtils.nextInt(0,101)); //low value tax as a %
        info.add(""+RandomUtils.nextInt(0,101)); //high value tax as a %

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



}
