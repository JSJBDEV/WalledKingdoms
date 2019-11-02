package gd.rf.acro.walledkingdoms;

import gd.rf.acro.walledkingdoms.Citizens.EntityCitizen;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.scoreboard.ScoreCriteria;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import scala.Int;
import scala.collection.$colon$plus;

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
            //String pref = "saves/" + world.getWorldInfo().getWorldName() + "/WalledKingdoms/"+i+"/";
            String pref = DimensionManager.getCurrentSaveRootDirectory() + "/WalledKingdoms/"+i+"/";
            if(!Files.exists(Paths.get(pref+"politics.wk")))
            {
                //create a universal scoreboard to identify what the next storybook should create
                Scoreboard scoreboard = event.getWorld().getScoreboard();
                scoreboard.addScoreObjective("WK_KingdomsInit", ScoreCriteria.DUMMY);
                scoreboard.getOrCreateScore("world",scoreboard.getObjective("WK_KingdomsInit")).setScorePoints(0);

                //create necessary information and descriptions
                List<String> politics = genImportantInformation(world);
                writeLines(politics, pref + "politics.wk");

                //create the building layout
                List<String> layout = genLayoutFromSeed(world, 32, Integer.parseInt(politics.get(2)));
                writeLines(layout, pref + "layout.wk");
            }
        }


    }

    public static void createKingdom(World world, int kingdomNo, EntityPlayer reference)
    {
        String pref = DimensionManager.getCurrentSaveRootDirectory() + "/WalledKingdoms/"+kingdomNo+"/";
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
