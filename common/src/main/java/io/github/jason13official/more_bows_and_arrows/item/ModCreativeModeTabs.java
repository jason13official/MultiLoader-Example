package io.github.jason13official.more_bows_and_arrows.item;

import io.github.jason13official.more_bows_and_arrows.Constants;
import io.github.jason13official.more_bows_and_arrows.MoreBowsAndArrows;
import io.github.jason13official.more_bows_and_arrows.platform.Services;
import java.util.function.BiConsumer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModCreativeModeTabs {

  public static CreativeModeTab MORE_BOWS_AND_ARROWS = null;

  public static void register(BiConsumer<CreativeModeTab, ResourceLocation> consumer) {

    MORE_BOWS_AND_ARROWS = Services.registry().tabBuilder()
        .icon(() -> new ItemStack(ModItems.MOD_BOW))
        .title(Component.translatable("itemGroup.moreBowsAndArrows"))
        .displayItems((itemDisplayParameters, output) -> {
          output.accept(ModItems.MOD_BOW);
          output.accept(ModItems.MOD_ARROW);
        }).build();
    consumer.accept(MORE_BOWS_AND_ARROWS, MoreBowsAndArrows.identifier(Constants.MOD_ID));
  }
}
