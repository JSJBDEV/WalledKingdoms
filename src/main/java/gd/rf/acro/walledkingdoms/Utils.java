package gd.rf.acro.walledkingdoms;

import gd.rf.acro.walledkingdoms.Citizens.EntityCitizenPassive;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemMap;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.*;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.world.storage.MapData;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomUtils;
import scala.actors.threadpool.Arrays;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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

    public static void loadStructure(BlockPos pos, World world, String name, Mirror mirror, Rotation rotation) {
        boolean flag = false;
        if (!world.isRemote) {
            WorldServer worldserver = (WorldServer) world;
            MinecraftServer minecraftserver = world.getMinecraftServer();
            TemplateManager templatemanager = worldserver.getStructureTemplateManager();
            ResourceLocation air_loc = new ResourceLocation("walledkingdoms", "clear_air");
            Template air_template = templatemanager.getTemplate(minecraftserver, air_loc);
            ResourceLocation loc = new ResourceLocation("walledkingdoms", name);
            Template template = templatemanager.getTemplate(minecraftserver, loc);
            if (template != null) {
                BlockPos air_pos = pos.add(0,32,0);
                IBlockState air_iblockstate = world.getBlockState(air_pos);
                world.notifyBlockUpdate(air_pos, air_iblockstate, air_iblockstate, 3);

                IBlockState iblockstate = world.getBlockState(pos);
                world.notifyBlockUpdate(pos, iblockstate, iblockstate, 3);
                flag = true;
                if (flag) {
                    PlacementSettings placementsettings = (new PlacementSettings()).setMirror(mirror)
                            .setRotation(rotation).setIgnoreEntities(false).setChunk((ChunkPos) null)
                            .setReplacedBlock((Block) null).setIgnoreStructureBlock(true);

                    air_template.addBlocksToWorldChunk(world, air_pos.down(), placementsettings);
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

    public static byte[] imageUrlToMap(String url){
        BufferedImage image = null;
        try {
            image = ImageIO.read(new URL(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Byte> bytes = new ArrayList<>();

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                bytes.add(closestMapColour(image.getRGB(j,i)));

            }
        }
        Byte[] bites = bytes.toArray(new Byte[bytes.size()]);
        return ArrayUtils.toPrimitive(bites);
    }

    public static byte closestMapColour(int argb)
    {
        String[] mccolours = {"89,125,39","109,153,48","127,178,56","67,94,29","174,164,115","213,201,140","247,233,163","130,123,86","140,140,140","171,171,171","199,199,199","105,105,105","180,0,0","220,0,0","255,0,0","135,0,0","112,112,180","138,138,220","160,160,255","84,84,135","117,117,117","144,144,144","167,167,167","88,88,88","0,87,0","0,106,0","0,124,0","0,65,0","180,180,180","220,220,220","255,255,255","135,135,135","115,118,129","141,144,158","164,168,184","86,88,97","106,76,54","130,94,66","151,109,77","79,57,40","79,79,79","96,96,96","112,112,112","59,59,59","45,45,180","55,55,220","64,64,255","33,33,135","100,84,50","123,102,62","143,119,72","75,63,38","180,177,172","220,217,211","255,252,245","135,133,129","152,89,36","186,109,44","216,127,51","114,67,27","125,53,152","153,65,186","178,76,216","94,40,114","72,108,152","88,132,186","102,153,216","54,81,114","161,161,36","197,197,44","229,229,51","121,121,27","89,144,17","109,176,21","127,204,25","67,108,13","170,89,116","208,109,142","242,127,165","128,67,87","53,53,53","65,65,65","76,76,76","40,40,40","108,108,108","132,132,132","153,153,153","81,81,81","53,89,108","65,109,132","76,127,153","40,67,81","89,44,125","109,54,153","127,63,178","67,33,94","36,53,125","44,65,153","51,76,178","27,40,94","72,53,36","88,65,44","102,76,51","54,40,27","72,89,36","88,109,44","102,127,51","54,67,27","108,36,36","132,44,44","153,51,51","81,27,27","17,17,17","21,21,21","25,25,25","13,13,13","176,168,54","215,205,66","250,238,77","132,126,40","64,154,150","79,188,183","92,219,213","48,115,112","52,90,180","63,110,220","74,128,255","39,67,135","0,153,40","0,187,50","0,217,58","0,114,30","91,60,34","111,74,42","129,86,49","68,45,25","79,1,0","96,1,0","112,2,0","59,1,0","147,124,113","180,152,138","209,177,161","110,93,85","112,57,25","137,70,31","159,82,36","84,43,19","105,61,76","128,75,93","149,87,108","78,46,57","79,76,97","96,93,119","112,108,138","59,57,73","131,93,25","160,114,31","186,133,36","98,70,19","72,82,37","88,100,45","103,117,53","54,61,28","112,54,55","138,66,67","160,77,78","84,40,41","40,28,24","49,35,30","57,41,35","30,21,18","95,75,69","116,92,84","135,107,98","71,56,51","61,64,64","75,79,79","87,92,92","46,48,48","86,51,62","105,62,75","122,73,88","64,38,46","53,43,64","65,53,79","76,62,92","40,32,48","53,35,24","65,43,30","76,50,35","40,26,18","53,57,29","65,70,36","76,82,42","40,43,22","100,42,32","122,51,39","142,60,46","75,31,24","26,15,11","31,18,13","37,22,16","19,11,8"};
        int red =   (argb >> 16) & 0xFF;
        int green = (argb >>  8) & 0xFF;
        int blue =  (argb      ) & 0xFF;

        double closest = 999;
        int closei = 0;

        for (int i = 0; i < mccolours.length; i++)
        {
            String[] rgb = mccolours[i].split(",");
            double rs = (Math.abs(Integer.valueOf(rgb[0])-red))^2;
            double gs = (Math.abs(Integer.valueOf(rgb[1])-green))^2;
            double bs = (Math.abs(Integer.valueOf(rgb[2])-blue))^2;
            double distance = Math.sqrt(rs+gs+bs);
            if(distance<closest)
            {
                closest=distance;
                closei=i;
            }

        }
        closei+=4;
        return (byte)closei;

        
    }

    public static List<String> readLines(String path)
    {
        try {
            return Files.readAllLines(Paths.get(path));
        }catch (Exception e)
        {
            System.out.println("Exception thrown when reading files: "+e);
        }
        return null;
    }

    //inspired by Ancient Warfare 2, but as you can see, almost completely different
    public static void makeRangedAttack(EntityLivingBase attacker)
    {
        //so this is the simplest possible way to implement ranged attacks I guess.
        EntityArrow arrow = new EntityTippedArrow(attacker.world,attacker);
        Vec3d lookdir = attacker.getLookVec();
        arrow.setVelocity(lookdir.x*3,lookdir.y*3,lookdir.z);
        arrow.setDamage(5);
        attacker.world.spawnEntity(arrow);
    }

    public static void makeRangedAttack(EntityLivingBase attacker,EntityLivingBase target)
    {
        //maths, specifically unit vectors
        EntityArrow arrow = new EntityTippedArrow(attacker.world,attacker);

        BlockPos dir = target.getPosition().subtract(attacker.getPosition());
        Vec3d lookdir = new Vec3d(dir.getX(),dir.getY(),dir.getZ()).normalize();

        arrow.setVelocity(lookdir.x*2,lookdir.y*2+0.05,lookdir.z*2);
        arrow.setDamage(RandomUtils.nextInt(0,5));
        attacker.world.spawnEntity(arrow);
    }

    public static void initVillager(World world, BlockPos pos,boolean mirror)
    {
        List<EntityCitizenPassive> villagers = world.getEntitiesWithinAABB(EntityCitizenPassive.class,new AxisAlignedBB(pos,pos.add(16,32,16)));

        if(villagers.size()>0)
        {
            giveProfessionItem(villagers.get(0),0,true);
            setCitizenHouse(villagers.get(0),pos,mirror);
        }
    }


    public static void giveProfessionItem(EntityCitizenPassive entity, int profession, boolean isRandom)
    {
        if(isRandom)
        {
            profession = RandomUtils.nextInt(0,5);
        }
        switch (profession)
        {
            case 0: //butcher
                entity.setHeldItem(EnumHand.MAIN_HAND,new ItemStack(Items.PORKCHOP));
                break;
            case 1: //baker
                entity.setHeldItem(EnumHand.MAIN_HAND,new ItemStack(Items.BREAD));
                break;
            case 2: //blacksmith
                entity.setHeldItem(EnumHand.MAIN_HAND,new ItemStack(Blocks.ANVIL));
                break;
            case 3: //silversmith
                entity.setHeldItem(EnumHand.MAIN_HAND,new ItemStack(Items.CLOCK));
                break;
            case 4: //stonemason
                entity.setHeldItem(EnumHand.MAIN_HAND,new ItemStack(Blocks.STONE_BRICK_STAIRS));
                break;
        }
    }
    public static void setCitizenHouse(EntityCitizenPassive entity, BlockPos blockPos, boolean mirror)
    {
        //requires the position that the generator would use (least positive x and z corner)
        ItemStack item = entity.getHeldItem(EnumHand.MAIN_HAND);
        if(!item.hasTagCompound())
        {
            item.setTagCompound(new NBTTagCompound());
        }
        NBTTagCompound tags = item.getTagCompound();
        tags.setBoolean("mirror",mirror);
        tags.setInteger("x",blockPos.getX());
        tags.setInteger("y",blockPos.getY());
        tags.setInteger("z",blockPos.getZ());
    }



}
