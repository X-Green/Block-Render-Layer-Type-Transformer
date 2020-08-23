package dev.eeasee.render_layer_transformer.mixin;

import dev.eeasee.render_layer_transformer.data.Block2RenderLayer;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.chunk.ChunkRenderer;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ChunkRenderer.class)
public abstract class ChunkRendererMixin {
    @Redirect(method = "rebuildChunk", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getRenderLayer()Lnet/minecraft/client/render/RenderLayer;"))
    private RenderLayer redirectedGetBlockRenderLayer(Block block) {
        if (Block2RenderLayer.BLOCK_TO_RENDER_LAYER_MAP.containsKey(block)) {
            return Block2RenderLayer.BLOCK_TO_RENDER_LAYER_MAP.get(block);
        } else {
            return block.getRenderLayer();
        }
    }

    @Redirect(method = "rebuildChunk", at = @At(value = "INVOKE", target = "Lnet/minecraft/fluid/FluidState;getRenderLayer()Lnet/minecraft/client/render/RenderLayer;"))
    private RenderLayer redirectedGetFluidRenderLayer(FluidState fluidState) {
        Fluid fluid = fluidState.getFluid();
        if (Block2RenderLayer.FLUID_TO_RENDER_LAYER_MAP.containsKey(fluid)) {
            return Block2RenderLayer.FLUID_TO_RENDER_LAYER_MAP.get(fluid);
        } else {
            return fluidState.getRenderLayer();
        }
    }
}
