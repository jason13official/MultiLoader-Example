package io.github.jason13official.more_bows_and_arrows;

import io.github.jason13official.more_bows_and_arrows.item.ModCreativeModeTabs;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

public class MoreBowsAndArrowsFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {

        bind(BuiltInRegistries.CREATIVE_MODE_TAB, ModCreativeModeTabs::register);

        MoreBowsAndArrows.init();
    }

    public <T> void bind(Registry<T> registry, Consumer<BiConsumer<T, ResourceLocation>> source) {
        source.accept((t, rl) -> Registry.register(registry, rl, t));
    }
}
