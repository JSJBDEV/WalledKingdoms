package gd.rf.acro.walledkingdoms.proxy;

import gd.rf.acro.walledkingdoms.Citizens.ModEntities;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Acro on 13/08/2018.
 */
public class ClientProxy extends CommonProxy {
    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation("walledkingdoms" + ":" + id, "inventory"));
    }


}
