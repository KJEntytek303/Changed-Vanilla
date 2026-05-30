package net.ltxprogrammer.changedvanilla.client.render;

import net.ltxprogrammer.changed.client.renderer.AdvancedHumanoidRenderer;
import net.ltxprogrammer.changed.client.renderer.layers.CustomEyesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.GasMaskLayer;
import net.ltxprogrammer.changed.client.renderer.layers.LatexParticlesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.TransfurCapeLayer;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexDeerModel;
import net.ltxprogrammer.changedvanilla.ChangedVanilla;
import net.ltxprogrammer.changedvanilla.client.render.model.LatexPigModel;
import net.ltxprogrammer.changedvanilla.entity.LatexPig;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class LatexPigRenderer extends AdvancedHumanoidRenderer<LatexPig, LatexPigModel> {
    public static final ResourceLocation DEFAULT_SKIN_LOCATION = ChangedVanilla.modResource("textures/entity/latex_pig.png");

    public LatexPigRenderer(EntityRendererProvider.Context context) {
        super(context, new LatexPigModel(context.bakeLayer(LatexPigModel.LAYER_LOCATION)), ArmorLatexDeerModel.MODEL_SET, 0.5f);
        this.addLayer(new LatexParticlesLayer<>(this, getModel()));
        this.addLayer(TransfurCapeLayer.normalCape(this, context.getModelSet()));
        this.addLayer(CustomEyesLayer.builder(this, context.getModelSet()).build());
        this.addLayer(GasMaskLayer.forLargeSnouted(this, context.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(LatexPig entity) {
        return DEFAULT_SKIN_LOCATION;
    }
}
