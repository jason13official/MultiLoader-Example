package com.example.examplemod;

import com.example.examplemod.item.ModCreativeModeTabs;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

public class ExampleMod implements ModInitializer {
    
    @Override
    public void onInitialize() {

        bind(BuiltInRegistries.CREATIVE_MODE_TAB, ModCreativeModeTabs::register);

        CommonClass.init();
    }

    public <T> void bind(Registry<T> registry, Consumer<BiConsumer<T, ResourceLocation>> source) {
        source.accept((t, rl) -> Registry.register(registry, rl, t));
    }
}
