package dev.eeasee.render_layer_transformer.listener;

import dev.eeasee.render_layer_transformer.BlockRenderLayerTransformer;
import dev.eeasee.render_layer_transformer.data.Block2RenderLayer;
import dev.eeasee.render_layer_transformer.data.RenderLayerData;
import net.minecraft.block.Block;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.fluid.Fluid;
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
        Block2RenderLayer.BLOCK_TO_RENDER_LAYER_MAP.clear();
        Block2RenderLayer.FLUID_TO_RENDER_LAYER_MAP.clear();
        for (Block block : Registry.BLOCK) {
            key = BlockRenderLayerTransformer.toLangKey("block", Registry.BLOCK.getId(block).toString());
            if (!I18n.hasTranslation(key)) {
                continue;
            }
            renderLayerName = I18n.translate(key);
            if (!RenderLayerData.containRenderLayerNameString(renderLayerName)) {
                continue;
            }
            RenderLayer renderLayer = RenderLayerData.getRenderLayer(renderLayerName);
            if (renderLayer == null) {
                BlockRenderLayerTransformer.LOGGER.warn(String.format(
                        "[LayerRenderTypeTransformer] Wrong RenderLayer type name: [%s] at (%s)",
                        renderLayerName,
                        key
                ));
            } else {
                Block2RenderLayer.BLOCK_TO_RENDER_LAYER_MAP.put(block, renderLayer);
            }
        }
        for (Fluid fluid : Registry.FLUID) {
            key = BlockRenderLayerTransformer.toLangKey("fluid", Registry.FLUID.getId(fluid).toString());
            if (!I18n.hasTranslation(key)) {
                continue;
            }
            renderLayerName = I18n.translate(key);
            if (!RenderLayerData.containRenderLayerNameString(renderLayerName)) {
                continue;
            }
            RenderLayer renderLayer = RenderLayerData.getRenderLayer(renderLayerName);
            if (renderLayer == null) {
                BlockRenderLayerTransformer.LOGGER.warn(String.format(
                        "[LayerRenderTypeTransformer] Wrong RenderLayer type name: [%s] at (%s)",
                        renderLayerName,
                        key
                ));
            } else {
                Block2RenderLayer.FLUID_TO_RENDER_LAYER_MAP.put(fluid, renderLayer);
            }
        }
    }
}
