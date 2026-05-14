package io.github.jason13official.more_bows_and_arrows;

import io.github.jason13official.more_bows_and_arrows.item.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.DispenserBlock;

public class MoreBowsAndArrows {

  public static void init() {

    DispenserBlock.registerProjectileBehavior(ModItems.MOD_ARROW);
  }

  public static ResourceLocation identifier(String path) {
    return ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, path);
  }
}