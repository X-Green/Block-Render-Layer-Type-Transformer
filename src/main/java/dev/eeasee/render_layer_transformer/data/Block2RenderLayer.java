package dev.eeasee.render_layer_transformer.data;

import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.fluid.Fluid;

import java.util.HashMap;
import java.util.Map;

public class Block2RenderLayer {
    public final static Map<Block, RenderLayer> BLOCK_TO_RENDER_LAYER_MAP = new HashMap<>();

    public final static Map<Fluid, RenderLayer> FLUID_TO_RENDER_LAYER_MAP = new HashMap<>();
}
