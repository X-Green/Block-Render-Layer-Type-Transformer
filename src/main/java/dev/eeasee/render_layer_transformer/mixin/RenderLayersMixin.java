package dev.eeasee.render_layer_transformer.mixin;

import dev.eeasee.render_layer_transformer.data.Block2RenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(RenderLayers.class)
public abstract class RenderLayersMixin {

    @Inject(method = "getBlockLayer", at = @At("HEAD"), cancellable = true)
    private static void injectCustomBlockRenderLayer(BlockState state, CallbackInfoReturnable<RenderLayer> cir) {
        Block block = state.getBlock();
        if (Block2RenderLayer.BLOCK_TO_RENDER_LAYER_MAP.containsKey(block)) {
            cir.setReturnValue(Block2RenderLayer.BLOCK_TO_RENDER_LAYER_MAP.get(block));
        }
    }

    @Inject(method = "getMovingBlockLayer", at = @At("HEAD"), cancellable = true)
    private static void injectCustomMovingBlockRenderLayer(BlockState state, CallbackInfoReturnable<RenderLayer> cir) {
        Block block = state.getBlock();
        if (Block2RenderLayer.BLOCK_TO_RENDER_LAYER_MAP.containsKey(block)) {
            RenderLayer layer = Block2RenderLayer.BLOCK_TO_RENDER_LAYER_MAP.get(block);
            if (layer == RenderLayer.getTranslucent()) {
                cir.setReturnValue(RenderLayer.getTranslucentMovingBlock());
            } else {
                cir.setReturnValue(layer);
            }
        }
    }

    @Inject(method = "getFluidLayer", at = @At("HEAD"), cancellable = true)
    private static void injectCustomFluidRenderLayer(FluidState state, CallbackInfoReturnable<RenderLayer> cir) {
        Fluid fluid = state.getFluid();
        if (Block2RenderLayer.FLUID_TO_RENDER_LAYER_MAP.containsKey(fluid)) {
            cir.setReturnValue(Block2RenderLayer.FLUID_TO_RENDER_LAYER_MAP.get(fluid));
        }
    }


}
