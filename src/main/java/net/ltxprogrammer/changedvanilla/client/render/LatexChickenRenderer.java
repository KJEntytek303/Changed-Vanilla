package net.ltxprogrammer.changedvanilla.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.ltxprogrammer.changed.client.renderer.AdvancedHumanoidRenderer;
import net.ltxprogrammer.changed.client.renderer.layers.CustomEyesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.GasMaskLayer;
import net.ltxprogrammer.changed.client.renderer.layers.LatexParticlesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.TransfurCapeLayer;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexMaleBirdModel;
import net.ltxprogrammer.changed.util.Color3;
import net.ltxprogrammer.changedvanilla.ChangedVanilla;
import net.ltxprogrammer.changedvanilla.client.render.model.LatexChickenModel;
import net.ltxprogrammer.changedvanilla.entity.LatexChicken;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class LatexChickenRenderer extends AdvancedHumanoidRenderer<LatexChicken, LatexChickenModel> {
    public static final ResourceLocation DEFAULT_SKIN_LOCATION = ChangedVanilla.modResource("textures/entity/latex_chicken.png");

    public LatexChickenRenderer(EntityRendererProvider.Context context) {
        super(context, new LatexChickenModel(context.bakeLayer(LatexChickenModel.LAYER_LOCATION)), ArmorLatexMaleBirdModel.MODEL_SET, 0.5f);
        this.addLayer(new LatexParticlesLayer<>(this, getModel()));
        this.addLayer(TransfurCapeLayer.normalCape(this, context.getModelSet()));
        this.addLayer(CustomEyesLayer.builder(this, context.getModelSet())
                .withSclera(Color3.fromInt(0x111111)).build());
        this.addLayer(GasMaskLayer.forSnouted(this, context.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(LatexChicken entity) {
        return DEFAULT_SKIN_LOCATION;
    }

    @Override
    protected void scale(LatexChicken entity, PoseStack poseStack, float partialTicks) {
        super.scale(entity, poseStack, partialTicks);
        poseStack.scale(0.95f, 0.95f, 0.95f);
    }
}
