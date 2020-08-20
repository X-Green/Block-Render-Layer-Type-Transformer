package example.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SimpleSound;
import net.minecraft.client.gui.GuiScreenLoading;
import net.minecraft.init.SoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiScreenLoading.class)
public class MixinLoadingGui {

    @Inject(method = "onGuiClosed", at = @At("RETURN"))
    private void onRender(CallbackInfo ci) {
        Minecraft.getInstance().getSoundHandler().play(SimpleSound.music(SoundEvents.ENTITY_GENERIC_EXPLODE));
    }
}
