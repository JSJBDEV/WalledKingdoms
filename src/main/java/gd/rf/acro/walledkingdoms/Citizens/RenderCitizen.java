package gd.rf.acro.walledkingdoms.Citizens;

import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nonnull;

public class RenderCitizen extends RenderLiving<EntityCitizen> {
    private ResourceLocation mobTexture = new ResourceLocation("walledkingdoms:textures/entity/citizen.png");

    public static final Factory FACTORY = new Factory();

    public RenderCitizen(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelZombie(), 0.5F);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntityCitizen entity) {
        return mobTexture;
    }

    public static class Factory implements IRenderFactory<EntityCitizen> {

        @Override
        public Render<? super EntityCitizen> createRenderFor(RenderManager manager) {
            return new RenderCitizen(manager);
        }

    }
}
