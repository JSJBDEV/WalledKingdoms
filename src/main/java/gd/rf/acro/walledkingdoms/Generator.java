package gd.rf.acro.walledkingdoms;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import scala.Int;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static gd.rf.acro.walledkingdoms.Layout.Layout.genLayoutFromSeed;
import static gd.rf.acro.walledkingdoms.Layout.Layout.pickBuildingFromStyle;
import static gd.rf.acro.walledkingdoms.Politics.Politics.genImportantInformation;
import static gd.rf.acro.walledkingdoms.Utils.*;

public class Generator {

    @SubscribeEvent
    public static void worldgen(WorldEvent.Load event)
    {
        World world = event.getWorld();
        for (int i = 0; i < 1; i++)
        {
            String pref = "saves/" + world.getWorldInfo().getWorldName() + "/WalledKingdoms/"+i+"/";
            if(!Files.exists(Paths.get(pref+"politics.wk")))
            {

                //create necessary information and descriptions
                List<String> politics = genImportantInformation(world);
                writeLines(politics, pref + "politics.wk");

                //create the building layout
                List<String> layout = genLayoutFromSeed(world, 32, Integer.parseInt(politics.get(2)));
                writeLines(layout, pref + "layout.wk");
            }
        }


    }

    public static void createKingdom(World world, int kingdomNo)
    {
        String pref = "saves/" + world.getWorldInfo().getWorldName() + "/WalledKingdoms/"+kingdomNo+"/";
        List<String> politics = readLines(pref+"politics.wk");
        int x = Integer.parseInt(politics.get(3));
        int z = Integer.parseInt(politics.get(4));
        int y = world.getHeight(x,z);
        BlockPos base = new BlockPos(x,y,z);

        List<String> layout = readLines(pref+"layout.wk");

        for (int i = 0; i < layout.size(); i++) {
            String[] buildings = layout.get(i).split(",");
            for (int j = 0; j < buildings.length; j++) {
                loadStructure(base.add(16*i,0,16*j),world,buildings[j]);
            }
        }

    }
}
