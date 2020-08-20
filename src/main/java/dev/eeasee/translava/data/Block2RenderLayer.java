package dev.eeasee.translava.data;

import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;

import java.util.HashMap;
import java.util.Map;

public class Block2RenderLayer {
    private final static Map<Block, RenderLayer> BLOCK_TO_RENDER_LAYER_MAP = new HashMap<>();

    public static void clear() {
        BLOCK_TO_RENDER_LAYER_MAP.clear();
    }

    public static void set(Block block, RenderLayer type) {
        BLOCK_TO_RENDER_LAYER_MAP.put(block, type);
    }

    public static RenderLayer get(Block block, RenderLayer defaultRenderLayer) {
        return BLOCK_TO_RENDER_LAYER_MAP.getOrDefault(block, defaultRenderLayer);
    }
}
