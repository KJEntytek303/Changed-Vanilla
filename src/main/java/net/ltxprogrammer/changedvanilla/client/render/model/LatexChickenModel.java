package net.ltxprogrammer.changedvanilla.client.render.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.ltxprogrammer.changed.client.renderer.animate.AnimatorPresets;
import net.ltxprogrammer.changed.client.renderer.animate.HumanoidAnimator;
import net.ltxprogrammer.changed.client.renderer.model.AdvancedHumanoidModel;
import net.ltxprogrammer.changedvanilla.ChangedVanilla;
import net.ltxprogrammer.changedvanilla.entity.LatexChicken;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.HumanoidArm;

import java.util.List;

public class LatexChickenModel extends AdvancedHumanoidModel<LatexChicken> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ChangedVanilla.modResource("latex_chicken"), "main");
    private final ModelPart RightLeg;
    private final ModelPart LeftLeg;
    private final ModelPart RightArm;
    private final ModelPart LeftArm;
    private final ModelPart Head;
    private final ModelPart Torso;
    private final ModelPart Tail;
    private final HumanoidAnimator<LatexChicken, LatexChickenModel> animator;

    public LatexChickenModel(ModelPart root) {
        super(root);
        this.RightLeg = root.getChild("RightLeg");
        this.LeftLeg = root.getChild("LeftLeg");
        this.Head = root.getChild("Head");
        this.Torso = root.getChild("Torso");
        this.Tail = Torso.getChild("Tail");
        this.RightArm = root.getChild("RightArm");
        this.LeftArm = root.getChild("LeftArm");

        var tailPrimary = Tail.getChild("TailPrimary");

        var leftLowerLeg = LeftLeg.getChild("LeftLowerLeg");
        var leftFoot = leftLowerLeg.getChild("LeftFoot");
        var rightLowerLeg = RightLeg.getChild("RightLowerLeg");
        var rightFoot = rightLowerLeg.getChild("RightFoot");

        var leftWing = LeftArm.getChild("LeftFlight");
        var leftSubWing = leftWing.getChild("LeftSubFlight");
        var rightWing = RightArm.getChild("RightFlight");
        var rightSubWing = rightWing.getChild("RightSubFlight");

        animator = HumanoidAnimator.of(this).hipOffset(-1.5f)
                .addPreset(AnimatorPresets.birdLike(
                        Head, Torso, LeftArm, RightArm,
                        Tail, List.of(tailPrimary),
                        LeftLeg, leftLowerLeg, leftFoot, leftFoot.getChild("LeftPad"), RightLeg, rightLowerLeg, rightFoot, rightFoot.getChild("RightPad"),
                        leftWing, leftSubWing, rightWing, rightSubWing));
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.5F, 10.5F, 0.0F, -0.3491F, 0.0F, 0.0F));

        PartDefinition RightThigh_r1 = RightLeg.addOrReplaceChild("RightThigh_r1", CubeListBuilder.create().texOffs(24, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

        PartDefinition RightLowerLeg = RightLeg.addOrReplaceChild("RightLowerLeg", CubeListBuilder.create(), PartPose.offset(0.0F, 6.375F, -3.45F));

        PartDefinition RightCalf_r1 = RightLowerLeg.addOrReplaceChild("RightCalf_r1", CubeListBuilder.create().texOffs(24, 58).addBox(-0.99F, 0.0168F, 0.0504F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-0.5F, -1.025F, 0.45F, 0.7418F, 0.0F, 0.0F));

        PartDefinition RightFoot = RightLowerLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create(), PartPose.offset(0.0F, 0.875F, 6.0F));

        PartDefinition RightArch_r1 = RightFoot.addOrReplaceChild("RightArch_r1", CubeListBuilder.create().texOffs(52, 53).addBox(-1.0F, -8.2F, -0.725F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 7.075F, -4.075F, -0.2618F, 0.0F, 0.0F));

        PartDefinition RightPad = RightFoot.addOrReplaceChild("RightPad", CubeListBuilder.create().texOffs(64, 30).addBox(-0.5F, 0.0F, 1.65F, 1.0F, 2.0F, 2.0F, new CubeDeformation(-0.025F))
                .texOffs(64, 42).addBox(-0.5F, 0.0F, -3.25F, 1.0F, 2.0F, 2.0F, new CubeDeformation(-0.025F))
                .texOffs(48, 62).addBox(-1.5F, 0.0F, -1.3F, 3.0F, 2.0F, 3.0F, new CubeDeformation(-0.025F)), PartPose.offset(0.0F, 4.275F, -2.925F));

        PartDefinition RightPad_r1 = RightPad.addOrReplaceChild("RightPad_r1", CubeListBuilder.create().texOffs(64, 38).addBox(-0.5F, -1.5F, -4.75F, 1.0F, 2.0F, 2.0F, new CubeDeformation(-0.025F)), PartPose.offsetAndRotation(0.0F, 1.5F, 1.475F, 0.0F, -0.3927F, 0.0F));

        PartDefinition RightPad_r2 = RightPad.addOrReplaceChild("RightPad_r2", CubeListBuilder.create().texOffs(64, 34).addBox(-0.5F, -1.5F, -4.75F, 1.0F, 2.0F, 2.0F, new CubeDeformation(-0.025F)), PartPose.offsetAndRotation(0.0F, 1.5F, 1.475F, 0.0F, 0.3927F, 0.0F));

        PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create(), PartPose.offsetAndRotation(2.5F, 10.5F, 0.0F, 0.3491F, 0.0F, 0.0F));

        PartDefinition LeftThigh_r1 = LeftLeg.addOrReplaceChild("LeftThigh_r1", CubeListBuilder.create().texOffs(48, 30).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

        PartDefinition LeftLowerLeg = LeftLeg.addOrReplaceChild("LeftLowerLeg", CubeListBuilder.create(), PartPose.offset(0.0F, 6.375F, -3.45F));

        PartDefinition LeftCalf_r1 = LeftLowerLeg.addOrReplaceChild("LeftCalf_r1", CubeListBuilder.create().texOffs(36, 61).addBox(-0.99F, 0.0168F, 0.0504F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-0.5F, -1.025F, 0.45F, 0.7418F, 0.0F, 0.0F));

        PartDefinition LeftFoot = LeftLowerLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create(), PartPose.offset(0.0F, 0.875F, 6.0F));

        PartDefinition LeftArch_r1 = LeftFoot.addOrReplaceChild("LeftArch_r1", CubeListBuilder.create().texOffs(56, 0).addBox(-1.0F, -8.2F, -0.725F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 7.075F, -4.075F, -0.2618F, 0.0F, 0.0F));

        PartDefinition LeftPad = LeftFoot.addOrReplaceChild("LeftPad", CubeListBuilder.create().texOffs(64, 46).addBox(-0.5F, 0.0F, 1.65F, 1.0F, 2.0F, 2.0F, new CubeDeformation(-0.025F))
                .texOffs(64, 58).addBox(-0.5F, 0.0F, -3.25F, 1.0F, 2.0F, 2.0F, new CubeDeformation(-0.025F))
                .texOffs(60, 62).addBox(-1.5F, 0.0F, -1.3F, 3.0F, 2.0F, 3.0F, new CubeDeformation(-0.025F)), PartPose.offset(0.0F, 4.275F, -2.925F));

        PartDefinition LeftPad_r1 = LeftPad.addOrReplaceChild("LeftPad_r1", CubeListBuilder.create().texOffs(64, 54).addBox(-0.5F, -1.5F, -4.75F, 1.0F, 2.0F, 2.0F, new CubeDeformation(-0.025F)), PartPose.offsetAndRotation(0.0F, 1.5F, 1.475F, 0.0F, -0.3927F, 0.0F));

        PartDefinition LeftPad_r2 = LeftPad.addOrReplaceChild("LeftPad_r2", CubeListBuilder.create().texOffs(64, 50).addBox(-0.5F, -1.5F, -4.75F, 1.0F, 2.0F, 2.0F, new CubeDeformation(-0.025F)), PartPose.offsetAndRotation(0.0F, 1.5F, 1.475F, 0.0F, 0.3927F, 0.0F));

        PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 0.0F));

        PartDefinition Snout_r1 = Head.addOrReplaceChild("Snout_r1", CubeListBuilder.create().texOffs(56, 9).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -4.75F, 0.0F, -0.7854F, 0.0F));

        PartDefinition Feathers = Head.addOrReplaceChild("Feathers", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -1.0F));

        PartDefinition Head_r1 = Feathers.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(48, 23).addBox(0.0F, 0.0F, 0.0F, 4.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -4.0F, -2.0F, 0.0F, 0.0F, 1.0472F));

        PartDefinition Head_r2 = Feathers.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(48, 16).addBox(-4.0F, 0.0F, 0.0F, 4.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -4.0F, -2.0F, 0.0F, 0.0F, -1.0472F));

        PartDefinition Hair = Head.addOrReplaceChild("Hair", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.2F))
                .texOffs(0, 32).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 0.0F));

        PartDefinition Tail = Torso.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 11.5F, 1.0F, -0.4363F, 0.0F, 0.0F));

        PartDefinition TailPrimary = Tail.addOrReplaceChild("TailPrimary", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition Base_r1 = TailPrimary.addOrReplaceChild("Base_r1", CubeListBuilder.create().texOffs(0, 46).addBox(-6.0F, 0.75F, -0.5F, 12.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.9635F, 0.0F, 3.1416F));

        PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(32, 32).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 1.5F, 0.0F, 0.2618F, 0.0F, 0.2618F));

        PartDefinition RightArm_r1 = RightArm.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(48, 44).addBox(0.0F, -2.0F, -2.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 7.0F, -2.0F, 0.0F, 0.3491F, 0.0F));

        PartDefinition RightFlight = RightArm.addOrReplaceChild("RightFlight", CubeListBuilder.create().texOffs(40, 48).addBox(-6.0F, -6.0F, 0.0F, 6.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 3.0F, 0.0F, 0.0F, 1.309F, 0.0F));

        PartDefinition RightSubFlight = RightFlight.addOrReplaceChild("RightSubFlight", CubeListBuilder.create().texOffs(12, 53).addBox(-6.0F, -6.0F, 0.25F, 6.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -2.0F, 0.0F));

        PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(32, 16).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 1.5F, 0.0F, -0.2618F, 0.0F, -0.2618F));

        PartDefinition LeftArm_r1 = LeftArm.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().texOffs(48, 40).addBox(0.0F, -2.0F, -2.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 7.0F, -2.0F, 0.0F, -0.3491F, 0.0F));

        PartDefinition LeftFlight = LeftArm.addOrReplaceChild("LeftFlight", CubeListBuilder.create().texOffs(52, 40).addBox(0.0F, -6.0F, 0.0F, 6.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 3.0F, 0.0F, 0.0F, -1.309F, 0.0F));

        PartDefinition LeftSubFlight = LeftFlight.addOrReplaceChild("LeftSubFlight", CubeListBuilder.create().texOffs(0, 53).addBox(-1.0F, -6.0F, 0.25F, 6.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -2.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 96, 96);
    }

    public ModelPart getArm(HumanoidArm side) {
        return side == HumanoidArm.LEFT ? this.LeftArm : this.RightArm;
    }

    public ModelPart getLeg(HumanoidArm side) {
        return side == HumanoidArm.LEFT ? this.LeftLeg : this.RightLeg;
    }

    public ModelPart getHead() {
        return this.Head;
    }

    public ModelPart getTorso() {
        return Torso;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        RightLeg.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        LeftLeg.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        Head.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        Torso.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        RightArm.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        LeftArm.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public HumanoidAnimator<LatexChicken, LatexChickenModel> getAnimator(LatexChicken entity) {
        return animator;
    }
}
