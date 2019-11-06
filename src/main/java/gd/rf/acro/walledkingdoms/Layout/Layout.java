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

        for (int i = 0; i<length; i++)
        {
            String row = "";
            for (int j = 0; j<length; j++)
            {
                row=row+pickBuildingFromStyle(style)+",";
            }
            csvLayout.add(row);
        }
        return  csvLayout;
    }

    public static String pickBuildingFromStyle(int style)
    {
        String[] europe = {"wk_china_com_0","wk_china_com_1","wk_china_res_0","wk_china_res_1"};

        switch (style)
        {
            case 0:
                return europe[RandomUtils.nextInt(0,europe.length)];


        }
        return "";
    }


}
