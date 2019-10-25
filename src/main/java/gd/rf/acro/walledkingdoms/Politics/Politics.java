package gd.rf.acro.walledkingdoms.Politics;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Politics {

    public static List<String> genImportantInformation()
    {
        List<String> info = new ArrayList<>();
        info.add("Republic of"); //Government type
        info.add(genName(4)); //kingdom name
        info.add("0"); //cultural style
        info.add(RandomUtils.nextInt(-10000,10001)+","+RandomUtils.nextInt(-10000,10001)+","+RandomUtils.nextInt(-10000,10001));


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
