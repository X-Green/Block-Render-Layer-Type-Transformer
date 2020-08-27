package dev.eeasee.render_layer_transformer.mixin;

import dev.eeasee.render_layer_transformer.BlockRenderLayerTransformer;
import dev.eeasee.render_layer_transformer.data.listener.ReloadTranslucentBlockListListener;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.RunArgs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin {
    @Inject(method = "<init>", at = @At("RETURN"))
    private void onClientInitDone(RunArgs args, CallbackInfo ci) {
        BlockRenderLayerTransformer.reloadListener = new ReloadTranslucentBlockListListener();
    }
}
