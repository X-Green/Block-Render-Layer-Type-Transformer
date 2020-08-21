package dev.eeasee.render_layer_transformer.data;

import net.minecraft.util.BlockRenderLayer;

import java.util.HashMap;
import java.util.Map;

public class RenderLayerData {
    public final static Map<String, BlockRenderLayer> renderLayerMap = new HashMap<>();

    static {
        for (BlockRenderLayer renderLayer : BlockRenderLayer.values()) {
            renderLayerMap.put(renderLayer.toString().toLowerCase(), renderLayer);
        }
    }

    public static boolean containRenderLayerNameString(String s) {
        return renderLayerMap.containsKey(s);
    }

    public static BlockRenderLayer getRenderLayer(String s) {
        return renderLayerMap.getOrDefault(s, null);
    }
}
