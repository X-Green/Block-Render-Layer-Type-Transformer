package dev.eeasee.render_layer_transformer.mixin;

import dev.eeasee.render_layer_transformer.fakes.IBlock_opacityTransformed;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractBlock.AbstractBlockState.class)
public class AbstractBlock$AbstractBlockStateMixin {
    @Shadow
    public Block getBlock() {
        throw new UnsupportedOperationException();
    }

    @Inject(method = "isOpaque", at = @At("HEAD"), cancellable = true)
    private void returnFalseIfTransformedInTexturePack(CallbackInfoReturnable<Boolean> cir) {
        Block block = getBlock();
        if (((IBlock_opacityTransformed) block).isOpacityTransformed()) {
            cir.setReturnValue(((IBlock_opacityTransformed) block).getTransformedOpacity());
        }
    }

}
