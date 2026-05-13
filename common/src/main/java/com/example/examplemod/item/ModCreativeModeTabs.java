package com.example.examplemod.item;

import com.example.examplemod.CommonClass;
import com.example.examplemod.Constants;
import com.example.examplemod.platform.Services;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModCreativeModeTabs {

  public static CreativeModeTab EXAMPLE_TAB = null;

  public static void register(BiConsumer<CreativeModeTab, ResourceLocation> consumer) {

    EXAMPLE_TAB = Services.registry().tabBuilder()
        .icon(() -> new ItemStack(Items.STICK))
        .title(Component.literal(Constants.MOD_NAME))
        .displayItems((itemDisplayParameters, output) -> {
          output.accept(Items.STICK);
          output.accept(Items.DIAMOND);
        }).build();
    consumer.accept(EXAMPLE_TAB, CommonClass.identifier("example_tab"));
  }
}
