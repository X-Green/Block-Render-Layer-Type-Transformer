package dev.eeasee.render_layer_transformer.data;

import net.minecraft.block.Block;
import net.minecraft.util.BlockRenderLayer;

import java.util.HashMap;
import java.util.Map;

public class Block2RenderLayer {
    private final static Map<Block, BlockRenderLayer> BLOCK_TO_RENDER_LAYER_MAP = new HashMap<>();

    public static void clear() {
        BLOCK_TO_RENDER_LAYER_MAP.clear();
    }

    public static void set(Block block, BlockRenderLayer type) {
        BLOCK_TO_RENDER_LAYER_MAP.put(block, type);
    }

    public static BlockRenderLayer get(Block block, BlockRenderLayer defaultRenderLayer) {
        return BLOCK_TO_RENDER_LAYER_MAP.getOrDefault(block, defaultRenderLayer);
    }
}
