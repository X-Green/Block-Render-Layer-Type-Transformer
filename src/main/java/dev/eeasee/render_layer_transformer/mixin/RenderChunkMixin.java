package dev.eeasee.render_layer_transformer.mixin;

import dev.eeasee.render_layer_transformer.data.Block2RenderLayer;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.chunk.RenderChunk;
import net.minecraft.fluid.IFluidState;
import net.minecraft.util.BlockRenderLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(RenderChunk.class)
public abstract class RenderChunkMixin {
    @Redirect(method = "rebuildChunk", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getRenderLayer()Lnet/minecraft/util/BlockRenderLayer;"))
    private BlockRenderLayer insertCustomBlockRenderLayer(Block block) {
        if (Block2RenderLayer.BLOCK_TO_RENDER_LAYER_MAP.containsKey(block)) {
            return (Block2RenderLayer.BLOCK_TO_RENDER_LAYER_MAP.get(block));
        } else {
            return block.getRenderLayer();
        }
    }

    @Redirect(method = "rebuildChunk", at = @At(value = "INVOKE", target = "Lnet/minecraft/fluid/IFluidState;getRenderLayer()Lnet/minecraft/util/BlockRenderLayer;"))
    private BlockRenderLayer insertCustomFluidRenderLayer(IFluidState iFluidState) {

        if (Block2RenderLayer.FLUID_TO_RENDER_LAYER_MAP.containsKey(iFluidState.getFluid())) {
            return Block2RenderLayer.FLUID_TO_RENDER_LAYER_MAP.get(iFluidState.getFluid());
        } else {
            return iFluidState.getRenderLayer();
        }
    }
}
