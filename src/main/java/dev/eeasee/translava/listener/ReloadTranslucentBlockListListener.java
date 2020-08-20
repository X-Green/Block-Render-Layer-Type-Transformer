package dev.eeasee.translava.listener;

import net.minecraft.block.Block;
import net.minecraft.client.MinecraftClient;
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
        String blockID;
        Language language = Language.getInstance();
        for (Block block : Registry.BLOCK) {
            blockID = Registry.BLOCK.getId(block).toString();
            if (language.hasTranslation(blockID)) {

            }
        }
    }
}
