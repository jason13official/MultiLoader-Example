package io.github.jason13official.more_bows_and_arrows;

import net.minecraft.resources.ResourceLocation;

public class MoreBowsAndArrows {

  public static void init() {
  }

  public static ResourceLocation identifier(String path) {
    return ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, path);
  }
}