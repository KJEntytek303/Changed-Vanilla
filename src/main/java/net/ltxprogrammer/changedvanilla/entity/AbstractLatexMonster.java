package net.ltxprogrammer.changedvanilla.entity;

import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

public abstract class AbstractLatexMonster extends ChangedEntity {
    public AbstractLatexMonster(EntityType<? extends ChangedEntity> type, Level level) {
        super(type, level);
    }

    public static <T extends ChangedEntity> boolean checkEntitySpawnRules(EntityType<T> entityType, ServerLevelAccessor world, MobSpawnType reason, BlockPos pos, RandomSource random) {
        return checkSpawnBlock(world, reason, pos) && Monster.checkMonsterSpawnRules(entityType, world, reason, pos, random);
    }
}
