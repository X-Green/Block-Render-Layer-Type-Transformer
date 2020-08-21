package dev.eeasee.render_layer_transformer.listener;

import dev.eeasee.render_layer_transformer.BlockRenderLayerTransformer;
import dev.eeasee.render_layer_transformer.data.Block2RenderLayer;
import dev.eeasee.render_layer_transformer.data.RenderLayerData;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.resources.IReloadableResourceManager;
import net.minecraft.resources.IResourceManager;
import net.minecraft.resources.IResourceManagerReloadListener;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.registry.IRegistry;

public class ReloadTranslucentBlockListListener implements IResourceManagerReloadListener {

    public ReloadTranslucentBlockListListener() {
        ((IReloadableResourceManager) Minecraft.getInstance().getResourceManager()).addReloadListener(this);
    }

    @Override
    public void onResourceManagerReload(IResourceManager manager) {
        updateCustomBlockRenderLayers();
    }

    private void updateCustomBlockRenderLayers() {
        String key;
        String renderLayerName;
        Block2RenderLayer.clear();
        for (Block block : IRegistry.BLOCK) {
            key = BlockRenderLayerTransformer.toLangKey(IRegistry.BLOCK.getKey(block).toString());
            if (!I18n.hasKey(key)) {
                continue;
            }
            renderLayerName = I18n.format(key);
            if (!RenderLayerData.containRenderLayerNameString(renderLayerName)) {
                continue;
            }
            BlockRenderLayer renderLayer = RenderLayerData.getRenderLayer(renderLayerName);
            if (renderLayer == null) {
                BlockRenderLayerTransformer.LOGGER.warn(String.format(
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
