package gd.rf.acro.walledkingdoms;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemMap;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.world.storage.MapData;
import org.apache.commons.io.FileUtils;
import scala.actors.threadpool.Arrays;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Utils {

    public static byte[] createImageColourMap(String file)
    {
        List<String> text = Arrays.asList(file.split(","));
        int size = text.size();
        byte[] col = new byte[size];
        for (int i = 0; i < size ; ++i)
        {
            col[i] = Byte.parseByte(text.get(i));
        }

        return col;

    }


    private int rotation;
    private int mirror;

    public static void loadStructure(BlockPos pos, World world, String name) {
        boolean flag = false;
        if (!world.isRemote) {
            WorldServer worldserver = (WorldServer) world;
            MinecraftServer minecraftserver = world.getMinecraftServer();
            TemplateManager templatemanager = worldserver.getStructureTemplateManager();
            ResourceLocation loc = new ResourceLocation("walledkingdoms", name);
            Template template = templatemanager.getTemplate(minecraftserver, loc);
            if (template != null) {
                IBlockState iblockstate = world.getBlockState(pos);
                world.notifyBlockUpdate(pos, iblockstate, iblockstate, 3);
                flag = true;
                if (flag) {
                    PlacementSettings placementsettings = (new PlacementSettings()).setMirror(Mirror.NONE)
                            .setRotation(Rotation.NONE).setIgnoreEntities(false).setChunk((ChunkPos) null)
                            .setReplacedBlock((Block) null).setIgnoreStructureBlock(true);

                    template.addBlocksToWorldChunk(world, pos.down(), placementsettings);
                }
            }
        }
    }

    /**
     * String worldfile = "saves/"+event.getWorld().getWorldInfo().getWorldName()+"/WalledKingdoms/real.wk";
     *         try
     *         {
     *             if(!Files.exists(Paths.get(worldfile)))
     *             {
     *                 FileUtils.write(new File(worldfile ),"text","utf-8");
     *             }
     *         }catch (Exception e)
     *         {
     *             System.out.println("exception thrown:"+e);
     *         }
     */


    public static void writeLines(List<String> lines,String file)
    {
        try
              {
                  FileUtils.writeLines(new File(file),lines,false);
              }catch (Exception e)
              {
                  System.out.println("exception thrown whilst trying to write to a file:"+e);
              }
    }

}
