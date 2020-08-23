package dev.eeasee.render_layer_transformer.data;

import com.google.common.collect.Maps;
import dev.eeasee.render_layer_transformer.fakes.IRenderLayer;
import net.minecraft.client.render.RenderLayer;

import java.util.Map;

public class RenderLayerData {
    public final static Map<String, RenderLayer> renderLayerMap;

    static {
        renderLayerMap = Maps.newHashMap();
        for (RenderLayer renderLayer : new RenderLayer[]{
                RenderLayer.getSolid(),
                RenderLayer.getCutoutMipped(),
                RenderLayer.getCutout(),
                RenderLayer.getTranslucent(),
                RenderLayer.getTranslucentNoCrumbling(),
                RenderLayer.getLeash(),
                RenderLayer.getWaterMask(),
                RenderLayer.getGlint(),
                RenderLayer.getEntityGlint(),
                RenderLayer.getLightning()
        }
        ) {
            renderLayerMap.put(((IRenderLayer) renderLayer).getRawName(), renderLayer);
        }
    }

    public static boolean containRenderLayerNameString(String s) {
        return renderLayerMap.containsKey(s);
    }

    public static RenderLayer getRenderLayer(String s) {
        return renderLayerMap.getOrDefault(s, null);
    }
}
