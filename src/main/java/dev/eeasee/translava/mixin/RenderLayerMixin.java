package dev.eeasee.translava.mixin;

import dev.eeasee.translava.fakes.IRenderLayer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderPhase;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(RenderLayer.class)
public abstract class RenderLayerMixin extends RenderPhase implements IRenderLayer {
    public RenderLayerMixin(String name, Runnable beginAction, Runnable endAction) {
        super(name, beginAction, endAction);
    }

    @Override
    public String getRawName() {
        return this.name;
    }
}
