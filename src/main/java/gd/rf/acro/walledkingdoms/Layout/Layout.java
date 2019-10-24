package gd.rf.acro.walledkingdoms.Layout;

import net.minecraft.world.World;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Layout {

    public static List<String> genLayoutFromSeed(World world,int length,int style)
    {
        long seed = world.getSeed();
        List<String> csvLayout = new ArrayList<>();

        for (int i = 1; i<length; i++)
        {
            String row = "";
            for (int j = 1; j<length; j++)
            {
                row=row+pickBuildingFromStyle(style)+",";
            }
            csvLayout.add(row);
        }
        return  csvLayout;
    }

    public static char pickBuildingFromStyle(int style)
    {
        char[] europe = {'a','b','c','d'};

        switch (style)
        {
            case 0:
                return europe[RandomUtils.nextInt(0,europe.length-1)];


        }
        return 0;
    }


}
