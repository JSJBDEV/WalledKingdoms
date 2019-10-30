package gd.rf.acro.walledkingdoms.Citizens;

import gd.rf.acro.walledkingdoms.WalledKingdoms;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModEntities {
    public static void init() {
        // Every entity in our mod has an ID (local to this mod)
        int id = 1;
        EntityRegistry.registerModEntity(new ResourceLocation("walledkingdoms"),EntityCitizen.class,"Citizen",id++,WalledKingdoms.instance,64,3,true,0x996600, 0x00ff00);

        // We want our mob to spawn in Plains and ice plains biomes. If you don't add this then it will not spawn automatically
        // but you can of course still make it spawn manually
        //EntityRegistry.addSpawn(EntityCitizen.class, 100, 3, 5, EnumCreatureType.MONSTER, Biomes.PLAINS, Biomes.ICE_PLAINS);

    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        RenderingRegistry.registerEntityRenderingHandler(EntityCitizen.class, RenderCitizen.FACTORY);
    }
}
