package dev.eeasee.render_layer_transformer.listener;

import dev.eeasee.render_layer_transformer.TranslucentBlocks;
import dev.eeasee.render_layer_transformer.data.Block2RenderLayer;
import dev.eeasee.render_layer_transformer.data.RenderLayerData;
import net.minecraft.block.Block;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.resource.ReloadableResourceManager;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.SynchronousResourceReloadListener;
import net.minecraft.util.Language;
import net.minecraft.util.registry.Registry;

public class ReloadTranslucentBlockListListener implements SynchronousResourceReloadListener {

    public ReloadTranslucentBlockListListener() {
        ((ReloadableResourceManager) MinecraftClient.getInstance().getResourceManager()).registerListener(this);
    }

    @Override
    public void apply(ResourceManager manager) {
        updateCustomBlockRenderLayers();
    }

    private void updateCustomBlockRenderLayers() {
        String key;
        String renderLayerName;
        Language language = Language.getInstance();
        Block2RenderLayer.clear();
        for (Block block : Registry.BLOCK) {
            key = TranslucentBlocks.toLangKey(Registry.BLOCK.getId(block).toString());
            if (!language.hasTranslation(key)) {
                continue;
            }
            renderLayerName = language.get(key);
            if (!RenderLayerData.containRenderLayerNameString(renderLayerName)) {
                continue;
            }
            RenderLayer renderLayer = RenderLayerData.getRenderLayer(renderLayerName);
            if (renderLayer == null) {
                TranslucentBlocks.LOGGER.warn(String.format(
                        "[LayerRenderTypeTransformer] Wrong RenderLayer type name: [%s] at (%s)",
                        renderLayerName,
                        key
                ));
            } else {
                Block2RenderLayer.set(block, renderLayer);
            }
        }
    }
}
