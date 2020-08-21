package dev.eeasee.render_layer_transformer.mixin;

import dev.eeasee.render_layer_transformer.BlockRenderLayerTransformer;
import dev.eeasee.render_layer_transformer.listener.ReloadTranslucentBlockListListener;
import net.minecraft.client.Minecraft;
import net.minecraft.client.main.GameConfiguration;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public abstract class MinecraftClientMixin {
    @Inject(method = "<init>", at = @At("RETURN"))
    private void onClientInitDone(GameConfiguration gameConfig, CallbackInfo ci) {
        BlockRenderLayerTransformer.reloadListener = new ReloadTranslucentBlockListListener();
    }
}
