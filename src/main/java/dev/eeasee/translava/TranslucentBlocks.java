package dev.eeasee.translava;

import dev.eeasee.translava.listener.ReloadTranslucentBlockListListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TranslucentBlocks {

    public static final Logger LOGGER = LogManager.getLogger();

    public static ReloadTranslucentBlockListListener reloadListener = null;

    public static String toLangKey(String source) {
        return "render_layer_transformer" + source;
    }
}
