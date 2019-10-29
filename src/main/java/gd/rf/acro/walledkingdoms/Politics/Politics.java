package gd.rf.acro.walledkingdoms.Politics;

import net.minecraft.world.World;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Politics {

    public static List<String> genImportantInformation(World world)
    {
        List<String> info = new ArrayList<>();
        info.add("Republic of"); //Government type
        info.add(genName(4)); //kingdom name
        info.add("0"); //cultural style
        info.add(""+(RandomUtils.nextInt(0,20001)-10000)); //x
        info.add(""+(RandomUtils.nextInt(0,20001)-10000)); //z


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
            name = name + vowels[RandomUtils.nextInt(0,vowels.length-1)];

        }
        return name;
    }

}
