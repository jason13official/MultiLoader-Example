package io.github.jason13official.more_bows_and_arrows.mixin;

import com.mojang.authlib.GameProfile;
import io.github.jason13official.more_bows_and_arrows.item.ModBowItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractClientPlayer.class)
public abstract class AbstractClientPlayerMixin extends Player {

  public AbstractClientPlayerMixin(Level level, BlockPos pos, float yRot, GameProfile gameProfile) {
    super(level, pos, yRot, gameProfile);
  }

  @Inject(at = @At("HEAD"), method = "getFieldOfViewModifier", cancellable = true)
  private void more_bows_and_arrows$getFieldOfViewModifier(CallbackInfoReturnable<Float> cir) {

    float modifier = 1.0F;

    if (this.getAbilities().flying) {
      modifier *= 1.1F;
    }

    modifier *= ((float)this.getAttributeValue(Attributes.MOVEMENT_SPEED) / this.getAbilities().getWalkingSpeed() + 1.0F) / 2.0F;
    if (this.getAbilities().getWalkingSpeed() == 0.0F || Float.isNaN(modifier) || Float.isInfinite(modifier)) {
      modifier = 1.0F;
    }

    ItemStack itemstack = this.getUseItem();

    if (itemstack.getItem() instanceof ModBowItem) {
      int useTicks = this.getTicksUsingItem();
      float progress = (float)useTicks / 20.0F;

      if (progress > 1.0F) {
        progress = 1.0F;
      } else {
        progress *= progress;
      }

      modifier *= 1.0F - progress * 0.15F;

      cir.setReturnValue(Mth.lerp(((Double) Minecraft.getInstance().options.fovEffectScale().get()).floatValue(), 1.0F, modifier));
    }
  }
}
