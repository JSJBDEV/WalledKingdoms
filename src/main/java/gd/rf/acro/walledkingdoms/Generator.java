package gd.rf.acro.walledkingdoms;

import net.minecraft.world.World;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

import static gd.rf.acro.walledkingdoms.Layout.Layout.genLayoutFromSeed;
import static gd.rf.acro.walledkingdoms.Utils.writeLines;
import static gd.rf.acro.walledkingdoms.Politics.Politics.genImportantInformation;

public class Generator {

    @SubscribeEvent
    public static void worldgen(WorldEvent.Load event)
    {
        World world = event.getWorld();
        String pref = "saves/"+world.getWorldInfo().getWorldName()+"/WalledKingdoms/1/";

        //create necessary information and descriptions
        List<String> politics = genImportantInformation();
        writeLines(politics,pref+"politics.wk");

        //create the building layout
        List<String> layout = genLayoutFromSeed(world,32,Integer.parseInt(politics.get(2)));
        writeLines(layout,pref+"layout.wk");









    }
}
