package dev.eeasee.render_layer_transformer;

import dev.eeasee.render_layer_transformer.listener.ReloadTranslucentBlockListListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BlockRenderLayerTransformer {

    public static final Logger LOGGER = LogManager.getLogger();

    public static ReloadTranslucentBlockListListener reloadListener = null;

    public static String toLangKey(String source) {
        return "render_layer_transformer" + source;
    }
}
