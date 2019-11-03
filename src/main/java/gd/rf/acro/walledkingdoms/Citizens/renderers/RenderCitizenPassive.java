package gd.rf.acro.walledkingdoms.Citizens.renderers;

import gd.rf.acro.walledkingdoms.Citizens.EntityCitizen;
import gd.rf.acro.walledkingdoms.Citizens.EntityCitizenPassive;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nonnull;

public class RenderCitizenPassive extends RenderLiving<EntityCitizenPassive> {
    private ResourceLocation mobTexture = new ResourceLocation("walledkingdoms:textures/entity/citizen.png");

    public static final Factory FACTORY = new Factory();

    public RenderCitizenPassive(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelBiped(), 0.5F);
        addLayer(new LayerBipedArmor(this));
        addLayer(new LayerHeldItem(this));
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntityCitizenPassive entity) {
        return mobTexture;
    }

    public static class Factory implements IRenderFactory<EntityCitizenPassive> {

        @Override
        public Render<? super EntityCitizenPassive> createRenderFor(RenderManager manager) {
            return new RenderCitizenPassive(manager);
        }

    }
}
