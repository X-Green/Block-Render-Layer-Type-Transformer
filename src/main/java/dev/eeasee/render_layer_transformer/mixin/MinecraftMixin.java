package dev.eeasee.render_layer_transformer.mixin;

import dev.eeasee.render_layer_transformer.listener.ReloadTranslucentBlockListListener;
import net.minecraft.client.Minecraft;
import net.minecraft.client.main.GameConfiguration;
import net.minecraft.resources.IReloadableResourceManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public abstract class MinecraftMixin {

    @Shadow
    private IReloadableResourceManager resourceManager;

    @Inject(method = "init", at = @At("RETURN"))
    private void onClientInitDone(CallbackInfo ci) {
        resourceManager.addReloadListener(new ReloadTranslucentBlockListListener());
    }
}
