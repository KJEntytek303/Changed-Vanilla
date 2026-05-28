package net.ltxprogrammer.changedvanilla.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.ltxprogrammer.changed.client.renderer.AdvancedHumanoidRenderer;
import net.ltxprogrammer.changed.client.renderer.layers.CustomEyesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.GasMaskLayer;
import net.ltxprogrammer.changed.client.renderer.layers.LatexParticlesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.TransfurCapeLayer;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexBigTailDragonModel;
import net.ltxprogrammer.changed.entity.SpringType;
import net.ltxprogrammer.changed.util.Color3;
import net.ltxprogrammer.changedvanilla.ChangedVanilla;
import net.ltxprogrammer.changedvanilla.client.render.model.LatexSlimeModel;
import net.ltxprogrammer.changedvanilla.entity.LatexSlime;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class LatexSlimeRenderer extends AdvancedHumanoidRenderer<LatexSlime, LatexSlimeModel> {
    public static final ResourceLocation DEFAULT_SKIN_LOCATION = ChangedVanilla.modResource("textures/entity/latex_slime.png");

    public LatexSlimeRenderer(EntityRendererProvider.Context context) {
        super(context, new LatexSlimeModel(context.bakeLayer(LatexSlimeModel.LAYER_LOCATION)), ArmorLatexBigTailDragonModel.MODEL_SET, 0.5f);
        this.addLayer(new LatexParticlesLayer<>(this, getModel()));
        this.addLayer(TransfurCapeLayer.normalCape(this, context.getModelSet()));
        this.addLayer(CustomEyesLayer.builder(this, context.getModelSet())
                .withSclera(Color3.fromInt(0x5bd400)).withIris(Color3.fromInt(0x76e500)).build());
        this.addLayer(GasMaskLayer.forSnouted(this, context.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(LatexSlime entity) {
        return DEFAULT_SKIN_LOCATION;
    }

    @Override
    protected void scale(LatexSlime entity, PoseStack pose, float deltaTime) {
        super.scale(entity, pose, deltaTime);
        float spring = entity.getSimulatedSpring(SpringType.MODERATE_STRONG, SpringType.Direction.VERTICAL, deltaTime) * -0.125f;
        pose.scale(1.0f - spring, 1.0f + spring, 1.0f - spring);
    }
}
