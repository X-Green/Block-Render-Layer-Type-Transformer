package dev.eeasee.render_layer_transformer.mixin;

import dev.eeasee.render_layer_transformer.fakes.IBlock_opacityTransformed;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Block.class)
public class BlockMixin implements IBlock_opacityTransformed {

    private boolean isOpacityTransformed = false;
    private boolean transformedOpacity = false;

    @Shadow
    private BlockState defaultState;

    @Override
    public void setTransformedOpacity(boolean b) {
        if (b != defaultState.isOpaque()) {
            isOpacityTransformed = true;
            transformedOpacity = b;
        }
    }

    @Override
    public void resetTransformedOpacity() {
        this.isOpacityTransformed = false;
    }

    @Override
    public boolean getTransformedOpacity() {
        return this.transformedOpacity;
    }

    @Override
    public boolean isOpacityTransformed() {
        return this.isOpacityTransformed;
    }


}
