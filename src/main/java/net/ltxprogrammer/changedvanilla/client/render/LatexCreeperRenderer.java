package net.ltxprogrammer.changedvanilla.client.render;

import net.ltxprogrammer.changed.client.renderer.AdvancedHumanoidRenderer;
import net.ltxprogrammer.changed.client.renderer.layers.*;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexCentaurLowerModel;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexMaleTaurUpperModel;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorModelPicker;
import net.ltxprogrammer.changed.util.Color3;
import net.ltxprogrammer.changedvanilla.ChangedVanilla;
import net.ltxprogrammer.changedvanilla.client.render.model.LatexCreeperModel;
import net.ltxprogrammer.changedvanilla.entity.LatexCreeper;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.SaddleLayer;
import net.minecraft.resources.ResourceLocation;

public class LatexCreeperRenderer extends AdvancedHumanoidRenderer<LatexCreeper, LatexCreeperModel> {
    public static final ResourceLocation DEFAULT_SKIN_LOCATION = ChangedVanilla.modResource("textures/entity/latex_creeper/entity.png");

    public LatexCreeperRenderer(EntityRendererProvider.Context context) {
        super(context, new LatexCreeperModel(context.bakeLayer(LatexCreeperModel.LAYER_LOCATION)),
                ArmorModelPicker.centaur(context.getModelSet(), ArmorLatexMaleTaurUpperModel.MODEL_SET, ArmorLatexCentaurLowerModel.MODEL_SET_WITH_TORSO), 0.7f);
        this.addLayer(new LatexParticlesLayer<>(this, getModel()));
        this.addLayer(CustomEyesLayer.builder(this, context.getModelSet())
                .withSclera(Color3.fromInt(0x1b1b1b)).build());
        this.addLayer(new SaddleLayer<>(this, getModel(), ChangedVanilla.modResource("textures/entity/latex_creeper/saddle.png")));
        this.addLayer(new TaurChestPackLayer<>(this, context.getModelSet()));
        this.addLayer(TransfurCapeLayer.shortCape(this, context.getModelSet()));
        this.addLayer(GasMaskLayer.forSnouted(this, context.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(LatexCreeper entity) {
        return DEFAULT_SKIN_LOCATION;
    }
}
