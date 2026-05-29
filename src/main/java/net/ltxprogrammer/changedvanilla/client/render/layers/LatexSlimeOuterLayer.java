package net.ltxprogrammer.changedvanilla.client.render.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.ltxprogrammer.changed.client.FormRenderHandler;
import net.ltxprogrammer.changed.client.renderer.layers.FirstPersonLayer;
import net.ltxprogrammer.changedvanilla.client.render.model.LatexSlimeModel;
import net.ltxprogrammer.changedvanilla.entity.LatexSlime;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.HumanoidArm;

public class LatexSlimeOuterLayer extends RenderLayer<LatexSlime, LatexSlimeModel> implements FirstPersonLayer<LatexSlime> {
    private final LatexSlimeModel model;
    private final ResourceLocation texture;

    public LatexSlimeOuterLayer(RenderLayerParent<LatexSlime, LatexSlimeModel> parent, LatexSlimeModel model, ResourceLocation texture) {
        super(parent);
        this.model = model;
        this.texture = texture;
    }

    public void render(PoseStack p_117470_, MultiBufferSource p_117471_, int p_117472_, LatexSlime entity, float p_117474_, float p_117475_, float p_117476_, float p_117477_, float p_117478_, float p_117479_) {
        Minecraft minecraft = Minecraft.getInstance();
        boolean flag = minecraft.shouldEntityAppearGlowing(entity) && entity.isInvisible();
        if (!entity.isInvisible() || flag) {
            VertexConsumer vertexconsumer;
            if (flag) {
                vertexconsumer = p_117471_.getBuffer(RenderType.outline(this.texture));
            } else {
                vertexconsumer = p_117471_.getBuffer(RenderType.entityTranslucent(this.texture));
            }

            this.model.copyFrom(getParentModel());
            this.model.renderToBuffer(p_117470_, vertexconsumer, p_117472_, LivingEntityRenderer.getOverlayCoords(entity, 0.0F), 1.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    public LatexSlimeModel getModel() {
        return this.model;
    }

    public ResourceLocation getTexture() {
        return this.texture;
    }

    public void renderFirstPersonOnArms(PoseStack stack, MultiBufferSource bufferSource, int packedLight, LatexSlime entity, HumanoidArm arm, PartPose armPose, float partialTick) {
        ModelPart armPart = this.model.getArm(arm);
        armPart.loadPose(armPose);
        FormRenderHandler.renderModelPartWithTexture(armPart, stack, bufferSource.getBuffer(RenderType.entityTranslucent(this.texture)), packedLight, 1.0F);
    }
}