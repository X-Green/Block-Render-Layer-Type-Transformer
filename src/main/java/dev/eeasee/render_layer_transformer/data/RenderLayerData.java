package dev.eeasee.render_layer_transformer.data;

import com.google.common.collect.Maps;
import net.minecraft.client.render.RenderLayer;

import java.util.Map;

public class RenderLayerData {
    public final static Map<String, RenderLayer> renderLayerMap = Maps.newHashMap();

    static {
        renderLayerMap.put("solid", RenderLayer.SOLID);
        renderLayerMap.put("cutout", RenderLayer.CUTOUT);
        renderLayerMap.put("cutout_mipped", RenderLayer.CUTOUT_MIPPED);
        renderLayerMap.put("translucent", RenderLayer.TRANSLUCENT);
    }

    public static boolean containRenderLayerNameString(String s) {
        return renderLayerMap.containsKey(s);
    }

    public static RenderLayer getRenderLayer(String s) {
        return renderLayerMap.getOrDefault(s, null);
    }
}
