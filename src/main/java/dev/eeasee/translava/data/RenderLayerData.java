package dev.eeasee.translava.data;

import com.google.common.collect.Maps;
import dev.eeasee.translava.fakes.IRenderLayer;
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
                RenderLayer.getTranslucentMovingBlock(),
                RenderLayer.getTranslucentNoCrumbling(),
                RenderLayer.getLeash(),
                RenderLayer.getWaterMask(),
                RenderLayer.getArmorGlint(),
                RenderLayer.getArmorEntityGlint(),
                RenderLayer.method_30676(),
                RenderLayer.getGlint(),
                RenderLayer.getGlintDirect(),
                RenderLayer.getEntityGlint(),
                RenderLayer.getEntityGlintDirect(),
                RenderLayer.getLightning(),
                RenderLayer.getTripwire()
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
