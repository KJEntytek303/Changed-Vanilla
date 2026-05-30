package net.ltxprogrammer.changedvanilla.init;

import net.ltxprogrammer.changedvanilla.client.render.model.*;
import net.ltxprogrammer.changedvanilla.client.render.model.armor.ArmorLatexSpiderModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ChangedVanillaLayerDefinitions {
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(LatexCatModel.LAYER_LOCATION, LatexCatModel::createBodyLayer);
        event.registerLayerDefinition(LatexChickenModel.LAYER_LOCATION, LatexChickenModel::createBodyLayer);
        event.registerLayerDefinition(LatexCowModel.LAYER_LOCATION, LatexCowModel::createBodyLayer);
        event.registerLayerDefinition(LatexCreeperModel.LAYER_LOCATION, LatexCreeperModel::createBodyLayer);
        event.registerLayerDefinition(LatexFoxModel.LAYER_LOCATION, LatexFoxModel::createBodyLayer);
        event.registerLayerDefinition(LatexFoxPartialModel.LAYER_LOCATION_LATEX, () -> LatexFoxPartialModel.createLatexLayer(false));
        event.registerLayerDefinition(LatexFoxPartialModel.LAYER_LOCATION_LATEX_SLIM, () -> LatexFoxPartialModel.createLatexLayer(true));
        event.registerLayerDefinition(LatexGhastModel.LAYER_LOCATION, LatexGhastModel::createBodyLayer);
        event.registerLayerDefinition(LatexGuardianModel.LAYER_LOCATION, LatexGuardianModel::createBodyLayer);
        event.registerLayerDefinition(LatexPigModel.LAYER_LOCATION, LatexPigModel::createBodyLayer);
        event.registerLayerDefinition(LatexSheepModel.LAYER_LOCATION, LatexSheepModel::createBodyLayer);
        event.registerLayerDefinition(LatexSkeletonModel.LAYER_LOCATION, LatexSkeletonModel::createBodyLayer);
        event.registerLayerDefinition(LatexSlimeModel.LAYER_LOCATION_INNER, LatexSlimeModel::createInnerLayer);
        event.registerLayerDefinition(LatexSlimeModel.LAYER_LOCATION_OUTER, LatexSlimeModel::createOuterLayer);
        event.registerLayerDefinition(LatexSpiderModel.LAYER_LOCATION, LatexSpiderModel::createBodyLayer);
        event.registerLayerDefinition(LatexZombieModel.LAYER_LOCATION, LatexZombieModel::createBodyLayer);

        ArmorLatexSpiderModel.MODEL_SET.registerDefinitions(event::registerLayerDefinition);
    }
}
