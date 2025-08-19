package de.florianmichael.imguiexample.mixin;

import de.florianmichael.imguiexample.imgui.ImGuiImpl;
import de.florianmichael.imguiexample.imgui.RenderInterface;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.RenderTickCounter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    @Inject(method = "render", at = @At("RETURN"))
    private void render(RenderTickCounter tickCounter, boolean tick, CallbackInfo ci) {
        if (MinecraftClient.getInstance().currentScreen instanceof RenderInterface imGuiScreen) {
            ImGuiImpl.draw(imGuiScreen);
        }
    }
}
