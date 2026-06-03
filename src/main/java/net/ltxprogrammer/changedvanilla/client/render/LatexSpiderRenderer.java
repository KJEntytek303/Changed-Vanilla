package net.ltxprogrammer.changedvanilla.client.render;

import net.ltxprogrammer.changed.client.renderer.AdvancedHumanoidRenderer;
import net.ltxprogrammer.changed.client.renderer.layers.*;
import net.ltxprogrammer.changed.util.Color3;
import net.ltxprogrammer.changedvanilla.ChangedVanilla;
import net.ltxprogrammer.changedvanilla.client.render.model.LatexSpiderModel;
import net.ltxprogrammer.changedvanilla.client.render.model.armor.ArmorLatexSpiderModel;
import net.ltxprogrammer.changedvanilla.entity.LatexSpider;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class LatexSpiderRenderer extends AdvancedHumanoidRenderer<LatexSpider, LatexSpiderModel> {
    public static final ResourceLocation DEFAULT_SKIN_LOCATION = ChangedVanilla.modResource("textures/entity/latex_spider.png");

    public LatexSpiderRenderer(EntityRendererProvider.Context context) {
        super(context, new LatexSpiderModel(context.bakeLayer(LatexSpiderModel.LAYER_LOCATION)), ArmorLatexSpiderModel.MODEL_SET, 0.5f);
        this.addLayer(new LatexParticlesLayer<>(this, getModel()));
        this.addLayer(TransfurCapeLayer.normalCape(this, context.getModelSet()));
        this.addLayer(CustomEyesLayer.builder(this, context.getModelSet())
                .withSclera(CustomEyesLayer.fixedColorGlowing(Color3.fromInt(0x9f1f12)))
                .withIris(CustomEyesLayer::glowingIrisColorLeft, CustomEyesLayer::glowingIrisColorRight).build());
        this.addLayer(AdditionalEyesLayer.builder(this, context.getModelSet())
                .withSclera(CustomEyesLayer.fixedColorGlowing(Color3.fromInt(0x9f1f12)))
                .withIris(CustomEyesLayer::glowingIrisColorLeft, CustomEyesLayer::glowingIrisColorRight).build(ChangedVanilla.modResource("latex_spider")));
        this.addLayer(GasMaskLayer.forSnouted(this, context.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(LatexSpider entity) {
        return DEFAULT_SKIN_LOCATION;
    }
}
