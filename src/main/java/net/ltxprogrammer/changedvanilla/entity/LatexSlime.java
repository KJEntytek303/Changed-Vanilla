package net.ltxprogrammer.changedvanilla.entity;

import net.ltxprogrammer.changed.entity.AttributePresets;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.ltxprogrammer.changed.entity.TransfurCause;
import net.ltxprogrammer.changed.entity.TransfurMode;
import net.ltxprogrammer.changed.util.Color3;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.level.Level;

public class LatexSlime extends AbstractLatexMonster {
    protected float crouchImpulse = 0f;
    protected Pose lastPose = Pose.STANDING;

    public LatexSlime(EntityType<? extends ChangedEntity> type, Level level) {
        super(type, level);
    }

    @Override
    protected void setAttributes(AttributeMap attributes) {
        super.setAttributes(attributes);
        AttributePresets.wolfLike(attributes);
    }

    @Override
    public float getDripRate(float damage) {
        return super.getDripRate(damage) * 2.0f;
    }

    @Override
    public TransfurMode getTransfurMode() {
        return TransfurMode.REPLICATION;
    }

    @Override
    public Color3 getTransfurColor(TransfurCause cause) {
        return Color3.fromInt(0x67eb03);
    }

    @Override
    public float getVerticalSpringOffset() {
        return crouchImpulse;
    }

    @Override
    public void variantTick(Level level) {
        var currentPose = getPose();

        if (lastPose == Pose.STANDING && currentPose == Pose.CROUCHING) {
            crouchImpulse = -0.7f;
        }

        else if (lastPose == Pose.CROUCHING && currentPose == Pose.STANDING) {
            crouchImpulse = 0.7f;
        }

        else {
            crouchImpulse = 0f;
        }

        lastPose = currentPose;

        super.variantTick(level);
    }
}
