package dev.eeasee.render_layer_transformer;

import dev.eeasee.render_layer_transformer.listener.ReloadTranslucentBlockListListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BlockRenderLayerTransformer {

    public static final Logger LOGGER = LogManager.getLogger();

    public static String toLangKey(String head, String source) {
        return String.format("render_layer_transformer.%s.%s", head, source);
    }
}
