package gd.rf.acro.walledkingdoms;

import net.minecraft.world.World;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static gd.rf.acro.walledkingdoms.Layout.Layout.genLayoutFromSeed;
import static gd.rf.acro.walledkingdoms.Layout.Layout.pickBuildingFromStyle;
import static gd.rf.acro.walledkingdoms.Utils.writeLines;
import static gd.rf.acro.walledkingdoms.Politics.Politics.genImportantInformation;

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

    public static void createKingdom()
    {

    }
}
