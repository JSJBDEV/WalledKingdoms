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
        info.add("Republic of"); //Government type
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
