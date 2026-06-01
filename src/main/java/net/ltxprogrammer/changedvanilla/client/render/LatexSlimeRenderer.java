package net.ltxprogrammer.changedvanilla.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.ltxprogrammer.changed.client.renderer.AdvancedHumanoidRenderer;
import net.ltxprogrammer.changed.client.renderer.layers.*;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexBigTailDragonModel;
import net.ltxprogrammer.changed.entity.SpringType;
import net.ltxprogrammer.changed.util.Color3;
import net.ltxprogrammer.changedvanilla.ChangedVanilla;
import net.ltxprogrammer.changedvanilla.client.render.layers.LatexSlimeOuterLayer;
import net.ltxprogrammer.changedvanilla.client.render.model.LatexSlimeModel;
import net.ltxprogrammer.changedvanilla.entity.LatexSlime;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Pose;
import org.jetbrains.annotations.Nullable;

public class LatexSlimeRenderer extends AdvancedHumanoidRenderer<LatexSlime, LatexSlimeModel> {
    public static final ResourceLocation DEFAULT_SKIN_LOCATION_INNER = ChangedVanilla.modResource("textures/entity/latex_slime/inner.png");
    public static final ResourceLocation DEFAULT_SKIN_LOCATION_OUTER = ChangedVanilla.modResource("textures/entity/latex_slime/outer.png");

    public LatexSlimeRenderer(EntityRendererProvider.Context context) {
        super(context, new LatexSlimeModel(context.bakeLayer(LatexSlimeModel.LAYER_LOCATION_INNER)), ArmorLatexBigTailDragonModel.MODEL_SET, 0.5f);
        var slimeLayer = new LatexSlimeOuterLayer(this, new LatexSlimeModel(context.bakeLayer(LatexSlimeModel.LAYER_LOCATION_OUTER)), DEFAULT_SKIN_LOCATION_OUTER);
        this.addLayer(slimeLayer);
        this.addLayer(new LatexParticlesLayer<>(this, getModel())
                .addModel(slimeLayer.getModel(), entity -> slimeLayer.getTexture()));
        this.addLayer(TransfurCapeLayer.normalCape(this, context.getModelSet()));
        this.addLayer(CustomEyesLayer.builder(this, context.getModelSet())
                .withSclera(CustomEyesLayer.fixedColor(Color3.fromInt(0x5bd400), 0.5f)).withIris(CustomEyesLayer.fixedColor(Color3.fromInt(0x76e500), 0.75f)).build());
        this.addLayer(GasMaskLayer.forSnouted(this, context.getModelSet()));
    }

    @Override
    protected @Nullable RenderType getRenderType(LatexSlime entity, boolean bodyVisible, boolean visibleToPlayerExclusive, boolean glowing) {
        ResourceLocation resourcelocation = this.getTextureLocation(entity);
        if (visibleToPlayerExclusive) {
            return RenderType.itemEntityTranslucentCull(resourcelocation);
        } else if (bodyVisible) {
            return RenderType.entityCutoutNoCull(resourcelocation);
        } else {
            return glowing ? RenderType.outline(resourcelocation) : null;
        }
    }

    @Override
    public ResourceLocation getTextureLocation(LatexSlime entity) {
        return DEFAULT_SKIN_LOCATION_INNER;
    }

    @Override
    protected void scale(LatexSlime entity, PoseStack pose, float deltaTime) {
        super.scale(entity, pose, deltaTime);
        float spring = entity.getSimulatedSpring(SpringType.MODERATE_STRONG, SpringType.Direction.VERTICAL, deltaTime) * -0.125f;
        if (!entity.hasPose(Pose.SLEEPING)) {
            pose.scale(1.0f - spring, 1.0f + spring, 1.0f - spring);
        } else {
            pose.scale(1.0f - (spring * 0.5f), 1.0f - (spring * 0.5f), 1.0f + (spring * 4.0f));
        }
    }
}
