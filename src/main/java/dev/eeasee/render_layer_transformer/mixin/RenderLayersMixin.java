package dev.eeasee.render_layer_transformer.mixin;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.fluid.FluidState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RenderLayers.class)
public abstract class RenderLayersMixin {
    @Inject(method = "getFluidLayer", at = @At("HEAD"), cancellable = true)
    private static void translucentLava(FluidState state, CallbackInfoReturnable<RenderLayer> cir) {
        cir.setReturnValue(RenderLayer.getTranslucent());
    }
}
