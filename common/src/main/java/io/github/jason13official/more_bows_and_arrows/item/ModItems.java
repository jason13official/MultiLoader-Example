package io.github.jason13official.more_bows_and_arrows.item;

import io.github.jason13official.more_bows_and_arrows.MoreBowsAndArrows;
import java.util.function.BiConsumer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;

public class ModItems {

  public static Item MOD_BOW;
  public static Item MOD_ARROW;

  public static void register(BiConsumer<Item, ResourceLocation> consumer) {

    MOD_BOW = new ModBowItem((new Item.Properties()).durability(384));
    MOD_ARROW = new ArrowItem(new Item.Properties());

    consumer.accept(MOD_BOW, MoreBowsAndArrows.identifier("mod_bow"));
    consumer.accept(MOD_ARROW, MoreBowsAndArrows.identifier("mod_arrow"));
  }
}
