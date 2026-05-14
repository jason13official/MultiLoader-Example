package io.github.jason13official.more_bows_and_arrows;

import io.github.jason13official.more_bows_and_arrows.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

public class MoreBowsAndArrowsClient {

  public static void init() {

    ItemProperties.register(ModItems.MOD_BOW, ResourceLocation.withDefaultNamespace("pull"), (itemStack, clientLevel, livingEntity, i) -> {
      if (livingEntity == null) {
        return 0.0F;
      } else {
        return livingEntity.getUseItem() != itemStack ? 0.0F : (float) (itemStack.getUseDuration(livingEntity) - livingEntity.getUseItemRemainingTicks()) / 20.0F;
      }
    });

    ItemProperties.register(ModItems.MOD_BOW, ResourceLocation.withDefaultNamespace("pulling"),
        (itemStack, clientLevel, livingEntity, i) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F);
  }
}
