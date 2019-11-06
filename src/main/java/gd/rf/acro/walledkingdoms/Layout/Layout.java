package gd.rf.acro.walledkingdoms.Layout;

import net.minecraft.world.World;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

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
        String[] china = {"wk_china_com_0","wk_china_com_1","wk_china_res_0","wk_china_res_1"};

        switch (style)
        {
            case 0:
                return china[RandomUtils.nextInt(0,china.length)];


        }
        return "";
    }

    public static List<String> makeCityCoherent(List<String> city, int style,int length)
    {
        switch (style)
        {
            case 0:
                city.set(0, StringUtils.repeat("wk_china_wall_z-,",length));
                city.set(length-1,StringUtils.repeat("wk_china_wall_z-,",length));

                for (int i = 0; i < length; i++) {
                    String[] buildings = city.get(i).split(",");
                    buildings[0]="wk_china_wall_x-";
                    buildings[length-1]="wk_china_wall_x-";
                    city.set(i,String.join(",",buildings));
                }
                break;
        }
        return city;
    }




}
