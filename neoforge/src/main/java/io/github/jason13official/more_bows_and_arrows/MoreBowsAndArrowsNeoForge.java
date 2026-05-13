package io.github.jason13official.more_bows_and_arrows;


import io.github.jason13official.more_bows_and_arrows.item.ModCreativeModeTabs;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(Constants.MOD_ID)
public class MoreBowsAndArrowsNeoForge {

    public static IEventBus EVENT_BUS;

    public MoreBowsAndArrowsNeoForge(IEventBus modEventBus) {

        EVENT_BUS = modEventBus;

        bind(Registries.CREATIVE_MODE_TAB, ModCreativeModeTabs::register);

        MoreBowsAndArrows.init();

    }

    public <T> void bind(ResourceKey<Registry<T>> registry, Consumer<BiConsumer<T, ResourceLocation>> source) {
        EVENT_BUS.addListener((Consumer<RegisterEvent>) event -> {
            if (registry.equals(event.getRegistryKey())) {
                source.accept((t, rl) -> event.register(registry, rl, () -> t));
            }
        });
    }
}