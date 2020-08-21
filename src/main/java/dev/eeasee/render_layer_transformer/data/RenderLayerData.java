package dev.eeasee.render_layer_transformer.data;

import net.minecraft.util.BlockRenderLayer;

import java.util.HashMap;
import java.util.Map;

public class RenderLayerData {
    public final static Map<String, BlockRenderLayer> renderLayerMap = new HashMap<>();

    static {
        renderLayerMap.put("solid", BlockRenderLayer.SOLID);
        renderLayerMap.put("cutout_mipped", BlockRenderLayer.CUTOUT_MIPPED);
        renderLayerMap.put("cutout", BlockRenderLayer.CUTOUT);
        renderLayerMap.put("translucent", BlockRenderLayer.TRANSLUCENT);
    }

    public static boolean containRenderLayerNameString(String s) {
        return renderLayerMap.containsKey(s);
    }

    public static BlockRenderLayer getRenderLayer(String s) {
        return renderLayerMap.getOrDefault(s, null);
    }
}
